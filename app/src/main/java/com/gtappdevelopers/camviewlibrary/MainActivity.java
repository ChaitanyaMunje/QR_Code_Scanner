package com.gtappdevelopers.camviewlibrary;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;


import android.widget.ImageView;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

public class MainActivity extends AppCompatActivity {

   private ImageView img;
    DisplayImageOptions options;
     ImageLoader imageLoader;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // initialize image loader before using
        imageLoader= ImageLoader.getInstance();
        imageLoader.init(ImageLoaderConfiguration.createDefault(getApplicationContext()));

        //initialize imageview from activity_main.xml
        img=findViewById(R.id.idImageView);
         // URL for our image that we have to load..
        String imageUri = "https://www.geeksforgeeks.org/wp-content/uploads/gfg_200X200-1.png";
        //with below method we are setting display option for our image..
        options = new DisplayImageOptions.Builder()
                // stub image will display when your image is loading
                .showStubImage(R.drawable.ic_launcher_foreground)
                // below image will be displayed when the image url is empty
                .showImageForEmptyUri(R.drawable.ic_launcher_background)
                // cachememory method will caches the image in users external storage
                .cacheInMemory()
                // cache on disc will caches the image in users internal storage
                .cacheOnDisc()
                //. build will build the view for displaying image..
                .build();
        // below method will display image inside our image view..
        imageLoader.displayImage(imageUri, img, options, null);


    }
}