package com.zhiyou100.vm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.vm.mapper.SubjectMapper;
import com.zhiyou100.vm.model.Subject;
import com.zhiyou100.vm.service.SubjectService;
@Service
public class SubjectServiceImpl implements SubjectService {
	@Autowired
	SubjectMapper sm;

	@Override
	public Subject findSubject(Integer subjectId) {
		
		return sm.selectByPrimaryKey(subjectId);
	}

	
}
