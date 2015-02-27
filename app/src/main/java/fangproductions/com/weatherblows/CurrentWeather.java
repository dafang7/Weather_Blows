package fangproductions.com.weatherblows;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/**
 * Created by Derek Fang on 2/15/2015.
 */
public class CurrentWeather {
    private long mTime;
    private String mSummary;
    private String mIcon;
    private String mTimezone;
    private double mNearestStormDistance;
    private double mNearestStormBearing;
    private double mPrecipIntensity;
    private double mPrecipProbability;
    private double mTemperature;
    private double mApparentTemperature;
    private double mDewPoint;
    private double mHumidity;
    private double mWindSpeed;
    private double mWindBearing;
    private double mVisibility;
    private double mCloudCover;
    private double mPressure;
    private double mOzone;

    public CurrentWeather(String timezone, long time, String summary, String icon, double nearestStormDistance, double nearestStormBearing, double precipIntensity, double precipProbability, double temperature, double apparentTemperature, double dewPoint, double humidity, double windSpeed, double windBearing, double visibility, double cloudCover, double pressure, double ozone) {
        mTimezone = timezone;
        mTime = time;
        mSummary = summary;
        mIcon = icon;
        mNearestStormDistance = nearestStormDistance;
        mNearestStormBearing = nearestStormBearing;
        mPrecipIntensity = precipIntensity;
        mPrecipProbability = precipProbability;
        mTemperature = temperature;
        mApparentTemperature = apparentTemperature;
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

    public long getTime() {
        return mTime;
    }

    public void setTime(long time) {
        mTime = time;
    }

    public String getFormattedTime(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("hh:mm a");
        dateFormat.setTimeZone(TimeZone.getTimeZone(mTimezone));
        Date date = new Date(getTime() *1000);
        return dateFormat.format(date);
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

    public double getNearestStormDistance() {
        return mNearestStormDistance;
    }

    public void setNearestStormDistance(double nearestStormDistance) {
        mNearestStormDistance = nearestStormDistance;
    }

    public double getNearestStormBearing() {
        return mNearestStormBearing;
    }

    public void setNearestStormBearing(double nearestStormBearing) {
        mNearestStormBearing = nearestStormBearing;
    }

    public double getPrecipIntensity() {
        return mPrecipIntensity;
    }

    public void setPrecipIntensity(double precipIntensity) {
        mPrecipIntensity = precipIntensity;
    }

    public double getPrecipProbability() {
        return mPrecipProbability;
    }

    public void setPrecipProbability(double precipProbability) {
        mPrecipProbability = precipProbability;
    }

    public double getTemperature() {
        return mTemperature;
    }

    public int getIntTemperature() {
        return (int) Math.round(mTemperature);
    }

    public void setTemperature(double temperature) {
        mTemperature = temperature;
    }

    public double getApparentTemperature() {
        return mApparentTemperature;
    }

    public int getIntApparentTemperature() {
        return (int) Math.round(mApparentTemperature);
    }

    public void setApparentTemperature(double apparentTemperature) {
        mApparentTemperature = apparentTemperature;
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

