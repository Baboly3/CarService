<%@include file="../includes/header.jsp"%>

<div class="container">
	<div id="container1" 
		style="min-width: 310px; height: 400px; margin: 0 auto"></div>

	<table id="pieYearReportTable" class="color">
		<thead>
			<tr>
				<th></th>
				<th>January</th>
				<th>February</th>
				<th>March</th>
				<th>April</th>
				<th>May</th>
				<th>June</th>
				<th>July</th>
				<th>August</th>
				<th>September</th>
				<th>Oktober</th>
				<th>November</th>
				<th>December</th>
			</tr>
		</thead>
		<tbody>
			<tr>
				<th>Month</th>
				<td>${jan}</td>
				<td>${feb}</td>
				<td>${mar}</td>
				<td>${apr}</td>
				<td>${maj}</td>
				<td>${jun}</td>
				<td>${jul}</td>
				<td>${aug}</td>
				<td>${sep}</td>
				<td>${okt}</td>
				<td>${nov}</td>
				<td>${dec}</td>
			</tr>
		</tbody>
	</table>
</div>
	
<%@include file="../includes/footer.jsp"%>