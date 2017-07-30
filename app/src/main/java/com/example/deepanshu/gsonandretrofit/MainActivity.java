package com.example.deepanshu.gsonandretrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.deepanshu.gsonandretrofit.network.ApiInterface;
import com.example.deepanshu.gsonandretrofit.network.CourseResponse;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    final static String TAG = "TAG";
    ListView listView;
    ArrayList<Course> courseArrayList;
    ArrayList<String> courseTitleArrayList;
    ArrayAdapter<String> mCourseAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Courses We Offer");

        listView = (ListView) findViewById(R.id.listView);
        courseArrayList = new ArrayList<>();
        courseTitleArrayList = new ArrayList<>();
        mCourseAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,courseTitleArrayList);
        listView.setAdapter(mCourseAdapter);
        fetchCourses();

    }

    private void fetchCourses() {

        Retrofit retrofit = new Retrofit.Builder().baseUrl("https://codingninjas.in/api/v1/")
                .addConverterFactory(GsonConverterFactory.create()).build();

        ApiInterface apiInterface = retrofit.create(ApiInterface.class);

        Call<CourseResponse> courseResponseCall = apiInterface.getCourses();

        courseResponseCall.enqueue(new Callback<CourseResponse>() {
            @Override
            public void onResponse(Call<CourseResponse> call, Response<CourseResponse> response) {
                CourseResponse courseResponse = response.body();
                ArrayList<Course> fetchedCourseList = courseResponse.data.getCourseArrayList();
//                Log.i(TAG, "onResponse: "+ fetchedCourseList.size());
                courseArrayList.clear();
                courseTitleArrayList.clear();
                courseArrayList.addAll(fetchedCourseList);
//                Log.i(TAG, "onResponse: "+courseArrayList.size());
                for(int i=0;i<courseArrayList.size();i++){
                    Log.i(TAG, "onResponse: "+courseArrayList.get(i).getName());
                    Course course = courseArrayList.get(i);
//                    Log.i(TAG, "onResponse: " + course.getTitle());
                    courseTitleArrayList.add(course.getTitle());
                }
                mCourseAdapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<CourseResponse> call, Throwable t) {
            }
        });

    }
}
