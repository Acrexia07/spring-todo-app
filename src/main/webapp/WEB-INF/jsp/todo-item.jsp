<%@ include file="common/header.jspf" %>
<%@ include file="common/navigation.jspf" %>

<div class="container">
	<section>
		<h1>Task Details</h1>
		<form:form method="post" modelAttribute="todo">

			<fieldset class="mb-3">
				<form:label path="description">Task Description</form:label>
				<form:input type="text" path="description" required="required"/>
				<form:errors path="description" cssClass="text-warning"/>
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Target Date</form:label>
				<form:input type="text" path="targetDate" required="required"/>
				<form:errors path="targetDate" cssClass="text-warning"/>
			</fieldset>

			<fieldset class="mb-3">
				<form:label path="targetDate">Task Status</form:label>
				<form:input type="text" path="taskStatus" required="required"/>
				<form:errors path="taskStatus" cssClass="text-warning"/>
			</fieldset>

			<form:input type="hidden" path="id" required="required"/>

			<input type="submit" class="btn btn-success">
		</form:form>
	</section>
</div>

<%@ include file="common/footer.jspf" %>

<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>
<script type="text/javascript">
	$('#targetDate').datepicker({
	   	format: 'yyyy-mm-dd',
	});
</script>



