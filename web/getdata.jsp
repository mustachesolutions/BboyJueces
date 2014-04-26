<%-- 
    Document   : getdata
    Created on : 17-abr-2014, 13:26:16
    Author     : Enrique
--%>

<%@page import="db.ConsultasEvento"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="control.AutocompleteController"%>
<%
    ConsultasEvento consultasEvento = new ConsultasEvento();
	AutocompleteController db = new AutocompleteController(consultasEvento.listaNombresCrews());

	String query = request.getParameter("q");
	
	List<String> countries = db.getData(query);

	Iterator<String> iterator = countries.iterator();
	while(iterator.hasNext()) {
		String country = (String)iterator.next();
		out.println(country);
	}
%>
