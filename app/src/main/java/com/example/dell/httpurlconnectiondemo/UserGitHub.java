package com.example.dell.httpurlconnectiondemo;

/**
 * Created by Dell on 24-Jan-18.
 */

public class UserGitHub {

    private int mID;
    private String mName;
    private String mDescription;

    public int getID() {
        return mID;
    }

    public void setID(int ID) {
        mID = ID;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }

    public String getDescription() {
        return mDescription;
    }

    public void setDescription(String description) {
        mDescription = description;
    }

    public UserGitHub(int ID, String name, String description) {
        mID = ID;
        mName = name;
        mDescription = description;
    }
}
