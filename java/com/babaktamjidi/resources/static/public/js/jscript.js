$(function() {
	$("#datepicker").datepicker().datepicker("option", {
		changeMonth : true,
		changeYear : true,
		dateFormat : "yy-mm-dd",
		yearRange : "1940:2000"
	});
});


setTimeout(function() {
	$('.alert').fadeTo("slow", 0.1, function() {
		$('.alert').alert('close')
	});
}, 3000)


$(function() {
	$('#container').highcharts(
			{
				data : {
					table : 'datatable'
				},
				chart : {
					type : 'bar'
				},
				title : {
					text : 'Total by category'
				},
				yAxis : {
					allowDecimals : false,
					title : {
						text : 'Units'
					}
				},
				tooltip : {
					formatter : function() {
						return '<b>' + this.series.name + '</b><br/>'
								+ this.point.y + ' '
								+ this.point.name.toLowerCase();
					}
				}
			});
});


$(function() {
	$('#container3').highcharts(
			{
				data : {
					table : 'datatable'
				},
				chart : {
					type : 'bar'
				},
				title : {
					text : 'Services between dates'
				},
				yAxis : {
					allowDecimals : false,
					title : {
						text : 'Units'
					}
				},
				tooltip : {
					formatter : function() {
						return '<b>' + this.series.name + '</b><br/>'
								+ this.point.y + ' '
								+ this.point.name.toLowerCase();
					}
				}
			});
});

$(function() {
	$('#container1').highcharts(
			{
    data: {
        table: document.getElementById('pieGendertable'),
        switchRowsAndColumns: true, // use rows as points
        endRow:1 
    },
    chart: {
        type: 'pie'
    },
    title: {
        text: 'Services by gender'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            },
    yAxis: {
        allowDecimals: false,
        title: {
            text: 'Units'
        }
    },
    tooltip: {
        formatter: function() {
            return '<b>'+ this.series.name +'</b><br/>'+
                this.point.y +' '+ this.point.name.toLowerCase();
        }
    }
}
}
});
});

$(function() {
	$('#container2').highcharts(
			{
    data: {
        table: document.getElementById('pieBrandtable'),
        switchRowsAndColumns: true, // use rows as points
        endRow:5 
    },
    chart: {
        type: 'pie',
        
    },
    title: {
        text: 'Services By Brand'
    },
    
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            },
    yAxis: {
        allowDecimals: false,
        title: {
            text: 'Units'
        }
    },
    tooltip: {
        formatter: function() {
            return '<b>'+ this.series.name +'</b><br/>'+
                this.point.y +' '+ this.point.name.toLowerCase();
        }
    }
}
}
});
});

$(function() {
	$('#container1').highcharts(
			{
    data: {
        table: document.getElementById('pieYearReportTable'),
        switchRowsAndColumns: true, // use rows as points
        endRow:12 
    },
    chart: {
        type: 'column'
    },
    title: {
        text: 'Year Report'
    },
    plotOptions: {
        pie: {
            allowPointSelect: true,
            cursor: 'pointer',
            dataLabels: {
                enabled: true,
                format: '<b>{point.name}</b>: {point.percentage:.1f} %',
                style: {
                    color: (Highcharts.theme && Highcharts.theme.contrastTextColor) || 'black'
                }
            },
    yAxis: {
        allowDecimals: false,
        title: {
            text: 'Units'
        }
    },
    tooltip: {
        formatter: function() {
            return '<b>'+ this.series.name +'</b><br/>'+
                this.point.y +' '+ this.point.name.toLowerCase();
        }
    }
}
}
});
});


