package com.example.checkboxes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private CheckBox chocolate = null;
    private CheckBox sprinkles = null;
    private CheckBox nut = null;
    private CheckBox cherries = null;
    private CheckBox cookie = null;
    private CheckBox all = null;

    private Button btnShowToast = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chocolate = findViewById(R.id.chocalate);
        sprinkles = findViewById(R.id.sprinkles);
        nut = findViewById(R.id.nut);
        cherries = findViewById(R.id.cherries);
        cookie = findViewById(R.id.cookie);
        all = findViewById(R.id.all);
        attachListener();

        btnShowToast = findViewById(R.id.showToast);

        btnShowToast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                detachListener();
                StringBuilder chosenItems = new StringBuilder("Toppings: ");
                if (chocolate.isChecked())
                    chosenItems.append(getString(R.string.choco) + " ");
                if (sprinkles.isChecked())
                    chosenItems.append(getString(R.string.sprinkle) + " ");
                if (nut.isChecked())
                    chosenItems.append(getString(R.string.nut) + " ");
                if (cherries.isChecked())
                    chosenItems.append(getString(R.string.cherry) + " ");
                if (cookie.isChecked())
                    chosenItems.append(getString(R.string.cookie) + " ");

                display(chosenItems.toString());

                attachListener();

            }
        });
    }

    // listener nay nhan su kien khi cac CheckBox thay doi trang thai
    CompoundButton.OnCheckedChangeListener listener
            = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean isChecked) {
            if (compoundButton == all) {
                detachListener();
                chocolate.setEnabled(!isChecked);
                sprinkles.setEnabled(!isChecked);
                nut.setEnabled(!isChecked);
                cherries.setEnabled(!isChecked);
                cookie.setEnabled(!isChecked);


                chocolate.setChecked(isChecked);
                sprinkles.setChecked(isChecked);
                nut.setChecked(isChecked);
                cherries.setChecked(isChecked);
                cookie.setChecked(isChecked);
                attachListener();
            }

            else {
                display(compoundButton.getText() + " | " + compoundButton.isChecked());
            }
        }
    };

    //Gan Listener vao CheckBox
    void attachListener()
    {
        chocolate.setOnCheckedChangeListener(listener);
        sprinkles.setOnCheckedChangeListener(listener);
        nut.setOnCheckedChangeListener(listener);
        cherries.setOnCheckedChangeListener(listener);
        cookie.setOnCheckedChangeListener(listener);
        all.setOnCheckedChangeListener(listener);

    }
    //Bo Listener khoi CheckBox
    void detachListener()
    {
        chocolate.setOnCheckedChangeListener(null);
        sprinkles.setOnCheckedChangeListener(null);
        nut.setOnCheckedChangeListener(null);
        cherries.setOnCheckedChangeListener(null);
        cookie.setOnCheckedChangeListener(null);
        all.setOnCheckedChangeListener(null);

    }

    private void display(String msg) {
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
    }
}