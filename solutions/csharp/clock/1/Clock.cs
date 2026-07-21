public class Clock
{
    private int _hours;
    private int _minutes;

    public Clock(int hours, int minutes) => Add(hours * 60 + minutes);

    public Clock Add(int minutesToAdd)
    {
        _hours += minutesToAdd / 60;
        _minutes += minutesToAdd % 60;

        if (_minutes > 60)
            _hours++;
        else if (_minutes < 0)
            _hours--;

        _minutes = Mod(_minutes, 60);
        _hours = Mod(_hours, 24);

        return this;
    }

    public Clock Subtract(int minutesToSubtract) => Add(-minutesToSubtract);

    public override string ToString() => $"{_hours:D2}:{_minutes:D2}";

    public override bool Equals(object? obj) =>
        obj is Clock c && (_hours, _minutes) == (c._hours, c._minutes);

    private static int Mod(int num, int b) => ((num % b) + b) % b;
}