package model;

public class Livro {
    private int codigo;
    private String titulo;
    private String idioma;
    private int ano;

    public int getCodigo() { return codigo; }
    public void setCodigo(int codigo) { this.codigo = codigo; }
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public String getIdioma() { return idioma; }
    public void setIdioma(String idioma) { this.idioma = idioma; }
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
}