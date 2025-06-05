<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<section>
		<h1>Your Tasks:</h1>
		<table class="table">
			<thead>
				<tr>
					<th>Description</th>
					<th>Target Date</th>
					<th>Status</th>
					<th></th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${todos}" var="todo">
					<tr>
						<td>${todo.description}</td>
						<td>${todo.targetDate}</td>
						<td>${todo.taskStatus}</td>
						<td> <a href="update-task?id=${todo.id}" class="btn btn-success"> Update </a></td>
						<td> <a href="delete-task?id=${todo.id}" class="btn btn-warning"> Delete </a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<a href="add-new-task" class="btn btn-success">Add new task</a>
	</section>
</div>

<%@ include file="common/footer.jspf" %>