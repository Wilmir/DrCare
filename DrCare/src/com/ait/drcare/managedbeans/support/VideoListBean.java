package com.ait.drcare.managedbeans.support;

import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import com.ait.drcare.model.Video;

@ManagedBean
@SessionScoped
public class VideoListBean {
	private ArrayList<Video> videos;
	
	@PostConstruct
	public void init() {
		videos = new ArrayList<>();
		
		videos.add(new Video("vykYmXIiOs0","Accutane"));
		videos.add(new Video("3-m8kuhPTEo","Collagen"));
		videos.add(new Video("hzXLHHsa5bw", "Avoid Drug Interactions"));
		videos.add(new Video("-a5b2u7MG7U", "How To Swallow Tablets Easily"));
		videos.add(new Video("dC2PwVvJmxY","How to Take Levothyroxine"));
		videos.add(new Video("rc4ukEnN0OA","How to Take Metformin"));
		videos.add(new Video("eOsY84oYqKg","How to Test Blood Sugar"));
		videos.add(new Video("meft0OwowLE","How to Use Eye Drops"));
		videos.add(new Video("iO8HpORGHOA","How to Use an Inhaler"));
		videos.add(new Video("mYQhIaoIKj0","How to Use Nasal Spray"));

		
	}

	public ArrayList<Video> getVideos() {
		return videos;
	}

	public void setVideos(ArrayList<Video> videos) {
		this.videos = videos;
	}

}
