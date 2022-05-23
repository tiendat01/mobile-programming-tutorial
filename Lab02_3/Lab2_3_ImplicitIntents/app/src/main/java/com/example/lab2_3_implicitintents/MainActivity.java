package com.example.lab2_3_implicitintents;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnOpenWebsite = null;
    Button btnOpenLocation = null;
    Button btnShareText = null;

    EditText edtWebsite = null;
    EditText edtLocation = null;
    EditText edtShare = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Open Website
        edtWebsite = findViewById(R.id.edtWebsite);
        btnOpenWebsite = findViewById(R.id.btnOpenWebsite);
        btnOpenWebsite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String url = edtWebsite.getText().toString();
                Uri webpageUri = Uri.parse(url);

                Intent intent = new Intent(Intent.ACTION_VIEW, webpageUri);
                // resolveActivity() method and the Android package manager to find an Activity that can handle your implicit Intent
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                }
                else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        // Open Location
        edtLocation = findViewById(R.id.edtLocation);
        btnOpenLocation = findViewById(R.id.btnOpenLocation);
        btnOpenLocation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String location = edtLocation.getText().toString();
                Uri addressUri = Uri.parse("geo:0,0?q=" + location);

                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                if (intent.resolveActivity(getPackageManager()) != null) {
                    startActivity(intent);
                } else {
                    Log.d("ImplicitIntents", "Can't handle this intent!");
                }
            }
        });

        // Share Action
        edtShare = findViewById(R.id.edtShare);
        btnShareText = findViewById(R.id.btnShareText);
        btnShareText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String txt = edtShare.getText().toString();
                String mimeType = "text/plain";

                // ShareCompat.IntentBuilder build an Intent and launch a chooser to choose the destination app for sharing
//                from(): The Activity that launches this share Intent (this). --> deprecated
//                setType(): The MIME type of the item to be shared.
//                setChooserTitle(): The title that appears on the system app chooser.
//                setText(): The actual text to be shared
//                startChooser(): Show the system app chooser and send the Intent.
                new ShareCompat
                        .IntentBuilder(MainActivity.this)
                        .setType(mimeType)
                        .setChooserTitle("Share text with: ")
                        .setText(txt)
                        .startChooser();

            }
        });
    }

    public void openWebsite(View view) {
    }

    public void openLocation(View view) {
    }

    public void shareText(View view) {
    }


    static final int REQUEST_IMAGE_CAPTURE = 1;

    public void takePhoto(View view) {

        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        try {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        } catch (ActivityNotFoundException e) {
            // display error state to the user
        }

    }
}