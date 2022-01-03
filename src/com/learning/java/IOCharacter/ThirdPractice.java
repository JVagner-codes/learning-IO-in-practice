package com.learning.java.IOCharacter;

import java.io.*;

public class ThirdPractice {

    public static void copyFile() throws IOException {

        File f = new File("C:\\Users\\josev\\Documents\\Bootcamp Java - Amdocs\\learning-io-in-practice\\movie-recommendations.txt");
        String fileName = f.getName();

        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String line = br.readLine();

        // está pegando o nome do antigo arquivo, e deixando saldo desde o inicio do endereço
        // até o " . ", daí concatena toda a string com o novo nome do arquivo
        String fileNameCopy = fileName.substring(0, fileName.indexOf(".")).concat("-copy.txt");
        // criando o File para ter mais controle
        File copy = new File(fileNameCopy);
        // criando o arquivo em si
        BufferedWriter bw = new BufferedWriter(new FileWriter(copy.getName()));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        } while (line != null);

        System.out.printf("File \"%s\" copied successfully with size '%d bytes'\n", f.getName(), f.length());
        System.out.printf("File \"%s\" created successfully with size '%d bytes'\n", copy.getName(), copy.length());

        PrintWriter pw = new PrintWriter(System.out);
        pw.println("Recommend three books: ");
        pw.flush();

        addInformationToFile(copy.getName());
        pw.printf("Ok! New salved recommendations. File size '%d bytes'", copy.length());

        br.close();
        bw.close();
        pw.close();
    }

    public static void addInformationToFile(String file) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = br.readLine();

        // está passando o arquivo que deve ser manipulado, junto do argumento true,
        // que ativa o append, que faz com que as novas atualizações apareçam no fim
        // do arquivo
        BufferedWriter bw = new BufferedWriter(new FileWriter(file, true));

        do {
            bw.write(line);
            bw.newLine();
            bw.flush();
            line = br.readLine();
        } while (!(line.equalsIgnoreCase("fim")));

        br.close();
        bw.close();
    }

    public static void main(String[] args) throws IOException {
        copyFile();
    }
}
