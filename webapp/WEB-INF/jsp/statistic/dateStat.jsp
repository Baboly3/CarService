<%@include file="../includes/header.jsp"%>

<div class="container">
	<div id="container3"
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
				<th>Services</th>
				<td>${dateCount}</td>
			</tr>
		</tbody>
	</table>
	<form:form modelAttribute="serviceDTO" role="form" 
					action="dateStat" method="post" accept-charset="ISO-8859-1">
					<form:errors />
					<div class="container black">
						<div class="row">
						<div class="col-md-6">
							<form:label path="date">From Date</form:label>
							<form:input type="date" path="date" class="form-control" required = "true"/>
							<form:errors cssClass="error" path="date" />
						</div>
						<div class="col-md-6">
							<form:label path="date1">To Date</form:label>
							<form:input type="date" path="date1" class="form-control" required = "true"/>
							<form:errors cssClass="error" path="date1" />
						</div>
						<div class="row">
						<div class="col-md-12"></div>
						</div>
						<div class="row">
						<div class="col-md-12"></div>
						</div>
						<div class="row">
					<div class="col-md-4"></div>	
					<div class="col-md-4">
						<button type="submit" class="btn btn-success but">Submit</button>
					</div>
					</div>
					</div>
					</div>
				</form:form>
</div>







<%@include file="../includes/footer.jsp"%>