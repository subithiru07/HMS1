package com.dxc.hms.connection;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

public class HibCon {
	Session session;
	public Session getSession() {
		return session;
	}
	public HibCon(){
		SessionFactory sfact= new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
		 session=sfact.openSession();
		
	}


}
