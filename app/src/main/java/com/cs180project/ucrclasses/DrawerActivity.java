package com.cs180project.ucrclasses;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.PopupWindow;

import com.google.firebase.auth.FirebaseAuth;

public class DrawerActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    //variables for the signout popup
    private PopupWindow popupWindow;
    private LayoutInflater layoutInflater;
    //private LinearLayout linearLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawer);

        //reference to the layout for the signout popup
        //linearLayout = (LinearLayout) findViewById(R.id.drawer_layout);

        android.app.FragmentManager fragmentManager = getFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.content_frame, new Schedule1Activity()).commit();

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    public void signoutConfirm(View view){
        FirebaseAuth.getInstance().signOut();
        Intent intent = new Intent(DrawerActivity.this, SignInActivity.class);
        startActivity(intent);
    }

    public void signoutDeny(){
        popupWindow.dismiss();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            //super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        android.app.FragmentManager fragmentManager = getFragmentManager();

        android.app.Fragment fragment = fragmentManager.findFragmentByTag("search");

//        RequestedFragment myFragment = (RequestedFragment)getFragmentManager().findFragmentByTag("MY_FRAGMENT");
//        if (myFragment != null && myFragment.isVisible()) {
//            // add your code here
//        }

        if (id == R.id.nav_search && !(fragment.isVisible()) ) {
            fragmentManager.beginTransaction().replace(R.id.content_frame, new Schedule1Activity(), "search").commit();
        } else if (id == R.id.nav_schedule1) {

        } else if (id == R.id.nav_schedule2) {

        } else if (id == R.id.nav_schedule3) {

        } else if (id == R.id.nav_signout_drawer) {
//            fragmentManager.beginTransaction().replace(R.id.content_frame, new signout_drawer()).commit();

            FirebaseAuth.getInstance().signOut();
            Intent intent = new Intent(DrawerActivity.this, SignInActivity.class);
            startActivity(intent);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
