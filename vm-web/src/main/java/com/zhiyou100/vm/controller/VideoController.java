package com.zhiyou100.vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.vm.model.CSVVo;
import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.IdVo;
import com.zhiyou100.vm.model.Speaker;
import com.zhiyou100.vm.model.Video;
import com.zhiyou100.vm.service.VideoService;
import com.zhiyou100.vm.util.Page;

@Controller
@RequestMapping("/video")
public class VideoController {
	@Autowired
	VideoService vs;
	@RequestMapping("/viewVideo.action")
	public String findCSV(@RequestParam(defaultValue="",required=true)String keyword,
			@RequestParam(defaultValue="s",required=true)String sn,
			@RequestParam(defaultValue="s",required=true)String cn,
			@RequestParam(defaultValue="1",required=true)Integer page,Model md){
		md.addAttribute("keyword", keyword);
		md.addAttribute("sn", sn);
		md.addAttribute("cn", cn);
		CSVVo csvvo = new CSVVo();
		csvvo.setKeyword(keyword);
		csvvo.setSpeakerName(sn);
		csvvo.setCourseName(cn);
		csvvo.setCurrentPage(page);
		csvvo.setBegin((page-1)*10);
		//System.out.println(csvvo);
		CSVVo csv = vs.findAllVideo(csvvo);
		Page<Video> pv = csv.getPage();
		md.addAttribute("page", pv);
		md.addAttribute("csv", csv);
		//System.out.println(pv);
		//System.out.println(csv);
		return "video/viewVideo";
	}
	@RequestMapping("/addVideo.action")
	public String addVideo(Model md){
		List<Course> courses = vs.findAllCourse();
		List<Speaker> speakers = vs.findAllSpeaker();
		md.addAttribute("speakers", speakers);
		md.addAttribute("courses", courses);
		return "video/addVideo";
		
	}
	
	@RequestMapping(value="/addVideo.action",method=RequestMethod.POST)
	public String addVideo(Video v){
		vs.addVideo(v);
		
		return "redirect:/video/viewVideo.action";
		
	}
	@RequestMapping("/deleteVideo.action")
	public String deleteVideo(Video v){
		
		vs.deleteVideo(v);
		return "redirect:/video/viewVideo.action";
	}
	@RequestMapping("/editVideo.action")
	public String editVideo(Video v,Model md){
		Video video = vs.editVideo(v);
		List<Course> courses = vs.findAllCourse();
		List<Speaker> speakers = vs.findAllSpeaker();
		md.addAttribute("speakers", speakers);
		md.addAttribute("courses", courses);
		md.addAttribute("video", video);
		return "/video/editVideo";
	}
	@RequestMapping(value="/editVideo.action",method=RequestMethod.POST)
	public String editVideo(Video v){
		
		vs.updateVideo(v);
		return "redirect:/video/viewVideo.action";
	}
	@RequestMapping("/multiDeleteVideo.action")
	public String multiDeleteVideo(IdVo idvo){
		
		//System.out.println(idvo);
		Integer[] arr = {idvo.getId1(),idvo.getId2(),idvo.getId3(),idvo.getId4(),idvo.getId5(),idvo.getId6(),idvo.getId7(),idvo.getId8(),idvo.getId9(),idvo.getId10()};
		vs.multiDeleteVideo(arr);
		return "redirect:/video/viewVideo.action";
	}
	
	
	

}
