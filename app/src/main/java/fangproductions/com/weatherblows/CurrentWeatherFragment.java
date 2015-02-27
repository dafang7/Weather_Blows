package fangproductions.com.weatherblows;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by Derek Fang on 2/16/2015.
 */
public class CurrentWeatherFragment extends Fragment{

    public static final String TAG = CurrentWeatherFragment.class.getSimpleName();
    private TextView mCurrentTemperature;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_currently, container, false);
        return rootView;
    }

    @Override
    public void onResume() {
        super.onResume();
        mCurrentTemperature = (TextView) getActivity().findViewById(R.id.currentTempView);
        mCurrentTemperature.setText("75");
    }
}
