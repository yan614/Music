package com.example.music;

public class Mp3Info{
    private long id;

    private String title;
    private String artist;
    private long duration;
    private long size;
    private String url;

    private int isMusic;

    public void setId(long id){
        this.id = id;
    }

    public long getId(){return this.id;}

    public void setTitle(String title){
        this.title = title;
    }

    public String getTitle(){return this.title;}

    public void setArtist(String artist){
        this.artist = artist;
    }

    public String getArtist(){return this.artist;}

    public void setDuration(long duration){this.duration = duration;}

    public long getDuration(){return this.duration;}

    public void setSize(long size){this.size = size;}

    public long getSize(){return this.size;}

    public void setUrl(String url){this.url = url;}

    public String getUrl(){return this.url;}



}