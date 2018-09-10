package com.example.user.musicapp;

import org.parceler.Parcel;
import org.parceler.ParcelConstructor;

/**
 * Created by user on 8/31/2018.
 */
@Parcel
public class Song {
    /**
     * {@link Song} represents a vocabulary word that the user wants to learn.
     * It contains a default translation and a Miwok translation for that word.
     */
    private String mArtistName;
    /**
     * Miwok translation for the word
     */
    private String mSongName;

    @ParcelConstructor
    public Song() {
    }

    public Song(String artistName, String songName) {
        mArtistName = artistName;
        mSongName = songName;

    }
    /**
     * Get the default translation of the word.
     */
    public String getArtistName() {
        return mArtistName;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getSongName() {
        return mSongName;
    }

}
