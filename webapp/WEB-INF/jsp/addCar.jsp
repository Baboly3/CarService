<%@include file="includes/header.jsp"%>


<div class="container black" id="myModal">
	<div class="panel panel-default" id="addCar">

		<div class="panel-heading">
			<h3 class="panel-title">
				<strong>Add car to customer</strong>
				<button type="button" class="close" data-target="#addCar"
					data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</h3>
		</div>

		<div class="panel-body">

			<form:form modelAttribute="carDTO" role="form" accept-charset="ISO-8859-1">
					<form:errors />
					<div class="row">
						<div class="col-md-6">
							<form:label path="ssn">Social security Number</form:label>
							<form:input path="ssn" class="form-control" data-mask="9999-99-99-9999" placeholder="YYYY-MM-DD-LLLL" />
							<form:errors cssClass="error" path="ssn" />
						</div>
						<div class="col-md-6">
							<form:label path="brand">Brand</form:label>
							<form:select class="form-control" path="brand">
								<form:option value="Volvo">Volvo</form:option>
								<form:option value="BMW">BMW</form:option>
								<form:option value="Audi">Audi</form:option>
								<form:option value="Mercedes">Mercedes</form:option>
								<form:option value="Volkswagen">Volkswagen</form:option>
							</form:select>
						</div>
						</div>
					<div class="row">
						<div class="col-md-6">
							<form:label path="model">Model</form:label>
							<form:input path="model" class="form-control" required="true"/>
							<form:errors cssClass="error" path="model" />
						</div>
						<div class="col-md-6">
							<form:label path="generation">Generation</form:label>
							<form:input path="generation" type="date" class="form-control" required="true" />
							<form:errors cssClass="error" path="generation" />
						</div>
						</div>
						<div class="row">
						<div class="col-md-6">
							<form:label path="mileage">Mileage</form:label>
							<form:input path="mileage" type="number" class="form-control" required="true"/>
							<form:errors cssClass="error" path="mileage" />
						</div>
						<div class="col-md-6">
							<form:label path="engine">Engine</form:label>
							<form:input path="engine" class="form-control" required="true"/>
							<form:errors cssClass="error" path="engine" />
						</div>
						</div>
					<div class="row">	
						<div class="col-md-4">
							<form:label path="regnr">regnr</form:label>
							<form:input path="regnr" class="form-control" data-mask="aaa999" placeholder="AAA111" required="true"/>
							<form:errors cssClass="error" path="regnr" />
						</div>
						<div class="col-md-4 sub">
							<form:label path="color">color</form:label>
							<form:input path="color" type="color" class="form-control" required="true"/>
							<form:errors cssClass="error" path="color" />
						</div>			
						<div class="col-md-4">
							<form:label path="fuelType">Fuel Type</form:label>
							<br>
							<div class="btn-group bbk" data-toggle="buttons">
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
					</div>
					<div class="col-md-12">
						<button type="submit" class="btn btn-success">Submit</button>
					</div>
				</form:form>
		</div>
	</div>
</div>



<%@include file="includes/footer.jsp"%>