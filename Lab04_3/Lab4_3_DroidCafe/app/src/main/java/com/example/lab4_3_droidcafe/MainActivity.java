package com.example.lab4_3_droidcafe;

import android.app.DatePickerDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity implements DatePickerDialog.OnDateSetListener {

    public static final String EXTRA_MESSSAGE = "ORDER_MESSAGE";
    private ImageView donutImgView = null;
    private ImageView iceImgView = null;
    private ImageView froyoImgView = null;
    private StringBuilder orderMessage = new StringBuilder();
    private FloatingActionButton floatingActionButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        donutImgView = findViewById(R.id.donut);
        donutImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage.append(getString(R.string.donut_order_message)).append('\n');
                displayToastMsg(getString(R.string.donut_order_message));

                //
                final Calendar c = Calendar.getInstance();
                int year = c.get(Calendar.YEAR);
                int month = c.get(Calendar.MONTH);
                int day = c.get(Calendar.DAY_OF_MONTH);
                // date picker
                // do MainActivity implement DatePickerDialog.OnDateSetListener nen listener = MainActivity.this
                DatePickerDialog datePickerDialog = new DatePickerDialog(MainActivity.this, MainActivity.this, year, month, day);
                datePickerDialog.show();
            }
        });

        iceImgView = findViewById(R.id.ice_cream);
        iceImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage.append(getString(R.string.ice_cream_order_message)).append('\n');
                //displayToastMsg(getString(R.string.ice_cream_order_message));
                displayToastMsg(getText(R.string.ice_cream_order_message).toString());
            }
        });
        // dang ky su kien context menu
        registerForContextMenu(iceImgView);


        froyoImgView = findViewById(R.id.froyo);
        froyoImgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                orderMessage.append(getString(R.string.froyo_order_message)).append('\n');
                displayToastMsg(getString(R.string.froyo_order_message));

                // Dialog to request user's choice
                AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this);
                alert.setTitle("Hello, I'm froyo");
                alert.setMessage("Do you want to order froyo ?");

                alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                        intent.putExtra(EXTRA_MESSSAGE, orderMessage.toString());
                        if (intent != null) {
                            startActivity(intent);
                        }
                    }
                });


                alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

                alert.show();

            }
        });

        floatingActionButton = findViewById(R.id.btnOrder);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSSAGE, orderMessage.toString());
                startActivity(intent);
            }
        });


        // set toolbar
        Toolbar toolbar = findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
    }


    public void displayToastMsg(String message) {
        Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
    }


    // Handle with options menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int menuId = item.getItemId();
        switch (menuId) {
            case R.id.action_settings:
                displayToastMsg(getString(R.string.action_settings));
                break;
            case R.id.action_contact:
                displayToastMsg(getString(R.string.action_contact));
                break;
            case R.id.action_logout:
                displayToastMsg(getString(R.string.action_logout));
                break;
            case R.id.action_order:
                displayToastMsg(getString(R.string.action_order));
                Intent intent = new Intent(MainActivity.this, OrderActivity.class);
                intent.putExtra(EXTRA_MESSSAGE, orderMessage.toString());
                startActivity(intent);
                break;
            case R.id.action_favourites:
                displayToastMsg(getString(R.string.action_favourites));
                break;
            case R.id.action_status:
                displayToastMsg(getString(R.string.action_status));
                break;
            default:
                break;
        }

        return super.onOptionsItemSelected(item);
    }


    // create context_menu
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }



    // Override for DatePickerDialog.OnDateSetListener
    // Handle date after picked
    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        MainActivity activity = this; // do MainActivity implement DatePickerDialog.OnDateSetListener
        String res = activity.processDatePickerResult(year, month, dayOfMonth);
        displayToastMsg(res);
    }

    private String processDatePickerResult(int year, int month, int day) {
        String month_string = Integer.toString(month + 1);
        String day_string = Integer.toString(day);
        String year_string = Integer.toString(year);
        String dateMessage = (month_string +
                "/" + day_string + "/" + year_string);
        return dateMessage;
    }
}