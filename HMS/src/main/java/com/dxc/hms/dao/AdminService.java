package com.dxc.hms.dao;

import com.dxc.hms.model.Admin;

public interface AdminService {
	public void addAdmin(Admin ad);
	public boolean Login(String user,String pass);
}
