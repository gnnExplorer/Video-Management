package com.zhiyou100.vm.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.Subject;
import com.zhiyou100.vm.service.CourseService;
import com.zhiyou100.vm.service.SubjectService;

@Controller
@RequestMapping("/front/course")
public class FrontCourseController {
	@Autowired
	SubjectService ss;
	@Autowired
	CourseService cs;

	@RequestMapping("/index.do")
	public String getToCourseIndex(Integer subjectId, Model md) {
		Subject subject = ss.findSubject(subjectId);
		List<Course> courses = cs.findCourseWithVideos(subjectId);
		md.addAttribute("courses", courses);
		md.addAttribute("subject", subject);
		md.addAttribute("subjectId", subjectId);
		// System.out.println(subject);
		// System.out.println(courses);
		return "front/course/index";
	}
}
