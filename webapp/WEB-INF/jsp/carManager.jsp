<%@include file="includes/header.jsp"%>

<div class="container blacktable">
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>Plate&nbsp;number</th>
				<th>Brand</th>
				<th>Model</th>
				<th>Last&nbsp;update</th>
				<th>Registration date</th>
				<th></th>
			</tr>
		</thead>
		<tbody data-link="row" class="rowlink">
			<c:forEach items="${cars}" var="car">
				<tr>
					<td class="rowlink"><a href="#detail${car.regnr}"
						data-toggle="modal">${car.regnr}</a></td>
					<td>${car.brand}</td>
					<td>${car.model}</td>
					<td>${car.updatedate}</td>
					<td>${car.registrationDate}</td>
					<td style="text-align: center;" class="rowlink-skip cartbl">
						<button class="btn btn-success but" data-toggle="modal"
							data-target="#edit${car.regnr}">
							<i class="fa fa-pencil"></i>&nbsp;<i class="fa fa-car" ></i>
						</button> 
						<button class="btn btn-primary butblu" data-toggle="modal"
							data-target="#service${car.id}">
							<span class="glyphicon glyphicon-wrench"></span>&nbsp;<i class="fa fa-car"></i>
						</button> 
						<form:form modelAttribute="carDTO" role="form" name="delete"
							action="deleteCar" method="post">
							<form:input path="regnr" class="form-control" type="hidden"
								value="${car.regnr}" />
							<form:button type="submit" class="btn btn-danger butdel">
								<i class="fa fa-car"></i>&nbsp;<i class="fa fa-trash"></i>
							</form:button>
						</form:form>
					</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>


<c:forEach items="${cars}" var="car">
	<div class="modal fade" id="edit${car.regnr}" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&#120; </span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Edit Car for owner
						${car.customer.firstName} ${car.customer.lastName}</h4>
				</div>
				<form:form modelAttribute="carDTO" role="form" action="updateCar"
					method="post">
					<form:errors />
					<div class="row">
						<div class="col-md-4">
							<form:label path="mileage">Mileage</form:label>
							<form:input type="number" path="mileage" class="form-control"
								value="${car.mileage}" required="true"/>
						</div>
						<div class="col-md-6">
							<form:label path="fuelType">Fuel Type</form:label>
							<br>
							<div class="btn-group" data-toggle="buttons" required="true">
								<form:label path="fuelType" class="btn btn-default">
									<form:radiobutton path="fuelType" value="Gasolin" />Gasolin
							</form:label>
								<form:label path="fuelType" class="btn btn-default">
									<form:radiobutton path="fuelType" value="Diesel" />Diesel
							</form:label>
								<form:label path="fuelType" class="btn btn-default">
									<form:radiobutton path="fuelType" value="Electric" />Electric
							</form:label>
								<form:label path="fuelType" class="btn btn-default">
									<form:radiobutton path="fuelType" value="Flex" />Flex
							</form:label>
							</div>
						</div>
						<div class="col-md-2">
							<form:label path="color">Color</form:label>
							<form:input type="color" path="color" class="form-control"
								value="${car.color}" required="true"/>
						</div>
					</div>
					<div class="col-md-2">
						<form:label path="regnr"></form:label>
						<form:input path="regnr" class="form-control" value="${car.regnr}"
							type="hidden" />
					</div>
					<center>
						<button type="submit" class="btn btn-success sub">Submit</button>
					</center>
				</form:form>
			</div>
		</div>
	</div>
</c:forEach>


<c:forEach items="${cars}" var="car">
	<div class="modal fade" id="detail${car.regnr}" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&#120; </span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title">Details for plate number
						${car.regnr}</h4>
				</div>
				<form:form modelAttribute="carDTO" role="form">
					<form:errors />
					<div class="row">

						<div class="col-md-6">
							<form:label path="regnr">Owner</form:label>
							<form:input path="regnr" class="form-control"
								value="${car.customer.firstName} ${car.customer.lastName}"
								readonly="true" />
						</div>
						<div class="col-md-6">
							<form:label path="regnr">Plate nr.</form:label>
							<form:input path="regnr" class="form-control"
								value="${car.regnr}" readonly="true" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<form:label path="brand">Brand</form:label>
								<form:input path="brand" class="form-control"
									value="${car.brand}" readonly="true" />
							</div>
						</div>
						<div class="col-md-4">
							<form:label path="model">Model</form:label>
							<form:input path="model" class="form-control"
								value="${car.model}" readonly="true" />
						</div>
						<div class="col-md-4">
							<form:label path="generation">Generation</form:label>
							<form:input path="generation" class="form-control"
								value="${car.generation}" readonly="true" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<form:label path="mileage">Mileage</form:label>
							<form:input path="mileage" class="form-control"
								value="${car.mileage}" readonly="true" />
						</div>
						<div class="col-md-4">
							<form:label path="fuelType">Fuel type</form:label>
							<form:input path="fuelType" class="form-control"
								value="${car.fuelType}" readonly="true" />
						</div>

						<div class="col-md-4">
							<form:label path="color">Color</form:label>
							<form:input type="color" path="color" class="form-control"
								value="${car.color}" readonly="true" disabled="true" />
						</div>
					</div>
					<center>
						<button data-dismiss="modal" class="btn btn-success sub">Close</button>
					</center>
				</form:form>
			</div>
		</div>
	</div>
</c:forEach>

<c:forEach items="${cars}" var="car">
	<div class="modal fade" id="service${car.id}" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&#120; </span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add Service for
						plate number ${car.regnr}</h4>
				</div>
			<form:form modelAttribute="serviceDTO" role="form" name="addService"
					action="addService" method="post" accept-charset="ISO-8859-1"> 
					<form:errors />
					<div class="row">
						<div class="col-md-6">
							<form:label path="carRegNr">Car Plate Number</form:label>
							<form:input type="text" path="carRegNr" value="${car.regnr}" class="form-control" readonly="true"/>
							<form:errors cssClass="error" path="carRegNr"/>
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
							<form:textarea path="note" class="form-control" required="true"/>
							<form:errors cssClass="error" path="note" />
						</div>
					</div>
					<div class="row">	
					<div class="col-md-6">
						<button onclick="addService.action='addService'; return true;" type="submit" class="btn btn-success but">Submit</button>
					</div>
					</div>
				</form:form>
			</div>
		</div>
	</div>
</c:forEach>

<%@include file="includes/footer.jsp"%>