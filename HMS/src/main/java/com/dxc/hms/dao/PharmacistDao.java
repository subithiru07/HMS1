package com.dxc.hms.dao;

import java.util.Iterator;
import java.util.List;

import org.apache.catalina.User;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;


import com.dxc.hms.connection.HibCon;

import com.dxc.hms.model.Pharmacist;

public class PharmacistDao { 
	HibCon hc= new HibCon();
	
	
    public void AddPharmacist(Pharmacist pharmacist) {
	Session ses=hc.getSession();
	ses.save(pharmacist);
	Transaction t=ses.beginTransaction();
	t.commit();
}

	
	public boolean LoginValidate(String user, String password) {
		// TODO Auto-generated method stub
		boolean f=false;
		Session ses=hc.getSession();
		Criteria c=ses.createCriteria(Pharmacist.class);
		List l=c.list();
		Iterator i=l.iterator();
		while(i.hasNext()) {
			Pharmacist p=(Pharmacist) i.next();
			if(user.equals(p.getName())&& (password.equals(p.getPassword()))) {
		    f=true;
			System.out.println("true");
		}
		
		
		
		}
		System.out.println("false");
		return f;
	}
	public List pharmacistList() {
		Session ses = hc.getSession();
		Criteria c = ses.createCriteria(Pharmacist.class);
		List l = c.list();
		return l;
		
		
	}
}