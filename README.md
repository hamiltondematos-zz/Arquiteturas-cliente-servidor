(Abrir o projeto netbeans 7.4+. Essa versão já possui suporte para JEE7, glassfish4, jsf2.2, html5 etc)

Pessoal, esse projeto tem exemplos de alguns mecanismos que vimos em aula. Entre eles:

	Twitter bootstrap 
		Listas
		Paineis
		Css de botões e etc

	JSF/HTML5
		Convenção para incluir css e js
			<h:outputStylesheet name="css/bootstrap.css"/>
			Colocar os arquivos dentro da pasta resources

		Delegação para o browser de atributos HTML5
			Namespace xmlns:pt=http://xmlns.jcp.org/jsf/passthrough
			Dentro de inputs de texto por exemplo
				pt:placeholder="Insira o título"

		acionamento de métodos jsf a partir de html puro
			namespace xmlns:jsf=http://xmlns.jcp.org/jsf
			<button jsf:outcome="index"...

		Navegação implícita 
			Método que retorna String redireciona para página que tenha o nome igual ao valor do retorno

		Novo componente para envio de arquivos
			<h:inputFile...

	Amarração no managed bean através do objeto ‘Part’
		Método para realização de download de arrays de bytes

	EJB/JPA
		Classes de serviço/facade/repositório, entidades, unidade de persistência etc
