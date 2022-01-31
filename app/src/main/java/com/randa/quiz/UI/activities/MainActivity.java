package com.randa.quiz.UI.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

import com.randa.quiz.R;
import com.randa.quiz.UI.activities.Home;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    ImageView logo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  logo=findViewById(R.id.logoImage);
        InputStream imageStream = this.getResources().openRawResource(R.raw.quiz);
        Bitmap bitmap = BitmapFactory.decodeStream(imageStream);
        logo.setImageBitmap(bitmap);*/

        new Handler().postDelayed(() -> {
            startActivity(new Intent(getApplicationContext(), Home.class));
            finish();
        },5000);
    }
}