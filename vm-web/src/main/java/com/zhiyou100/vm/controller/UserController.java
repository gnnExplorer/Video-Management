package com.zhiyou100.vm.controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Random;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.zhiyou100.vm.model.Result;
import com.zhiyou100.vm.model.User;
import com.zhiyou100.vm.service.UserService;
import com.zhiyou100.vm.util.MailUtil;

@Controller
@RequestMapping("/front/user")
public class UserController {
	@Autowired
	UserService us;
	
	@RequestMapping("/showfont.do")
	public String showHeader(){
		return "front/index";
	}
	//注册
	@RequestMapping(value="/regist.do",method=RequestMethod.POST)
	@ResponseBody
	public Result regist(User u){
		Result res = new Result();
		List<User> list = us.orExist(u);
		if(list.isEmpty()){
			us.regist(u);
			res.setSuccess(true);
		}else{
			res.setSuccess(false);
			res.setMessage("邮箱已注册");
		}
		
		//System.out.println(res);
		return res;
	}
	//登录
	@RequestMapping(value="/login.do",method=RequestMethod.POST)
	@ResponseBody
	public Result login(User u, HttpSession session){
		Result res = new Result();
		List<User> list = us.login(u);
		
		if(list.isEmpty()){
			res.setSuccess(false);
			res.setMessage("登录失败");
			
		}else{
			res.setSuccess(true);
			session.setAttribute("user", list.get(0));
			//System.out.println(list.get(0));
		}
		
		return res;
	}
	//退出
	@RequestMapping("/logout.do")
	public String logout(HttpSession session){
		/*session.invalidate();*/
		session.removeAttribute("user");
		return "redirect:/front/user/showfont.do";
	}
	//忘记密码
	@RequestMapping("/forgetpwd.do")
	public String forgetpwd(){
		
		return "front/user/forget_pwd";
	}
	@RequestMapping(value="/forgetpwd.do",method=RequestMethod.POST)
	public String forgetpwd(User u,Model md){
		String str=null;
		List<User> list = us.verifyEmailAndCaptcha(u);
		if(list.isEmpty()){
			str="redirect:/front/user/forgetpwd.do";
		}else{
			str="front/user/reset_pwd";
			md.addAttribute("email", u.getEmail());
			md.addAttribute("captcha", u.getCaptcha());
		}
		return str;
	}
	//邮箱找回密码,发送验证码
	@RequestMapping(value="/sendemail.do",method=RequestMethod.POST)
	@ResponseBody
	public Result sendmail(User u){
		Result res = new Result();
		List<User> list = us.orExist(u);
		if(list.isEmpty()){
			res.setSuccess(false);
			res.setMessage("邮箱输入不正确");
			
		}else{
			res.setSuccess(true);
			Random rd= new Random();
			String str = rd.nextInt(89999)+10000+"";
			u.setCaptcha(str);
			us.sendmail(u);
			try {
				MailUtil.send("614726791@qq.com", "验证码", str);
			} catch (Exception e) {
				e.printStackTrace();
			}
			//System.out.println(u);
			
		}
		
		//System.out.println(res);
		return res;
	}
	//重置密码
	@RequestMapping(value="/resetpwd.do",method=RequestMethod.POST)
	public String resetpwd(User u){
		//System.out.println(u);
		us.reresetpwd(u);
		return "redirect:/front/user/showfont.do";
	}
	@RequestMapping("/index.do")
	public String getToPersonIndex(HttpSession session,Model md){
		User u=(User)session.getAttribute("user");
		User user=us.getPersonInfo(u);
		md.addAttribute("user", user);
		//System.out.println(user);
		return "front/user/index";
	}
	@RequestMapping("/profile.do")
	public String updateProfile(User u,Model md){
		User user=us.getPersonInfo(u);
		md.addAttribute("user", user);
		return "front/user/profile";
	}
	@RequestMapping(value="/profile.do",method=RequestMethod.POST)
	public String updateProfile(User u){
		us.saveProfile(u);
		//System.out.println(u);
		return "redirect:/front/user/index.do";
	}
	@RequestMapping("/avatar.do")
	public String avatar(){
		
		return "front/user/avatar";
	}
	@RequestMapping(value="/avatar.do",method=RequestMethod.POST)
	public String avatar(User u,MultipartFile image_file) throws IllegalStateException, IOException{
		String str = UUID.randomUUID().toString().replaceAll("-", "");
		String ext = FilenameUtils.getExtension(image_file.getOriginalFilename());
		String fileName = str+"."+ext;
		//System.out.println(fileName);
		//rv.getR().setrPic(fileName);
		//rs.saveRole(rv.getR());
		u.setHeadUrl(fileName);
		us.saveProfile(u);
		String path="D:\\upload";
		image_file.transferTo(new File(path+"\\"+fileName));
		return "redirect:/front/user/index.do";
	}
	
	
	@RequestMapping("/password.do")
	public String password(){
		
		return "front/user/password";
	}
	@RequestMapping(value="/password.do",method=RequestMethod.POST)
	public String password(User u,String oldPassword,String newPassword,Model md) {
		String str = null;
		u.setPassword(oldPassword);
		List<User> list = us.findUserByPwdAndId(u);
		if(list.isEmpty()){
			md.addAttribute("message", "请输入正确的旧密码");
			str="front/user/password";
		}else{
			u.setPassword(newPassword);
			us.updatePassword(u);
			str="redirect:/front/user/logout.do";
		}
		return str;
	}
	
	
	
	
}
