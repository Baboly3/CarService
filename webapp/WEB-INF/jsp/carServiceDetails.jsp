<%@include file="includes/header.jsp"%>

<div class="container blacktable">
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>Order nr</th>
				<th>Car</th>
				<th>Service Dates</th>
				<th>Mechanic</th>
			</tr>
		</thead>
		<tbody data-link="row" class="rowlink">
			<c:forEach items="${carServices}" var="carService">
				<tr>
					<td class="rowlink"><a href="#detail${carService.id}"
						data-toggle="modal"></a>${carService.id}</td>
					<td><c:out value="${carService.car.regnr}" /></td>
					<td><c:out value="${carService.date}" /></td>
					<td><c:out value="${carService.mechanic.firstName}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<%@include file="includes/footer.jsp"%>