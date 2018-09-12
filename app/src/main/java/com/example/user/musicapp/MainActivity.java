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
import android.widget.ImageButton;
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
        ImageButton banky = findViewById(R.id.image_button1);

        banky.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.bankyw, "B A N K Y W", generateAllSongsList());
            }
        });
        //Find the view that shows the cardview category
        ImageButton wizzy = findViewById(R.id.image_button2);

        wizzy.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.wizkid, "W I Z K I D", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageButton tiwa = findViewById(R.id.image_button3);

        tiwa.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.tiwa, "T I W A", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageButton omaumi = findViewById(R.id.image_button4);

        omaumi.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){

                startNowPlayingActivity(R.drawable.omawunmi, "O M A W U N M I", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageButton falz = findViewById(R.id.image_button5);

        falz.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.falzz, "F A L Z", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageButton emma = findViewById(R.id.image_button6);

        emma.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick (View view){
                startNowPlayingActivity(R.drawable.emma, "H I L L", generateAllSongsList());
            }
        });

        //Find the view that shows the cardview category
        ImageButton dija = findViewById(R.id.image_button7);

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

        songs.add(new Song("BankyW", "Heaven", R.drawable.bankyw, R.raw.banky_heaven));
        songs.add(new Song("Tuface", "Amaka disappoint", R.drawable.twobaba,R.raw.davido_assurance));
        songs.add(new Song("Mr Real", "Legbegpe", R.drawable.mr_real,R.raw.mr_real));
        songs.add(new Song("Flavour", "Unchangeable", R.drawable.flavour,R.raw.davido_assurance));
        songs.add(new Song("DannyP", "This is Akwa Ibom", R.drawable.dannyp,R.raw.davido_assurance));
        songs.add(new Song("Tiwa", "lova lova",R.drawable.tiwa,R.raw.davido_assurance));
        songs.add(new Song("Simi", "Joromi", R.drawable.simi,R.raw.simi_joromi));
        songs.add(new Song("Davido", "Assurance",R.drawable.davido,R.raw.davido_assurance));
        songs.add(new Song("Dija", "woe",R.drawable.dija,R.raw.davido_assurance));
        songs.add(new Song("Tecno", "Pana",R.drawable.tecno,R.raw.davido_assurance));

        return songs;
    }

    private List<Song> generateArtistList(){
        ArrayList<Song> songs = new ArrayList<Song>();

        songs.add(new Song("BankyW", "Heaven",R.drawable.bankyw,0));
        songs.add(new Song("Tuface", "amaka disappoint",R.drawable.twobaba,0));
        songs.add(new Song("Mr Real", "Legbegpe",R.drawable.bankyw,0));
        songs.add(new Song("Flavour", "Unchangeable",R.drawable.twobaba,0));
        songs.add(new Song("DannyP", "This is Akwa Ibom",R.drawable.dija,0));
        songs.add(new Song("Tiwa", "Heaven",R.drawable.tiwa,0));
        songs.add(new Song("Simi", "Joromi",R.drawable.dija,0));
        songs.add(new Song("Davido", "Assurance",R.drawable.emma,R.raw.davido_assurance));
        songs.add(new Song("Dija", "woe",R.drawable.dija,0));
        songs.add(new Song("Tecno", "Pana",R.drawable.dija,0));

        return songs;
    }

}
