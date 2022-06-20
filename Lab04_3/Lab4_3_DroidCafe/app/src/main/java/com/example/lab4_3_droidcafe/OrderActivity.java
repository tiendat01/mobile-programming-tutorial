package com.example.lab4_3_droidcafe;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class OrderActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    private TextView txtOrder = null;
    private final StringBuilder orderMsg = new StringBuilder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);


        // receive msg from MainActivity
        Intent intent = getIntent();
        orderMsg.append(intent.getStringExtra(MainActivity.EXTRA_MESSSAGE));
        txtOrder = findViewById(R.id.txtOrder);
        txtOrder.setText(orderMsg);

        RadioButton defaultCheckedBtn = findViewById(R.id.nextday);
        defaultCheckedBtn.setChecked(true);


        // Create a spinner
        Spinner spinner = findViewById(R.id.spinner);
        if (spinner != null) {
            spinner.setOnItemSelectedListener(this); // set spinner's listener
        }

        // Create ArrayAdapter using string array and default spinner:
        // default predefined layout spinner supported by Android in R.layout class: simple_spinner_item and simple_spinner_dropdown_item
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.labels_array, android.R.layout.simple_spinner_item);

        // Specify the layout to use when the list of choices appears.
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Apply adapter to the spinner ==> adapter gan voi spinner de goi cac callback method handle item chosen from spinner
        if (spinner != null) {
            spinner.setAdapter(adapter);
        }

    }

    public void onRadioButtonClicked(View view) {
        // check if the radio button is checked
        boolean checked = ((RadioButton) view).isChecked();

        // chech which radio button is checked
        if (checked) {
            switch (view.getId()) {
                case R.id.sameday:
                    displayToast(getString(R.string.same_day_messenger_service));
                    break;
                case R.id.nextday:
                    displayToast(getString(R.string.next_day_ground_delivery));
                    break;
                case R.id.pickup:
                    displayToast(getString(R.string.pick_up));
                    break;
                default:
                    break;
            }
        }

    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


    // Implement method for interface AdapterView.OnItemSelectedListener to activate the Spinner and its listener

    // implement 2 callback method to handle item chosen from spinner
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        String spinnerLabel = adapterView.getItemAtPosition(i).toString();
        displayToast(spinnerLabel + " (phone)");
    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}