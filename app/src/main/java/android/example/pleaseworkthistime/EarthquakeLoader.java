package android.example.pleaseworkthistime;
import android.content.AsyncTaskLoader;
import android.content.Context;
import android.util.Log;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class EarthquakeLoader extends AsyncTaskLoader<ArrayList<Earthquake>> {
    private String strings;
    private static final String LOG_TAG = EarthquakeLoader.class.getName();
    public EarthquakeLoader(Context context,String url) {
        super(context);
        strings=url;
    }

    @Override
    public ArrayList<Earthquake> loadInBackground() {
        Log.i(LOG_TAG, "loadinbackground is called");
        if(strings==null)
            return null;
        ArrayList<Earthquake> earthquakes=QueryUtils.fetchEarthquakeData(strings);
        return earthquakes;
    }
    @Override
    protected void onStartLoading() {
        Log.i(LOG_TAG, "onStartLoading is called");
        forceLoad();
    }

}