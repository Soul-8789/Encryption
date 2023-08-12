package com.example.encryption;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
//import android.widget.Toolbar;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Hooks
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        toolbar = findViewById(R.id.toolbar);

//        Tool Bar
        setSupportActionBar(toolbar);  //Going to tell our system that we are going to use this as our action bar


//        Navigation Drawer Menu
        //We have to tell the system whenever the nav button has been clicked
        // Hide or Show Items
        Menu menu = navigationView.getMenu();

        navigationView.bringToFront();
        ActionBarDrawerToggle toogle = new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toogle);
        toogle.syncState();

        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.nav_home);   //so that to start with the home screen
    }

    //To Avoid closing the application on pressing back button
    @Override
    public void onBackPressed() {
        if(drawerLayout.isDrawerOpen(GravityCompat.START)){
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else
        {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {

        switch(item.getItemId()){
            case R.id.nav_home:
                break;
            case R.id.piglatin:
                Intent intent1 = new Intent(MainActivity.this, encryptPigLatin.class);
                startActivity(intent1);
                break;
            case R.id.Diffy:
                Intent intent2 = new Intent(MainActivity.this, encryptDiffieHellman.class);
                startActivity(intent2);
                break;
            case R.id.piglatind:
                Intent intent3 = new Intent(MainActivity.this, decryptPigLatin.class);
                startActivity(intent3);
                break;
            case R.id.Diffyd:
                Intent intent4 = new Intent(MainActivity.this, decryptDiffieHellman.class);
                startActivity(intent4);
                break;
            case R.id.caesare:
                Intent intent5 = new Intent(MainActivity.this, encryptCaesar.class);
                startActivity(intent5);
                break;
            case R.id.caesard:
                Intent intent6 = new Intent(MainActivity.this, decryptCaesar.class);
                startActivity(intent6);
                break;
            case R.id.nav_about:
                Intent intent7 = new Intent(MainActivity.this, about.class);
                startActivity(intent7);
                break;
            case R.id.nav_credit:
                Intent intent8 = new Intent(MainActivity.this, credit.class);
                startActivity(intent8);
                break;
        }
        drawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}