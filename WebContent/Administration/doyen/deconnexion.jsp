<%@page import="metier.seanceImp"%>
<%@page import="Model.seance"%>
<%@page import="metier.seanceInterface"%>
<%@page import="metier.chefImp"%>
<%@page import="Model.chef"%>
<%@page import="metier.chefInterface"%>

<%@page import="metier.departementImp"%>
<%@page import="Model.departement"%>
<%@page import="metier.departementInterface"%>
<%
seanceInterface sc=new seanceImp();
departementInterface dep=new departementImp();
chefInterface cf=new chefImp();
String etat="non";
sc.Modifieretatseance(etat);
cf.Modifieretatchef(etat);
dep.Modifieretatdepartement(etat);
session.removeAttribute("role");
session.removeAttribute("id");
session.removeAttribute("login");
response.sendRedirect("../../index.jsp");

%>