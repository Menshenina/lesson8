package lesson7.emtity;

public class Weather {
    private  String day;
    private double minTemp;
    private double maxTemp;

    public Weather(String day, double minTemp, double maxTemp) {
        this.day = day;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
    }

    public String getDay() {
        return day;
    }

    public double getMinTemp() {
        return minTemp;
    }

    public double getMaxTemp() {
        return maxTemp;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public void setMinTemp(double minTemp) {
        this.minTemp = minTemp;
    }

    public void setMaxTemp(double maxTemp) {
        this.maxTemp = maxTemp;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "day='" + day + '\'' +
                ", minTemp=" + minTemp +
                ", maxTemp=" + maxTemp +
                '}';
    }
}
