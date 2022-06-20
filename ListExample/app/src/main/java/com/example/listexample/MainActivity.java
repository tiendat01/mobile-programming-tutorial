//package com.example.listexample;
//
//import androidx.appcompat.app.AppCompatActivity;
//
//import android.app.ListActivity;
//import android.os.Bundle;
//import android.util.Log;
//import android.view.View;
//import android.widget.ArrayAdapter;
//import android.widget.ListView;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class MainActivity extends ListActivity {
//
//    List<String> items;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//
//        items = new ArrayList<>();
//        for (int i = 0; i < 50; i++)
//            items.add("Item " + i);
//
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                items);
//
//        // phuong thuc cua lop ListActivity duoc ke thua
//        setListAdapter(adapter);
//    }
//
//    @Override
//    protected void onListItemClick(ListView l, View v, int position, long id) {
//        Log.v("TAG",  items.get(position) + " is clicked!");
//    }
//}


package com.example.listexample;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    List<String> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        items = new ArrayList<>();
        for (int i = 0; i < 50; i++)
            items.add("Item " + i);

// this layout supported by android
//        ArrayAdapter<String> adapter = new ArrayAdapter<>(
//                this,
//                android.R.layout.simple_list_item_1,
//                items);


        // my custom layout
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this,
                R.layout.simple_item_layout,
                R.id.text_view,
                items
        );
        ListView myListView = findViewById(R.id.myCustomizeListView);
        myListView.setAdapter(adapter);

        myListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.v("TAG",  items.get(position) + " is clicked!");
            }
        });

        findViewById(R.id.btnAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(0, "New Item");
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.btnRemove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.remove(0);
                adapter.notifyDataSetChanged();
            }
        });

        findViewById(R.id.btnUpdate).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.set(0, "Updated Item");
                adapter.notifyDataSetChanged();
            }
        });








    }

}