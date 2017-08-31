package com.zhiyou100.vm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zhiyou100.vm.mapper.UserMapper;
import com.zhiyou100.vm.model.User;
import com.zhiyou100.vm.model.UserExample;
import com.zhiyou100.vm.service.UserService;
@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserMapper um;

	public void setUm(UserMapper um) {
		this.um = um;
	}

	@Override
	public void regist(User u) {
		um.insertSelective(u);
		
	}

	@Override
	public List<User> orExist(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		return um.selectByExample(ue);
	}

	@Override
	public List<User> login(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andPasswordEqualTo(u.getPassword());
		return um.selectByExample(ue);
	}

	@Override
	public void sendmail(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail());
		um.updateByExampleSelective(u, ue);
		
	}

	@Override
	public List<User> verifyEmailAndCaptcha(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		return um.selectByExample(ue);
	}

	@Override
	public void reresetpwd(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andEmailEqualTo(u.getEmail()).andCaptchaEqualTo(u.getCaptcha());
		um.updateByExampleSelective(u, ue);
	}

	@Override
	public User getPersonInfo(User u) {
		
		return um.selectByPrimaryKey(u.getId());
	}

	@Override
	public void saveProfile(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}

	@Override
	public List<User> findUserByPwdAndId(User u) {
		UserExample ue = new UserExample();
		ue.createCriteria().andIdEqualTo(u.getId()).andPasswordEqualTo(u.getPassword());
		return um.selectByExample(ue);
	}

	@Override
	public void updatePassword(User u) {
		um.updateByPrimaryKeySelective(u);
		
	}
	

}
