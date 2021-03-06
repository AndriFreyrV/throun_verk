package Flight;

import java.sql.*;
import java.util.*;
import java.util.Date;

public class UpdateDB {
    public static int insertIntoDB(String[] userInfo) throws SQLException {
    	// returns -1 if failed, otherwise returns id
        Connection con = null;
        int return_id = -1;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS User(id INTEGER PRIMARY KEY, name varchar(30), email varchar(30))";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO User(name, email) SELECT '" + userInfo[0] +"' , '" + userInfo[1] + "' WHERE NOT EXISTS(SELECT 1 FROM User WHERE name = '" + userInfo[0] +"' and email = '" + userInfo[1] + "')";
        PreparedStatement prsts = con.prepareStatement(sqlInsertingValues, Statement.RETURN_GENERATED_KEYS);
        int rows = prsts.executeUpdate();
        System.out.println("numbers of rows affected: "+rows);
        ResultSet id_values = prsts.getGeneratedKeys();
        if (id_values.next()) {
        	return_id = id_values.getInt(1);
        }
        //int rows = st.executeUpdate(sqlInsertingValues);
        /*
        if (rows > 0) {
            System.out.println("A row created");
        }
        
        String checking = "SELECT * FROM User";
        ResultSet rs = st.executeQuery(checking);
        while(rs.next())
        {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            System.out.println(id + " | " + name + " | " + email);
        }
        rs.close();
        */
        
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }  
        return return_id;
    }
    
    public static int insertIntoFlightDB(String destination, String currentLoc, Date departureTime, Date arrivalTime) throws SQLException {
    	// returns -1 if failed, otherwise returns id
        Connection con = null;
        Random r = new Random();
        int return_id = -1;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS Flight(id INTEGER PRIMARY KEY, destination varchar(30), currentLoc varchar(30), departureTime Date, arrivalTime Date, seats INTEGER, cost INTEGER)";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO Flight(destination, currentLoc, departureTime, arrivalTime, seats, cost) Values( '"+ destination +"', '"+ currentLoc +"', '"+departureTime+"', '"+arrivalTime+"', '"+r.nextInt(30)+"', '"+r.nextInt(20000)+"')";
        System.out.println(sqlInsertingValues);
        PreparedStatement prsts = con.prepareStatement(sqlInsertingValues, Statement.RETURN_GENERATED_KEYS);
        int rows = prsts.executeUpdate();
        System.out.println("numbers of rows affected: "+rows);
        ResultSet id_values = prsts.getGeneratedKeys();
        if (id_values.next()) {
        	return_id = id_values.getInt(1);
        }
        //int rows = st.executeUpdate(sqlInsertingValues);
        /*
        if (rows > 0) {
            System.out.println("A row created");
        }
        
        String checking = "SELECT * FROM User";
        ResultSet rs = st.executeQuery(checking);
        while(rs.next())
        {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            System.out.println(id + " | " + name + " | " + email);
        }
        rs.close();
        */
        
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }  
        return return_id;
    }

    /**
     *
     * @param id, flight id
     * @param newSeats, number of seats available after update
     * @throws SQLException
     */
    public static void bookingAction(int id, int newSeats) throws SQLException {
        // returns -1 if failed, otherwise returns id
        Connection con = null;

        try {
            Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
            Statement st = con.createStatement();
            String updateStr= String.format("UPDATE Flight SET seats = %d WHERE id = %d", newSeats, id);
            st.executeUpdate(updateStr);

        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
            {
                if(con != null)
                    con.close();
            }
            catch(SQLException e)
            {
                // connection close failed.
                System.err.println("error closing database; "+e);
            }
        }
        return;
    }
    
    public static int insertIntoBookingDB(Booking booking) throws SQLException {
    	// returns -1 if failed, otherwise returns id
        Connection con = null;
        int return_id = -1;
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        
        Statement st = con.createStatement();
        String sqlCreatingTable = "CREATE TABLE IF NOT EXISTS Bookings(id INTEGER PRIMARY KEY, flight varchar(30), cost varchar(30))";
        st.executeUpdate(sqlCreatingTable);
        String sqlInsertingValues = "INSERT INTO Bookings(flight, cost) Values( '"+ booking.getFlight() +"', '"+ booking.getCost() +"')";
        PreparedStatement prsts = con.prepareStatement(sqlInsertingValues, Statement.RETURN_GENERATED_KEYS);
        int rows = prsts.executeUpdate();
        System.out.println("numbers of rows affected: "+rows);
        ResultSet id_values = prsts.getGeneratedKeys();
        if (id_values.next()) {
        	return_id = id_values.getInt(1);
        }

        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }  
        return return_id;
    }
    
    public static void deleteFromDB(String[]  wantDeleted, int identifier) throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlCheckingID = "SELECT * FROM User";
        
        String actualName = ""; String actualEmail = "";

        ResultSet rsID = st.executeQuery(sqlCheckingID);
        if (!rsID.isBeforeFirst() ) {    
            System.out.println("No data"); 
        } 
        while(rsID.next()) {
        	int id = rsID.getInt("id");
        	if (id == identifier) {
        		actualName = rsID.getString("name");
                actualEmail = rsID.getString("email");
                if(actualName.equals(wantDeleted[0]) && actualEmail.equals(wantDeleted[1])) {
                	String sqlDeleting = "DELETE FROM User WHERE name = '"+ wantDeleted[0]+"' AND email = '"+ wantDeleted[1]+"'";
                    st.executeUpdate(sqlDeleting);
                    System.out.println(wantDeleted[0] + " was deleted.");
                }
        	}else {
            	System.out.println("can't delete what doesn't exist");
            }
        }

        String checking = "SELECT * FROM User";
        ResultSet rs = st.executeQuery(checking);
        while(rs.next())
        {
        	int id = rs.getInt("id");
            String name = rs.getString("name");
            String email = rs.getString("email");

            System.out.println(id + " | " + name + " | " + email);
        }
        rs.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }        
    }
    
    public static void deleteFromFlightDB(int identifier) throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlCheckingID = "SELECT * FROM Flight";

        ResultSet rsID = st.executeQuery(sqlCheckingID);
        if (!rsID.isBeforeFirst() ) {    
            System.out.println("No data"); 
        } 
        while(rsID.next()) {
        	int id = rsID.getInt("id");
        	if (id == identifier) {
                	String sqlDeleting = "DELETE FROM Flight WHERE id = '"+identifier+"'";
                    st.executeUpdate(sqlDeleting);
                    System.out.println(identifier + " was deleted.");
                }
        	else{
            	System.out.println("can't delete what doesn't exist");
            }
        }


        rsID.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }        
    }
    
    public static void deletFlightDB() throws SQLException {
        Connection con = null;
        
        try {
        Class.forName("org.sqlite.JDBC");
        con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
        Statement st = con.createStatement();
        String sqlDeleting ="Drop TABLE Flight";
        //String sqlVacuum = "VACUUM";
        st.executeUpdate(sqlDeleting);
        //st.executeUpdate(sqlVacuum);
        System.out.println("FlightsDB was deleted.");
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }        
    }
    
    public static void updateDB(int identifier, String oldName, String oldEmail, String newName, String newEmail) throws SQLException{
    	Connection con = null;
    	try {
    		Class.forName("org.sqlite.JDBC");
            con = DriverManager.getConnection("jdbc:sqlite:flightsdb.db");
            Statement st = con.createStatement();
            String actualName = ""; String actualEmail = "";
            String sqlCheckingID = "SELECT * FROM User";
            ResultSet rsID = st.executeQuery(sqlCheckingID);
            if (!rsID.isBeforeFirst() ) {    
                System.out.println("No data"); 
            } 
            while(rsID.next()) {
            	int id = rsID.getInt("id");
            	if (id == identifier) {
            		actualName = rsID.getString("name");
                    actualEmail = rsID.getString("email");
                    if(actualName.equals(oldName) && actualEmail.equals(oldEmail)) {
                    	String sqlDeleting = "UPDATE User SET name = '" + newName + "', email = '"+newEmail+"' WHERE id = "+ identifier;
                        st.executeUpdate(sqlDeleting);
                        System.out.println(oldName +" was changed to "+newName+ " and the "+oldEmail+" was changed to "+newEmail);
                    }
            	}
            	else {
            		System.out.println("User doesnt exist");
            	}
            }
            String checking = "SELECT * FROM User";
            ResultSet rs = st.executeQuery(checking);
            while(rs.next())
            {
            	int id = rs.getInt("id");
                String name = rs.getString("name");
                String email = rs.getString("email");

                System.out.println(id + " | " + name + " | " + email);
            }

            // comment
            rs.close();
        }catch (ClassNotFoundException | SQLException e) {
            System.out.println("ClassNotFound & SQL Exception; "+e);
        } finally
        {
            try
              {
                if(con != null)
                  con.close();
              }
              catch(SQLException e)
              {
                // connection close failed.
                System.err.println("error closing database; "+e);
              }
        }        
    }
    

    
    public static void main(String[] args) throws SQLException{
        
        // insertIntoFlightDB(String currentLoc, String destination, Date departureTime, Date arrivalTime)
    	
    	Date date = new Date();
		Calendar calendar = Calendar.getInstance();
	    calendar.setTime(date);
	    calendar.add(Calendar.DAY_OF_MONTH, 7);
	    Date dateArrival = new Date();
	    dateArrival = calendar.getTime();
	    calendar.setTime(date);
	    calendar.add(calendar.DAY_OF_MONTH, 3);
	    Date dateInbetween = new Date();
	    dateInbetween = calendar.getTime();
	    Flight flight = new Flight(24, "Akureyri", "Reykjavik", date, dateArrival );
    	//insertIntoFlightDB("Akureyri", "Reykjavik", date, dateArrival); 	
    	
    	Booking booking = new Booking(flight, 10000);
        insertIntoBookingDB(booking);
       
	    System.out.println(date);
	    System.out.println(dateInbetween);
	    System.out.println(dateArrival);
	    if(!dateInbetween.before(date) && !dateInbetween.after(dateArrival)) {
	    	System.out.println("Date is inside the date searched");
	    }else {
	    	System.out.println("Date is not inside the date searched");
	    }
    }
    
}