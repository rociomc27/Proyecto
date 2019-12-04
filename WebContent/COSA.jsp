<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="explorer.InnerExplorer" %>    

<% String username = (String)session.getAttribute("username"); %>
<% for(String n : InnerExplorer.getMainRoute(username).list()){%>
		<div class="folder_label">
			<button class="folder_button"><%=n %></button>
		</div>
		<%} %>
