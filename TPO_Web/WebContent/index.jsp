<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
	<link rel="stylesheet" href="css/bootstrap.min.css">
	<link rel="stylesheet" href="css/bootstrap-theme.min.css">
	<script src="js/jquery.min.js"></script>
	<script src="js/bootstrap.min.js"></script>
	<script src="js/bootstrap-notify.min.js"></script>
	
	<title>Bienvenido</title>

	<style>     
	    h1 {
	        font-size: 48px;
	        font-family: 'Lobster', helvetica, arial;
	        margin-top:60px;
	    }
	     
	    h1 a {
	        text-decoration: none;
	        color: #666;
	        -webkit-mask-image: -webkit-gradient(linear, left top, left bottom, from(rgba(0,0,0,1)), color-stop(50%, rgba(0,0,0,.5)), to(rgba(0,0,0,1)));
	    }
	     
	    h1:after {
	        content : 'Der große Verteiler';
	        color: #d6d6d6;
	        text-shadow: 0 1px 0 white;
	    }
     	
     	body{
     		background-color: #fcfcf9;
     	}
     	
     	fieldset{
     		border: 1px solid #eeeeee;
     		padding-top: 15px;
     	}
     	
     	fieldset > div{
     		padding-left: 5px;
     		padding-right: 5px;
     		border-bottom: 1px solid #eeeeee;
     		padding-bottom: 7px;
     	}
     	
     	.funcionalidades > div > div{
     		margin-top: 15px;
     		font-size: 15px;
     		color: #fff;
     		padding-top:0px;
     		padding-bottom:0px;
     		text-align:center;
     		border-radius: 25px;
   	 		border: 2px solid #224a69;
   	 		margin-left:0px;
   	 		padding:0px;
     	}
     	
     	.funcionalidades > div:hover > div{
     		border: 2px solid #7CAE08;	
     		cursor:pointer;
     	}
    </style>
</head>

<body>
	<div style="width:100%; background-color:#224a69; height:200px; box-shadow: -2px 3px 5px #224a69; position:relative">
		<div class="col-md-offset-4 col-lg-offset-4 col-md-5 col-lg-5">
			<h1 style=""><a></a></h1>
		</div>
	</div>
	<div class="funcionalidades" style="width:100%; background-color:#000; height:50px; box-shadow: -2px 3px 5px #888888;margin-bottom:50px">
		<div class="col-md-2 col-md-offset-3 col-lg-offset-3"><div class="col-md-12" onclick="window.location = '/TPO_Web/Botonera?funcionalidad=recepcionPedido'">Recepción Pedido</div></div>
		<div class="col-md-2"><div class="col-md-12" onclick="window.location = '/TPO_Web/Botonera?funcionalidad=pagar'">Pagar Factura</div></div>
		<div class="col-md-2"><div class="col-md-12" onclick="window.location = '/TPO_Web/Botonera?funcionalidad=viajesPendientes'">Viajes Pendientes</div></div>
	</div>
	<div class="col-md-7 col-md-offset-4">
		<img alt="" src="jsp/c.png">
	</div>
	<div class="col-md-12 col-lg-12" style="background-color:#000; height:50px; box-shadow: -2px 3px 5px #888888; color:#fff; text-align:center">
		<label style="margin-top:10px">Aplicaciones Distribuidas 2015</label>
	</div>
</body>
</html>