package com.dxc.hms.actions;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.hms.dao.AdminDao;
import com.dxc.hms.dao.AppointmentsDao;
import com.dxc.hms.dao.DoctorDao;
import com.dxc.hms.dao.PatientDao;
import com.dxc.hms.dao.PharmacistDao;
import com.dxc.hms.dao.ReceptionistDao;
import com.dxc.hms.model.Admin;
import com.dxc.hms.model.Appointments;
import com.dxc.hms.model.ConfirmedAppointment;
import com.dxc.hms.model.Doctor;
import com.dxc.hms.model.Patient;
import com.dxc.hms.model.Pharmacist;
import com.dxc.hms.model.Receptionist;

@Controller
public class AppController implements AppCtrl {
	@RequestMapping(value="/admin/add")
	public ModelAndView addAdmin(@RequestParam(value="username")String user,@RequestParam(value="password") String password,@RequestParam(value="email")String email,@RequestParam(value="phone")String phno) {
		AdminDao ad = new AdminDao();
		Admin a = new Admin();
		a.setEmail(email);
		a.setUsername(user);
		a.setPhno(phno);
		a.setPassword(password);
		ad.addAdmin(a);
		
		return new ModelAndView("","","");
		
	}
	
	@RequestMapping(value="/admin/login")
	public ModelAndView LoginValidate(@RequestParam(value="username")String user,@RequestParam(value="password") String password) {
		AdminDao ad = new AdminDao();
		boolean b= ad.Login(user, password);
		if(b) {
			return new ModelAndView("adminhome","data",user);
		}
		else {
			return new ModelAndView("loginagain","data",user);
		}
		
	
	}
	   @RequestMapping(value="/patient/add")
	    public ModelAndView addpatient(@RequestParam(value="username") String Username, @RequestParam(value="password")String password, @RequestParam(value="emailid")String emailid, @RequestParam(value="phonenumber")String phonenumber,  @RequestParam(value="address")String address, @RequestParam(value="age")int age,  @RequestParam(value="gender")String gender )
	    {
	    PatientDao pd=new PatientDao();
	    
	    Patient p=new Patient();
	    p.setUsername(Username);
	    p.setPassword(password);
	    p.setEmailid(emailid);
	    p.setPhonenumber(phonenumber);
	    p.setAddress(address);
	    p.setAge(age);
	    p.setGender(gender);
	    pd.AddPatient(p);
	    return new ModelAndView("");
	        
	    }

	 

	    @Override
	    @RequestMapping(value="/patient/login",method=RequestMethod.POST)
	    public ModelAndView PatientLogin(@RequestParam(value="username")String user, @RequestParam(value="password")String userpass) {
	        // TODO Auto-generated method stub
	        PatientDao pd= new PatientDao();
	        boolean b= pd.LoginValidate(user, userpass);
	        if(b) {
	            return new ModelAndView("patienthome","data",user);
	        }
	        
	        else {
	            return new ModelAndView("patientloginagain");
	        }
	        
	   }
	    @RequestMapping(value="/doctor/add")
		public ModelAndView addDoctor(@RequestParam(value="count")int count,@RequestParam(value="date")String date,@RequestParam(value="name")String name, @RequestParam(value="emailid")String emailid,@RequestParam(value="phonenumber")String phonenumber,@RequestParam(value="department")String department,@RequestParam(value="availabletiming")String availabletiming,@RequestParam(value="gender")String gender, @RequestParam(value="password")String password) { 
		DoctorDao doc= new DoctorDao();
		Doctor d = new Doctor();
		d.setCount(count);
		d.setDate(date);
		d.setName(name);
		d.setPhonenumber(phonenumber);
		d.setEmailid(emailid);
		d.setDepartment(department);
		d.setGender(gender);
		d.setPassword(password);
		d.setAvailabletiming(availabletiming);
		doc.AddDoctor(d);
		
		return new ModelAndView("adminhome");
		
		
	}

	
		@RequestMapping(value="/doctor/login",method=RequestMethod.POST)
		public ModelAndView DoctorLogin(@RequestParam(value="username")String user,@RequestParam(value="password" )String userpassword) {
			// TODO Auto-generated method stub
			DoctorDao doc = new DoctorDao();
			boolean b=doc.LoginValidate(user, userpassword);
			if(b) {
				return new ModelAndView("doctorhome","data",user);
			}
			else {
				return new ModelAndView("doctorloginagain");
			}
		
		}
	    
		
		 @RequestMapping(value="/pharmacist/add")
		 public ModelAndView addPharmacist(@RequestParam(value="name")String name,@RequestParam(value="phonenumber")String phonenumber,@RequestParam(value="emailid")String emailid,@RequestParam(value="password")String password) {
			PharmacistDao pd = new PharmacistDao();
			Pharmacist p = new Pharmacist();
			p.setName(name);
			p.setPhonenumber(phonenumber);
			p.setEmailid(emailid);
			p.setPassword(password);
			pd.AddPharmacist(p);
			
			 return new ModelAndView("adminhome","","") ;
		 }

		@RequestMapping(value="/pharmacist/login", method=RequestMethod.POST)
		public ModelAndView PharmacistLogin(@RequestParam(value="name")String user,@RequestParam(value="password")String password) {
			// TODO Auto-generated method stub
			PharmacistDao pd=new PharmacistDao();
			boolean b=pd.LoginValidate(user, password);
			if(b) {
				return new ModelAndView("pharmacisthome","data",user);
			}
			else
			{
			return new ModelAndView("pharmacistloginagain");
		    }
		}
		
		
		@RequestMapping(value="/receptionist/add")
		public ModelAndView addReceptionist(@RequestParam(value="name")String name,@RequestParam(value="phnnumber")int phnnumber,@RequestParam(value="email")String email,@RequestParam(value="password")String password)
		{
		ReceptionistDao rd=new ReceptionistDao();
	    Receptionist r=new Receptionist();
	    r.setName(name);
	    r.setPassword(password);
	    r.setEmail(email);
	    r.setPhnnumber(phnnumber);
	    rd.addReceptionist(r);
		return new ModelAndView("adminhome","data",name);
	   }

		
		@RequestMapping(value="/receptionist/login",method=RequestMethod.POST)
		// TODO Auto-generated method stub
		public ModelAndView Login(@RequestParam(value="name")String user, @RequestParam(value="password")String userpass) {
		ReceptionistDao rd=new ReceptionistDao();
		boolean b=rd.LoginValidate(user, userpass);
		if(b)
		{
			return new ModelAndView("receptionisthome","data",user);
			
		}
		else
		{
			return new ModelAndView("receptionistloginagain");
		}
			
			
			
		}
		@RequestMapping(value="/doctor/list")
	public ModelAndView doctorList() {
		DoctorDao dd= new DoctorDao();
		
		List l =dd.doctorList();
		
		
		
		return new ModelAndView("doctorlist","data",l);
			
		}
		@RequestMapping(value="/patient/list")
		public ModelAndView patientList() {
			PatientDao p = new PatientDao();
			List l = p.patientList(); 
			return new ModelAndView("patientlist","data",l);
			
		}
		@RequestMapping(value="/pharmacist/list")
		public ModelAndView pharmacistList() {
			PharmacistDao pd= new PharmacistDao();
			List l = pd.pharmacistList();
			
			return new ModelAndView("pharmacistlist","data",l);
			
		}
		@RequestMapping(value="/receptionist/list")
		public ModelAndView receptionistList() {
			ReceptionistDao rd = new ReceptionistDao();
			List l= rd.receptionistList();
			return new ModelAndView("receptionistlist","data",l);
			
		}
		 @RequestMapping(value="/appointments/add")
		    public ModelAndView appointments(@RequestParam(value="time") String time, @RequestParam(value="date")String date, @RequestParam(value="specialist")String specialist,  @RequestParam(value="illness")String illness, @RequestParam(value="patientname")String patientname)
		    {
		    AppointmentsDao ap=new AppointmentsDao();
		   
		    Appointments a =new Appointments();
		   
		    a.setTime(time);
		    a.setDate(date);
		    a.setSpecialist(specialist);
		   
		    a.setIllness(illness);
		    a.setPatientname(patientname);
		    ap.bookAppointments(a);
		        return new ModelAndView("");
		       
		    }

		@Override
		@RequestMapping(value="/appointments/make")
		public ModelAndView makeAppointment(@RequestParam(value="time") String time, @RequestParam(value="date")String date, @RequestParam(value="specialist")String specialist,  @RequestParam(value="illness")String illness, @RequestParam(value="patientname")String patientname,@RequestParam(value="appid") int id) {
			// TODO Auto-generated method stub
			AppointmentsDao ad = new AppointmentsDao();
			ConfirmedAppointment cp = new ConfirmedAppointment();
			cp.setName(patientname);
			cp.setSpecialist(specialist);
			cp.setIllness(illness);
			cp.setDate(date);
			cp.setTime(time);
			
			List l = ad.makeAppointments(cp, id);
			
			
			return new ModelAndView("appointmentlist","data",l);
		}

		@Override
		@RequestMapping(value="/appointments/list")
		public ModelAndView appointmentList() {
			// TODO Auto-generated method stub
			AppointmentsDao ad = new AppointmentsDao();
			List  l= ad.appointmentslist();
			return new ModelAndView("appoitmentlist","data",l);
		}

		@Override
		@RequestMapping(value="/doctor/appointment",method=RequestMethod.POST)
		public ModelAndView doctorApplist(@RequestParam(value="name")String doctorname,@RequestParam(value="date") String date) {
			// TODO Auto-generated method stub
			DoctorDao d = new DoctorDao();
			List l= d.doctorAppList(doctorname, date);
			
			return new ModelAndView("doctorapplist","data",l);
		}

		@Override
		@RequestMapping(value="/appointment/status")
		public ModelAndView appointmentStatus(HttpSession session) {
			// TODO Auto-generated method stub
			String name = (String) session.getAttribute("user");
			System.out.print(name);
			PatientDao pd = new  PatientDao();
			List l = pd.appointmentStatus(name);
			
			return new ModelAndView("appointmentstatus","data",l);
		}
		

	
}