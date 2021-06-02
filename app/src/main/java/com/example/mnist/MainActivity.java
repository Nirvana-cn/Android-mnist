package com.example.mnist;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            AssetManager assetManager = getAssets();
            InputStream inputStream = assetManager.open("one.png");
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            ImageView image = findViewById(R.id.image);
            image.setImageBitmap(bitmap);

            Detect.getInstance().initialize(assetManager);

            Detect.getInstance().recognize(ImageUtils.prepareImageForClassification(bitmap));

            Detect.getInstance().getResult();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
