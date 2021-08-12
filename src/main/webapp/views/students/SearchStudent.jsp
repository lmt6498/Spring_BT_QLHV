<%@ page contentType="text/html;charset=UTF-8" language="java"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search Student</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">


    <h2>Tim kiem hoc vien</h2>

    <form method="post" action="/find">
        <input placeholder="Nhập tên cần tìm" name="findName">
        <button type="submit" class="btn btn-success">Find</button>
    </form>
    <a href="/show" class="btn btn-success">Back home</a>
    <a href="/create" class="btn btn-success">Create</a>
    <br>
    <br>
    <table class="table">
        <thead>
        <tr>
            <th>id</th>
            <th>Name</th>
            <th>Date of Birth</th>
            <th>Address</th>
            <th>Phone</th>
            <th>Email</th>
            <th>Class</th>
            <th colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${list}" var="person" varStatus="loop">
            <tr>
                <td>${person.id}</td>
                <td>${person.name}</td>
                <td>${person.date}</td>
                <td>${person.address}</td>
                <td>${person.phone}</td>
                <td>${person.email}</td>
                <td>${person.name_dp}</td>
                <td><a href="/edit?index=${loop.index}" class="btn btn-warning">Edit</a></td>
                <td><a onclick=" return confirm('Bạn có muốn xóa???')" href="/delete?index=${loop.index}" class="btn btn-danger">Delete</a></td>
            </tr>
        </c:forEach>

        </tbody>
    </table>
</div>

</body>
</html>
