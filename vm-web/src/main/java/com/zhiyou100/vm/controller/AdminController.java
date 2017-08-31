package com.zhiyou100.vm.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.zhiyou100.vm.model.Admin;
import com.zhiyou100.vm.service.AdminService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	AdminService as;

	@RequestMapping("/login.action")
	public String login(Admin a, HttpSession session, Model md) {

		// 生成一个MD5加密计算摘要
		/*MessageDigest messagedigest =null;
		try {
			messagedigest = MessageDigest.getInstance("MD5");
			// 计算md5函数
			messagedigest.update(a.getLoginPwd().getBytes());
			// digest()最后确定返回md5 hash值，返回值为8为字符串。因为md5 hash值是16位的hex值，实际上就是8位的字符
			// BigInteger函数则将8位的字符串转换成16位hex值，用字符串来表示；得到字符串形式的hash值
			a.setLoginPwd(new BigInteger(1, messagedigest.digest()).toString(16));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}*/
		//System.out.println(a.getLoginPwd());
		
		List<Admin> list = as.login(a);

		if (list.isEmpty() == false) {
			session.setAttribute("admin", list.get(0));
			return "redirect:/video/viewVideo.action";

		} else {
			md.addAttribute("ErrorMessage", "用户名或密码错误");
			return "forward:/index.jsp";
		}
	}

	@RequestMapping("/exitAdmin.action")
	public String exit(HttpSession session) {
		session.invalidate();
		return "redirect:/index.jsp";
	}

}
