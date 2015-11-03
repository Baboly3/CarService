<%@include file="../includes/header.jsp"%>
		

<div class="container">
	<div id="container1"
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	<table id="pieGendertable" class="color">
		<thead>
			<tr>
			    <th></th>
				<th>Male</th>
				<th>Female</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Amount</th>
				<td>${male}</td>
				<td>${female}</td>
			</tr>
		</tbody>
	</table>
</div>

		
<%@include file="../includes/footer.jsp"%>