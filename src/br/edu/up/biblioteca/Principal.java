package br.edu.up.biblioteca;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

import br.edu.up.biblioteca.files.FileManager;
import br.edu.up.biblioteca.modelos.Autor;
import br.edu.up.biblioteca.modelos.Editora;
import br.edu.up.biblioteca.modelos.Genero;
import br.edu.up.biblioteca.modelos.Livro;

public class Principal 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int opcao;

        Livro livro1 = new Livro("João e o pé de feijão", new Autor("Maria"), new Genero("Fantasia"), new Editora("Editora 21"));
        Livro livro2 = new Livro("Som de roer ouvido", new Autor("Rodrigo"), new Genero("Marvel"), new Editora("Editora 44"));

        FileManager.salvarDados(livro1.toString(), "livros.txt");
        FileManager.salvarDados(livro2.toString(), "livros.txt");

        List<String> livros = FileManager.carregarDados("livros.txt");
        for (String livro : livros) 
        {
            System.out.println(livro);
        }
        
        // menu de seleção de ação
        do 
        {
            System.out.println("Bem-vindo à Biblioteca!");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Remover livro");
            System.out.println("3 - Pesquisar livro");
            System.out.println("4 - Listar todos os livros");
            System.out.println("5 - Listar os livros de forma ordenada");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: "); 
            opcao = scanner.nextInt();            
            switch (opcao) {
                case 1:
                adicionarLivro();
                break;
                case 2:
                removerLivro();
                break;
            case 0:
                System.out.println("Saindo...");
                break;
            default:
                System.out.println("Opção inválida!");
            }
        } while (opcao != 0);
        
    }
    
    // método para adicionar um novo livro
    static void adicionarLivro() 
    {
        Scanner scanner = new Scanner(System.in);

        // pergunta dados do novo livro
        System.out.print("Digite o título do livro: ");
        String titulo = scanner.nextLine();

        System.out.print("Digite o autor do livro: ");
        String nomeAutor = scanner.nextLine();

        System.out.print("Digite o genero do livro: ");
        String nomeGenero = scanner.nextLine();

        System.out.print("Digite a editora do livro: ");
        String nomeEditora = scanner.nextLine();
    
        // Criar uma nova instância de Autor
        Autor autor = new Autor(nomeAutor);
    
        // Criar uma nova instância de Genero
        Genero genero = new Genero(nomeGenero);
    
        // Criar uma nova instância de Editora
        Editora editora = new Editora(nomeEditora);
    
        // Criar uma nova instância de Livro
        Livro novoLivro = new Livro(titulo, autor, genero, editora);
    
        // Converter o novo livro em uma string
        String dadosLivro = novoLivro.toString();
    
        // Salvando os dados do livro
        FileManager.salvarDados(dadosLivro, "livros.txt");
       
        System.out.println("Livro adicionado: " + titulo);
    }

    // método para a remoção do livro  
    static void removerLivro() {
    Scanner scanner = new Scanner(System.in);

    // Solicita o título do livro a ser removido
    System.out.print("Digite o título do livro a ser removido: ");
    String tituloRemover = scanner.nextLine();

    // Carrega a lista de livros do arquivo
    List<String> livros = FileManager.carregarDados("livros.txt");

    // Verifica se o livro está na lista e remove se encontrado
    boolean removido = false;
    for (int i = 0; i < livros.size(); i++) {
        if (livros.get(i).contains(tituloRemover)) {
            livros.remove(i);
            removido = true;
            break;
        }
    }

    // Se o livro foi removido, atualiza o arquivo
    if (removido) {
        try {
            // utilizando o BufferedWriter para escrever linha a linha dentro de livros.txt
            BufferedWriter writer = new BufferedWriter(new FileWriter("livros.txt"));
            for (String livro : livros) 
            {
                
                writer.write(livro);
                
                // utilizado para salvar os arquivos um em cada linha
                writer.newLine();
            }
            writer.close();
            System.out.println("Livro removido com sucesso!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    } else {
        System.out.println("Livro não encontrado!");
    }
}    
}

    
    


