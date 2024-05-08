package br.edu.up.biblioteca.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import br.edu.up.biblioteca.modelos.Autor;
import br.edu.up.biblioteca.modelos.Editora;
import br.edu.up.biblioteca.modelos.Genero;
import br.edu.up.biblioteca.modelos.Livro;

public class FileManager {

    // Função para salvar os dados no arquivo
    public static void salvarDados(String dados, String arquivo) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter(arquivo, true));
            writer.write(dados);
            writer.newLine();
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // Função que permite os funções a ler os arquivos
    public static List<String> carregarDados(String arquivo) {
        List<String> dados = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                dados.add(linha);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;
    }

    // método para adicionar um novo livro
    public static void adicionarLivro() {
        @SuppressWarnings("resource")
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
    public static void removerLivro() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita o título do livro a ser encontrado
        System.out.print("Digite o título do livro a ser apagado: ");
        String procurar = scanner.nextLine();

        // Carrega a lista de livros do arquivo
        List<String> livros = FileManager.carregarDados("livros.txt");

        // Verifica se o livro está na lista e remove se encontrado
        boolean encontrado = false;
        for (int i = 0; i < livros.size(); i++) {
            if (livros.get(i).contains(procurar)) {
                livros.remove(i);
                encontrado = true;
                break;
            }
        }

        // Se o livro foi encontrado, atualiza o arquivo
        if (encontrado) {
            try {
                // utilizando o BufferedWriter para escrever linha a linha dentro de livros.txt
                BufferedWriter writer = new BufferedWriter(new FileWriter("livros.txt"));
                for (String livro : livros) {

                    writer.write(livro);

                    // utilizado para salvar os arquivos um em cada linha
                    writer.newLine();
                }
                writer.close();
                System.out.println("Livro apagado com sucesso!");
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Livro não encontrado!");
        }
    }

    public static void buscarTitulos() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita o título do livro a ser encontrado
        System.out.print("Digite o título do livro procurado: ");
        String procurar = scanner.nextLine();

        // Carrega a lista de livros do arquivo
        List<String> livros = FileManager.carregarDados("livros.txt");

        boolean encontrado = false;

        for (String livro : livros) {
            if (livro.contains(procurar)) {
                System.out.println("Livro encontrado:");
                String[] partes = livro.split(",");
                System.out.println("- " + partes[0].trim());
                for (int i = 1; i < partes.length; i++) {
                    System.out.println("- " + partes[i].trim());
                }
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Livro não encontrado.");
        }
    }

    public static void buscarAutores() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita o autor a ser encontrado
        System.out.print("Digite o autor procurado: ");
        String procurar = scanner.nextLine();

        // Carrega a lista de livros do arquivo
        List<String> livros = FileManager.carregarDados("livros.txt");

        boolean encontrado = false;

        for (String livro : livros) {
            if (livro.contains(procurar)) {
                System.out.println("Autor encontrado:");
                String[] partes = livro.split(",");
                System.out.println("- " + partes[0].trim());
                for (int i = 1; i < partes.length; i++) {
                    System.out.println("- " + partes[i].trim());
                }
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Autor não encontrado.");
        }
    }
    public static void buscarGenero() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita o genero a ser encontrado
        System.out.print("Digite o genero procurado: ");
        String procurar = scanner.nextLine();

        // Carrega a lista de livros do arquivo
        List<String> livros = FileManager.carregarDados("livros.txt");

        boolean encontrado = false;

        for (String livro : livros) {
            if (livro.contains(procurar)) {
                System.out.println("Genero encontrado:");
                String[] partes = livro.split(",");
                System.out.println("- " + partes[0].trim());
                for (int i = 1; i < partes.length; i++) {
                    System.out.println("- " + partes[i].trim());
                }
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Genero não encontrado.");
        }
    }
    public static void buscarEditora() {
        @SuppressWarnings("resource")
        Scanner scanner = new Scanner(System.in);

        // Solicita a editora a ser encontrada
        System.out.print("Digite a editora procurada: ");
        String procurar = scanner.nextLine();

        // Carrega a lista de livros do arquivo
        List<String> livros = FileManager.carregarDados("livros.txt");

        boolean encontrado = false;

        for (String livro : livros) {
            if (livro.contains(procurar)) {
                System.out.println("Autor encontrado:");
                String[] partes = livro.split(",");
                System.out.println("- " + partes[0].trim());
                for (int i = 1; i < partes.length; i++) {
                    System.out.println("- " + partes[i].trim());
                }
                encontrado = true;
            }
        }

        if (!encontrado) {
            System.out.println("Editora não encontrada.");
        }
    }

}
