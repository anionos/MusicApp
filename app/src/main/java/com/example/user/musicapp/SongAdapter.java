package com.example.user.musicapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 *
 * Created by user on 8/31/2018.
 */
public class SongAdapter extends ArrayAdapter<Song> {

    SongClickListener songClickListener;

    public SongAdapter(Context context, ArrayList<Song> songs, SongClickListener songClickListener) {
        super(context, 0, songs);

        this.songClickListener = songClickListener;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.activity_list_item, parent, false);
        }

        listItemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                songClickListener.songClicked(position);
            }
        });

        // Get the {@link AndroidFlavor} object located at this position in the list
        Song currentSong = getItem(position);
        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView artistTextView = listItemView.findViewById(R.id.artist_tv);
        // Get the version name from the current AndroidFlavor object and
        // set this text on the name TextView
        artistTextView.setText(currentSong.getArtistName());
        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView songTextView = listItemView.findViewById(R.id.song_name_tv);
        // Get the version number from the current AndroidFlavor object and
        // set this text on the number TextView
        songTextView.setText(currentSong.getSongName());

        // Set the theme color for the list item
        View parentView = listItemView.findViewById(R.id.parent);

        return listItemView;
    }

    interface SongClickListener {

        public void songClicked(int position);
    }
}
