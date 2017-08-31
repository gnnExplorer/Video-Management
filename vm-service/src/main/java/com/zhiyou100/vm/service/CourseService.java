package com.zhiyou100.vm.service;

import java.util.List;

import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.Subject;
import com.zhiyou100.vm.util.Page;

public interface CourseService {

	Page<Course> getPage(Integer page);

	List<Subject> findAllSubject();

	void addCourse(Course course);

	void deleteCourse(Course course);

	Course findCourse(Course course);

	void editCourse(Course c);

	List<Course> analysisCourse();

	List<Course> findCourseWithVideos(Integer subjectId);

	Course findCourseById(Integer courseId);

}
