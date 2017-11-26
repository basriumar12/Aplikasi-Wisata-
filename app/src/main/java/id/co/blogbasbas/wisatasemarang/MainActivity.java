package id.co.blogbasbas.wisatasemarang;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import id.co.blogbasbas.wisatasemarang.fragment.BlankFragment;
import id.co.blogbasbas.wisatasemarang.fragment.FavoritFragment;
import id.co.blogbasbas.wisatasemarang.fragment.HomeFragment;
import id.co.blogbasbas.wisatasemarang.fragment.MapFragment;
import id.co.blogbasbas.wisatasemarang.map.MapsActivity;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FragmentManager manager = getSupportFragmentManager();
        HomeFragment homeFragment = new HomeFragment();
        getSupportActionBar().setTitle("Home ");
        manager.beginTransaction().replace(R.id.layoutFragment, homeFragment).commit();

     /*   FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
*/
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {

            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle(" Exit Konfirm");
            builder.setMessage("Apakah  Ingin Keluar ?");
            builder.setIcon(R.mipmap.ic_launcher);
            builder.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    System.exit(0);
                    moveTaskToBack(true);
                }
            });

            builder.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {

                }
            });

            builder.show();

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
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

        if (id == R.id.nav_home) {

          FragmentManager manager = getSupportFragmentManager();
            HomeFragment homeFragment = new HomeFragment();
            getSupportActionBar().setTitle("Home ");
            manager.beginTransaction().replace(R.id.layoutFragment, homeFragment).commit();


        } else if (id == R.id.nav_favorit) {
            FragmentManager manager = getSupportFragmentManager();
            FavoritFragment favoritFragment = new FavoritFragment();
            getSupportActionBar().setTitle(" Favorit ");
            manager.beginTransaction().replace(R.id.layoutFragment, favoritFragment).commit();

        } else if (id == R.id.nav_peta) {

            startActivity(new Intent(MainActivity.this, MapsActivity.class));


            FragmentManager manager = getSupportFragmentManager();
            getSupportActionBar().setTitle(" Peta ");

            manager.beginTransaction().replace(R.id.layoutFragment,new MapFragment()).commit();

        } else if (id == R.id.nav_tambah) {
           startActivity(new Intent(MainActivity.this, AboutActivity.class));

        } else if (id == R.id.nav_share) {
            startActivity(new Intent(MainActivity.this, CreateActivity.class));

        } else if (id == R.id.nav_send) {
            FragmentManager fm = getSupportFragmentManager();
            fm.beginTransaction().replace
                    (R.id.layoutFragment,
                            new BlankFragment()).commit();


        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
