package com.zhiyou100.vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.Subject;
import com.zhiyou100.vm.service.CourseService;
import com.zhiyou100.vm.util.Page;

@Controller
@RequestMapping("/course")
public class CourseController {
	@Autowired
	 CourseService cs;
	
	@RequestMapping("/viewCourse.action")
	public String viewCourse(@RequestParam(defaultValue="1",required=true)Integer page, Model md){
		
		Page<Course> pc = cs.getPage(page);
		md.addAttribute("page", pc);
		
		return "course/viewCourse";
	}
	@RequestMapping("/addCourse.action")
	public String addCourse(Model md){
		
		List<Subject> subjectlist = cs.findAllSubject();
		md.addAttribute("subjectlist", subjectlist);
		
		return "course/addCourse";
	}
	@RequestMapping(value="/addCourse.action",method=RequestMethod.POST)
	public String addCourse(Course course){
		cs.addCourse(course);
		
		return "redirect:/course/viewCourse.action";
	}
	@RequestMapping("/deleteCourse.action")
	public String deleteCourse(Course course){
		cs.deleteCourse(course);
		return "redirect:/course/viewCourse.action";
	}
	@RequestMapping("/editCourse.action")
	public String editCourse(Course c, Model md){
		Course course=cs.findCourse(c);
		
		md.addAttribute("course", course);
		md.addAttribute("subjectlist", cs.findAllSubject());
		return "/course/editCourse";
	}
	@RequestMapping(value="/editCourse.action", method=RequestMethod.POST)
	public String editCourse(Course c){
		cs.editCourse(c);
		return "redirect:/course/viewCourse.action";
	}
	@RequestMapping("/analysisCourse.action")
	public String analysisCourse(Model md){
		List<Course> lc = cs.analysisCourse();
		md.addAttribute("analysisCourseInfo", lc);
		//System.out.println(lc);
		//return null;
		return "/course/analysisCourse";
	}
	

}
