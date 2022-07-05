package com.example.lab07_2_asynctaskloader;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText mBookInput = null;
    private TextView mTitleText = null;
    private TextView mAuthorText = null;
    private Button btnSearchBooks = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBookInput = findViewById(R.id.bookInput);
        mTitleText = findViewById(R.id.titleText);
        mAuthorText = findViewById(R.id.authorText);


        MyLoaderCallbacks myLoaderCallbacks = new MyLoaderCallbacks(this, mTitleText, mAuthorText);

        if(getSupportLoaderManager().getLoader(0)!=null){
            getSupportLoaderManager().initLoader(0,null, myLoaderCallbacks);
        }

        btnSearchBooks = findViewById(R.id.searchButton);
        btnSearchBooks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String queryString = mBookInput.getText().toString();
//                new FetchBook(mTitleText, mAuthorText).execute(queryString);


                // make better UI
                InputMethodManager inputManager = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                if (inputManager != null ) {
                    inputManager.hideSoftInputFromWindow(v.getWindowToken(),
                            InputMethodManager.HIDE_NOT_ALWAYS);
                }

                ConnectivityManager connMgr = (ConnectivityManager)
                        getSystemService(Context.CONNECTIVITY_SERVICE);
                NetworkInfo networkInfo = null;
                if (connMgr != null) {
                    networkInfo = connMgr.getActiveNetworkInfo();
                }

                if (networkInfo != null && networkInfo.isConnected()
                        && queryString.length() != 0) {
                    //new FetchBook(mTitleText, mAuthorText).execute(queryString);

                    Bundle queryBundle = new Bundle();
                    queryBundle.putString("queryString", queryString);
                    getSupportLoaderManager().restartLoader(0, queryBundle, myLoaderCallbacks);

                    mAuthorText.setText("");
                    mTitleText.setText(R.string.loading);

                } else {
                    if (queryString.length() == 0) {
                        mAuthorText.setText("");
                        mTitleText.setText(R.string.no_search_term);
                    } else {
                        mAuthorText.setText("");
                        mTitleText.setText(R.string.no_network);
                    }
                }
            }
        });
    }

}