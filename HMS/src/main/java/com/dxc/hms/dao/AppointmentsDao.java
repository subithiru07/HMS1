package com.dxc.hms.dao;

 

import java.util.Iterator;
import java.util.List;

 

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.dxc.hms.connection.HibCon;

import com.dxc.hms.model.Appointments;
import com.dxc.hms.model.ConfirmedAppointment;
import com.dxc.hms.model.Doctor;
import com.dxc.hms.model.Patient;

 

public class AppointmentsDao  {
    
    
    HibCon hc= new HibCon();
  
    public void bookAppointments(Appointments appointment) {
        
        // TODO Auto-generated method stub
        Session ses= hc.getSession();
        ses.save(appointment);
        Transaction t = ses.beginTransaction();
        t.commit();
        
    }
    public List makeAppointments(ConfirmedAppointment cp,int id) {
    	Session ses = hc.getSession();
    	Criteria c = ses.createCriteria(Doctor.class);
    	//c.add(Restrictions.eq("department",cp.getSpecialist()));
    	List l = c.list();
    	Iterator i = l.iterator();
    	while(i.hasNext()) {
    		Doctor d = (Doctor) i.next();
    		if((d.getDepartment().equals(cp.getSpecialist()))&&(d.getAvailabletiming().equals(cp.getTime()))&&(d.getDate().equals(cp.getDate()))&&(d.getCount()>0)) {
    			cp.setDoctorName(d.getName());
    			cp.setStatus("Confirmed");
    			ses.save(cp);
    			d.setCount(d.getCount()-1);
    			ses.saveOrUpdate(d);
    			Transaction t = ses.beginTransaction();
    			t.commit();
    			System.out.println(cp);
    			System.out.print("Confirmed");
    			}
    		else 
    		{
    			cp.setDoctorName("no doctor");
    			cp.setStatus("Appointment full");
    			ses.save(cp);
    				System.out.println("Not yet Confirmed");
    			
    		}
    		
    	}
    	Appointments a = (Appointments) ses.load(Appointments.class, id);
		ses.delete(a);
		Transaction t = ses.beginTransaction();
		t.commit();
    	Criteria app = ses.createCriteria(Appointments.class);
		List la=app.list();
    	
		return l;
    	
    }
    public List appointmentslist()
   {
    	Session ses = hc.getSession();
    	Criteria c = ses.createCriteria(Appointments.class);
    	List l =c.list();
    	
    	
    	
	return l;
    	}
}
