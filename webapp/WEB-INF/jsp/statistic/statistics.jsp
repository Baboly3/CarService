<%@include file="../includes/header.jsp"%>

<div class="container">
	<div id="container"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	<table id="datatable" class="color">
		<thead>
			<tr>
				<th></th>
				<th>Amount</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Total Services</th>
				<td>${totalServices}</td>

			</tr>
			<tr>
				<th>Total Customers</th>
				<td>${totalCustomers}</td>
			</tr>
			<tr>
				<th>Total Cars</th>
				<td>${totalCars}</td>
			</tr>
		</tbody>
	</table>
</div>

<%@include file="../includes/footer.jsp"%>