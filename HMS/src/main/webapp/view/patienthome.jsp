<H1>Patient Home</H1>
<% String name = (String)request.getAttribute("data");
session.setAttribute("user", name);
%>
<a href="http://localhost:8989/HMS/appointments.jsp">appointments</a>
<a href="http://localhost:8989/HMS/appointment/status.html">appointment status</a>

<h1><%out.println(name);%>></h1>