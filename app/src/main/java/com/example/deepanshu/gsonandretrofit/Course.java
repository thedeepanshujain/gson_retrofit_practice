package com.example.deepanshu.gsonandretrofit;

/**
 * Created by deepanshu on 26/7/17.
 */

public class Course {

    private int mId;
    private String mTitle;
    private String mName;
    private boolean mIsActive;
    private String mOverview;
    private double mFeeWithTaxes;

    public Course(int id, String title, String name, boolean isActive, String overview, int feeWithTaxes) {
        this.mId = id;
        this.mTitle = title;
        this.mName = name;
        this.mIsActive = isActive;
        this.mOverview = overview;
        this.mFeeWithTaxes = feeWithTaxes;
    }


    public String getTitle() {
        return mTitle;
    }

    public String getName() {
        return mName;
    }


    public boolean isIsActive() {
        return mIsActive;
    }

    public String getOverview() {
        return mOverview;
    }

    public double getFeeWithTaxes() {
        return mFeeWithTaxes;
    }

    public int getId() {
        return mId;
    }
}
