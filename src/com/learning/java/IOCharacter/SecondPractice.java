package com.learning.java.IOCharacter;

import java.io.*;
import java.util.Scanner;

/**
 * está pratica tem como objetivo: ler dados através do teclado, e passar o mesmo
 * para um arquivo .txt, utilizando classes e interfaces do java.io
 */
public class SecondPractice {

    public static void readKeyboardAndWhiteDocument() throws IOException {

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Type three movies: ");
        pw.flush();

        // abrindo o terminal para entrada de texto através do teclado
        Scanner scan = new Scanner(System.in);
        // lendo a próxima linha
        String line = scan.nextLine();

        // criado para ter um retorno melhor sobre o arquivo
        File f = new File("movie-recommendations.txt");
        // criando um buffer para deixar salvo temporariamente os dados
        BufferedWriter bw = new BufferedWriter(new FileWriter(f.getName()));

        while (!(line.equalsIgnoreCase("fim"))) {
            // escreve o dados no arquivo
            bw.write(line);
            // pula uma nova linha no buffer
            bw.newLine();
            // descarrega os dados
            bw.flush();
            // ler a próxima linha do teclado
            line = scan.nextLine();
        }
        // irá colocar o nome do arquivo no lugar do ( \n"%s\" )
        pw.printf("File \"%s\" created successfully!", f.getName());

        pw.close();
        scan.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        readKeyboardAndWhiteDocument();
    }
}
