package com.zhiyou100.vm.controller;

import org.junit.Test;
import org.springframework.stereotype.Controller;

import com.zhiyou100.vm.util.MailUtil;

@Controller
public class TestHeader {
	@Test
	public void MialTest() throws Exception{
		MailUtil.send("614726791@qq.com", "生日快乐", "blablabla");
	}

}
