package br.edu.up.biblioteca.files;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager {

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

    public static List<String> carregarDados(String arquivo) {
        List<String> dados = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivo));
            String linha;
            while ((linha = reader.readLine()) != null) {
                dados.add(linha);
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dados;

    }
}