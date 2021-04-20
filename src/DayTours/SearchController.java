package DayTours;

import javafx.collections.ObservableList;


// This class is the controller that handles the search of tours.
public class SearchController
{
    // Attributes :
    public DatabaseUtility dbutil;
    // constructor
    public SearchController ()
    {
        dbutil = new DatabaseUtility();
    }

    public ObservableList<Tour> searchTour(SearchModel model)
    {
        ObservableList<Tour> allTours = dbutil.getTours(model);
        allTours.forEach((ele) ->
        {
            System.out.println(ele.toString());
        });
        return allTours;
    }

}