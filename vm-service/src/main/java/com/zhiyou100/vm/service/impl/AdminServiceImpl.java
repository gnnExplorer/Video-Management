package com.zhiyou100.vm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.vm.mapper.AdminMapper;
import com.zhiyou100.vm.model.Admin;
import com.zhiyou100.vm.model.AdminExample;
import com.zhiyou100.vm.service.AdminService;
@Service
public class AdminServiceImpl implements AdminService {
	@Autowired
	AdminMapper am;

	public void setAm(AdminMapper am) {
		this.am = am;
	}

	@Override
	public List<Admin> login(Admin a) {
		AdminExample ae = new AdminExample();
		ae.createCriteria().andLoginNameEqualTo(a.getLoginName()).andLoginPwdEqualTo(a.getLoginPwd());
		return am.selectByExample(ae);
	}
	

}
