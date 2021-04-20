package DayTours;

public final class PriceRange
{
    private int low;
    private int high;

    public PriceRange ()
    {
        this(0, Integer.MAX_VALUE);
    }

    public PriceRange (int low, int high)
    {
        this.low = low;
        this.high = high;
    }

    public int getLow()
    {
        return low;
    }

    public int getHigh()
    {
        return high;
    }

    public Boolean anyPrice()
    {
        return high == Integer.MAX_VALUE;
    }

    @Override
    public String toString ()
    {
        if (anyPrice()) return "Any Price";
        return low + " kr - " + high + " kr";
    }
}