package com.dxc.hms.dao;


import java.util.Iterator;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;

import com.dxc.hms.connection.HibCon;

import com.dxc.hms.model.Receptionist;

public class ReceptionistDao{
HibCon hc=new HibCon();
	
	public void addReceptionist(Receptionist rep) {
		// TODO Auto-generated method stub
		Session ses=hc.getSession();
		ses.save(rep);
		Transaction t=ses.beginTransaction();
		t.commit();
		
	}
	
	public boolean LoginValidate(String user, String userpass) {
		// TODO Auto-generated method stub
		boolean f=false;
		Session ses=hc.getSession();
		Criteria c=ses.createCriteria(Receptionist.class);
		List l=c.list();
		Iterator i=l.iterator();
		while(i.hasNext())
		{
			Receptionist r =(Receptionist)i.next();
		    if(user.equals(r.getName()) && (userpass.equals(r.getPassword()))){
		    	
		    f=true;
		    System.out.println("true");
		    }
		}
		    System.out.println("false");
		return f;
	}
	public List receptionistList() {
		Session ses = hc.getSession();
		Criteria c = ses.createCriteria(Receptionist.class);
		List l = c.list();
		return l;
		
	}

}
