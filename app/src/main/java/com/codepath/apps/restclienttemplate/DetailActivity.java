package com.codepath.apps.restclienttemplate;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.codepath.apps.restclienttemplate.models.Tweet;

import org.parceler.Parcels;

public class DetailActivity extends AppCompatActivity {

    ImageView ivProfileImage;
    TextView tvScreenName;
    TextView tvBody;
    TextView tvTimestamp;
    TextView tvName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivProfileImage = findViewById(R.id.ivProfileImage);
        tvScreenName= findViewById(R.id.tvScreenName);
        tvBody = findViewById(R.id.tvBody);
        tvTimestamp = findViewById(R.id.tvTimestamp);
        tvName = findViewById(R.id.tvName);

        Tweet tweet = Parcels.unwrap(getIntent().getParcelableExtra("tweet"));

        tvBody.setText(tweet.body);
        tvTimestamp.setText(tweet.getFormattedTimestamp());
        tvScreenName.setText("@"+tweet.user.screenName);
        tvName.setText(tweet.user.name);
        Glide.with(this).load(tweet.user.profileImageUrl).into(ivProfileImage);



    }



}