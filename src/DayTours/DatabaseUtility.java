package DayTours;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.*;
import java.time.format.DateTimeFormatter;
import java.time.*;

public class DatabaseUtility
{
    public static Connection getConnection()
    {
        Connection conn = null;
        try
        {
            conn = DriverManager.getConnection("jdbc:sqlite:toursdb.db");
        }
        catch(Exception e)
        {
            System.out.println("Could not make a connection");
        }
        return conn;
    }

    public static void closeConnection(Connection c)
    {
        if(c != null)
        {
            try
            {
                c.close();
            }
            catch (Exception e)
            {

            }
        }
    }


    public Boolean createBooking(int tripID, int customerID, int seats)
    {
        Connection conn = getConnection();
        String sql = "INSERT INTO Booking(tripID, customerID, seats) VALUES(?,?,?)";
        if(conn != null)
        {
            try
            {
                PreparedStatement pstmt = conn.prepareStatement(sql);
                pstmt.setInt(1, tripID);
                pstmt.setInt(2, customerID);
                pstmt.setInt(3, seats);
                pstmt.executeUpdate();
            }
            catch(SQLException e)
            {
                return false;
            }
        }
        closeConnection(conn);
        return true;
    }

    private int getTripCount(int tripID)
    {
        int result = 0;
        Connection conn = getConnection();
        String sql = "SELECT seats FROM Booking WHERE tripID = " +  tripID;
        if(conn != null)
        {
            try
            {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    result += rs.getInt("seats");
                }
            }
            catch(SQLException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        closeConnection(conn);
        System.out.println("Result: " + result);
        return result;
    }

    public int getAvailability(int tripID)
    {
        int occupied = getTripCount(tripID);
        int capacity = 0;
        Connection conn = getConnection();
        String sql = "SELECT TourInfo.capacity FROM Tour INNER JOIN TourInfo ON Tour.tourID = TourInfo.tourID  WHERE Tour.tripID = " + tripID;
        if(conn != null)
        {
            try
            {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                capacity = rs.getInt("capacity");
            }
            catch(SQLException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        System.out.println("Capacity: " + capacity);
        closeConnection(conn);
        return capacity - occupied;
    }

    public ObservableList<Tour> getTours(SearchModel model)
    {
        ObservableList<Tour> tours = FXCollections.observableArrayList();
        Connection conn = getConnection();
        String sql = "SELECT *, TourInfo.name FROM Tour INNER JOIN TourInfo ON Tour.tourID = TourInfo.tourID WHERE\n";
        PriceRange p = model.getPriceRange();
        Duration duration = model.getDuration();
        TourType ttype = model.getTourType();
        TimeFrame tf = model.getTimeFrame();
        LocalDate fromDate = model.getFromDate();
        LocalDate toDate = model.getToDate();
        sql += "Tour.tourDate >= '" + fromDate + "' AND Tour.tourDate <= '" + toDate + "'\n";
        if(p != null && !p.anyPrice())
            sql += "AND Tour.price >= " + p.getLow() + " AND Tour.price <= " + p.getHigh() + "\n";
        if(duration != null)
            sql += model.getDuration().toSql() + "\n";
        if(ttype != null && ttype != TourType.ANY)
            sql += "AND TourInfo.name = '" + ttype.toString() + "'\n";
        if(tf != null && tf != TimeFrame.ANY)
            sql += tf.toSql() + "\n";
        sql += "ORDER BY Tour.tourDate, Tour.tourTime";
        if(conn != null)
        {
            try
            {
                Statement st = conn.createStatement();
                ResultSet rs = st.executeQuery(sql);
                while(rs.next())
                {
                    String d = rs.getString("tourDate");
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    LocalDate localDate = LocalDate.parse(d, formatter);
                    String dt = rs.getString("tourTime");
                    LocalTime localTime = LocalTime.parse(dt);
                    LocalDateTime localDateTime = LocalDateTime.of(localDate, localTime);
                    Tour t = new Tour(rs.getInt("tripID"), TourType.fromID(rs.getInt("tourID")), rs.getInt("price"), localDateTime);
                    if(getAvailability(t.getTripID()) >= model.getPersons())
                        tours.add(t);
                }
            }
            catch(SQLException e)
            {
                System.out.println("Error: " + e.getMessage());
            }
        }
        closeConnection(conn);
        return tours;
    }
}
