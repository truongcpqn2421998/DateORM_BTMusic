package com.codegym.model;

import javax.persistence.*;

@Entity
@Table
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String singer;
    private String category;
    private String nameSong;

    public Song() {
    }

    public Song(String name, String singer, String category, String nameSong) {
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.nameSong = nameSong;
    }

    public Song(int id, String name, String singer, String category, String nameSong) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.nameSong = nameSong;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getNameSong() {
        return nameSong;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }
}
