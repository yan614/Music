package com.example.music;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import com.example.music.MusicAdapter;
import com.example.music.Mp3Info;
import com.example.music.Mp3Lab;
import com.example.music.R;


import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicListFragment extends Fragment {

    private RecyclerView musicList;
    private static List<Mp3Info> mMusics;
    private static MusicAdapter adapter;

    public static MusicListFragment newInstance(List<Mp3Info> musics){
        mMusics = musics;
        MusicListFragment frag = new MusicListFragment();
        return frag;

    }

    @Override
    public View onCreateView(LayoutInflater inflater,ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_music_list,container,false);

        if (Mp3Lab.get(getActivity()).getCount()<=0){
            Toast.makeText(getActivity(),"你的手机中没有音乐",Toast.LENGTH_SHORT).show();
            getActivity().finish();
        }

        musicList = (RecyclerView)v.findViewById(R.id.music_list);
        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        musicList.setLayoutManager(layoutManager);
        if (mMusics==null) {
            adapter = new MusicAdapter(Mp3Lab.get(getActivity()).getMusics());
            musicList.setAdapter(adapter);
        }else{
            adapter = new MusicAdapter(mMusics);
            musicList.setAdapter(adapter);
        }
        return v;
    }


    public static void notifyChange(){
        adapter.notifyDataSetChanged();
    }
}
