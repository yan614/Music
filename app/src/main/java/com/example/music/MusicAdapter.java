package com.example.music;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.music.Mp3Info;
import com.example.music.Mp3Lab;
import com.example.music.PlayingListLab;
import com.example.music.BottomFragment;
import com.example.music.R;
import com.example.music.MusicService;
import com.example.music.PlayerMsg;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MusicAdapter extends RecyclerView.Adapter<MusicAdapter.ViewHolder>{

    private List<Mp3Info> musics;

    static class ViewHolder extends RecyclerView.ViewHolder{
        TextView musicTitle;
        TextView musicSinger;

        TextView musicNumber;
        LinearLayout mLinearLayout;
        public ViewHolder(View view){
            super(view);
            musicTitle = (TextView)view.findViewById(R.id.music_title);
            musicSinger = (TextView)view.findViewById(R.id.music_singer);
            musicNumber = (TextView)view.findViewById(R.id.music_number);
            mLinearLayout = (LinearLayout)view.findViewById(R.id.music_layout);
        }

    }

    public MusicAdapter(List<Mp3Info> music){
        musics = music;
    }

    @Override
    public ViewHolder onCreateViewHolder(final ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.music_item,parent,false);
        final ViewHolder holder = new ViewHolder(view);
        holder.mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int position = holder.getAdapterPosition();
                Intent intent = new Intent(parent.getContext(),MusicService.class);

                intent.putExtra("path", Mp3Lab.get(parent.getContext()).getMusic(position).getUrl());
                PlayingListLab.get().getPlayingList().setPlayingList(Mp3Lab.get(parent.getContext()).getMusics());
                PlayingListLab.get().getPlayingList().setCurrentNum(position);
                PlayingListLab.isPlaying = true;
                BottomFragment.updateUI();

                PlayingListLab.get().getPlayingList().setCurrentNum(position);
                intent.putExtra("MSG", PlayerMsg.PLAY_MSG);
                parent.getContext().startService(intent);
            }
        });
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Mp3Info music = musics.get(position);
        holder.musicTitle.setText(music.getTitle());
        holder.musicSinger.setText(music.getArtist());

        holder.musicNumber.setText(""+(position+1));
    }

    @Override
    public int getItemCount() {
        return musics.size();
    }
}
