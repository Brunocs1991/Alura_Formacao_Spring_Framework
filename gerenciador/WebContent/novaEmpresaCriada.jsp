<%
	//scriplet
    String nomeEmpresa = (String)request.getAttribute("nomeEmpresa");
    System.out.println(nomeEmpresa);
%>

<html><body>
Empresa <%= (nomeEmpresa) %>  cadastrada com sucesso!
</body></html>