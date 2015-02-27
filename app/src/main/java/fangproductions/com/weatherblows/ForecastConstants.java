package fangproductions.com.weatherblows;

/**
 * Created by Derek Fang on 2/25/2015.
 * Class to hold all the values that are standard to retrieve the JSON data from forecast.io
 */
public class ForecastConstants {
    //Weather strings for the JSON data
    public static final String KEY_CURRENTLY = "currently";
    public static final String KEY_HOURLY = "hourly";
    public static final String KEY_DAILY = "daily";
    public static final String KEY_DATA = "data";
    public static final String KEY_FORECAST_WEBSITE = "https://api.forecast.io/forecast/";
    public static final String KEY_FORECAST_API = "18a00e0c47e1e983e9a0435a0b3318ec";

    //All
    public static final String KEY_TIMEZONE = "timezone";
    public static final String KEY_TIME = "time";
    public static final String KEY_SUMMARY = "summary";
    public static final String KEY_ICON = "icon";
    public static final String KEY_NEAREST_STORM_DISTANCE = "nearestStormDistance";
    public static final String KEY_NEAREST_STORM_BEARING = "nearestStormBearing";
    public static final String KEY_PRECIP_INTENSITY = "precipIntensity";
    public static final String KEY_PRECIP_PROBABILITY = "precipProbability";
    public static final String KEY_TEMPERATURE = "temperature";
    public static final String KEY_APPARENT_TEMPERATURE = "apparentTemperature";
    public static final String KEY_DEW_POINT = "dewPoint";
    public static final String KEY_HUMIDITY = "humidity";
    public static final String KEY_WIND_SPEED = "windSpeed";
    public static final String KEY_WIND_BEARING = "windBearing";
    public static final String KEY_VISIBILITY = "visibility";
    public static final String KEY_CLOUD_COVER = "cloudCover";
    public static final String KEY_PRESSURE = "pressure";
    public static final String KEY_OZONE = "ozone";

    //Daily Weather Only
    public static final String KEY_SUNRISE_TIME = "sunriseTime";
    public static final String KEY_SUNSET_TIME = "sunsetTime";
    public static final String KEY_MOON_PHASE = "moonPhase";
    public static final String KEY_PRECIP_INTENSITY_MAX = "precipIntensityMax";
    public static final String KEY_TEMPERATURE_MIN = "temperatureMin";
    public static final String KEY_TEMPERATURE_MIN_TIME = "temperatureMinTime";
    public static final String KEY_TEMPERATURE_MAX = "temperatureMax";
    public static final String KEY_TEMPERATURE_MAX_TIME = "temperatureMaxTime";
    public static final String KEY_APPARENT_TEMPERATURE_MIN = "apparentTemperatureMin";
    public static final String KEY_APPARENT_TEMPERATURE_MIN_TIME = "apparentTemperatureMinTime";
    public static final String KEY_APPARENT_TEMPERATURE_MAX = "apparentTemperatureMax";
    public static final String KEY_APPARENT_TEMPERATURE_MAX_TIME = "apparentTemperatureMaxTime";

}
