<%@page import="java.util.List" %>
<%@page import="com.dxc.hms.model.Appointments" %>

<%List name= (List)request.getAttribute("data");%>


 
<center>
<html>

<head>
<style type="text/css">
.menu{
	font-family:"Lucida Console";
	text-align:center;
	font-size:x-large;
	background-color: white;
	Border-color:#34aeeb;
	Border-style:groove;
	Border-width:Medium;
	width:100%;
	overflow:auto;
	text-align:center;
}
.menu a{
	float:left;
	padding:12px;
	color:#3483eb;
	text-decoration:none;
	font-size:17px;
	width:10%;
	text-align:center;
}
.menu a:hover{
	background-color:#34aeeb;
	text-align:center;
}
.menu a.active{
	background-color:white;
	text-align:center;
}

table {
  border-collapse: collapse;
  width: 100%;
}

th, td {
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {background-color: #63b2ff;}

</style>
<body>

<center>
<table border=1>
<tr>
<th><b>Patient Name</b></th>
<th><b>Specialist</b></th>


<th><b>Illness</b></th>

<th><b>Date</b></th>

<th><b>Time</b></th>
<th><b>Action</b></th>



</tr>
<%List<Appointments> l=(List<Appointments>)request.getAttribute("data");
for(Appointments p:l){%>
<tr>
<td><b><%= p.getPatientname() %></b></td>
<td><b><%= p.getSpecialist() %></b></td>

<td><b><%= p.getIllness() %></b></td>
<td><b><%= p.getDate() %></b></td>
<td><b><%= p.getTime() %></b></td>
<td>
<form action="http://localhost:8989/HMS/appointments/make.html" method="get">
<input type="hidden" value="<%=p.getPatientname() %>"name="patientname">
<input type="hidden" value="<%=p.getSpecialist() %>"name="specialist">
<input type="hidden" value="<%=p.getIllness() %>"name="illness">
<input type="hidden" value="<%=p.getDate() %>"name="date">
<input type="hidden" value="<%=p.getTime() %>"name="time">
<input type="hidden" value="<%=p.getId() %>"name="appid">
<input type="submit" value="MakeAppointment">
</form><td>
</tr>
<%} %>
</table>
</center>
</body>
</head>
</html>