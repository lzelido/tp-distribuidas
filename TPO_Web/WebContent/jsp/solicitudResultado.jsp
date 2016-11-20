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
	
	<title>Carga de Solicitud</title>

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
		<div class="col-md-2"><div class="col-md-12" onclick="window.location = '/TPO_Web/Botonera?funcionalidad=entregarCarga'">Entregar Carga Cliente</div></div>		

	</div>

	<div class="col-md-9 col-lg-9 col-md-offset-3 col-lg-offset-3">
		<form role="form" method="post" action="GenerarPedido">
			<fieldset class="col-md-8 col-lg-8">
					<div class="col-md-12 col-lg-12 form-group">
			        	<div class="col-md-5 col-lg-5">
				            <label>Fecha de Emisión</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
				            <input type="date" class="form-control" name="fechaEmision" autofocus required="required">
			        	</div>
		        	</div>   
		        	     	
		         	<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<label>Cliente</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
				            <select name="cliente" class="form-control" required="required">
				            	<c:forEach var="cliente" items="${clientes}">
								    <option value="${cliente.codigo}">${cliente.nombre} - ${cliente.tipoDoc}:${cliente.nroDoc}</option>
								</c:forEach>
					        </select>
				        </div>
		        	</div>
		        	<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<label>Fecha Máxima de Entrega</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
			        		<input type="date" class="form-control" name="fechaMaxEntrega" required="required">
				        </div>
		        	</div>
		        	<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<label>Fecha Estimada de Entrega</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
			        		<input type="date" class="form-control" name="fechaEstimadaEntrega" required="required">
				        </div>
		        	</div>
		        	<div class="col-md-12 col-lg-12 form-group">
			        	<div class="col-md-5 col-lg-5">
				            <label>Fecha de Retiro</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
			        		<input type="date" class="form-control" name="fechaRetiro" required="required">
			        	</div>
		        	</div>
			        <div class="col-md-12 col-lg-12 form-group">
			        	<div class="col-md-5 col-lg-5">
				            <label>Hora de Retiro Máxima</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
				            <input class="form-control" name="horaRetiroMax" type="time" min="1:00" max="18:00" step="900" autofocus required="required">
			        	</div>
			        </div>
			        <div class="col-md-12 col-lg-12 form-group">
			        	<div class="col-md-5 col-lg-5">
				            <label>Hora de Retiro Mínima</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
				            <input class="form-control" name="horaRetiroMin" type="time" min="9:00" max="17:00" step="900" autofocus required="required">
			        	</div>
			        </div>
			        <div class="col-md-12 col-lg-12 form-group">
			        	<div class="col-md-5 col-lg-5">
				            <label>Manifesto</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
				            <input class="form-control" placeholder="" name="manifesto" type="text" autofocus required="required">
			        	</div>
			        </div>
					<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<label>Cliente Habilitado Recepción</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
			        		<input class="form-control" name="clienteHabRecepcion" type="text">	            
				        </div>
		        	</div>
		        	<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<label>Cliente Habilitado Retiro</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
			        		<input class="form-control" name="clienteHabRetiro" type="text">
				        </div>
		        	</div>
		        	<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<label>Retiro a Domicilio?</label>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
				            <input type="checkbox" id="esRetiroDomicilio" name="esRetiroDomicilio" style=""/>
				        	<button id="botonDomicilioRetiro" type="button" class="btn btn-info" data-toggle="modal" data-target="#domicilioRetiroModal" style="margin-left:20px"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;Domicilio Retiro</button>
				        </div>
		        	</div>
		        	
		        	<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#domicilioEntregaModal"><span class="glyphicon glyphicon-home"></span>&nbsp;&nbsp;Domicilio Entrega</button>
			        	</div>
		        	</div>
		        	
		        	<div class="col-md-12 col-lg-12 form-group">
						<div class="col-md-5 col-lg-5">
				        	<button type="button" class="btn btn-info" data-toggle="modal" data-target="#agregarCargaModal"><span class="glyphicon glyphicon-plus-sign"></span>&nbsp;&nbsp;Agregar Carga</button>
			        	</div>
			        	<div class="col-md-7 col-lg-7">
				            <ul id="listaDeCargas" class="list-group">
							</ul>
				        </div>
		        	</div>
		        	<input type="hidden" id="domicilioEntrega" name="domicilioEntrega" value=""/>
		        	<input type="hidden" id="domicilioRetiro" name="domicilioRetiro" value=""/>
			</fieldset>
			<div style="margin-top:40px; margin-bottom:40px" class="col-md-4 col-lg-4 col-md-offset-3 col-lg-offset-3">
				<button type="submit" class="btn btn-success btn-lg">
					<span class="glyphicon glyphicon-thumbs-up"></span>
					Generar Solicitud
				</button>
			</div>			
		</form>
	</div>
	<div class="col-md-12 col-lg-12" style="background-color:#000; height:50px; box-shadow: -2px 3px 5px #888888; color:#fff; text-align:center">
		<label style="margin-top:10px">Aplicaciones Distribuidas 2015</label>
	</div>

	<div id="agregarCargaModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal">&times;</button>
				  	<h4 class="modal-title">Carga</h4>
				</div>
				<div class="modal-body">
				  	<fieldset>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					            <label>Descripción</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" id="descripcion" name="descripcion" type="text" autofocus>
				        	</div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
					        <div class="col-md-5 col-lg-5">
					        	<label>Tipo de Carga</label>
					        </div>
					        <div class="col-md-7 col-lg-7">
						        <select id="tipoCarga" name="tipoCarga" class="form-control">
						        	<c:forEach var="t" items="${tiposCargas}">
								   		 <option value="${t.codigo}">${t.descri}</option>
									</c:forEach>
						        </select>
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
					        <div class="col-md-5 col-lg-5">
					        	<label>Peso</label>
					        </div>
					        <div class="col-md-7 col-lg-7">
					            <input id="peso" class="form-control" placeholder="Kg" name="peso" type="number" required="required">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Coordenadas X</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input id="coordX" class="form-control" placeholder="" name="coordX" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
							<div class="col-md-5 col-lg-5">
					        	<label>Unidad Coordenadas X</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <select id="unidadCoordX" name="unidadCoordX" class="form-control">
							        <c:forEach var="unidad" items="${tipoUnidades}">
									    <option value="${unidad.codigo}">${unidad.tipo} - ${unidad.descri}</option>
									</c:forEach>
						        </select>
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Coordenadas Y</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input id="coordY" class="form-control" placeholder="" name="coordY" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Unidad Coordenadas Y</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <select id="unidadCoordY" name="unidadCoordY" class="form-control">
					            	 <c:forEach var="unidad" items="${tipoUnidades}">
									    <option value="${unidad.codigo}">${unidad.tipo} - ${unidad.descri}</option>
									</c:forEach>
						        </select>
					        </div>
					    </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Coordenadas Z</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input id="coordZ" class="form-control" placeholder="" name="coordZ" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Unidad Coordenadas Z</label>
				       		</div>
				       		<div class="col-md-7 col-lg-7">
					            <select id="unidadCoordZ" name="unidadCoordZ" class="form-control">
					            	 <c:forEach var="unidad" items="${tipoUnidades}">
									    <option value="${unidad.codigo}">${unidad.tipo} - ${unidad.descri}</option>
									</c:forEach>
						        </select>
					        </div>
					    </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Volumen</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input id="volumen" class="form-control" placeholder="m3" name="volumen" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Fragilidad</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
						        <select id="fragilidad" name="fragilidad" class="form-control">
						        	<c:forEach var="f" items="${categoriasFragilidad}">
									    <option value="${f}">${f}</option>
									</c:forEach>
						        </select>
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Tratamiento</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
						        <select id="tratamiento" name="tratamiento" class="form-control">
						        	<c:forEach var="f" items="${categoriasTratamiento}">
									    <option value="${f.codigo}">${f.descri}</option>
									</c:forEach>
						        </select>
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Es apilable?</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
				        		<div class="col-md-1 col-lg-1" style="padding:0px">
							        <input type="checkbox" id="apilable" name="apilable"/>
				        		</div>
						        <div class="col-md-11 col-lg-11" style="padding:0px">
						            <input id="cantApilable" class="form-control" placeholder="cantidad apilable" id="cantidadApilable" name="cantApilable" type="text">
						        </div>
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Es refrigerada?</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
						        <input id="refrigerada" type="checkbox" name="refrigerada"/>
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Condiciones Viaje</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input id="condicionesViaje" class="form-control" placeholder="" name="condicionesViaje" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Condiciones Manipulación</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input id="condicionesManipulacion" class="form-control" placeholder="" name="condicionesManipulacion" type="text">
					        </div>
				        </div>
				    </fieldset>
				</div>
				<div class="modal-footer">
				  	<button id="agregarCarga" type="button" class="btn btn-default" data-dismiss="modal">Aceptar</button>
				</div>
			</div>
		</div>
	</div>
	
	<div id="domicilioEntregaModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal">&times;</button>
				  	<h4 class="modal-title">Domicilio Entrega</h4>
				</div>
				<div class="modal-body">
				  	<fieldset>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					            <label>Calle</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="calle" type="text" autofocus>
				        	</div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
					        <div class="col-md-5 col-lg-5">
					        	<label>Número</label>
					        </div>
					        <div class="col-md-7 col-lg-7">
						        <input class="form-control" name="numero" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Piso</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
						    	<input class="form-control" name="piso" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
					        <div class="col-md-5 col-lg-5">
					        	<label>Departamento</label>
					        </div>
					        <div class="col-md-7 col-lg-7">
					            <input class="form-control" name="departamento" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Código Postal</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="codPostal" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
							<div class="col-md-5 col-lg-5">
					        	<label>Localidad</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					        	<input class="form-control" name="localidad" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Provincia</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="provincia" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Latitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					        	<input class="form-control" name="latitud" type="text">
					        </div>
					    </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Grados Latitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="gradosLat" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Minutos Latitud</label>
				       		</div>
				       		<div class="col-md-7 col-lg-7">
					        	<input class="form-control" name="minutosLat" type="text">
					        </div>
					    </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Segundos Latitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="segundosLat" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
						    	<input class="form-control" name="longitud" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Grados Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">	
				            	<input class="form-control" name="gradosLon" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Minutos Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="minutosLon" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Segundos Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="segundosLon" type="text">
					        </div>
				        </div>
				    </fieldset>
				</div>
				<div class="modal-footer">
				  	<button id="aplicarDomicilioEntrega" type="button" class="btn btn-default" data-dismiss="modal" >Aceptar</button>
				</div>
			</div>
		</div>
	</div>
	
	
	<div id="domicilioRetiroModal" class="modal fade" role="dialog">
		<div class="modal-dialog">
			<div class="modal-content">
				<div class="modal-header">
				 	<button type="button" class="close" data-dismiss="modal">&times;</button>
				  	<h4 class="modal-title">Domicilio Retiro</h4>
				</div>
				<div class="modal-body">
				  	<fieldset>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					            <label>Calle</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="calle" type="text" autofocus>
				        	</div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
					        <div class="col-md-5 col-lg-5">
					        	<label>Número</label>
					        </div>
					        <div class="col-md-7 col-lg-7">
						        <input class="form-control" name="numero" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Piso</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
						    	<input class="form-control" name="piso" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
					        <div class="col-md-5 col-lg-5">
					        	<label>Departamento</label>
					        </div>
					        <div class="col-md-7 col-lg-7">
					            <input class="form-control" name="departamento" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Código Postal</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="codPostal" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
							<div class="col-md-5 col-lg-5">
					        	<label>Localidad</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					        	<input class="form-control" name="localidad" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Provincia</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="provincia" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Latitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					        	<input class="form-control" name="latitud" type="text">
					        </div>
					    </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Grados Latitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="gradosLat" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Minutos Latitud</label>
				       		</div>
				       		<div class="col-md-7 col-lg-7">
					        	<input class="form-control" name="minutosLat" type="text">
					        </div>
					    </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Segundos Latitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="segundosLat" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
						    	<input class="form-control" name="longitud" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Grados Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">	
				            	<input class="form-control" name="gradosLon" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Minutos Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="minutosLon" type="text">
					        </div>
				        </div>
				        <div class="col-md-12 col-lg-12 form-group">
				        	<div class="col-md-5 col-lg-5">
					        	<label>Segundos Longitud</label>
				        	</div>
				        	<div class="col-md-7 col-lg-7">
					            <input class="form-control" name="segundosLon" type="text">
					        </div>
				        </div>
				    </fieldset>
				</div>
				<div class="modal-footer">
				  	<button id="aplicarDomicilioRetiro" type="button" class="btn btn-default" data-dismiss="modal" >Aceptar</button>
				</div>
			</div>
		</div>
	</div>
	<script>
		$.notify({
			message: "La solicitud se grabó correctamente"
		},{
			type: 'success'
		});
		function removerCarga(elemento){
			$(elemento).parent("li").remove();
		}

		$( document ).ready(function() {
			$("#aplicarDomicilioEntrega").click(function(){
				$("#domicilioEntrega").val($("#domicilioEntregaModal").find("select, textarea, input").serialize());
			});
			$("#aplicarDomicilioRetiro").click(function(){
				$("#domicilioRetiro").val($("#domicilioRetiroModal").find("select, textarea, input").serialize());
			});
			
			$("#esRetiroDomicilio").click(function(){
				if($(this).is(":checked")){
					$("#botonDomicilioRetiro").removeAttr("disabled");
				}else{
					$("#botonDomicilioRetiro").attr("disabled", "disabled");
				}
			}).click();
			
			$("#apilable").click(function(){
				if($(this).is(":checked")){
					$("#cantidadApilable").removeAttr("disabled");
				}else{
					$("#cantidadApilable").attr("disabled", "disabled").val("");
				}
			}).click();
			
			
			
			$("#agregarCarga").click(function(){		
				var contenido = $("#agregarCargaModal").find("select, textarea, input").serialize();
				var nuevaCarga = '<li class="list-group-item"><span class="badge">'+$("#agregarCargaModal").find("input[name=volumen]").val()+'&nbsp;m3</span><button class="btn btn-danger" onClick="removerCarga(this);"><i class="glyphicon glyphicon-trash"></i></button>&nbsp;&nbsp;'+$("#agregarCargaModal").find("input[name=descripcion]").val()+'<input type="hidden" name="cargas" value="'+contenido+'"/></li>'
				$("#listaDeCargas").append(nuevaCarga);
				$("#agregarCargaModal").find("input").val();
			});
		});
	</script>
</body>
</html>