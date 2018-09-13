package com.example.user.musicapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import org.parceler.Parcels;

public class PlaylistActivity extends AppCompatActivity {
    private MediaPlayer mMediaPlayer;

    SeekBar simpleSeekBar;
    Song songs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        //Toolbar
        Toolbar toolbar =  findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);
        setTitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        Intent intent = getIntent();
        songs = Parcels.unwrap(intent.getParcelableExtra("song"));

        TextView songNameTv = findViewById(R.id.textView9);
        songNameTv.setText(songs.getSongName());
        TextView artistNameTv = findViewById(R.id.textView10);
        artistNameTv.setText(songs.getArtistName());
        ImageView imageView = findViewById(R.id.banky_card2);
        imageView.setImageResource(songs.getmImageResourceId());

    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return super.onSupportNavigateUp();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.option_menu2, menu);

        return true;
    }

    int playOrPause =0; //we use 0 for play and 1 for pause
    public void startPlaying(View view) {

        ImageButton buttonPlay = findViewById(R.id.play);
        if(playOrPause == 0 ){
            //pause
            playOrPause = 1;
            buttonPlay.setImageResource(R.drawable.ic_pause_black_24dp);
            mMediaPlayer = MediaPlayer.create(PlaylistActivity.this, songs.getmAudioResourceId());
            mMediaPlayer.start();
        } else {
            //play
            playOrPause = 0;
            buttonPlay.setImageResource(R.drawable.ic_play_arrow_black_24dp);
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
    }

    public void next_song(View view) {
    }

    public void previous_song(View view) {
    }

    public void repeat_song(View view) {
    }

    public void add_song(View view) {
    }

    @Override
    public void onBackPressed() {
        if(mMediaPlayer != null){
            mMediaPlayer.stop();
            mMediaPlayer.release();
            mMediaPlayer=null;
        }
        super.onBackPressed();
    }

}
