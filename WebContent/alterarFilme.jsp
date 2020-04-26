<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Alteração de Filme</title>
</head>
<body>

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>

			<h1>Alteração de Filme</h1>

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Nome: " />
				<h:inputText value="#{filmeBacking.nome}" maxlength="50" size="60"
					readonly="true" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Genêro: " />
				<h:inputText value="#{filmeBacking.genero}" maxlength="50" size="59" readonly="true"  />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Valor: " />
				<h:inputText value="#{filmeBacking.valor}" maxlength="50" size="20"
					onkeyup="masc_moeda(this)" />
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Disponível: " />
				<h:selectOneRadio value="#{filmeBacking.disponivel}" >
					<f:selectItem itemValue="Sim" itemLabel="Sim" />
					<f:selectItem itemValue="Não" itemLabel="Não" />
				</h:selectOneRadio>
			</h:panelGrid>

			<h:panelGrid columns="2">
				<h:outputText value="Promoção: " />
				<h:selectOneRadio value="#{filmeBacking.promocao}">
					<f:selectItem itemValue="Sim" itemLabel="Sim" />
					<f:selectItem itemValue="Não" itemLabel="Não" />
				</h:selectOneRadio>
			</h:panelGrid>
			<h:panelGrid columns="2">
				<h:outputText value="Valor Promoção: " />
				<h:inputText value="#{filmeBacking.valorPromocao}" maxlength="50" size="20"
					onkeyup="masc_moeda(this)" />
			</h:panelGrid>

		
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton value="Alterar" action="#{filmeBacking.alterar}" />
					<h:commandButton value="Cancelar"
						action="#{filmeBacking.cancelar}" />
				</h:panelGrid>
			</h:panelGrid>

		</h:form>

	</f:view>

</body>
</html>