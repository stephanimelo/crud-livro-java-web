package dao;

import java.sql.*;
import java.util.*;
import model.Livro;
import conexao.ConexaoBD;

public class LivroDAO {

    public void inserir(Livro l) throws Exception {
        String sql = "INSERT INTO Livro (titulo, idioma, ano) VALUES (?, ?, ?)";
        try (Connection con = ConexaoBD.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getIdioma());
            ps.setInt(3, l.getAno());
            ps.executeUpdate();
        }
    }

    public List<Livro> listar() throws Exception {
        List<Livro> lista = new ArrayList<>();
        String sql = "SELECT * FROM Livro";
        try (Connection con = ConexaoBD.getConexao();
             Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Livro l = new Livro();
                l.setCodigo(rs.getInt("codigo"));
                l.setTitulo(rs.getString("titulo"));
                l.setIdioma(rs.getString("idioma"));
                l.setAno(rs.getInt("ano"));
                lista.add(l);
            }
        }
        return lista;
    }

    public void atualizar(Livro l) throws Exception {
        String sql = "UPDATE Livro SET titulo=?, idioma=?, ano=? WHERE codigo=?";
        try (Connection con = ConexaoBD.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, l.getTitulo());
            ps.setString(2, l.getIdioma());
            ps.setInt(3, l.getAno());
            ps.setInt(4, l.getCodigo());
            ps.executeUpdate();
        }
    }

    public void excluir(int codigo) throws Exception {
        String sql = "DELETE FROM Livro WHERE codigo=?";
        try (Connection con = ConexaoBD.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            ps.executeUpdate();
        }
    }

    public Livro buscarPorCodigo(int codigo) throws Exception {
        String sql = "SELECT * FROM Livro WHERE codigo=?";
        try (Connection con = ConexaoBD.getConexao();
             PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, codigo);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Livro l = new Livro();
                    l.setCodigo(rs.getInt("codigo"));
                    l.setTitulo(rs.getString("titulo"));
                    l.setIdioma(rs.getString("idioma"));
                    l.setAno(rs.getInt("ano"));
                    return l;
                }
            }
        }
        return null;
    }
}