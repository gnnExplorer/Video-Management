package com.zhiyou100.vm.service;

import java.util.List;

import com.zhiyou100.vm.model.User;

public interface UserService {

	void regist(User u);

	List<User> orExist(User u);

	List<User> login(User u);

	void sendmail(User u);

	List<User> verifyEmailAndCaptcha(User u);

	void reresetpwd(User u);

	User getPersonInfo(User u);

	void saveProfile(User u);

	List<User> findUserByPwdAndId(User u);

	void updatePassword(User u);

}
