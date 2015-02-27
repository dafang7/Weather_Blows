package fangproductions.com.weatherblows;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;


public class MainActivity extends ActionBarActivity {

    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    SectionsPagerAdapter mSectionsPagerAdapter;
    private final static String TAG = MainActivity.class.getSimpleName();
    private final String mApiKey = ForecastConstants.KEY_FORECAST_API;
    private double mLatitude;
    private double mLongitude;
    private CurrentWeather mCurrentWeather;
    private HourlyWeather mHourlyWeather;
    private DailyWeather mDailyWeather;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if(isNetworkConnected()){
            //Network is connected. Do internet things
            //Since the network is connected, get the GPS location
            getLocationCoordinates();

            final String forecastUrl = ForecastConstants.KEY_FORECAST_WEBSITE +
                    mApiKey + "/" + mLatitude + "," + mLongitude;

            //Use OKHttp to get the JSON data
            OkHttpClient client = new OkHttpClient();
            Request request = new Request.Builder()
                    .url(forecastUrl)
                    .build();
            Call call = client.newCall(request);
            call.enqueue(new Callback() {
                @Override
                public void onFailure(Request request, IOException e) {

                }

                @Override
                public void onResponse(Response response) throws IOException {

                    try {

                        String jsonData = response.body().string();
                        Log.v(TAG, response.body().string());
                        Log.d(TAG, forecastUrl);

                        if (response.isSuccessful()) {
                            mCurrentWeather = getCurrentWeather(jsonData);
                            Log.d(TAG, mCurrentWeather.getTimezone() + " feels like:  " + mCurrentWeather.getIntApparentTemperature() + " F");
                            Log.d(TAG, mCurrentWeather.getFormattedTime() + " " + mCurrentWeather.getIntTemperature() + " F");

                            mHourlyWeather = getHourlyWeather(jsonData);
                            Log.d(TAG, mHourlyWeather.getHour0().getFormattedTime() + " Hour 0 Time");
                            Log.d(TAG, mHourlyWeather.getHour1().getFormattedTime() + " Hour 1 Time");
                            Log.d(TAG, mHourlyWeather.getHour24().getFormattedTime() + " Hour 24 Time");
                            Log.d(TAG, "Icon: " + mHourlyWeather.getIcon() + " summary: " + mHourlyWeather.getSummary() );

                            mDailyWeather = getDailyWeather(jsonData);
                            Log.d(TAG, "Day current Time: " + mDailyWeather.getDay0().getFormattedTime() + " sunrise time: " + mDailyWeather.getDay0().getFormattedSunriseTime());
                            Log.d(TAG, "Day current Time 1: " + mDailyWeather.getDay1().getFormattedTime());
                            Log.d(TAG, "Day current Time 7: " + mDailyWeather.getDay7().getFormattedTime());

                        }
                    } catch (JSONException e){
                        Log.e(TAG, getString(R.string.exception_JSON),e);
                    }
                }
            });

        }else{
            //internet is not connected. Tell the User about his folly.
            Toast.makeText(this, getString(R.string.error_no_network), Toast.LENGTH_LONG).show();

        }


        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        //2/16: updated to pass the context to the separate class
        mSectionsPagerAdapter = new SectionsPagerAdapter(this, getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.pager);
        mViewPager.setAdapter(mSectionsPagerAdapter);

    }

    private DailyWeather getDailyWeather(String jsonData) throws JSONException {

        JSONObject forecast = new JSONObject(jsonData);
        JSONObject dailyForecast = forecast.getJSONObject(ForecastConstants.KEY_DAILY);
        JSONArray dailyArray = dailyForecast.getJSONArray(ForecastConstants.KEY_DATA);

        DailyWeatherData[] dailyWeatherArray = new DailyWeatherData[DailyWeather.DAYS];

        for(int i=0; i < DailyWeather.DAYS ; i++){
            //create individuals objects for the 8 days
            JSONObject day = dailyArray.getJSONObject(i);
            //Need an if statement because Visibility is not offered more that 4 days forward.
            if(i < 4) {
                dailyWeatherArray[i] = new DailyWeatherData(
                        forecast.getString(ForecastConstants.KEY_TIMEZONE),
                        day.getLong(ForecastConstants.KEY_TIME),
                        day.getString(ForecastConstants.KEY_SUMMARY),
                        day.getString(ForecastConstants.KEY_ICON),
                        day.getLong(ForecastConstants.KEY_SUNRISE_TIME),
                        day.getLong(ForecastConstants.KEY_SUNSET_TIME),
                        day.getDouble(ForecastConstants.KEY_MOON_PHASE),
                        day.getDouble(ForecastConstants.KEY_PRECIP_INTENSITY),
                        day.getDouble(ForecastConstants.KEY_PRECIP_INTENSITY_MAX),
                        day.getDouble(ForecastConstants.KEY_PRECIP_PROBABILITY),
                        day.getDouble(ForecastConstants.KEY_TEMPERATURE_MIN),
                        day.getLong(ForecastConstants.KEY_TEMPERATURE_MIN_TIME),
                        day.getDouble(ForecastConstants.KEY_TEMPERATURE_MAX),
                        day.getLong(ForecastConstants.KEY_TEMPERATURE_MAX_TIME),
                        day.getDouble(ForecastConstants.KEY_APPARENT_TEMPERATURE_MIN),
                        day.getLong(ForecastConstants.KEY_APPARENT_TEMPERATURE_MIN_TIME),
                        day.getDouble(ForecastConstants.KEY_APPARENT_TEMPERATURE_MAX),
                        day.getLong(ForecastConstants.KEY_APPARENT_TEMPERATURE_MAX_TIME),
                        day.getDouble(ForecastConstants.KEY_DEW_POINT),
                        day.getDouble(ForecastConstants.KEY_HUMIDITY),
                        day.getDouble(ForecastConstants.KEY_WIND_SPEED),
                        day.getDouble(ForecastConstants.KEY_WIND_BEARING),
                        day.getDouble(ForecastConstants.KEY_VISIBILITY),
                        day.getDouble(ForecastConstants.KEY_CLOUD_COVER),
                        day.getDouble(ForecastConstants.KEY_PRESSURE),
                        day.getDouble(ForecastConstants.KEY_OZONE)
                );
            }else{
                dailyWeatherArray[i] = new DailyWeatherData(
                        forecast.getString(ForecastConstants.KEY_TIMEZONE),
                        day.getLong(ForecastConstants.KEY_TIME),
                        day.getString(ForecastConstants.KEY_SUMMARY),
                        day.getString(ForecastConstants.KEY_ICON),
                        day.getLong(ForecastConstants.KEY_SUNRISE_TIME),
                        day.getLong(ForecastConstants.KEY_SUNSET_TIME),
                        day.getDouble(ForecastConstants.KEY_MOON_PHASE),
                        day.getDouble(ForecastConstants.KEY_PRECIP_INTENSITY),
                        day.getDouble(ForecastConstants.KEY_PRECIP_INTENSITY_MAX),
                        day.getDouble(ForecastConstants.KEY_PRECIP_PROBABILITY),
                        day.getDouble(ForecastConstants.KEY_TEMPERATURE_MIN),
                        day.getLong(ForecastConstants.KEY_TEMPERATURE_MIN_TIME),
                        day.getDouble(ForecastConstants.KEY_TEMPERATURE_MAX),
                        day.getLong(ForecastConstants.KEY_TEMPERATURE_MAX_TIME),
                        day.getDouble(ForecastConstants.KEY_APPARENT_TEMPERATURE_MIN),
                        day.getLong(ForecastConstants.KEY_APPARENT_TEMPERATURE_MIN_TIME),
                        day.getDouble(ForecastConstants.KEY_APPARENT_TEMPERATURE_MAX),
                        day.getLong(ForecastConstants.KEY_APPARENT_TEMPERATURE_MAX_TIME),
                        day.getDouble(ForecastConstants.KEY_DEW_POINT),
                        day.getDouble(ForecastConstants.KEY_HUMIDITY),
                        day.getDouble(ForecastConstants.KEY_WIND_SPEED),
                        day.getDouble(ForecastConstants.KEY_WIND_BEARING),
                        0, // visibility is not offered 4 days in advance
                        day.getDouble(ForecastConstants.KEY_CLOUD_COVER),
                        day.getDouble(ForecastConstants.KEY_PRESSURE),
                        day.getDouble(ForecastConstants.KEY_OZONE)
                );
            }

        }

        return new DailyWeather(
                dailyForecast.getString(ForecastConstants.KEY_SUMMARY),
                dailyForecast.getString(ForecastConstants.KEY_ICON),
                dailyWeatherArray[0],
                dailyWeatherArray[1],
                dailyWeatherArray[2],
                dailyWeatherArray[3],
                dailyWeatherArray[4],
                dailyWeatherArray[5],
                dailyWeatherArray[6],
                dailyWeatherArray[7]
        );
    }

/*    private DailyWeather getDailyWeather(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        JSONObject dailyForecast = forecast.getJSONObject("daily");

    }*/

    private HourlyWeather getHourlyWeather(String jsonData) throws JSONException {
        JSONObject forecast = new JSONObject(jsonData);
        JSONObject hourlyForecast = forecast.getJSONObject(ForecastConstants.KEY_HOURLY);
        JSONArray hourlyArray = hourlyForecast.getJSONArray(ForecastConstants.KEY_DATA);

        CurrentWeather[] hourlyWeatherArray = new CurrentWeather[HourlyWeather.HOURS];

        for (int i = 0; i < HourlyWeather.HOURS ; i++){
            //Create individual JSON object for each item in "data" hours array
            JSONObject hour = hourlyArray.getJSONObject(i);
            hourlyWeatherArray[i] = new CurrentWeather(
                    forecast.getString(ForecastConstants.KEY_TIMEZONE),
                    hour.getLong(ForecastConstants.KEY_TIME),
                    hour.getString(ForecastConstants.KEY_SUMMARY),
                    hour.getString(ForecastConstants.KEY_ICON),
                    0, //Storm Distance is not offered in hourly
                    0, //Storm Bearing is not offered in hourly
                    hour.getDouble(ForecastConstants.KEY_PRECIP_INTENSITY),
                    hour.getDouble(ForecastConstants.KEY_PRECIP_PROBABILITY),
                    hour.getDouble(ForecastConstants.KEY_TEMPERATURE),
                    hour.getDouble(ForecastConstants.KEY_APPARENT_TEMPERATURE),
                    hour.getDouble(ForecastConstants.KEY_DEW_POINT),
                    hour.getDouble(ForecastConstants.KEY_HUMIDITY),
                    hour.getDouble(ForecastConstants.KEY_WIND_SPEED),
                    hour.getDouble(ForecastConstants.KEY_WIND_BEARING),
                    hour.getDouble(ForecastConstants.KEY_VISIBILITY),
                    hour.getDouble(ForecastConstants.KEY_CLOUD_COVER),
                    hour.getDouble(ForecastConstants.KEY_PRESSURE),
                    hour.getDouble(ForecastConstants.KEY_OZONE)
            );
        }

        return new HourlyWeather(
                hourlyWeatherArray[0],
                hourlyWeatherArray[1],
                hourlyWeatherArray[2],
                hourlyWeatherArray[3],
                hourlyWeatherArray[4],
                hourlyWeatherArray[5],
                hourlyWeatherArray[6],
                hourlyWeatherArray[7],
                hourlyWeatherArray[8],
                hourlyWeatherArray[9],
                hourlyWeatherArray[10],
                hourlyWeatherArray[11],
                hourlyWeatherArray[12],
                hourlyWeatherArray[13],
                hourlyWeatherArray[14],
                hourlyWeatherArray[15],
                hourlyWeatherArray[16],
                hourlyWeatherArray[17],
                hourlyWeatherArray[18],
                hourlyWeatherArray[19],
                hourlyWeatherArray[20],
                hourlyWeatherArray[21],
                hourlyWeatherArray[22],
                hourlyWeatherArray[23],
                hourlyWeatherArray[24],
                hourlyForecast.getString(ForecastConstants.KEY_SUMMARY),
                hourlyForecast.getString(ForecastConstants.KEY_ICON)
        );
    }

    private CurrentWeather getCurrentWeather(String jsonData) throws JSONException{
        JSONObject forecast = new JSONObject(jsonData);
        JSONObject currentForecast = forecast.getJSONObject(ForecastConstants.KEY_CURRENTLY);
        return new CurrentWeather(
                forecast.getString(ForecastConstants.KEY_TIMEZONE),
                currentForecast.getLong(ForecastConstants.KEY_TIME),
                currentForecast.getString(ForecastConstants.KEY_SUMMARY),
                currentForecast.getString(ForecastConstants.KEY_ICON),
                currentForecast.getDouble(ForecastConstants.KEY_NEAREST_STORM_DISTANCE),
                currentForecast.getDouble(ForecastConstants.KEY_NEAREST_STORM_BEARING),
                currentForecast.getDouble(ForecastConstants.KEY_PRECIP_INTENSITY),
                currentForecast.getDouble(ForecastConstants.KEY_PRECIP_PROBABILITY),
                currentForecast.getDouble(ForecastConstants.KEY_TEMPERATURE),
                currentForecast.getDouble(ForecastConstants.KEY_APPARENT_TEMPERATURE),
                currentForecast.getDouble(ForecastConstants.KEY_DEW_POINT),
                currentForecast.getDouble(ForecastConstants.KEY_HUMIDITY),
                currentForecast.getDouble(ForecastConstants.KEY_WIND_SPEED),
                currentForecast.getDouble(ForecastConstants.KEY_WIND_BEARING),
                currentForecast.getDouble(ForecastConstants.KEY_VISIBILITY),
                currentForecast.getDouble(ForecastConstants.KEY_CLOUD_COVER),
                currentForecast.getDouble(ForecastConstants.KEY_PRESSURE),
                currentForecast.getDouble(ForecastConstants.KEY_OZONE)
                );
    }

    private void getLocationCoordinates() {
        mLatitude = 41.8811;
        mLongitude = -87.8433;
    }

    //Method to check if the internet is successfully connected.
    private boolean isNetworkConnected() {
        boolean isConnected = false;
        ConnectivityManager manager = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo network = manager.getActiveNetworkInfo();
        if(network != null && network.isConnected()){
            isConnected = true;
        }
        return isConnected;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);
            fragment.setArguments(args);
            return fragment;
        }

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_currently, container, false);
            return rootView;
        }
    }

}
