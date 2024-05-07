package br.edu.up.biblioteca;

import java.util.List;

import br.edu.up.biblioteca.files.FileManager;
import br.edu.up.biblioteca.modelos.Autor;
import br.edu.up.biblioteca.modelos.Editora;
import br.edu.up.biblioteca.modelos.Genero;
import br.edu.up.biblioteca.modelos.Livro;

public class Principal {
    public static void main(String[] args) {
        Livro livro1 = new Livro("João e o pé de feijão", new Autor("Maria"), new Genero("Fantasia"), new Editora("Editora 21"));
        Livro livro2 = new Livro("Som de roer ouvido", new Autor("Rodrigo"), new Genero("Marvel"), new Editora("Editora 44"));

        FileManager.salvarDados(livro1.toString(), "livros.txt");
        FileManager.salvarDados(livro2.toString(), "livros.txt");

        List<String> livros = FileManager.carregarDados("livros.txt");
        for (String livro : livros) {
            System.out.println(livro);
        }

    }
}
