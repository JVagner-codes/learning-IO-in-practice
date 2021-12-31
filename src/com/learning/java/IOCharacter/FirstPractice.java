package com.learning.java.IOCharacter;

import java.io.*;

/**
 * está pratica tem como objetivo: ler dados do teclado, e imprimir o mesmo
 * utilizando classes e interfaces do java.io
 */
public class FirstPractice {

    public static void receiveKeyboardAndPrintConsole() throws IOException {

//        // recebendo dados do teclado
//        InputStream inputStream = System.in;
//        // convertendo para caracteres
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        // armazenando em um buffer
//        BufferedReader br = new BufferedReader(inputStreamReader);

        // fazendo a abertura para lida de dados através do teclado (mais ytilizado)
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.print("Enter your heart team: ");
        // lendo uma linha do teclado
        String line = br.readLine();

//        // faz a abertura de saida
//        OutputStream os = System.out;
//        // converte para bytes
//        OutputStreamWriter osw = new OutputStreamWriter(os);
//        // faz o buffer dos bytes
//        BufferedWriter bw = new BufferedWriter(osw);

        // fazendo a abertura para a escrita de dados
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (!(line.isEmpty())) {
            bw.write(line);
            bw.newLine();
            line = br.readLine();
        }
        bw.flush();

        br.close();
        bw.close();
    }

    public static void main (String[] args) throws IOException {
        receiveKeyboardAndPrintConsole();
    }
}
