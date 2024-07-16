<%@ page import="java.util.List" %>
<%@ page import="org.example.last_lesson_library.entity.User" %>
<%@ page import="org.example.last_lesson_library.repo.UserRepo" %>
<%@ page import="org.example.last_lesson_library.entity.Book" %>
<%@ page import="java.util.Objects" %><%--
  Created by IntelliJ IDEA.
  User: Бахтиёр Садуллоев
  Date: 23.04.2024
  Time: 13:06
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Employer</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<%
    String search = Objects.requireNonNullElse(request.getParameter("search"),"");
    int totalPageCount = UserRepo.totalPageCount(search);
    int p = Integer.parseInt(Objects.requireNonNullElse(request.getParameter("page"),"1"));
    List<User> allUsers = UserRepo.findAll(p,search);
%>
<nav class="navbar navbar-light bg-light justify-content-between">
    <form method="get">
        <input value="<%=search%>" name="search" class="form-control mr-sm-2" type="text" placeholder="Search" aria-label="Search">
        <button class="btn btn-outline-success my-2 my-sm-0">Search</button>
    </form>
    <a class="btn btn-primary" href="register.jsp">Register</a>
</nav>
<div class="row">
    <div class="col-12">
        <table class="table table-striped">
            <thead>
            <tr class="text-center">
                <th>User name</th>
                <th>Book</th>
                <th>Out</th>
                <th>In</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <% for (User user : allUsers) {%>
            <tr class="text-center">
                <td><%=user.getUserName()%></td>
                <td><%if (user.getStatus().equals("out")){%>
                        <button class="btn btn-outline-secondary btn-block">Book</button>
                    <%}else{%>
                        <a href="bookSetting.jsp?id=<%=user.getId()%>" class="btn btn btn-info btn-block">Book</a>
                   <%}%>
                </td>
                <td><%if (user.getBookId()==null && user.getStatus().equals("in")){%>
                    <form action="/user/out" method="post" >
                        <input name ="id" type="hidden" value="<%=user.getId()%>">
                        <button class="btn btn-warning btn-block">out</button>
                    </form>
                   <% } else{%>
                    <button class="btn btn-outline-warning btn-block">out</button>
                   <%}%>
                </td>
                <td><%if (user.getStatus().equals("out")){%>
                    <form action="/user/in" method="post" >
                        <input name ="id" type="hidden" value="<%=user.getId()%>">
                        <button class="btn btn-success btn-block">in</button>
                    </form>
               <%}else {%>
                    <button class="btn btn-outline-success btn-block">in</button>
               <%}%>
                </td>
                <td><%if (user.getStatus().equals("out")){%>
                    <form action="/user/delete" method="post">
                        <input name ="id" type="hidden" value="<%=user.getId()%>">
                        <button class="btn btn-danger btn-block text-white">delete</button>
                    </form>
                <%}else { %>
                    <button class="btn btn-outline-danger btn-block">delete</button>
                <%} %>
                </td>
            </tr>
            <%} %>
            </tbody>
        </table>
    </div>
</div>

<nav aria-label="Page navigation example">
    <ul class="pagination">
        <%if (p!=1){ %>
        <li class="page-item"><a class="page-link" href="?page=<%=p-1%>&search=<%=search%>">Previous</a></li>
        <%} %>

        <%for (int i = 1; i < totalPageCount; i++) {%>
            <li class="page-item <%= p==i? "active":"" %>"><a class="page-link" href="?page=<%=i%>&search=<%=search%>"><%=i%>
            </a></li>
        <%} %>

        <%if (p!=totalPageCount){%>
        <li class="page-item"><a class="page-link" href="?page=<%=p+1%>&search=<%=search%>">Next</a></li>
        <%} %>
    </ul>
</nav>
</body>
</html>
