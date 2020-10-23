package com.dxc.hms.actions;

import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dxc.hms.model.ConfirmedAppointment;

public interface AppCtrl {
	public ModelAndView addAdmin(@RequestParam(value="username")String user,@RequestParam(value="password") String password,@RequestParam(value="email")String email,@RequestParam(value="phone")String phno);
	public ModelAndView LoginValidate(@RequestParam(value="username")String user,@RequestParam(value="password") String password);
	ModelAndView PatientLogin(String user, String userpass);
	ModelAndView DoctorLogin(String user, String userpassword);
	ModelAndView PharmacistLogin(String user, String password);
	//public ModelAndView appointments(@RequestParam(value="time") String time, @RequestParam(value="date")String date, @RequestParam(value="specialist")String specialist, @RequestParam(value="doctorname")String doctorname,  @RequestParam(value="illness")String illness, @RequestParam(value="patientname")String patientname);
	public ModelAndView makeAppointment(@RequestParam(value="time") String time, @RequestParam(value="date")String date, @RequestParam(value="specialist")String specialist,  @RequestParam(value="illness")String illness, @RequestParam(value="patientname")String patientname,int id);
    public ModelAndView appointmentList();
    public ModelAndView doctorApplist(String doctorname,String date);
    public ModelAndView appointmentStatus(HttpSession session);

}
