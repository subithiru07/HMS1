<%@page import="java.util.List" %>
<%@page import="com.dxc.hms.model.Receptionist" %>

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
<th><b>Receptionist Name</b></th>
<th><b>emailid</b></th>
<th><b>phonenumber</b></th>



</tr>
<%List<Receptionist> l=(List<Receptionist>)request.getAttribute("data");
for(Receptionist p:l){%>
<tr>
<td><b><%= p.getName() %></b></td>
<td><b><%= p.getEmail() %></b></td>
<td><b><%= p.getPhnnumber() %></b></td>





</tr>
<%} %>
</table>
</center>
</body>
</head>
</html>