<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Cadastro de Vendedor</title>
</head>
<body>

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
		
			<h1>Cadastro de Vendedor</h1>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Nome: " />
				<h:inputText value="#{vendedorBacking.nome}" maxlength="50" size="50" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Area Venda: " />
				<h:inputText value="#{vendedorBacking.areaVenda}" maxlength="50" size="44" />			
			</h:panelGrid>
			
			
			<h:panelGrid columns="2">
				<h:outputText value="Cidade: " />
				<h:inputText value="#{vendedorBacking.cidade}" maxlength="50" size="49" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Estado: " />
				<h:inputText value="#{vendedorBacking.estado}" maxlength="50" size="49" />			
			</h:panelGrid>
			
			
			
			<h:panelGrid columns="2">
				<h:outputText value="Sexo: " />
				<h:selectOneRadio value="#{vendedorBacking.sexo}">
					<f:selectItem itemValue="F" itemLabel="Feminino"/>
					<f:selectItem itemValue="M" itemLabel="Masculino"/>
				</h:selectOneRadio>		
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Idade: " />
				<h:inputText value="#{vendedorBacking.idade}" maxlength="3" size="50" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Sal�rio: " />
				<h:inputText value="#{vendedorBacking.salario}" maxlength="50"
					size="20" onkeyup="masc_moeda(this)" />
			</h:panelGrid>

		
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{vendedorBacking.salvar}"/>
					<h:commandButton value="Cancelar" action="#{vendedorBacking.cancelar}"/>
				</h:panelGrid>			
			</h:panelGrid>
			
		</h:form>
		
	</f:view>

</body>
</html>