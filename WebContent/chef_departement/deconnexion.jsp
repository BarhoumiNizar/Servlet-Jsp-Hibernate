 <%@page import="metier.notesImp"%>
<%@page import="Model.Examen"%>
<%@page import="metier.notesInterface"%>
 <%@page import="metier.absenceImp"%>
<%@page import="Model.absence"%>
<%@page import="metier.absenceInterface"%>

 <%@page import="metier.filiereImp"%>
<%@page import="Model.Filiere"%>
<%@page import="metier.filiereInterface"%>

 <%@page import="metier.matiereImp"%>
<%@page import="Model.matiere"%>
<%@page import="metier.matiereInterface"%>

 <%@page import="metier.classeImp"%>
<%@page import="Model.classe"%>
<%@page import="metier.classeInterface"%>

 <%@page import="metier.professeursImp"%>
<%@page import="Model.Professeur"%>
<%@page import="metier.professeursInterface"%>

<%
Object prenom=session.getAttribute("prenom");
Object nom=session.getAttribute("nom");
String preno=prenom.toString();
String name=nom.toString();
String prof=name+" "+preno;
notesInterface note=new notesImp();
absenceInterface absence=new absenceImp();

filiereInterface fl=new filiereImp();

matiereInterface mat=new matiereImp();

professeursInterface profs=new professeursImp();

classeInterface cls=new classeImp();
String etat="non";
note.Modifieretatnote(etat,prof);
absence.Modifieretatnote(etat, prof);
fl.Modifieretatfiliere(etat);
mat.Modifieretatmatiere(etat);
cls.Modifieretatclasse(etat);
profs.Modifieretatprof(etat);
session.removeAttribute("prenom");
session.removeAttribute("idprof");
response.sendRedirect("../index.jsp");

%>