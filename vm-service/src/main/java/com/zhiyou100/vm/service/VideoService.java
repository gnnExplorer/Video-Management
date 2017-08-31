package com.zhiyou100.vm.service;

import java.util.List;

import com.zhiyou100.vm.model.CSVVo;
import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.Speaker;
import com.zhiyou100.vm.model.Video;

public interface VideoService {
	
	CSVVo findAllVideo(CSVVo csvvo);

	List<Course> findAllCourse();

	List<Speaker> findAllSpeaker();

	void addVideo(Video v);

	void deleteVideo(Video v);

	Video editVideo(Video v);

	void updateVideo(Video v);

	void multiDeleteVideo(Integer[] arr);

	Video findVideo(Integer videoId);

	List<Video> findVideosByCourseId(Integer courseId);


}
