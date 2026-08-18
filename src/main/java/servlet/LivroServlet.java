package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import dao.LivroDAO;
import model.Livro;

@WebServlet("/livro")
public class LivroServlet extends HttpServlet {

    private LivroDAO dao = new LivroDAO();

    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        String acao = req.getParameter("acao");
        try {
            if (acao == null) acao = "listar";
            switch (acao) {
                case "novo":
                    req.getRequestDispatcher("form.jsp").forward(req, resp);
                    break;
                case "editar":
                    int cod = Integer.parseInt(req.getParameter("codigo"));
                    Livro l = dao.buscarPorCodigo(cod);
                    req.setAttribute("livro", l);
                    req.getRequestDispatcher("form.jsp").forward(req, resp);
                    break;
                case "excluir":
                    dao.excluir(Integer.parseInt(req.getParameter("codigo")));
                    resp.sendRedirect("livro");
                    break;
                default:
                    req.setAttribute("lista", dao.listar());
                    req.getRequestDispatcher("listar.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        try {
            Livro l = new Livro();
            String codigoStr = req.getParameter("codigo");
            if (codigoStr != null && !codigoStr.isEmpty())
                l.setCodigo(Integer.parseInt(codigoStr));
            l.setTitulo(req.getParameter("titulo"));
            l.setIdioma(req.getParameter("idioma"));
            l.setAno(Integer.parseInt(req.getParameter("ano")));

            if (codigoStr == null || codigoStr.isEmpty())
                dao.inserir(l);
            else
                dao.atualizar(l);

            resp.sendRedirect("livro");
        } catch (Exception e) {
            throw new ServletException(e);
        }
    }
}