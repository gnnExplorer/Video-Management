package com.zhiyou100.vm.model;

import java.io.Serializable;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;

import com.zhiyou100.vm.util.MD5Utils;

public class Admin implements HttpSessionActivationListener,Serializable {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer id;

    private String loginName;

    private String loginPwd;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : MD5Utils.getMD5(loginPwd.trim());
    }

	@Override
	public String toString() {
		return "Admin [id=" + id + ", loginName=" + loginName + ", loginPwd=" + loginPwd + "]";
	}

	@Override
	public void sessionWillPassivate(HttpSessionEvent se) {
		System.out.println("钝化");
		
	}

	@Override
	public void sessionDidActivate(HttpSessionEvent se) {
		System.out.println("活化");
		
	}
    
    
}