<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="f" uri="http://java.sun.com/jsf/core"%>
<%@ taglib prefix="h" uri="http://java.sun.com/jsf/html"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<script type="text/javascript" src="js/mascara.js"></script>

<title>Cadastro de Cliente</title>
</head>
<body>

	<f:view>
		<jsp:include page="/menu.jsp"></jsp:include>
		<h:form>
		
			<h1>Cadastro de Cliente</h1>
			
			<h:panelGrid columns="1">
				<h:messages />
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Nome: " />
				<h:inputText value="#{clienteBacking.nome}" maxlength="50" size="50" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Logradouro: " />
				<h:inputText value="#{clienteBacking.logradouro}" maxlength="50" size="44" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Numero: " />
				<h:inputText value="#{clienteBacking.numeroLogradouro}" maxlength="50" size="48" 
								onkeyup="masc_numero(this)" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Bairro: " />
				<h:inputText value="#{clienteBacking.bairro}" maxlength="50" size="50" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Cidade: " />
				<h:inputText value="#{clienteBacking.cidade}" maxlength="50" size="49" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Estado: " />
				<h:inputText value="#{clienteBacking.estado}" maxlength="50" size="49" />			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Cep: " />
				<h:inputText value="#{clienteBacking.cep}" maxlength="50" size="52" onkeyup="masc_cep(this)"/>			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Telefone: " />
				<h:inputText value="#{clienteBacking.telefone}" maxlength="50" size="47" onkeyup="masc_telefone(this)"/>			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="CPF: " />
				<h:inputText value="#{clienteBacking.cpf}" maxlength="50" size="52" onkeyup="masc_cpf(this)"/>			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="RG: " />
				<h:inputText value="#{clienteBacking.rg}" maxlength="50" size="53" onkeyup="masc_rg(this)"/>			
			</h:panelGrid>
					
			<h:panelGrid columns="2">
				<h:outputText value="Sexo: " />
				<h:selectOneRadio value="#{clienteBacking.sexo}">
					<f:selectItem itemValue="F" itemLabel="Feminino"/>
					<f:selectItem itemValue="M" itemLabel="Masculino"/>
				</h:selectOneRadio>		
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Data de Nascimento: " />
				<h:inputText value="#{clienteBacking.dataNascimento}" maxlength="50" size="34" onkeyup="masc_nascimento(this)"/>			
			</h:panelGrid>
			
			<h:panelGrid columns="2">
				<h:outputText value="Idade: " />
				<h:inputText value="#{clienteBacking.idade}" maxlength="50" size="50" />			
			</h:panelGrid>
		
			<h:panelGrid>
				<h:panelGrid columns="2">
					<h:commandButton value="Salvar" action="#{clienteBacking.salvar}"/>
					<h:commandButton value="Cancelar" action="#{clienteBacking.cancelar}"/>
				</h:panelGrid>			
			</h:panelGrid>
			
		</h:form>
		
	</f:view>

</body>
</html>