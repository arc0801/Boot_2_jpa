<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:import url="../template/boot.jsp"></c:import>
</head>
<body>
<c:import url="../template/nav.jsp"></c:import>
	<div class="container">
		<a href="./${board}Write" class="btn btn-danger">Write</a>
	
		<h2>${board} List</h2>
		<table class="table table-hover">
			<tr>
				<td>NUM</td>
				<td>TITLE</td>
				<td>WRITER</td>
				<td>DATE</td>
				<td>HIT</td>
<!-- 				<td>File</td>			 -->
			</tr>
			
			<c:forEach items="${list}" var="vo">
				<tr>
					<td>${vo.num}</td>
					<td><a href="./${board}Select?num=${vo.num}">${vo.title}</a></td>
					<td>${vo.writer}</td>
					<td>${vo.regDate}</td>
					<td>${vo.hit}</td>
<!-- 					<td> -->
<%-- 						<c:forEach items="${vo.noticeFilesVOs}" var="f"> --%>
<%-- 							${f.fname} --%>
<%-- 						</c:forEach> --%>
<!-- 					</td> -->
				</tr>
			</c:forEach>
		</table>
	</div>

	<div class="container">
		<ul class="pagination">
			<c:if test="${pageNum+1 gt 1}">
				<li class="previous"><a href="./noticeList?page=${pageNum -1}&size=10&sort=num,desc">Previous</a></li>
			</c:if>
			
			<c:forEach begin="0" end="${pageSize-1}" var="i">
				<li><a href="./noticeList?page=${i}&size=10&sort=num,desc">${i+1}</a></li>
			</c:forEach>
			
			<c:if test="${pageNum+1 lt pageSize}">
				<li class="next"><a href="./noticeList?page=${pageNum +1}&size=10&sort=num,desc">Next</a></li>
			</c:if>
		</ul>
	</div>

	<div class="container">
		<select class="kind">
			<option value="t">Title</option>
			<option value="w">Writer</option>
			<option value="c">Contents</option>
		</select>
		<input type="text">
	</div>
	
</body>
</html>