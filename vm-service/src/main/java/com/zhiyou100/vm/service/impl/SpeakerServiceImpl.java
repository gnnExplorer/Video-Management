package com.zhiyou100.vm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.vm.mapper.SpeakerMapper;
import com.zhiyou100.vm.model.Speaker;
import com.zhiyou100.vm.service.SpeakerService;
import com.zhiyou100.vm.util.Page;
@Service
public class SpeakerServiceImpl implements SpeakerService {
	
	@Autowired
	SpeakerMapper sm;
	@Override
	public Page<Speaker> viewSpeaker(String nameKey, String jobKey, Integer page) {
		Page<Speaker> ps = new Page<>();
		ps.setPage(page);
		ps.setSize(10);
		ps.setTotal(sm.getTotalCount(nameKey,jobKey));
		ps.setRows(sm.findAllSpeaker(nameKey,jobKey,(page-1)*10));
		return ps;
	}
	@Override
	public void addSpeaker(Speaker speaker) {
		sm.insertSelective(speaker);
		
	}
	@Override
	public void deleteSpeaker(Speaker speaker) {
		sm.deleteByPrimaryKey(speaker.getId());
		
	}
	@Override
	public Speaker findSpeaker(Speaker s) {
		return sm.selectByPrimaryKey(s.getId());
	}
	@Override
	public void editSpeaker(Speaker speaker) {
		sm.updateByPrimaryKeySelective(speaker);
		
	}
	@Override
	public Speaker findSpeakerById(Integer speakerId) {
		
		return sm.selectByPrimaryKey(speakerId);
	}

}
