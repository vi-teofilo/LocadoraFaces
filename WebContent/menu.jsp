<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Locadora</title>
</head>
<body>
	<div>
	
		<f:subview id="view">
			
			<h:form id="menu">
			
				<rich:toolBar>
					
					<rich:dropDownMenu value="Cadastro">
					
						<rich:menuItem id="menu1" value="Filme" action="#{filmeBacking.cadastraFilme}">
						</rich:menuItem>
					
						<rich:menuItem id="menu2" value="Cliente" action="#{clienteBacking.cadastraCliente}">
						</rich:menuItem>
						
						<rich:menuItem id="menu3" value="Vendedor" action="#{vendedorBacking.cadastraVendedor}">
						</rich:menuItem>
						
					</rich:dropDownMenu>
					
					<rich:dropDownMenu value="Consulta">
					
						<rich:menuItem id="menu4" value="Filme" action="#{filmeBacking.consultaFilme}">
						</rich:menuItem>
					
						<rich:menuItem id="menu5" value="Cliente" action="#{clienteBacking.consultaCliente}">
						</rich:menuItem>
						
						<rich:menuItem id="menu6" value="Vendedor" action="#{vendedorBacking.consultaVendedor}">
						</rich:menuItem>
						
					</rich:dropDownMenu>
				
				</rich:toolBar>
			
			</h:form>
	
		</f:subview>
	
	
	
	</div>
</body>
</html>