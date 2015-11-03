<%@include file="includes/header.jsp"%>

<div class="container black">
	<div class="panel panel-default" id="newCustomer">

		<div class="panel-heading">
			<h3 class="panel-title">
				<strong>Signup Customer</strong>
				<button type="button" class="close" data-target="#newCustomer"
					data-dismiss="alert">
					<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
				</button>
			</h3>
		</div>

		<div class="panel-body">

			<form:form modelAttribute="customerDTO" role="form" accept-charset="ISO-8859-1">
				<form:errors />
				<div class="row">
					<div class="col-md-6">
						<form:label path="firstName">First Name</form:label>
						<form:input path="firstName" class="form-control"
							placeholder="Enter your name" required="true"/>
						<form:errors cssClass="error" path="firstName" />
					</div>
					<div class="col-md-6">
						<form:label path="lastName">Last name</form:label>
						<form:input path="lastName" class="form-control"
							placeholder="Enter your lastname" required="true"/>
						<form:errors cssClass="error" path="lastName" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<div class="form-group">
							<form:label path="email">Email address</form:label>
							<form:input path="email" class="form-control"
								placeholder="Enter your email" required="true"/>
							<form:errors cssClass="error" path="email" />
						</div>
					</div>
					<div class="col-md-6">
						<form:label path="mobil">Mobil</form:label>
						<form:input path="mobil" class="form-control"
							placeholder="Enter your mobil" required="true"/>
						<form:errors cssClass="error" path="mobil" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-6">
						<form:label path="street">Street</form:label>
						<form:input path="street" class="form-control"
							placeholder="Enter your adress" required="true"/>
						<form:errors cssClass="error" path="street" />
					</div>
					<div class="col-md-6">
						<form:label path="phone">phone</form:label>
						<form:input type="number" path="phone" class="form-control"
							placeholder="Enter your phone" required="true"/>
						<form:errors cssClass="error" path="phone" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-4">
						<form:label path="zip">ZipCode</form:label>
						<form:input path="zip" class="form-control"
							placeholder="Enter your zipcode" required="true"/>
						<form:errors cssClass="error" path="zip" />
					</div>
					<div class="col-md-4">
						<form:label path="region">State</form:label>
						<form:input path="region" class="form-control"
							placeholder="Enter your state" required="true"/>
						<form:errors cssClass="error" path="region" />
					</div>
					<div class="col-md-4">
						<form:label path="city">City</form:label>
						<form:input type="city" path="city" class="form-control"
							placeholder="Enter city" required="true"/>
						<form:errors cssClass="error" path="city" />
					</div>
				</div>
				<div class="row">
					<div class="col-md-3"></div>
					<div class="col-md-2">
						<form:label path="insuranceCo">Insurance Co.</form:label>
						<form:select class="form-control selecta" path="insuranceCo">
							<option class="test" value="">Select option</option>
							<option class="test" value="Folksam">Folksam</option>
							<option class="test" value="Länsförsäkringar">Länsförsäkringar</option>
							<option class="test" value="Gjensidige">Gjensidige</option>
							<option class="test" value="Moderna">Moderna</option>
							<option class="test" value="Aktsam">Aktsam</option>
						</form:select>
						<form:errors cssClass="error" path="insuranceCo" />
					</div>
					<div class="col-md-2">
						<form:label path="ssn">Social security Number</form:label>
						<form:input path="ssn" class="form-control"
							data-mask="9999-99-99-9999" placeholder="YYYYMMDDLLLL" required="true"/>
						<form:errors cssClass="error" path="ssn" />
					</div>
					<div class="col-md-2 bbk">
						<form:label path="gender">Gender</form:label>
						<br>
						<div class="btn-group bbk" data-toggle="buttons">
							<form:label path="gender" class="btn btn-default">
								<form:radiobutton path="gender" value="male" />Male&nbsp;&nbsp;
							</form:label>
							<form:label path="gender" class="btn btn-default">
								<form:radiobutton path="gender" value="female" />Female
							</form:label>
							<form:errors cssClass="error" path="gender" />
						</div>
					</div>
				</div>
				<br>
				<div class="col-md-12">
					<button type="submit" id="submit" class="btn btn-success">Submit</button>
				</div>
			</form:form>
		</div>
	</div>
</div>




<%@include file="includes/footer.jsp"%>