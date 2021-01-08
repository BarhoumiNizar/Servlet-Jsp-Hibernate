 <%@page import="metier.salleImp"%>
<%@page import="Model.Salle"%>
<%@page import="metier.salleInterface"%>

 <%@page import="metier.EtudiantImp"%>
<%@page import="Model.Etudiant"%>
<%@page import="metier.EtudiantInterface"%>

 <%@page import="metier.payementImp"%>
<%@page import="Model.Payement"%>
<%@page import="metier.payementInterface"%>
<%
salleInterface sal=new salleImp();
payementInterface pay=new payementImp();
EtudiantInterface etd=new EtudiantImp();
String etat="non";
sal.Modifieretatsalle(etat);
pay.Modifieretatpayement(etat);
etd.Modifieretatetudiant(etat);
session.removeAttribute("matricule");
response.sendRedirect("../../index.jsp");

%>