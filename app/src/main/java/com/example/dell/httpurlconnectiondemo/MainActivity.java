package com.example.dell.httpurlconnectiondemo;

import android.content.Context;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayList<UserGitHub> mListUser = new ArrayList<>();
    private RecyclerView mRecyclerView;
    public static final String LOG_TAG = MainActivity.class.getName();
    private static final String REQUEST_URL = "https://api.github.com/users/google/repos";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        displayRecyclerView();

        UserAsyncTask task = new UserAsyncTask();
        task.execute(REQUEST_URL);


    }

    private void displayRecyclerView(){
        mRecyclerView = findViewById(R.id.recycler_view);
        mRecyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        mRecyclerView.setLayoutManager(linearLayoutManager);

        UserAdapter userAdapter = new UserAdapter(this, mListUser);
        mRecyclerView.setAdapter(userAdapter);


    }


}
