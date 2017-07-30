package com.example.deepanshu.gsonandretrofit.network;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by deepanshu on 26/7/17.
 */

public interface ApiInterface {

    @GET("courses")
    Call<CourseResponse> getCourses();
}
