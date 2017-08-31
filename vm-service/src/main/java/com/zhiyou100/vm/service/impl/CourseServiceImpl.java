package com.zhiyou100.vm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.vm.mapper.CourseMapper;
import com.zhiyou100.vm.mapper.SubjectMapper;
import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.Subject;
import com.zhiyou100.vm.service.CourseService;
import com.zhiyou100.vm.util.Page;
@Service
public class CourseServiceImpl implements CourseService {
	@Autowired
	CourseMapper cm;
	@Autowired
	SubjectMapper sm;

	@Override
	public Page<Course> getPage(Integer page) {
		
		Page<Course> pc = new Page<>();
		pc.setPage(page);
		pc.setSize(10);
		pc.setTotal(cm.getAlltotalCount());
		pc.setRows(cm.findAllCourse((page-1)*10));
		return pc;
	}

	@Override
	public List<Subject> findAllSubject() {
		
		return sm.selectByExample(null);
	}

	@Override
	public void addCourse(Course course) {
		cm.insert(course);
		
	}

	@Override
	public void deleteCourse(Course course) {
		cm.deleteByPrimaryKey(course.getId());
		
	}

	@Override
	public Course findCourse(Course c) {
		return cm.selectByPrimaryKey(c.getId());
		
	}

	@Override
	public void editCourse(Course c) {
		cm.updateByPrimaryKeySelective(c);
		
	}

	@Override
	public List<Course> analysisCourse() {
		
		return cm.analysisCourse();
	}

	@Override
	public List<Course> findCourseWithVideos(Integer subjectId) {
		
		return cm.findCourseWithVideos(subjectId);
	}

	@Override
	public Course findCourseById(Integer courseId) {
		// TODO Auto-generated method stub
		return cm.selectByPrimaryKey(courseId);
	}

}
