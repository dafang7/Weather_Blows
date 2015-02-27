package fangproductions.com.weatherblows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Derek Fang on 2/15/2015.
 * Daily weather is so different that it needs a classs of its own
 * Lots of different information displayed from the Current Weather class
 */
public class DailyWeatherData{

    private String mTimezone;
    private long mTime;
    private String mSummary;
    private String mIcon;
    private long mSunriseTime;
    private long mSunsetTime;
    private double mMoonPhase;
    private double mPrecipIntensity;
    private double mPrecipIntensityMax;
    private double mPrecipProbability;
    private double mTemperatureMin;
    private long mTemperatureMinTime;
    private double mTemperatureMax;
    private long mTemperatureMaxTime;
    private double mApparentTemperatureMin;
    private long mApparentTemperatureMinTime;
    private double mApparentTemperatureMax;
    private long mApparentTemperatureMaxTime;
    private double mDewPoint;
    private double mHumidity;
    private double mWindSpeed;
    private double mWindBearing;
    private double mVisibility;
    private double mCloudCover;
    private double mPressure;
    private double mOzone;

    public DailyWeatherData(String timezone, long time, String summary, String icon, long sunriseTime, long sunsetTime, double moonPhase, double precipIntensity, double precipIntensityMax, double precipProbability, double temperatureMin, long temperatureMinTime, double temperatureMax, long temperatureMaxTime, double apparentTemperatureMin, long apparentTemperatureMinTime, double apparentTemperatureMax, long apparentTemperatureMaxTime, double dewPoint, double humidity, double windSpeed, double windBearing, double visibility, double cloudCover, double pressure, double ozone) {
        mTimezone = timezone;
        mTime = time;
        mSummary = summary;
        mIcon = icon;
        mSunriseTime = sunriseTime;
        mSunsetTime = sunsetTime;
        mMoonPhase = moonPhase;
        mPrecipIntensity = precipIntensity;
        mPrecipIntensityMax = precipIntensityMax;
        mPrecipProbability = precipProbability;
        mTemperatureMin = temperatureMin;
        mTemperatureMinTime = temperatureMinTime;
        mTemperatureMax = temperatureMax;
        mTemperatureMaxTime = temperatureMaxTime;
        mApparentTemperatureMin = apparentTemperatureMin;
        mApparentTemperatureMinTime = apparentTemperatureMinTime;
        mApparentTemperatureMax = apparentTemperatureMax;
        mApparentTemperatureMaxTime = apparentTemperatureMaxTime;
        mDewPoint = dewPoint;
        mHumidity = humidity;
        mWindSpeed = windSpeed;
        mWindBearing = windBearing;
        mVisibility = visibility;
        mCloudCover = cloudCover;
        mPressure = pressure;
        mOzone = ozone;
    }

    public String getTimezone() {
        return mTimezone;
    }

    public void setTimezone(String timezone) {
        mTimezone = timezone;
    }

    private String formatTime(long time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        dateFormat.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date date = new Date(time * 1000);
        return dateFormat.format(date);
    }

    private String formatDayOfWeek(long time){
        SimpleDateFormat dateFormat = new SimpleDateFormat("EEEE");
        dateFormat.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date date = new Date(time * 1000);
        return dateFormat.format(date);
    }


    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getFormattedTime(){
        return formatDayOfWeek(getTime());
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

    //Get icon ID for when the text is related to an image
    // This may be moved later to a separate class that uses more data to pick an image.
    public int getIconId(){
        int iconId = 0;
        if (mIcon.equals("clear-day")) {
            //iconId = R.drawable.clear_day;
        }
        else if (mIcon.equals("clear-night")) {
            //iconId = R.drawable.clear_night;
        }
        else if (mIcon.equals("rain")) {
            //iconId = R.drawable.rain;
        }
        else if (mIcon.equals("snow")) {
            //iconId = R.drawable.snow;
        }
        else if (mIcon.equals("sleet")) {
            //iconId = R.drawable.sleet;
        }
        else if (mIcon.equals("wind")) {
            //iconId = R.drawable.wind;
        }
        else if (mIcon.equals("fog")) {
            //iconId = R.drawable.fog;
        }
        else if (mIcon.equals("cloudy")) {
            //iconId = R.drawable.cloudy;
        }
        else if (mIcon.equals("partly-cloudy-day")) {
            //iconId = R.drawable.partly_cloudy;
        }
        else if (mIcon.equals("partly-cloudy-night")) {
            //iconId = R.drawable.cloudy_night;
        }else if (mIcon.equals("hail")){
            //iconId = R.drawable.hail;
        }else if (mIcon.equals("thunderstorm")){
            //iconId = R.drawable.thunderstorm;
        }else if (mIcon.equals("tornado")){
            //iconId = R.drawable.tornado;
        }

        return iconId;
    }

    public long getSunriseTime() {
        return mSunriseTime;
    }

    public void setSunriseTime(long sunriseTime) {
        mSunriseTime = sunriseTime;
    }

    public String getFormattedSunriseTime(){
        return formatTime(getSunriseTime());
    }

    public long getSunsetTime() {
        return mSunsetTime;
    }

    public void setSunsetTime(long sunsetTime) {
        mSunsetTime = sunsetTime;
    }

    public String getFormattedSunsetTime(){
        return formatTime(getSunsetTime());
    }

    public double getMoonPhase() {
        return mMoonPhase;
    }

    public void setMoonPhase(double moonPhase) {
        mMoonPhase = moonPhase;
    }

    public double getPrecipIntensity() {
        return mPrecipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        mPrecipIntensity = precipIntensity;
    }

    public double getPrecipIntensityMax() {
        return mPrecipIntensityMax;
    }

    public void setPrecipIntensityMax(double precipIntensityMax) {
        mPrecipIntensityMax = precipIntensityMax;
    }

    public double getPrecipProbability() {
        return mPrecipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        mPrecipProbability = precipProbability;
    }

    public double getTemperatureMin() {
        return mTemperatureMin;
    }

    public int getIntTemperatureMin(){
        return (int) Math.round(mTemperatureMin);
    }

    public void setTemperatureMin(double temperatureMin) {
        mTemperatureMin = temperatureMin;
    }

    public long getTemperatureMinTime() {
        return mTemperatureMinTime;
    }

    public String getFormattedTempMinTime(){
        return formatTime(getTemperatureMinTime());
    }

    public void setTemperatureMinTime(long temperatureMinTime) {
        mTemperatureMinTime = temperatureMinTime;
    }

    public double getTemperatureMax() {
        return mTemperatureMax;
    }

    public int getIntTemperatureMax(){
        return (int) Math.round(mTemperatureMax);
    }

    public void setTemperatureMax(double temperatureMax) {
        mTemperatureMax = temperatureMax;
    }

    public long getTemperatureMaxTime() {
        return mTemperatureMaxTime;
    }

    public String getFormattedTempMaxTime(){
        return formatTime(getTemperatureMaxTime());
    }
    public void setTemperatureMaxTime(long temperatureMaxTime) {
        mTemperatureMaxTime = temperatureMaxTime;
    }

    public double getApparentTemperatureMin() {
        return mApparentTemperatureMin;
    }

    public int getIntApparentTemperatureMin(){
        return (int) Math.round(mApparentTemperatureMin);
    }

    public void setApparentTemperatureMin(double apparentTemperatureMin) {
        mApparentTemperatureMin = apparentTemperatureMin;
    }

    public long getApparentTemperatureMinTime() {
        return mApparentTemperatureMinTime;
    }

    public String getFormattedApparentTempMinTime(){
        return formatTime(getApparentTemperatureMinTime());
    }

    public void setApparentTemperatureMinTime(long apparentTemperatureMinTime) {
        mApparentTemperatureMinTime = apparentTemperatureMinTime;
    }

    public double getApparentTemperatureMax() {
        return mApparentTemperatureMax;
    }

    public int getIntApparentTemperatureMax(){
        return (int) Math.round(mApparentTemperatureMax);
    }

    public void setApparentTemperatureMax(double apparentTemperatureMax) {
        mApparentTemperatureMax = apparentTemperatureMax;
    }

    public long getApparentTemperatureMaxTime() {
        return mApparentTemperatureMaxTime;
    }

    public String getFormattedApparentTempMaxTime(){
        return formatTime(getApparentTemperatureMaxTime());
    }

    public void setApparentTemperatureMaxTime(long apparentTemperatureMaxTime) {
        mApparentTemperatureMaxTime = apparentTemperatureMaxTime;
    }

    public double getDewPoint() {
        return mDewPoint;
    }

    public void setDewPoint(double dewPoint) {
        mDewPoint = dewPoint;
    }

    public double getHumidity() {
        return mHumidity;
    }

    public void setHumidity(double humidity) {
        mHumidity = humidity;
    }

    public double getWindSpeed() {
        return mWindSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        mWindSpeed = windSpeed;
    }

    public double getWindBearing() {
        return mWindBearing;
    }

    public void setWindBearing(double windBearing) {
        mWindBearing = windBearing;
    }

    public double getVisibility() {
        return mVisibility;
    }

    public void setVisibility(double visibility) {
        mVisibility = visibility;
    }

    public double getCloudCover() {
        return mCloudCover;
    }

    public void setCloudCover(double cloudCover) {
        mCloudCover = cloudCover;
    }

    public double getPressure() {
        return mPressure;
    }

    public void setPressure(double pressure) {
        mPressure = pressure;
    }

    public double getOzone() {
        return mOzone;
    }

    public void setOzone(double ozone) {
        mOzone = ozone;
    }
}
