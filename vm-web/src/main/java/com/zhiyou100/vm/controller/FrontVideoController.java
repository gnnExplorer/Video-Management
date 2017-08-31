package com.zhiyou100.vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.Speaker;
import com.zhiyou100.vm.model.Subject;
import com.zhiyou100.vm.model.Video;
import com.zhiyou100.vm.service.CourseService;
import com.zhiyou100.vm.service.SpeakerService;
import com.zhiyou100.vm.service.SubjectService;
import com.zhiyou100.vm.service.VideoService;

@Controller
@RequestMapping("/front/video")
public class FrontVideoController {
	@Autowired
	VideoService vs;
	@Autowired
	SubjectService sus;
	@Autowired
	SpeakerService sps;
	@Autowired
	CourseService cs;
	
	@RequestMapping("/index.do")
	public String getToIndex(Integer videoId, Integer subjectId, Model md){
		Subject subject = sus.findSubject(subjectId);
		md.addAttribute("subject", subject);
		md.addAttribute("videoId", videoId);
		return "front/video/index";
	}
	@RequestMapping("/videoData.do")
	public String getToIndex(Integer videoId, Model md){
		
		Video video = vs.findVideo(videoId);
		Speaker speaker = sps.findSpeakerById(video.getSpeakerId());
		Course course = cs.findCourseById(video.getCourseId());
		List<Video> videoList = vs.findVideosByCourseId(video.getCourseId());
		md.addAttribute("video", video);
		md.addAttribute("speaker", speaker);
		md.addAttribute("course", course);
		md.addAttribute("videoList", videoList);
		md.addAttribute("subjectId", course.getSubjectId());
		
		//System.out.println(video);
		//System.out.println(speaker);
		return "front/video/content";
	}
}
