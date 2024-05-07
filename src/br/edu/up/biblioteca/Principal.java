package br.edu.up.biblioteca;

import java.io.FileNotFoundException;
import java.util.Collections;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.edu.up.biblioteca.files.FileManager;

public class Principal {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        List<String> dados = FileManager.carregarDados("Livros.txt");

        // Menu de seleção de ação
        Integer opcao = null;
        do {
            System.out.println("Bem-vindo à Biblioteca!");
            System.out.println("1 - Adicionar livro");
            System.out.println("2 - Remover livro");
            System.out.println("3 - Listar todos os dados");
            System.out.println("4 - Procurar livro por título");
            System.out.println("0 - Sair");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpar o buffer do scanner

                switch (opcao) {
                    case 1:
                        FileManager.adicionarLivro();

                        break;
                    case 2:
                        FileManager.removerLivro();

                        break;
                    case 3:
                        // Organiza os dados para ficarem em ordem ascendente (Pelo Titulo)
                        Collections.sort(dados);

                        // Apresenta os dados
                        for (String livro : dados) {
                            System.out.println(livro);
                        }

                        break;
                    case 4:
                        FileManager.buscarTitulos();

                        break;
                    case 0:
                        System.out.println("Saindo...");

                        break;
                    default:
                        System.out.println("Opção inválida!");
                        break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Opção inválida! Por favor, insira um número correspondente à opção desejada.");
                scanner.nextLine(); // Limpar o buffer do scanner
            }
        } while (opcao != 0);

        scanner.close();
    }

}
