package com.example.android.newsstage1;

import android.content.AsyncTaskLoader;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.List;

public class NewsLoader extends AsyncTaskLoader<List<News>> {
    /** Tag for log messages */
    private static final String LOG_TAG = NewsLoader.class.getName();

    /** Query URL */
    private String mUrl;

    /**
     * Constructs a new {@link NewsLoader).
     *
     * @param context of the activity
     * @param url to load data from
     */
    public NewsLoader(Context context, String url) {
        super(context);
        Log.i(LOG_TAG,"TEST: EarthquakeLoader called..");
        mUrl = url;
    }

    @Override
    protected void onStartLoading() {

        Log.i(LOG_TAG,"TEST: onStartLoading()called..");
        forceLoad();
    }

    /**
     * This is on a background thread.
     */
    @Override
    public List<News> loadInBackground() {
        Log.i(LOG_TAG,"TEST:  loadInBackground called..");
        if (mUrl == null) {
            return null;
        }

        // Perform the network request, parse the response, and extract a list of earthquakes.
        List<News> news = QueryUtils.fetchNewsData(mUrl);
        return news;
    }

}
