package com.ait.drcare.managedbeans.backing.test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import com.ait.drcare.managedbeans.support.VideoListBean;
import com.ait.drcare.model.Video;

class VideoListBeanTest {

	private ArrayList<Video> videosList;
	private VideoListBean videoListBean;

	@Test
	void testSetGetVideos() {
		
	
		videoListBean = new VideoListBean();
		videosList = new ArrayList<Video>();
		
		videosList.add(new Video("vykYmXIiOs0","Accutane"));
		videosList.add(new Video("3-m8kuhPTEo","Collagen"));
		videosList.add(new Video("hzXLHHsa5bw", "Avoid Drug Interactions"));
		videosList.add(new Video("-a5b2u7MG7U", "How To Swallow Tablets Easily"));

		
		videoListBean.setVideos(videosList);
		assertEquals(videosList,videoListBean.getVideos());
	}
	
	@Test
	void testInit() {
		videoListBean = new VideoListBean();
		videoListBean.init();
	}
		

}
