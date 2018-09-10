package com.example.user.musicapp;

import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.support.v4.view.GravityCompat;
import android.view.View;
import android.widget.ImageView;
import android.widget.SearchView;
import android.widget.TextView;

import org.parceler.Parcel;
import org.parceler.Parcels;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private DrawerLayout mDrawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the view that shows the cardview category
        ImageView banky = findViewById(R.id.banky_imageView);

        banky.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.bankyw, "B A N K Y W", generateAllSongsList());
            }
        });
        //Find the view that shows the cardview category
        ImageView wizzy = findViewById(R.id.wizzy);

        wizzy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.wizkid, "W I Z K I D", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageView tiwa = findViewById(R.id.tiwa);

        tiwa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.tiwa, "T I W A", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageView omaumi = findViewById(R.id.oma);

        omaumi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                startNowPlayingActivity(R.drawable.omawunmi, "O M A W U N M I", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageView falz = findViewById(R.id.falz);

        falz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.falzz, "F A L Z", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageView emma = findViewById(R.id.emma);

        emma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.emma, "H I L L", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageView dija = findViewById(R.id.dija);

        dija.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.dija, "D I J A", generateAllSongsList());
            }
        });

        //Toolbar
        Toolbar toolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        ActionBar actionbar = getSupportActionBar();
        actionbar.setDisplayHomeAsUpEnabled(true);
        actionbar.setHomeAsUpIndicator(R.drawable.ic_menu_black_24dp);

        mDrawerLayout = findViewById(R.id.drawer_layout);

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(
                new NavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(MenuItem menuItem) {
                        // set item as selected to persist highlight
                        menuItem.setChecked(true);
                        //to determine which item was clicked
                        switch (menuItem.getItemId()) {
                            case R.id.nav_all_songs:

                                startNowPlayingActivity(R.drawable.twobaba, "A L L  S O N G S", generateAllSongsList());

                                return true;
                        }

                        switch (menuItem.getItemId()) {
                            case R.id.nav_artist:

                                startNowPlayingActivity(R.drawable.all_artist, "A R T I S T S", generateAllSongsList());

                                return true;
                        }
                        // close drawer when item is tapped
                        mDrawerLayout.closeDrawers();

                        // Add code here to update the UI based on the item selected
                        // For example, swap UI fragments here

                        return true;
                    }
                });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                mDrawerLayout.openDrawer(GravityCompat.START);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.options_menu, menu);

        // Associate searchable configuration with the SearchView
        SearchManager searchManager =
                (SearchManager) getSystemService(Context.SEARCH_SERVICE);
        SearchView searchView =
                (SearchView) menu.findItem(R.id.search).getActionView();
        searchView.setSearchableInfo(
                searchManager.getSearchableInfo(getComponentName()));

        return true;

    }

    public void startNowPlayingActivity(int image, String name, List<Song> songs){
        Intent intent = new Intent(MainActivity.this, NowPlayingActivity.class);
        //this adds extra data to the intent of the next activity
        intent.putExtra("image", image);
        intent.putExtra("artist name", name);
        intent.putExtra("lists", Parcels.wrap(songs));
        startActivity(intent);
    }

    private List<Song> generateAllSongsList(){
        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("BankyW", "Heaven"));
        songs.add(new Song("Tuface", "amaka disappoint"));
        songs.add(new Song("Mr Real", "Legbegpe"));
        songs.add(new Song("Flavour", "African Queen"));
        songs.add(new Song("DannyP", "This is Akwa Ibom"));
        songs.add(new Song("Tiwa", "lova lova"));
        songs.add(new Song("Simi", "Joromi"));
        songs.add(new Song("Davido", "Gaga shuffle"));
        songs.add(new Song("Dija", "woe"));
        songs.add(new Song("Tecno", "Pana"));

        return songs;
    }

    private List<Song> generateArtistList(){
        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("BankyW", "Heaven"));
        songs.add(new Song("Tuface", "amaka disappoint"));
        songs.add(new Song("Mr Real", "Legbegpe"));
        songs.add(new Song("Flavour", "heaven"));
        songs.add(new Song("DannyP", "This is Akwa Ibom"));
        songs.add(new Song("Tiwa", "heaven"));
        songs.add(new Song("Simi", "Joromi"));
        songs.add(new Song("Davido", "Gaga shuffle"));
        songs.add(new Song("Dija", "woe"));
        songs.add(new Song("Tecno", "Pana"));

        return songs;
    }

}
