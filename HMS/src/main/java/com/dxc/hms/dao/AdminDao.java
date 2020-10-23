package com.dxc.hms.dao;

import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dxc.hms.connection.HibCon;
import com.dxc.hms.model.Admin;



public class AdminDao implements AdminService{
	HibCon hc = new HibCon();
	public void addAdmin(Admin ad) {
		Session ses= hc.getSession();
		ses.save(ad);
		Transaction t = ses.beginTransaction();
		t.commit();
		}
	public boolean Login(String user,String pass) {
		boolean f=false;
		Session ses= hc.getSession();
		Criteria c=ses.createCriteria(Admin.class);
		List l = c.list();
		Iterator i = l.iterator();
		while(i.hasNext()) {
			Admin a= (Admin) i.next();
			if((user.equals(a.getUsername()))&&(pass.equals(a.getPassword()))) {
				f=true;
				System.out.print("true");
			}
			System.out.print("false");
		}
		return f;
		
	}

}
