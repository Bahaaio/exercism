public struct Clock
{
    private int _minutes;
    private const int MinutesInDay = 1440;

    public Clock(int hours, int minutes) => Add(hours * 60 + minutes);

    public Clock Add(int minutesToAdd)
    {
        _minutes += minutesToAdd % MinutesInDay;
        _minutes = Mod(_minutes, MinutesInDay);
        return this;
    }

    public Clock Subtract(int minutesToSubtract) => Add(-minutesToSubtract);

    public override string ToString() => $"{_minutes / 60:00}:{_minutes % 60:00}";

    private static int Mod(int num, int b) => ((num % b) + b) % b;
}