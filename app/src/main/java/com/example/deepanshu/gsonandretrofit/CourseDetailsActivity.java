package com.example.deepanshu.gsonandretrofit;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.deepanshu.gsonandretrofit.network.RetrofitClass;

import retrofit2.Retrofit;

public class CourseDetailsActivity extends AppCompatActivity {

    Course course;
    int courseId;
    String titleString;

    TextView nameTextView;
    TextView isActiveTextView;
    TextView overviewTextView;
    TextView feeTextView;
    Button enrolButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_details);

        nameTextView = (TextView) findViewById(R.id.name_text_view);
        isActiveTextView = (TextView) findViewById(R.id.active_text_view);
        overviewTextView = (TextView) findViewById(R.id.overview_text_view);
        feeTextView = (TextView) findViewById(R.id.fee_text_view);
        enrolButton = (Button) findViewById(R.id.enrol_button);

        Intent intent = getIntent();
        course = (Course) intent.getSerializableExtra(IntentConstants.COURSE);
        setTitle(course.getTitle());

        boolean ifActive = course.isIsActive();
        String isActiveText = ifActive ? "ACTIVE" : "INACTIVE";

        nameTextView.setText(course.getName());
        isActiveTextView.setText(isActiveText);
        overviewTextView.setText(course.getOverview());
        feeTextView.setText(course.getFeeWithTaxes() + "/-");

        enrolButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://codingninjas.in/app/payment?ctype=offline");
                Intent implicitIntent = new Intent(Intent.ACTION_VIEW,uri);
                startActivity(implicitIntent);
            }
        });
    }
}
