package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class SongForm {
    private int id;
    private String name;
    private String singer;
    private String category;
    private MultipartFile nameSong;

    public SongForm() {
    }

    public SongForm(String name, String singer, String category, MultipartFile nameSong) {
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.nameSong = nameSong;
    }

    public SongForm(int id, String name, String singer, String category, MultipartFile nameSong) {
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

    public MultipartFile getNameSong() {
        return nameSong;
    }

    public void setNameSong(MultipartFile nameSong) {
        this.nameSong = nameSong;
    }
}
