public class Time {
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        if (hour >= 24) {
            hour -= 24;
        }
        this.hour = hour;
        if (minute >= 60) {
            minute -= 60;
        }
        this.minute = minute;
        if (second >= 60) {
            second -= 60;
        }
        this.second = second;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute() {
        return minute;
    }

    public int getSecond() {
        return second;
    }

    public void tick() {
        second++;
        if (second > 59) {
            second = 0;
            minute++;
        }
        if (minute > 59) {
            minute = 0;
            hour++;
        }
        if (hour > 23) {
            hour = 0;
        }
    }

    public void add (Time addedTime) {
        second += addedTime.getSecond();
        minute += addedTime.getMinute();
        hour += addedTime.getHour();
        if (second > 60) {
            second -= 60;
            minute++;
        }
        if (minute > 60) {
            minute -= 60;
            hour++;
        }
        if (hour > 24) {
            hour -= 24;
        }
    }

    public String toString() {
        String secondAsString = Integer.toString(second);
        String minuteAsString = Integer.toString(minute);
        String hourAsString = Integer.toString(hour);
        if (secondAsString.length() == 1) {
            secondAsString = "0" + secondAsString;
        }
        if (minuteAsString.length() == 1) {
            minuteAsString = "0" + minuteAsString;
        }
        if (hourAsString.length() == 1) {
            hourAsString = "0" + hourAsString;
        }
        return hourAsString + ":" + minuteAsString + ":" + secondAsString;
    }

}
