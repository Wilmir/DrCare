package com.ait.drcare.managedbeans.models;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.ait.drcare.model.Video;

class VideoTest {

	private Video video;
	
	@BeforeEach
	public void init() {
		video = new Video("myId","I am a video");
	}
	
	@Test
	void testConstructor() {
		assertEquals("myId",video.getId());
		assertEquals("I am a video", video.getTitle());
	}
	
	@Test
	void testSetId() {
		video.setId("newId");
		assertEquals("newId",video.getId());
	}
	
	@Test
	void testSetTitle() {
		video.setTitle("I am a new title");
		assertEquals("I am a new title",video.getTitle());
	}

}
