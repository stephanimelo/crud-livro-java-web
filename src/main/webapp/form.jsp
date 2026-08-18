<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<body>
<h2>Cadastro de Livro</h2>
<form action="livro" method="post">
<input type="hidden" name="codigo" value="${livro.codigo}">
Titulo: <input type="text" name="titulo" value="${livro.titulo}"><br>
Idioma: <input type="text" name="idioma" value="${livro.idioma}"><br>
Ano: <input type="number" name="ano" value="${livro.ano}"><br>
<input type="submit" value="Salvar">
</form>
</body>
</html>
