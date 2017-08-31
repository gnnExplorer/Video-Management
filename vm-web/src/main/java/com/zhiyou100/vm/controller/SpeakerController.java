package com.zhiyou100.vm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.vm.model.Speaker;
import com.zhiyou100.vm.service.SpeakerService;
import com.zhiyou100.vm.util.Page;

@Controller
@RequestMapping("/speaker")
public class SpeakerController {
	@Autowired
	SpeakerService ss;
	@RequestMapping("/viewSpeaker.action")
	public String viewSpeaker(@RequestParam(defaultValue="1",required=true) Integer page,
			@RequestParam(defaultValue="",required=true) String nameKey,
			@RequestParam(defaultValue="",required=true) String jobKey,Model md){
		
		md.addAttribute("nameKey", nameKey);
		md.addAttribute("jobKey", jobKey);
		
		Page<Speaker> pageInfo =ss.viewSpeaker(nameKey,jobKey,page);
		md.addAttribute("page", pageInfo);
		return "/speaker/viewSpeaker";
	}
	
	@RequestMapping("/addSpeaker.action")
	public String addSpeaker(){
		return "speaker/addSpeaker";
	}
	@RequestMapping(value="/addSpeaker.action", method=RequestMethod.POST)
	public String addSpeaker(Speaker speaker){
		ss.addSpeaker(speaker);
		return "redirect:/speaker/viewSpeaker.action";
	}
	
	@RequestMapping("/deleteSpeaker.action")
	public String deleteSpeaker(Speaker speaker){
		ss.deleteSpeaker(speaker);
		return "redirect:/speaker/viewSpeaker.action";
	}
	@RequestMapping("/editSpeaker.action")
	public String editSpeaker(Speaker s, Model md){
		Speaker speaker = ss.findSpeaker(s);
		md.addAttribute("speaker", speaker);
		return "/speaker/editSpeaker";
	}
	@RequestMapping(value="/editSpeaker.action", method=RequestMethod.POST)
	public String editSpeaker(Speaker speaker){
		ss.editSpeaker(speaker);
		return "redirect:/speaker/viewSpeaker.action";
	}

	
	
}
