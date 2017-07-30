package com.example.deepanshu.gsonandretrofit.network;

import com.example.deepanshu.gsonandretrofit.Course;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by deepanshu on 30/7/17.
 */

public class CourseResponse {

    public Data data;
    public int status;

    public static class Data{

        @SerializedName("courses")
        ArrayList<Course> courseArrayList;

        public ArrayList<Course> getCourseArrayList() {
            return courseArrayList;
        }
    }
}
