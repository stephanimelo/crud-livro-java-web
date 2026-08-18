<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<body>
<h2>Livros</h2>
<a href="livro?acao=novo">Novo Livro</a>
<table border="1">
<tr><th>Código</th><th>Título</th><th>Idioma</th><th>Ano</th><th>Ações</th></tr>
<c:forEach var="l" items="${lista}">
<tr>
<td>${l.codigo}</td><td>${l.titulo}</td><td>${l.idioma}</td><td>${l.ano}</td>
<td>
<a href="livro?acao=editar&codigo=${l.codigo}">Editar</a> |
<a href="livro?acao=excluir&codigo=${l.codigo}">Excluir</a>
</td>
</tr>
</c:forEach>
</table>
</body>
</html>