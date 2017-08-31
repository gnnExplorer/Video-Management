package com.zhiyou100.vm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.vm.mapper.CourseMapper;
import com.zhiyou100.vm.mapper.SpeakerMapper;
import com.zhiyou100.vm.mapper.VideoMapper;
import com.zhiyou100.vm.model.CSVVo;
import com.zhiyou100.vm.model.Course;
import com.zhiyou100.vm.model.Speaker;
import com.zhiyou100.vm.model.Video;
import com.zhiyou100.vm.service.VideoService;
import com.zhiyou100.vm.util.Page;
@Service
public class VideoServiceImpl implements VideoService {
	@Autowired
	VideoMapper vm;
	@Autowired
	CourseMapper cm;
	@Autowired
	SpeakerMapper sm;

	public void setVm(VideoMapper vm) {
		this.vm = vm;
	}
	

	public void setCm(CourseMapper cm) {
		this.cm = cm;
	}


	public void setSm(SpeakerMapper sm) {
		this.sm = sm;
	}


	@Override
	public CSVVo findAllVideo(CSVVo csvvo) {
		
		Page<Video> page= new Page<>();
		page.setTotal(vm.getTotalVideo(csvvo));
		page.setSize(10);
		page.setPage(csvvo.getCurrentPage());
		page.setRows(vm.getAllVideo(csvvo));
		
		CSVVo csv= new CSVVo();
		csv.setSl(sm.selectByExample(null));
		csv.setCl(cm.selectByExample(null));
		csv.setVl(vm.getAllVideo(csvvo));
		csv.setPage(page);
		
		return csv;
	}


	@Override
	public List<Course> findAllCourse() {
		
		return cm.selectByExample(null);
	}


	@Override
	public List<Speaker> findAllSpeaker() {
		// TODO Auto-generated method stub
		return sm.selectByExample(null);
	}


	@Override
	public void addVideo(Video v) {
		vm.insertSelective(v);
		
	}


	@Override
	public void deleteVideo(Video v) {
		vm.deleteByPrimaryKey(v.getId());
		
	}


	@Override
	public Video editVideo(Video v) {
		return vm.selectByPrimaryKey(v.getId());
	}


	@Override
	public void updateVideo(Video v) {
		vm.updateByPrimaryKeySelective(v);
		
	}


	@Override
	public void multiDeleteVideo(Integer[] arr) {
		vm.multiDeleteVideo(arr);
		
	}


	@Override
	public Video findVideo(Integer videoId) {
		
		return vm.selectByPrimaryKey(videoId);
	}


	@Override
	public List<Video> findVideosByCourseId(Integer courseId) {
		
		return vm.findVideosByCourseId(courseId);
	}

	
}
