package com.example.dell.httpurlconnectiondemo;

import android.content.Context;
import android.os.AsyncTask;
import java.util.ArrayList;

/**
 * Created by Dell on 25-Jan-18.
 */

public class UserAsyncTask extends AsyncTask<String, Void, ArrayList<UserGitHub>> {

    private ArrayList<UserGitHub> mListUser = new ArrayList<>();
    private OnFetchData mOnFetchData = null;

    public UserAsyncTask(OnFetchData OnFetchData) {
        this.mOnFetchData = OnFetchData;
    }

    @Override
    protected ArrayList<UserGitHub> doInBackground(String... urls) {

        // Don't perform the request if there are no URLs, or the first URL is null.
        if (urls.length < 1 || urls[0] == null) {
            return null;
        }

        mListUser = QueryUtils.fetchUserGitHub(urls[0]);
        return mListUser;
    }

    @Override
    protected void onPostExecute(ArrayList<UserGitHub> userGitHubs) {
        super.onPostExecute(userGitHubs);
        mOnFetchData.OnFetchDataSuccess(userGitHubs);
    }
    
}
