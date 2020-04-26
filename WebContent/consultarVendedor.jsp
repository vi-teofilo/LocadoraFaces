<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<%@taglib prefix="rich" uri="http://richfaces.org/rich"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Consulta de Vendedor</title>
</head>
<body>


	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>

		<h:form>

			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>

			<h:panelGrid columns="3">
				<h:outputText value="Nome: " />
				<h:inputText value="#{vendedorBacking.nome}" maxlength="50" size="40" />
				<h:commandButton value="Pesquisar Vendedor"
					action="#{vendedorBacking.pesquisar}" />
			</h:panelGrid>

			<h:panelGrid columns="1" width="700">
				<rich:dataTable id="listaCliente" width="100%"
					value="#{vendedorBacking.listaVendedor}" var="vendedor">

					<f:facet name="caption">
						<h:outputText value="Lista de Vendedores" />
					</f:facet>

					<f:facet name="header">
						<rich:columnGroup>
							<rich:column>
								<h:outputText value="Nome" />
							</rich:column>
							<rich:column>
								<h:outputText value="Area Venda" />
							</rich:column>
							<rich:column>
								<h:outputText value="Salário" />
							</rich:column>
							<rich:column colspan="2">
								<h:outputText value="Ações" />
							</rich:column>
						</rich:columnGroup>
					</f:facet>

					<rich:column>
						<h:outputText value="#{vendedor.nome}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{vendedor.areaVenda}" />
					</rich:column>
					<rich:column>
						<h:outputText value="#{vendedor.salario}" />
					</rich:column>
					<rich:column>
						<h:commandLink value="Alterar"
								action="#{vendedorBacking.alterarVendedor}">
								<f:setPropertyActionListener value="#{vendedor}"
									target="#{vendedorBacking.vendedorSelecionado}" />
							</h:commandLink>
					</rich:column>
					<rich:column>
						<h:commandLink value="Excluir" action="#{vendedorBacking.excluir}">
							<f:setPropertyActionListener value="#{vendedor}"
								target="#{vendedorBacking.vendedorSelecionado}" />
						</h:commandLink>
					</rich:column>
				</rich:dataTable>
			</h:panelGrid>


			<h:panelGrid>
				<h:panelGrid columns="1">
					<h:commandButton value="Cancelar"
						action="#{vendedorBacking.cancelar}" />
				</h:panelGrid>
			</h:panelGrid>




		</h:form>
	</f:view>

</body>
</html>