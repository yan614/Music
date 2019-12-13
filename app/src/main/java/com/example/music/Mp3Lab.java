package com.example.music;

import android.content.Context;

import com.example.music.MediaUtils;

import java.text.Collator;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Mp3Lab {
    private static Mp3Lab sMp3Lab;
    private List<Mp3Info> mMusics;

    public static Mp3Lab get(Context context){
        if (sMp3Lab == null){
            sMp3Lab = new Mp3Lab(context);
        }
        return sMp3Lab;
    }

    private Mp3Lab(Context context){
        mMusics = MediaUtils.getMp3Infos(context.getContentResolver());

    }

    public List<Mp3Info> getMusics(){
        return mMusics;
    }

    public Mp3Info getMusic(int position){
        return mMusics.get(position);
    }

    public int getCount(){
        return mMusics.size();
    }

}