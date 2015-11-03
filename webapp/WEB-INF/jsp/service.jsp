<%@include file="includes/header.jsp"%>



<div class="container blacktable">
	<table class="table table-hover table-bordered ">
		<thead>
			<tr>
				<th>Ordernr</th>
				<th>Plate&nbsp;number</th>
				<th>Service Date</th>
				<th>Mechanic</th>
				<th></th>
			</tr>
		</thead>
		<tbody data-link="row" class="rowlink">
			<c:forEach items="${services}" var="service">
				<tr>
					<td>${service.id}</td>
					<td class="rowlink"><a href="#detail${service.car.regnr}"
						data-toggle="modal">${service.car.regnr}</a></td>
					<td>${service.date}</td>
					<td>${service.mechanic.firstName}</td>
					<td style="text-align: center;" class="rowlink-skip cartbl">
						<button class="btn btn-success but" data-toggle="modal"
							data-target="#note${service.carID}">
							<i class="fa fa-book"></i>&nbsp;<span class="glyphicon glyphicon-wrench"></span>
						</button>
						<form:form modelAttribute="serviceDTO" role="form" 
							action="carServiceDetails" method="post">
							<form:input path="carID" class="form-control" type="hidden"
								value="${service.carID}" />
							<form:button type="submit" class="btn btn-success but">
								<i class="fa fa-history"></i>&nbsp;<i class="fa fa-car"></i>
							</form:button>
						</form:form>
						 
						<form:form modelAttribute="serviceDTO" role="form" name="delete"
							action="delService" method="post">
							<form:input path="id" class="form-control" type="hidden"
								value="${service.id}" />
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

<c:forEach items="${services}" var="service">
	<div class="modal fade" id="note${service.carID}" tabindex="-1"
		role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal">
						<span aria-hidden="true">&#120; </span><span class="sr-only">Close</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">Service note for car: 
						${service.car.regnr}</h4>
				</div>
				<form:form modelAttribute="serviceDTO" role="form"
					 accept-charset="ISO-8859-1">
					<form:errors />
					<div class="row">
						<div class="col-md-12">
							<div class="form-group">
								<form:label path="note">Service Note</form:label>
								<form:textarea path="note" type="text" class="form-control"
									placeholder="${service.note}" readonly="true"/>
								<form:errors cssClass="error" path="note" />
							</div>
						</div>
						</div>
					<center>
						<button class="btn btn-success sub" data-dismiss="modal">close</button>
					</center>
				</form:form>
			</div>
		</div>
	</div>
</c:forEach>


<%@include file="includes/footer.jsp"%>