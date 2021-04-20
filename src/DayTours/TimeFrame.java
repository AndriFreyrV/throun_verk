package DayTours;

public enum TimeFrame
{
    ANY,
    MORNING,
    AFTERNOON,
    EVENING,
    NIGHT;

    public static TimeFrame fromHour (int hour)
    {
        int frame = (hour / 6 + 2) % 3;
        switch (frame)
        {
            case 0:
                return TimeFrame.MORNING;
            case 1:
                return TimeFrame.AFTERNOON;
            case 2:
                return TimeFrame.EVENING;
            case 3:
                return TimeFrame.NIGHT;
            default:
                return TimeFrame.ANY;
        }
    }

    public static TimeFrame getFrameFromTime ()
    {
        return TimeFrame.ANY;
    }

    public String toSql()
    {
        switch(this)
        {
            case MORNING:
                return "AND tourTime >= '06:00' AND tourTime < '12:00'";
            case AFTERNOON:
                return "AND tourTime >= '12:00' AND tourTime < '18:00'";
            case EVENING:
                return "AND tourTime >= '18:00' AND tourTime < '00:00'";
            case NIGHT:
                return "AND tourTime >= '00:00' AND tourTime < '06:00'";
            default:
                return "AND tourTime >= 00:00";
        }
    }

    @Override
    public String toString ()
    {
        switch (this)
        {
            case ANY:
                return "Any Time Frame";
            case MORNING:
                return "Morning (06:00 - 12:00)";
            case AFTERNOON:
                return "Afternoon (12:00 - 18:00)";
            case EVENING:
                return "Evening (18:00 - 00:00)";
            case NIGHT:
                return "Night (00:00 - 06:00)";
            default:
                return "";
        }
    }
}