package DayTours;

public enum Duration
{
    SHORT,
    MEDIUM,
    LONG,
    VERY_LONG,
    EXTREMELY_LONG;

    public static Duration fromID (int id)
    {
        return values()[id];
    }

    public String toSql()
    {
        switch(this)
        {
            case SHORT:
                return "AND duration > 0 AND duration <= 4";
            case MEDIUM:
                return "AND duration > 4 AND duration <= 8";
            case LONG:
                return "AND duration > 8 AND duration <= 12";
            case VERY_LONG:
                return "AND duration > 12 AND duration <= 24";
            case EXTREMELY_LONG:
                return "AND duration > 24 AND duration <= 48";
            default:
                return "AND duration > 0";
        }
    }

    @Override
    public String toString ()
    {
        switch(this)
        {
            case SHORT:
                return "0 - 4 hours";
            case MEDIUM:
                return "4 - 8 hours";
            case LONG:
                return "8 - 12 hours";
            case VERY_LONG:
                return "12 - 24 hours";
            case EXTREMELY_LONG:
                return "1 - 2 days";
            default:
                return "";
        }
    }
}
