<%@include file="includes/header.jsp"%>

<div class="container blacktable">
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>Social&nbsp;Security&nbsp;Number&nbsp;</th>
				<th>First&nbsp;Name</th>
				<th>Last&nbsp;Name</th>
				<th>Mobil</th>
				<th>Email</th>
				<th>Reg&nbsp;Date&nbsp;&nbsp;&nbsp;</th>
				<th>Last&nbsp;update</th>
				<th></th>
			</tr>
		</thead>
		<tbody data-link="row" class="rowlink">
			<c:forEach items="${customers}" var="customer">
				<tr>
					<td class="rowlink"><a href="#detail${customer.id}"
						data-toggle="modal"></a>${customer.ssn}</td>
					<td><c:out value="${customer.firstName}" /></td>
					<td><c:out value="${customer.lastName}" /></td>
					<td><c:out value="${customer.mobil}" /></td>
					<td><c:out value="${customer.email}" /></td>
					<td><c:out value="${customer.registrationDate}" /></td>
					<td><c:out value="${customer.updatedate}" /></td>
					<td style="text-align: center;" class="rowlink-skip">
						<button class="btn btn-success but" data-toggle="modal"
							data-target="#edit${customer.id}"><i class="fa fa-pencil">&nbsp;<i class="fa fa-user"></i></i>&nbsp;</button>
						<button class="btn btn-success but" data-toggle="modal"
							data-target="#car${customer.id}"><i class="fa fa-car"></i>&nbsp;<i class="fa fa-plus"></i>
						</button>
						<form:form modelAttribute="customerDTO" role="form" name="delete"
							action="delCustomer" method="post">
							<form:input path="id" class="form-control" type="hidden"
								value="${customer.id}" />
							<form:button type="submit" class="btn btn-danger butdel">
								<i class="fa fa-user"></i>&nbsp;<i class="fa fa-trash"></i>
						</form:button>
						</form:form>		
					</td>	
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<c:forEach items="${customers}" var="customer">
	<div class="modal fade" id="edit${customer.id}" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&#120; </span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Edit
						${customer.firstName} ${customer.lastName}</h4>
				</div>
				<form:form modelAttribute="customerDTO" role="form"
					action="updateCustomer" accept-charset="ISO-8859-1">
					<form:errors />
					<div class="row">
						<div class="col-md-6">
							<div class="form-group">
								<form:label path="email">Email address</form:label>
								<form:input path="email" class="form-control"
									value="${customer.email}" required="true"/>
								<form:errors cssClass="error" path="email" />
							</div>
						</div>
						<div class="col-md-6">
							<form:label path="mobil">Mobil</form:label>
							<form:input path="mobil" class="form-control"
								value="${customer.mobil}" required="true"/>
							<form:errors cssClass="error" path="mobil" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<form:label path="street">Street</form:label>
							<form:input path="street" class="form-control"
								value="${customer.adress.street}" required="true"/>
							<form:errors cssClass="error" path="street" />
						</div>
						<div class="col-md-6">
							<form:label path="phone">phone</form:label>
							<form:input type="number" path="phone" class="form-control"
								value="${customer.phone}" required="true"/>
							<form:errors cssClass="error" path="phone" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<form:label path="city">City</form:label>
							<form:input type="text" path="city" class="form-control"
								value="${customer.adress.city}" required="true"/>
							<form:errors cssClass="error" path="city" />
						</div>

						<div class="col-md-6">
							<form:label path="region">Region</form:label>
							<form:input path="region" class="form-control"
								value="${customer.adress.region}" required="true"/>
							<form:errors cssClass="error" path="region" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-3"></div>
						<div class="col-md-3">
							<form:label path="zip">ZipCode</form:label>
							<form:input path="zip" class="form-control"
								value="${customer.adress.zip}" required="true"/>
							<form:errors cssClass="error" path="zip" />
						</div>
						<div class="col-md-3">
							<form:label path="insuranceCo">Insurance Co.</form:label>
							<form:select class="form-control" path="insuranceCo">
								<form:option value="Folksam">Folksam</form:option>
								<form:option value="Länsförsäkringar">Länsförsäkringar</form:option>
								<form:option value="Gjensidige">Gjensidige</form:option>
								<form:option value="Moderna">Moderna</form:option>
								<form:option value="Aktsam">Aktsam</form:option>
							</form:select>
						</div>
					</div>
					<div class="row">
						<div class="col-md-12">
							<div class="col-md-4">
								<form:label path="ssn"></form:label>
								<form:input path="ssn" class="form-control" type="hidden"
									value="${customer.ssn}"/>
							</div>
						</div>
					</div>
					<center>
						<button type="submit" class="btn btn-success sub">Submit</button>
					</center>
				</form:form>
			</div>
		</div>
	</div>
</c:forEach>

<c:forEach items="${customers}" var="customer">
	<div class="modal fade" id="car${customer.id}" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&#120; </span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Add car to
						${customer.firstName} ${customer.lastName}</h4>
				</div>
				<form:form modelAttribute="carDTO" role="form" 
					action="addCar" method="post" name="addCar"
					accept-charset="ISO-8859-1">
					<form:errors />
					<div class="row">
						<div class="col-md-6">
							<form:label path="brand">Brand</form:label>
							<form:select class="form-control" path="brand" required="true">
								<form:option value="Volvo">Volvo</form:option>
								<form:option value="BMW">BMW</form:option>
								<form:option value="Audi">Audi</form:option>
								<form:option value="Mercedes">Mercedes</form:option>
								<form:option value="Volkswagen">Volkswagen</form:option>
							</form:select>
						</div>
						<div class="col-md-6">
							<form:label path="model">Model</form:label>
							<form:input path="model" class="form-control" required="true"/>
							<form:errors cssClass="error" path="model" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-6">
							<form:label path="generation">Generation</form:label>
							<form:input path="generation" type="date" class="form-control" required="true"/>
							<form:errors cssClass="error" path="generation" />
						</div>
						<div class="col-md-6">
							<form:label path="mileage">Mileage</form:label>
							<form:input path="mileage" type="number" class="form-control" required="true"/>
							<form:errors cssClass="error" path="mileage" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<form:label path="engine">Engine</form:label>
							<form:input path="engine" class="form-control" required="true"/>
							<form:errors cssClass="error" path="engine" />
						</div>
						<div class="col-md-4">
							<form:label path="regnr">Plate number</form:label>
							<form:input path="regnr" class="form-control" data-mask="aaa999" 
								placeholder="AAA111" required="true"/>
							<form:errors cssClass="error" path="regnr" />
						</div>
						<div class="col-md-4">
							<form:label path="color">color</form:label>
							<form:input path="color" type="color" class="form-control" required="true"/>
							<form:errors cssClass="error" path="color" />
						</div>
					</div>
					<div class="row">
						<div class="col-md-12 bbk">
							<form:label path="fuelType" required="true">Fuel Type</form:label>
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
						<div class="col-md-4">
							<form:label path="ssn"></form:label>
							<form:input path="ssn" class="form-control" type="hidden"
								value="${customer.ssn}" />
						</div>
					</div>
					<center>
						<button type="submit" onclick="addCar.action='addCar'; return true;"
							class="btn btn-success sub">Submit</button>
					</center>
				</form:form>
			</div>
		</div>
	</div>
</c:forEach>

<c:forEach items="${customers}" var="customer">
	<div class="modal fade" id="detail${customer.id}" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&#120; </span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Customer details for
						${customer.firstName} ${customer.lastName}</h4>
				</div>
				<form:form role="form" modelAttribute="customerDTO" action="updateCustomer" accept-charset="ISO-8859-1">
					<div class="row">
					<div class="col-md-4"></div>
							<div class="col-md-4">
								<form:label path="ssn">Social Security Number</form:label>
								<form:input path="ssn" class="form-control" 
									value="${customer.ssn}" readonly="true"/>
							</div>
						</div>
					<div class="row">
						<div class="col-md-4">
							<div class="form-group">
								<form:label path="email">Email address</form:label>
								<form:input path="email" class="form-control" value="${customer.email}" readonly="true" />
							</div>
						</div>
						<div class="col-md-4">
							<form:label path="mobil">Mobil</form:label>
							<form:input path="mobil" class="form-control"
								value="${customer.mobil}" readonly="true" />
						</div>
						<div class="col-md-4">
							<form:label path="street">Street</form:label>
							<form:input path="street" class="form-control"
								value="${customer.adress.street}" readonly="true" />
						</div>
						</div>
					<div class="row">	
						<div class="col-md-4">
							<form:label path="phone">phone</form:label>
							<form:input type="number" path="phone" class="form-control"
								value="${customer.phone}" readonly="true"/>
						</div>
						<div class="col-md-4">
							<form:label path="city">City</form:label>
							<form:input type="text" path="city" class="form-control"
								value="${customer.adress.city}" readonly="true"/>
						</div>

						<div class="col-md-4">
							<form:label path="region">Region</form:label>
							<form:input path="region" class="form-control"
								value="${customer.adress.region}" readonly="true"/>
						</div>
					</div>
					<div class="row">
						<div class="col-md-4">
							<form:label path="zip">ZipCode</form:label>
							<form:input path="zip" class="form-control"
								value="${customer.adress.zip}" readonly="true"/>
							 
						</div>
						<div class="col-md-4">
							<form:label path="gender">Gender</form:label>
							<form:input path="gender" class="form-control"
								value="${customer.gender}" readonly="true"/>
						</div>
						<div class="col-md-4">
							<form:label path="gender">Gender</form:label>
							<form:input path="gender" class="form-control"
								value="${customer.insuranceCo}" readonly="true"/>
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

<%@include file="includes/footer.jsp"%>