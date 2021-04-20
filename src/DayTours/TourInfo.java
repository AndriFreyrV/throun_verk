package DayTours;

import java.util.ArrayList;
import java.util.List;

public class TourInfo
{
    private static List<String> descriptions = new ArrayList<>();
    private static List<Integer> maxCapacities = new ArrayList<>();
    private static List<Duration> durations = new ArrayList<>();

    private static Duration getDuration (TourType tourType)
    {
        return durations.get(tourType.ordinal());
    }

    public String description;
    public int maxCapacity;
    public Duration duration;

}