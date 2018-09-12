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
    public String mArtistName;
    /**
     * Miwok translation for the word
     */
    public String mSongName;

    public int mImageResourceId;

    public int mAudioResourceId;

    @ParcelConstructor
    public Song() {
    }

    public Song(String artistName, String songName, int imageResourceId, int audioResourceId) {
        mArtistName = artistName;
        mSongName = songName;
        mImageResourceId = imageResourceId;
        mAudioResourceId = audioResourceId;

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

    /**
     * Get the the image Id.
     */
    public int getmImageResourceId() {
        return mImageResourceId;
    }

    /**
     * Get the audio id.
     */
    public int getmAudioResourceId() {
        return mAudioResourceId;
    }



}
