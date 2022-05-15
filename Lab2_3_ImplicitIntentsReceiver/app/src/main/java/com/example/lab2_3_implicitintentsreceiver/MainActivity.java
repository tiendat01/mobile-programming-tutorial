package com.example.lab2_3_implicitintentsreceiver;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        Uri uri = intent.getData();
        if (uri != null) {
            String uriStr = getString(R.string.uri_lable) + uri.toString();
            TextView txtURIMessage = (TextView) findViewById(R.id.txtURIMessage);
            txtURIMessage.setText(uriStr);
        }
    }
}