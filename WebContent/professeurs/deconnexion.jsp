 <%@page import="metier.notesImp"%>
<%@page import="Model.Examen"%>
<%@page import="metier.notesInterface"%>
 <%@page import="metier.absenceImp"%>
<%@page import="Model.absence"%>
<%@page import="metier.absenceInterface"%>
 <%@page import="metier.stageImp"%>
<%@page import="Model.stage"%>
<%@page import="metier.stageInterface"%>
 <%@page import="metier.notificationImp"%>
<%@page import="Model.notification"%>
<%@page import="metier.notificationInterface"%>
<%
Object prenom=session.getAttribute("prenom");
Object nom=session.getAttribute("nom");
String preno=prenom.toString();
String name=nom.toString();
String prof=name+" "+preno;
notesInterface note=new notesImp();
stageInterface stag=new stageImp();
absenceInterface absence=new absenceImp();
notificationInterface notif=new notificationImp();
String etat="non";
note.Modifieretatnote(etat,prof);
absence.Modifieretatnote(etat, prof);
stag.Modifieretatstage(etat, prof);
notif.Modifieretatnotification(etat, prof);
session.removeAttribute("prenom");
session.removeAttribute("idprof");
response.sendRedirect("../index.jsp");

%>