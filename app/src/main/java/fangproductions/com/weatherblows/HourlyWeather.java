package fangproductions.com.weatherblows;

/**
 * Created by Derek Fang on 2/15/2015.
 */
public class HourlyWeather {

    public final static int HOURS = 25; //Amount of hours that HourlyWeather will store. Note that this is 25 because we want to store 24 hours from now and 0 stores the current hour.
    private CurrentWeather mHour0; //Note this is the CURRENT HOUR
    private CurrentWeather mHour1;
    private CurrentWeather mHour2;
    private CurrentWeather mHour3;
    private CurrentWeather mHour4;
    private CurrentWeather mHour5;
    private CurrentWeather mHour6;
    private CurrentWeather mHour7;
    private CurrentWeather mHour8;
    private CurrentWeather mHour9;
    private CurrentWeather mHour10;
    private CurrentWeather mHour11;
    private CurrentWeather mHour12;
    private CurrentWeather mHour13;
    private CurrentWeather mHour14;
    private CurrentWeather mHour15;
    private CurrentWeather mHour16;
    private CurrentWeather mHour17;
    private CurrentWeather mHour18;
    private CurrentWeather mHour19;
    private CurrentWeather mHour20;
    private CurrentWeather mHour21;
    private CurrentWeather mHour22;
    private CurrentWeather mHour23;
    private CurrentWeather mHour24;

    private String mSummary;
    private String mIcon;

    public HourlyWeather(CurrentWeather hour0, CurrentWeather hour1, CurrentWeather hour2, CurrentWeather hour3, CurrentWeather hour4, CurrentWeather hour5, CurrentWeather hour6, CurrentWeather hour7, CurrentWeather hour8, CurrentWeather hour9, CurrentWeather hour10, CurrentWeather hour11, CurrentWeather hour12, CurrentWeather hour13, CurrentWeather hour14, CurrentWeather hour15, CurrentWeather hour16, CurrentWeather hour17, CurrentWeather hour18, CurrentWeather hour19, CurrentWeather hour20, CurrentWeather hour21, CurrentWeather hour22, CurrentWeather hour23, CurrentWeather hour24, String summary, String icon) {
        mHour0 = hour0;
        mHour1 = hour1;
        mHour2 = hour2;
        mHour3 = hour3;
        mHour4 = hour4;
        mHour5 = hour5;
        mHour6 = hour6;
        mHour7 = hour7;
        mHour8 = hour8;
        mHour9 = hour9;
        mHour10 = hour10;
        mHour11 = hour11;
        mHour12 = hour12;
        mHour13 = hour13;
        mHour14 = hour14;
        mHour15 = hour15;
        mHour16 = hour16;
        mHour17 = hour17;
        mHour18 = hour18;
        mHour19 = hour19;
        mHour20 = hour20;
        mHour21 = hour21;
        mHour22 = hour22;
        mHour23 = hour23;
        mHour24 = hour24;
        mSummary = summary;
        mIcon = icon;
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

    public CurrentWeather getHour0() {
        return mHour0;
    }

    public void setHour0(CurrentWeather hour0) {
        mHour0 = hour0;
    }

    public CurrentWeather getHour1() {
        return mHour1;
    }

    public void setHour1(CurrentWeather hour1) {
        mHour1 = hour1;
    }

    public CurrentWeather getHour2() {
        return mHour2;
    }

    public void setHour2(CurrentWeather hour2) {
        mHour2 = hour2;
    }

    public CurrentWeather getHour3() {
        return mHour3;
    }

    public void setHour3(CurrentWeather hour3) {
        mHour3 = hour3;
    }

    public CurrentWeather getHour4() {
        return mHour4;
    }

    public void setHour4(CurrentWeather hour4) {
        mHour4 = hour4;
    }

    public CurrentWeather getHour5() {
        return mHour5;
    }

    public void setHour5(CurrentWeather hour5) {
        mHour5 = hour5;
    }

    public CurrentWeather getHour6() {
        return mHour6;
    }

    public void setHour6(CurrentWeather hour6) {
        mHour6 = hour6;
    }

    public CurrentWeather getHour7() {
        return mHour7;
    }

    public void setHour7(CurrentWeather hour7) {
        mHour7 = hour7;
    }

    public CurrentWeather getHour8() {
        return mHour8;
    }

    public void setHour8(CurrentWeather hour8) {
        mHour8 = hour8;
    }

    public CurrentWeather getHour9() {
        return mHour9;
    }

    public void setHour9(CurrentWeather hour9) {
        mHour9 = hour9;
    }

    public CurrentWeather getHour10() {
        return mHour10;
    }

    public void setHour10(CurrentWeather hour10) {
        mHour10 = hour10;
    }

    public CurrentWeather getHour11() {
        return mHour11;
    }

    public void setHour11(CurrentWeather hour11) {
        mHour11 = hour11;
    }

    public CurrentWeather getHour12() {
        return mHour12;
    }

    public void setHour12(CurrentWeather hour12) {
        mHour12 = hour12;
    }

    public CurrentWeather getHour13() {
        return mHour13;
    }

    public void setHour13(CurrentWeather hour13) {
        mHour13 = hour13;
    }

    public CurrentWeather getHour14() {
        return mHour14;
    }

    public void setHour14(CurrentWeather hour14) {
        mHour14 = hour14;
    }

    public CurrentWeather getHour15() {
        return mHour15;
    }

    public void setHour15(CurrentWeather hour15) {
        mHour15 = hour15;
    }

    public CurrentWeather getHour16() {
        return mHour16;
    }

    public void setHour16(CurrentWeather hour16) {
        mHour16 = hour16;
    }

    public CurrentWeather getHour17() {
        return mHour17;
    }

    public void setHour17(CurrentWeather hour17) {
        mHour17 = hour17;
    }

    public CurrentWeather getHour18() {
        return mHour18;
    }

    public void setHour18(CurrentWeather hour18) {
        mHour18 = hour18;
    }

    public CurrentWeather getHour19() {
        return mHour19;
    }

    public void setHour19(CurrentWeather hour19) {
        mHour19 = hour19;
    }

    public CurrentWeather getHour20() {
        return mHour20;
    }

    public void setHour20(CurrentWeather hour20) {
        mHour20 = hour20;
    }

    public CurrentWeather getHour21() {
        return mHour21;
    }

    public void setHour21(CurrentWeather hour21) {
        mHour21 = hour21;
    }

    public CurrentWeather getHour22() {
        return mHour22;
    }

    public void setHour22(CurrentWeather hour22) {
        mHour22 = hour22;
    }

    public CurrentWeather getHour23() {
        return mHour23;
    }

    public void setHour23(CurrentWeather hour23) {
        mHour23 = hour23;
    }

    public CurrentWeather getHour24() {
        return mHour24;
    }

    public void setHour24(CurrentWeather hour24) {
        mHour24 = hour24;
    }
}
