package fangproductions.com.weatherblows;

/**
 * Created by Derek Fang on 2/21/2015.
 */
public class DailyWeather {

    public final static int DAYS = 8; //Number of days contained in the DailyWeather Object

    private String mSummary;
    private String mIcon;

    private DailyWeatherData mDay0;
    private DailyWeatherData mDay1;
    private DailyWeatherData mDay2;
    private DailyWeatherData mDay3;
    private DailyWeatherData mDay4;
    private DailyWeatherData mDay5;
    private DailyWeatherData mDay6;
    private DailyWeatherData mDay7;

    public DailyWeather(String summary, String icon, DailyWeatherData day0, DailyWeatherData day1, DailyWeatherData day2, DailyWeatherData day3, DailyWeatherData day4, DailyWeatherData day5, DailyWeatherData day6, DailyWeatherData day7) {
        mSummary = summary;
        mIcon = icon;
        mDay0 = day0;
        mDay1 = day1;
        mDay2 = day2;
        mDay3 = day3;
        mDay4 = day4;
        mDay5 = day5;
        mDay6 = day6;
        mDay7 = day7;
    }

    public String getSummary() {
        return mSummary;
    }

    public void setSummary(String summary) {
        mSummary = summary;
    }

    public String getIcon() {
        return mIcon;
    }

    public void setIcon(String icon) {
        mIcon = icon;
    }

    public DailyWeatherData getDay0() {
        return mDay0;
    }

    public void setDay0(DailyWeatherData day0) {
        mDay0 = day0;
    }

    public DailyWeatherData getDay1() {
        return mDay1;
    }

    public void setDay1(DailyWeatherData day1) {
        mDay1 = day1;
    }

    public DailyWeatherData getDay2() {
        return mDay2;
    }

    public void setDay2(DailyWeatherData day2) {
        mDay2 = day2;
    }

    public DailyWeatherData getDay3() {
        return mDay3;
    }

    public void setDay3(DailyWeatherData day3) {
        mDay3 = day3;
    }

    public DailyWeatherData getDay4() {
        return mDay4;
    }

    public void setDay4(DailyWeatherData day4) {
        mDay4 = day4;
    }

    public DailyWeatherData getDay5() {
        return mDay5;
    }

    public void setDay5(DailyWeatherData day5) {
        mDay5 = day5;
    }

    public DailyWeatherData getDay6() {
        return mDay6;
    }

    public void setDay6(DailyWeatherData day6) {
        mDay6 = day6;
    }

    public DailyWeatherData getDay7() {
        return mDay7;
    }

    public void setDay7(DailyWeatherData day7) {
        mDay7 = day7;
    }
}
