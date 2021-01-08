 <%@page import="metier.documentsImp"%>
<%@page import="Model.document_administratif"%>
<%@page import="metier.documentsInterface"%>


<%
documentsInterface doc=new documentsImp();
String etat="non";
doc.Modifieretatdocument(etat);
session.removeAttribute("matricule");
response.sendRedirect("../index.jsp");

%>