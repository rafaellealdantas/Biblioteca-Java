package br.edu.up.biblioteca.modelos;

public class Livro {
    private String titulo;
    private Autor autor;
    private Genero genero;
    private Editora editora;

    public Livro() {
    }

    public Livro(String titulo, Autor autor, Genero genero, Editora editora) {
        this.titulo = titulo;
        this.autor = autor;
        this.genero = genero;
        this.editora = editora;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Autor getAutor() {
        return autor;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Editora getEditora() {
        return editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    @Override
public String toString() {
    return "Livro: " + titulo + ", Autor: " + autor.getNome() + ", Gênero: " + genero.getNome() + ", Editora: " + editora.getNome();
}

}
