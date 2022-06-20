package com.example.fragmentexample;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, FirstFragment.class, null, "FirstFragment")
                .add(R.id.fragmentContainerView, SecondFragment.class, null, "SecondFragment")
                .addToBackStack("something")
                .commit();

        FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");

        SecondFragment secondFragment = (SecondFragment) fragmentManager.findFragmentByTag("SecondFragment");

        if (firstFragment != null) {
            fragmentManager.beginTransaction().hide(firstFragment).commit();
        }
        if (secondFragment != null) {
            fragmentManager.beginTransaction().hide(secondFragment).commit();
        }


//        Button btn2 = findViewById(R.id.button2);
//        btn2.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmentManager.beginTransaction()
//                        .replace(R.id.fragmentContainerView, SecondFragment.class, null, "SecondFragment")
//                        .addToBackStack("BackStack's Name")
//                        .commit();
//
//                // addToBackStack: push frag1 vao backstack de khi dang o frag2 roi bam nut back se quay tro ve frag1
//            }
//        });

        Button btn2 = findViewById(R.id.button2);
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FirstFragment firstFragment = (FirstFragment) fragmentManager.findFragmentByTag("FirstFragment");
                if (fragmentManager.findFragmentByTag("SecondFragment") != null)
                    fragmentManager.beginTransaction().hide(firstFragment).commit();
            }
        });

        Button btn1 = findViewById(R.id.button1);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}