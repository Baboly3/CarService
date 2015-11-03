<%@include file="includes/header.jsp"%>

<div class="container black" id="myModal">
	<div class="panel panel-default" id="addService">

		<div class="panel-heading">
			<h3 class="panel-title">
				<strong>Add Service</strong>
				<button type="button" class="close" data-target="#addService"
					data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</h3>
		</div>

		<div class="panel-body">

			<form:form modelAttribute="serviceDTO" role="form" 
					action="addService" method="post" accept-charset="ISO-8859-1">
					<form:errors />
					<div class="row">
						<div class="col-md-6">
							<form:label path="carRegNr">Car Plate Number</form:label>
							<form:input type="text" path="carRegNr" class="form-control" data-mask="aaa999" placeholder="ABC123" required="true"/>
							<form:errors cssClass="error" path="carRegNr" />
						</div>
						</div>
						<div class="row">
						<div class="col-md-6">
							<form:label path="date">Service Date</form:label>
							<form:input type="date" path="date" class="form-control" required="true"/>
							<form:errors cssClass="error" path="date" />
						</div>
						<div class="col-md-6">
							<form:label path="note">Note</form:label>
							<form:textarea path="note" class="form-control" />
							<form:errors cssClass="error" path="note" />
						</div>
					</div>
					<div class="row">	
					<div class="col-md-6">
						<button type="submit" class="btn btn-success but">Submit</button>
					</div>
					</div>
				</form:form>
		</div>
	</div>
</div>
			
<%@include file="includes/footer.jsp"%>