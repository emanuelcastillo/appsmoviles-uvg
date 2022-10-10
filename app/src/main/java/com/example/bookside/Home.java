package com.example.bookside;

import android.content.res.Configuration;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


import com.example.bookside.fragment.FragmentBookFav;
import com.example.bookside.fragment.FragmentBookLibrary;
import com.example.bookside.fragment.FragmentBookUpload;
import com.example.bookside.fragment.FragmentError;
import com.example.bookside.fragment.FragmentHelp;
import com.example.bookside.fragment.FragmentProfile;
import com.example.bookside.fragment.FragmentInfoBookside;
import com.example.bookside.fragment.FragmentSettings;
import com.google.android.material.navigation.NavigationView;

public class Home extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;
    private ActionBarDrawerToggle toggle;
    public static FragmentManager fragmentManager;
    public static FragmentTransaction fragmentTransaction;
    public static String nombre,email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Login contenedor = new Login();
        //txtnombre = findViewById(R.id.header_nombre);
        //txtemail = findViewById(R.id.email);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.main_drawerlayout);
        navigationView = findViewById(R.id.nav_view);
        View headerView = navigationView.getHeaderView(0);


        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //navigation view add listener click
        navigationView.setNavigationItemSelectedListener(this);

        // Find our drawer view
        DrawerLayout drawerLayout = findViewById(R.id.main_drawerlayout);
        toggle = setupDrawerToggle();

        // Setup toggle to display hamburger icon with nice animation
        toggle.setDrawerIndicatorEnabled(true);
        toggle.syncState();

        // Tie DrawerLayout events to the ActionBarToggle
        drawerLayout.addDrawerListener(toggle);

        //setear los nombres en el header
        TextView navHeaderNombre = (TextView) headerView.findViewById(R.id.header_nombre);
        navHeaderNombre.setText(contenedor.nombre + " " + contenedor.apellido);

        TextView navHeaderEmail = (TextView) headerView.findViewById(R.id.header_email);
        navHeaderEmail.setText(contenedor.email);


        //fragment default
        getSupportActionBar().setTitle("Libros");
        fragmentManager = getSupportFragmentManager();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.framentcontainer, new FragmentBookLibrary());
        fragmentTransaction.commit();

    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        // NOTE: Make sure you pass in a valid toolbar reference.  ActionBarDrawToggle() does not require it
        // and will not render the hamburger icon without it.
        return new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.DrawerOpen,  R.string.DrawerClose);
    }

    @Override
    public void onPostCreate(@Nullable Bundle savedInstanceState, @Nullable PersistableBundle persistentState) {
        super.onPostCreate(savedInstanceState, persistentState);
        toggle.syncState();
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        toggle.onConfigurationChanged(newConfig);
        super.onConfigurationChanged(newConfig);

    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(toggle.onOptionsItemSelected(item)){
            return true;
        }
        switch (item.getItemId()) {
            case android.R.id.home:
                drawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        drawerLayout.closeDrawer(GravityCompat.START);
        switch (item.getItemId())
        {
            case R.id.Booklibrary:
                getSupportActionBar().setTitle("Libros");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentBookLibrary());
                fragmentTransaction.commit();
                break;
            case R.id.BookUpload:
                getSupportActionBar().setTitle("Aportes");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentBookUpload());
                fragmentTransaction.commit();
                break;
            case R.id.BookFav:
                getSupportActionBar().setTitle("Favoritos");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentBookFav());
                fragmentTransaction.commit();
                break;
            case R.id.Profile:
                getSupportActionBar().setTitle("Perfil");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentProfile());
                fragmentTransaction.commit();
                break;
            case R.id.Settings:
                getSupportActionBar().setTitle("Ajustes");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentSettings());
                fragmentTransaction.commit();
                break;
            case R.id.Error:
                getSupportActionBar().setTitle("Reporte de error");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentError());
                fragmentTransaction.commit();
                break;
            case R.id.LogOut:
                //LogOut
                break;
            case R.id.InfoBookside:
                getSupportActionBar().setTitle("Info BooksideUVG");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentInfoBookside());
                fragmentTransaction.commit();
                break;
            case R.id.Help:
                getSupportActionBar().setTitle("Ayuda");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.framentcontainer, new FragmentHelp());
                fragmentTransaction.commit();
                break;
            default:
                getSupportActionBar().setTitle("Libros");
                fragmentManager = getSupportFragmentManager();
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.add(R.id.framentcontainer, new FragmentProfile());
                fragmentTransaction.commit();
        }
        return false;
    }
}