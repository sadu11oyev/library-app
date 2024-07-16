<%@ page import="org.example.last_lesson_library.entity.User" %>
<%@ page import="org.example.last_lesson_library.repo.UserRepo" %>
<%@ page import="org.example.last_lesson_library.entity.Book" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Бахтиёр Садуллоев
  Date: 23.04.2024
  Time: 16:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Select Book</title>
    <link rel="stylesheet" href="../static/bootstrap.min.css">
</head>
<body>
<%
    Integer id = Integer.parseInt(request.getParameter("id"));
    User user = UserRepo.findAllById(id);
%>
<div class="container">
    <div class="row justify-content-center mt-5">
        <div class="col-md-6">
            <div class="card">
                <div class="card-header">
                    <h3 class="text-center"><%=user.getUserName()%></h3>
                </div>
                <div class="card-body">
                    <%if (user.getBookId()!=null){
                        Book book = UserRepo.findBookById(user.getBookId()); %>
                        <form method="post" action="/book/return">
                            <h5><%=book.getName()%></h5>
                            <input name ="id" type="hidden" value="<%=user.getId()%>">
                            <button class="btn btn-outline-danger btn-block">Return book</button>
                        </form>
                   <% }else{ %>
                    <form method="post" action="/book/add">
                        <div class="mb-3">
                            <label for="exampleInputEmail3">Choose book</label>
                            <select class="form-control" name="bookId" id="exampleInputEmail3">
                                <%for (Book book : UserRepo.findAllBooks()) {
                                %>
                                <option value="<%=book.getId()%>"> <%=book.getName()%></option>
                                <%}%>
                            </select>
                        </div>
                        <input name ="id" type="hidden" value="<%=user.getId()%>">
                        <button class="btn btn-primary btn-block">Save</button>
                    </form>
                   <% } %>
                </div>
            </div>
        </div>
    </div>
</div>


</body>
</html>
