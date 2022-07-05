package com.example.lab07_2_asynctaskloader;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.loader.content.AsyncTaskLoader;

public class BookAsyncTaskLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    // bat buoc phai co constructor do AsyncTaskLoader ko co default constructor
    public BookAsyncTaskLoader(@NonNull Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }
    @Nullable
    @Override
    public String loadInBackground() {
        return NetworkUtils.getBookInfo(mQueryString);
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }
}
