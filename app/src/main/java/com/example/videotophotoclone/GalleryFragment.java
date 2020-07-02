package com.example.videotophotoclone;

import android.media.MediaMetadataRetriever;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.videotophotoclone.Model.Video;
import com.google.android.material.tabs.TabItem;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;

import wseemann.media.FFmpegMediaMetadataRetriever;


/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment {
    List<Video> videoList = new ArrayList<>();
    RecyclerView rvShow;
    TabItem tbVideos,tbImages;
    TabLayout tabHost;
    MediaMetadataRetriever media = new MediaMetadataRetriever();
    public GalleryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvShow=view.findViewById(R.id.rvShow);
        tabHost=view.findViewById(R.id.tabHost);
        tbVideos=view.findViewById(R.id.tbVideos);
        tbImages=view.findViewById(R.id.tbImages);
        videoList.clear();
        String videoPath = "android.resource://com.example.videotophotoclone/"+R.raw.video;
//        media.setDataSource(videoPath);
//        String duration = media.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DURATION);
//        String date = media.extractMetadata(MediaMetadataRetriever.METADATA_KEY_DATE);
//        String name = media.extractMetadata(MediaMetadataRetriever.METADATA_KEY_TITLE);

        videoList.add(new Video("ABCD","duration","date",videoPath));
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(),LinearLayoutManager.VERTICAL,false);
        rvShow.setLayoutManager(linearLayoutManager);
        rvShow.setHasFixedSize(true);
        rvShow.setAdapter(new VideoAdapter(videoList,getContext()));

     }
}
