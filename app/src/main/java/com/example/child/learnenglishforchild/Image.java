package com.example.child.learnenglishforchild;

/**
 * Created by CaoTin on 23/3/2018.
 */

public class Image {
    private int picture;
    private int audio;

    public Image(int picture, int audio) {
        this.picture = picture;
        this.audio = audio;
    }

    public int getPicture() {
        return picture;
    }

    public void setPicture(int picture) {
        this.picture = picture;
    }

    public int getAudio() {
        return audio;
    }

    public void setAudio(int audio) {
        this.audio = audio;
    }
}
