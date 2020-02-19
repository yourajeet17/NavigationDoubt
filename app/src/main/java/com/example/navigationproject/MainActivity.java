package com.example.navigationproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.NavigationUI;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

private Toolbar toolbar;
private DrawerLayout drawerLayout;
private  NavigationView navigationView;
private NavController navController;

private void setupnavigation()
{
    toolbar=findViewById(R.id.toolbar);
    drawerLayout=findViewById(R.id.drawer);
    navigationView=findViewById(R.id.navigation_view);
    setSupportActionBar(toolbar);
    getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    getSupportActionBar().setDisplayShowHomeEnabled(true);
    navController= Navigation.findNavController(this,R.id.nav_host_fragment);
    NavigationUI.setupActionBarWithNavController(this,navController,drawerLayout);
    NavigationUI.setupWithNavController(toolbar,navController);
    navigationView.setNavigationItemSelectedListener(this);

}

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setupnavigation();
    }

    @Override
    public boolean onSupportNavigateUp(){
    return NavigationUI.navigateUp(navController,drawerLayout);
    }

    @Override
    public void onBackPressed(){
    if (drawerLayout.isDrawerOpen(GravityCompat.START))
    {
        drawerLayout.closeDrawers();
    }
    else{
        super.onBackPressed();
    }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
    item.setChecked(true);
    drawerLayout.closeDrawers();
    switch (item.getItemId())
    {
        case R.id.menu_first:
        navController.navigate(R.id.firstfragment);
        break;

        case R.id.menu_second:
            navController.navigate(R.id.second_fragment);
            break;
    }

        return true;
    }
}
