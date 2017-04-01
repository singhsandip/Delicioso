package com.example.sandeep.myapplication.Activities;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sandeep.myapplication.Fragments.About_us;
import com.example.sandeep.myapplication.Fragments.Complaints;
import com.example.sandeep.myapplication.Fragments.Feedback;
import com.example.sandeep.myapplication.Fragments.Products;
import com.example.sandeep.myapplication.Fragments.Specilites;
import com.example.sandeep.myapplication.R;

public class MainActivity extends AppCompatActivity
{
    //ImageView main;
    EditText cname,cemail,cdetails;
    Button b1;
    TextView t;
    android.app.FragmentManager fragmentManager = getFragmentManager();
    android.app.FragmentTransaction ft;

    Toolbar toolbar;
    DrawerLayout drawerLayout;
    NavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);




            setContentView(R.layout.activity_main);


        if (!isNetworkAvailable()) {
            Toast.makeText(this, "not connected", Toast.LENGTH_SHORT).show();
            /*AlertDialog.Builder alertdialogbuilder = new AlertDialog.Builder(this);
            final AlertDialog alertdialog = alertdialogbuilder.create();
            alertdialogbuilder.setMessage("Moblie Data Should b on to get full acees to features of this app , do u want to on mobile data");
            alertdialogbuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    Toast.makeText(MainActivity.this, "turn on mobile data", Toast.LENGTH_SHORT).show();

                }
            });
            alertdialogbuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    alertdialog.dismiss();

                }
            });

            alertdialog.show();*/
        }



            t = (TextView) findViewById(R.id.name);
            cname = (EditText) findViewById(R.id.c_name);
            cemail = (EditText) findViewById(R.id.c_email);
            cdetails = (EditText) findViewById(R.id.c_details);
            b1 = (Button) findViewById(R.id.button3);




            toolbar = (Toolbar) findViewById(R.id.toolbar);
            drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
            navigationView = (NavigationView) findViewById(R.id.navigation_view);

            toolbar.setTitle("Delicioso");

            navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem menuitem) {


                    switch (menuitem.getItemId()) {
                        case R.id.nav_about:
                            ft = fragmentManager.beginTransaction();
                            About_us frgmnt = new About_us();
                            ft.addToBackStack(String.valueOf(frgmnt));
                            ft.replace(R.id.frame, frgmnt);
                            ft.commit();
                            toolbar.setTitle("About Us");
                            break;

                        case R.id.nav_products:
                            ft = fragmentManager.beginTransaction();
                            Products products_fragment = new Products();
                            ft.addToBackStack("product");
                            ft.replace(R.id.frame, products_fragment);
                            ft.commit();
                            toolbar.setTitle("Products");
                            break;

                        case R.id.nav_special:
                            //Toast.makeText(getApplicationContext(),"Specility Selected",Toast.LENGTH_SHORT).show();
                            ft = fragmentManager.beginTransaction();
                            Specilites specilities_fragment = new Specilites();
                            ft.addToBackStack("specility");
                            ft.replace(R.id.frame, specilities_fragment);
                            ft.commit();
                            toolbar.setTitle("Our Specilities");
                            break;

                        case R.id.nav_comp:
                            ft = fragmentManager.beginTransaction();
                            Complaints complaints_fragment = new Complaints();
                            ft.addToBackStack("complaints");
                            ft.replace(R.id.frame, complaints_fragment);
                            ft.commit();
                            toolbar.setTitle("Complaints");
                            break;

                        case R.id.nav_feedback:
                            //  Toast.makeText(getApplicationContext(),"feedback Selected",Toast.LENGTH_SHORT).show();
                            ft = fragmentManager.beginTransaction();
                            Feedback feedback_fragment = new Feedback();
                            ft.addToBackStack("feedback");
                            ft.replace(R.id.frame, feedback_fragment);
                            ft.commit();
                            toolbar.setTitle("Feedback & Suggestions");
                            break;

                        default:
                            Toast.makeText(getApplicationContext(), "Somethings Wrong", Toast.LENGTH_SHORT).show();
                            return true;
                    }
                    //    main.setVisibility(View.INVISIBLE);
                    drawerLayout.closeDrawer(Gravity.LEFT, true);
                    return true;

                }
            });

            drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
            ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {


                @Override
                public void onDrawerClosed(View drawerView) {
                    // Code here will be triggered once the drawer closes as we dont want anything to happen so we leave this blank
                    super.onDrawerClosed(drawerView);
                }

                @Override
                public void onDrawerOpened(View drawerView) {
                    // Code here will be triggered once the drawer open as we dont want anything to happen so we leave this blank

                    super.onDrawerOpened(drawerView);
                }
            };
            drawerLayout.setDrawerListener(actionBarDrawerToggle);

            //calling sync state is necessay or else your hamburger icon wont show up
            actionBarDrawerToggle.syncState();


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
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

    @Override
    public void onBackPressed() {

        int check = fragmentManager.getBackStackEntryCount();


        if (drawerLayout.isDrawerOpen(GravityCompat.START))
        {
            drawerLayout.closeDrawer(GravityCompat.START);
        }
        else if (check > 0 && check != 1)
        {
            toolbar.setTitle("Delicioso");
            fragmentManager.popBackStack();
           // main.setVisibility(View.VISIBLE);

        }
        else if ( check == 1)
        {
            fragmentManager.popBackStack();
        }
        else {
            super.onBackPressed();
        }

    }
    private boolean isNetworkAvailable() {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) getSystemService(CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }


    /*public View getView()
    {
        LayoutInflater inflater = this;
        View view = inflater.inflate(R.layout.header,null,false);
    }*/


}
