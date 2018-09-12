package com.example.user.musicapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

import org.parceler.Parcels;

import java.util.ArrayList;

public class NowPlayingActivity extends AppCompatActivity implements SongAdapter.SongClickListener {

    ArrayList<Song> songs;
    int image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_now_playing);

        Intent intent = getIntent();

        image = intent.getIntExtra("image",0);
        String text = intent.getStringExtra("artist name");

        TextView textView =  findViewById(R.id.textView6);
        textView.setText(text);

        // Find a reference to the ImageView in the layout. Change the image.
        ImageView imageView =  findViewById(R.id.imageView3);
        imageView.setImageResource(image);

        // Find a reference to the ImageView in the layout. Change the image.
        ImageView profile =  findViewById(R.id.profile_image);
        profile.setImageResource(image);

        // Create a list of songs
        songs = Parcels.unwrap(intent.getParcelableExtra("lists"));

        SongAdapter adapter = new SongAdapter(this, songs, this);

        ListView listView =  findViewById(R.id.list);

        listView.setOnTouchListener(new ListView.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {int action = event.getAction();
                switch (action) {
                    case MotionEvent.ACTION_DOWN:
                        // Disallow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(true);
                        break;

                    case MotionEvent.ACTION_UP:
                        // Allow ScrollView to intercept touch events.
                        v.getParent().requestDisallowInterceptTouchEvent(false);
                        break;
                }
                // Handle ListView touch events.
                v.onTouchEvent(event);
                return true;
            }
        });

        listView.setAdapter(adapter);

    }

    @Override
    public void songClicked(int position) {
        Intent intent = new Intent(this, PlaylistActivity.class);
        Song song = songs.get(position);
        intent.putExtra("song", Parcels.wrap(song));
//        intent.putExtra("image", image);
        startActivity(intent);
    }

    /**** Method for Setting the Height of the ListView dynamically.
     **** Hack to fix the issue of not showing all the items of the ListView
     **** when placed inside a ScrollView  ****/
    public static void setListViewHeightBasedOnChildren(ListView listView) {
        ListAdapter listAdapter = listView.getAdapter();
        if (listAdapter == null)
            return;

        int desiredWidth = View.MeasureSpec.makeMeasureSpec(listView.getWidth(), View.MeasureSpec.UNSPECIFIED);
        int totalHeight = 0;
        View view = null;
        for (int i = 0; i < listAdapter.getCount(); i++) {
            view = listAdapter.getView(i, view, listView);
            if (i == 0)
                view.setLayoutParams(new ViewGroup.LayoutParams(desiredWidth, ViewGroup.LayoutParams.WRAP_CONTENT));

            view.measure(desiredWidth, View.MeasureSpec.UNSPECIFIED);
            totalHeight += view.getMeasuredHeight();
        }
        ViewGroup.LayoutParams params = listView.getLayoutParams();
        params.height = totalHeight + (listView.getDividerHeight() * (listAdapter.getCount() - 1));
        listView.setLayoutParams(params);
    }
}
