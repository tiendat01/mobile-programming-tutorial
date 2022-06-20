package com.example.autocompletetextview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView txtMsg = null;
    AutoCompleteTextView edtText = null;

    String[] items= { "words", "starting", "with", "set", "Setback","Setline", "Setoffs",
            "Setouts", "Setters", "Setting","Settled", "Settler", "Wordless", "Wordiness", "Adios"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtMsg = findViewById(R.id.txtMsg);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_single_choice,
                items
        );

        edtText = findViewById(R.id.autoComplete);
        edtText.setAdapter(adapter);
        edtText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                txtMsg.setText(edtText.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
    }
}