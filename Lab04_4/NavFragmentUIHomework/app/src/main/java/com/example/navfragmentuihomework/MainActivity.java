package com.example.navfragmentuihomework;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentContainerView;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    FragmentManager fragmentManager = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // DrawerLayout
        DrawerLayout drawerLayout = findViewById(R.id.drawer_layout);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);

        if (drawerLayout != null) {
            drawerLayout.addDrawerListener(toggle);
        }
        toggle.syncState();

        fragmentManager = getSupportFragmentManager();

        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null)
            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    DrawerLayout drawer = findViewById(R.id.drawer_layout);
                    // handle navigation view item clicks
                    switch (item.getItemId()) {
                        case R.id.nav_gallery:
                            drawer.closeDrawer(GravityCompat.START);
                            // change fragment
                            fragmentManager.popBackStack();
                            GalleryFragment galleryFragment = new GalleryFragment();
                            fragmentManager.beginTransaction()
                                    .replace(R.id.fragment_container_view, galleryFragment)
                                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
                                    .addToBackStack(null)
                                    .commit();
                            displayToast("abc");
                            return true;

                        case R.id.nav_tools:
                            drawer.closeDrawer(GravityCompat.START);
                            // change fragment
                            fragmentManager.popBackStack();
                            fragmentManager.beginTransaction()
                                    .add(R.id.fragment_container_view, ToolsFragment.class, null, "Tools Fragment")
                                    .addToBackStack(null)
                                    .commit();
                            return true;

                        case R.id.nav_send:
                            drawer.closeDrawer(GravityCompat.START);
                            // change fragment
                            fragmentManager.popBackStack();
                            fragmentManager.beginTransaction()
                                    .add(R.id.fragment_container_view, SendFragment.class, null, "Send Fragment")
                                    .addToBackStack(null)
                                    .commit();
                            return true;

                        case R.id.nav_share:
                            drawer.closeDrawer(GravityCompat.START);
                            // change fragment
                            fragmentManager.popBackStack();
                            fragmentManager.beginTransaction()
                                    .add(R.id.fragment_container_view, ShareFragment.class, null, "Share Fragment")
                                    .addToBackStack(null)
                                    .commit();
                            return true;
                        default:
                            return false;
                    }
                }

            });
}

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }

//    boolean doubleBackToExitPressedOnce = false;
//
//    @Override
//    public void onBackPressed() {
//        if (doubleBackToExitPressedOnce) {
//            super.onBackPressed();
//            return;
//        }
//
//        this.doubleBackToExitPressedOnce = true;
//        Toast.makeText(this, "Please click BACK again to exit", Toast.LENGTH_SHORT).show();
//
//        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() {
//
//            @Override
//            public void run() {
//                doubleBackToExitPressedOnce=false;
//            }
//        }, 2000);
//    }


    @Override
    public void onBackPressed() {
        if(getFragmentManager().getBackStackEntryCount() > 0) {
            getFragmentManager().popBackStack();
        }
        else {
            super.onBackPressed();
        }
    }
}