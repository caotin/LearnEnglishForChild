package com.example.child.learnenglishforchild;

import java.util.ArrayList;

/**
 * Created by CaoTin on 15/5/2018.
 */

public class Topic {
    private int image;
    private String name;
    private int idTopic;

    public Topic(int image, String name, int idTopic) {
        this.image = image;
        this.name = name;
        this.idTopic = idTopic;
    }

    public int getIdTopic() {
        return idTopic;
    }

    public void setIdTopic(int idTopic) {
        this.idTopic = idTopic;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
