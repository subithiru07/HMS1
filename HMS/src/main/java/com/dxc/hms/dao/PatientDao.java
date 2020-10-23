
	package com.dxc.hms.dao;

	 


	import java.util.Iterator;
	import java.util.List;
	import org.hibernate.Criteria;
	import org.hibernate.Session;
	import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;

import com.dxc.hms.connection.HibCon;
import com.dxc.hms.model.ConfirmedAppointment;
import com.dxc.hms.model.Patient;

	 

	public class PatientDao {
	    HibCon hc= new HibCon();
	   
	    public void AddPatient(Patient patient) {
	        
	        // TODO Auto-generated method stub
	        Session ses= hc.getSession();
	        ses.save(patient);
	        Transaction t = ses.beginTransaction();
	        t.commit();
	        
	    }
	    
	    public boolean LoginValidate(String user, String userpass) {
	        // TODO Auto-generated method stub
	        boolean u =false;
	        Session ses = hc.getSession();
	        Criteria c=ses.createCriteria(Patient.class);
	        List l=c.list();
	        Iterator i = l.iterator();
	        while(i.hasNext()) {
	            Patient p = (Patient) i.next();
	            if(user.equals(p.getUsername())&&(userpass.equals(p.getPassword()))){
	            u=true;    
	            System.out.println("true");
	            }
	            else
	            {
	                System.out.println("false");
	            }
	                
	            }
	        
	        return u;
	    }
	    
	    public List patientList() {
	    	// TODO Auto-generated method stub
	    	Session ses= hc.getSession();
	    	Criteria c = ses.createCriteria(Patient.class);
	    	List l = c.list();
			return l;
	    	
	    }
	    public List appointmentStatus(String name) {
	    	Session ses = hc.getSession();
	    	Criteria c = ses.createCriteria(ConfirmedAppointment.class);
	    	c.add(Restrictions.eq("Name", name));
	    	List l = c.list();
	    	
			return l;
	    	
	    }

		

	 

	    
	    
	    

}
