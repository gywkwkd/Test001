<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ include file="/common/header.jsp"%>

<section>
	<h2>회원목록조회/수정</h2>

	<table border=1>
		<tr>
		
			<th>회원아이디</th>
		
			
			<th>이름</th>
		
		
		</tr>
		<c:forEach items="${list }" var="member">
		<tr>
			
			<td>${member.member_id}</td>
			
			
			<td>${member.member_name }</td>
			
			
		</tr>
		</c:forEach>
	</table>

</section>

<script>
	
</script>
<%@ include file="/common/footer.jsp"%>