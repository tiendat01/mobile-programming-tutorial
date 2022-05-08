package com.example.lab02_1_twoactivities;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button btnSend;
    private EditText editMessage;

    private TextView txtReply;
    private TextView txtHeader;

    private static final String LOG_TAG = MainActivity.class.getSimpleName();
    public static final String EXTRA_MESSAGE =
            "com.example.lab02_1_twoactivities.extra.MESSAGE";
    public static final int TEXT_REQUEST = 1; // request code

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnSend = (Button) this.findViewById(R.id.btnSend);
        // Cach 1 to set behavior of button
        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(LOG_TAG, "Button Send of MainActivity clicked!");
                // call explicit intent (know the class name - target of intent
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);

                String message = editMessage.getText().toString();
                intent.putExtra(EXTRA_MESSAGE, message); // name - value
                //        intent.putExtra("count", 10);

                //        Bundle bundle = new Bundle();
                //        bundle.putFloat(); // dong goi nhieu cac kieu du lieu vao bundle voi cung 1 key
                //        intent.putExtra("bundle", new Bundle());

//                startActivity(intent); // not need to get data back
                startActivityForResult(intent, TEXT_REQUEST); // start Activity and wait for result data from SecondActivity
            }
        });

        editMessage = (EditText) this.findViewById(R.id.editMessage);
        txtReply = (TextView) this.findViewById(R.id.txtReply);
        txtHeader = (TextView) this.findViewById(R.id.txtHeader);
    }

    @Override
    // callback method to handle with return data
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        // three parameters contain information to handle return data:
        // requestCode when you launched the SecondActivity with startActivityForResult()
        // resultCode (usually RESULT_OK or RESULT_CANCELLED or RESULT_FIRST_USER) from setResult() in SecondActivity
        // data intent contains data returned from the launch SecondActivity
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == TEXT_REQUEST) {
            if (resultCode == RESULT_OK) {
                String reply = data.getStringExtra(SecondActivity.EXTRA_REPLY);
                txtHeader.setVisibility(View.VISIBLE);
                txtReply.setText(reply);
                txtReply.setVisibility(View.VISIBLE);

            }
        }
    }
}