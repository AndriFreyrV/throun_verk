package DayTours;

public enum TourType
{
    ANY,
    CITY_TOUR,
    GLACIER_TOUR,
    HIKING_TOUR,
    ICECAVE_TOUR,
    NORTHERNLIGHTS_TOUR,
    PUFFIN_TOUR,
    WHALEWATCHING_TOUR;

    public static TourType fromID (int id)
    {
        return TourType.values()[id];
    }

    @Override
    public String toString ()
    {
        switch (this)
        {
            case ANY:
                return "Any Tour";
            case CITY_TOUR:
                return "City Tour";
            case GLACIER_TOUR:
                return "Glacier Tour";
            case HIKING_TOUR:
                return "Hiking Tour";
            case ICECAVE_TOUR:
                return "Ice Cave Tour";
            case NORTHERNLIGHTS_TOUR:
                return "Northern Lights Tour";
            case PUFFIN_TOUR:
                return "Puffin Tour";
            case WHALEWATCHING_TOUR:
                return "Whale Watching Tour";
            default:
                return "";
        }
    }
}
