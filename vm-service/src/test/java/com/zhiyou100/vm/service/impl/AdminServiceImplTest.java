package com.zhiyou100.vm.service.impl;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.zhiyou100.vm.model.Admin;
import com.zhiyou100.vm.service.AdminService;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext-*")
public class AdminServiceImplTest {
	@Autowired
	AdminService as;
	@Test
	public void test() {
		Admin a = new Admin();
		a.setLoginName("admin");
		a.setLoginPwd("admin");
		System.out.println(as.login(a).get(0));
	}

}
