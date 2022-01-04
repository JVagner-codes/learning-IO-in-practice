package com.learning.java.IOBytes.IOData;

import java.io.*;
import java.util.Scanner;

public class ExampleIOData {

    public static void includesProduct() throws IOException {
        // representando o arquivo
        File f = new File("C:\\Users\\josev\\Documents\\garment.bin");

        // chamando a classe PrintStream para poder imprimir no console
        PrintStream ps = new PrintStream(System.out);
        ps.flush();

//        OutputStream os = new FileOutputStream(f.getPath());
//        DataOutputStream dos = new DataOutputStream(os);
        // foi criado para poder persistir tipos primitivos no documento
        DataOutputStream dos = new DataOutputStream(new FileOutputStream(f.getPath()));

        // serve para abrir o teclado
        Scanner scan = new Scanner(System.in);

        // imprimindo no console
        ps.print("Part name: ");
        // capturando a próxima linha
        String name = scan.nextLine();
        // escrevendo no arquivo
        dos.writeUTF(name);

        ps.print("Piece size (P/M/G/U): ");
        char size = (char) System.in.read();
        dos.writeChar(size);

        ps.print("Quantity: ");
        int quant = scan.nextInt();
        dos.writeInt(quant);

        ps.print("Unit price: ");
        double price = scan.nextDouble();
        dos.writeDouble(price);

        ps.printf("File %s was created with %d bytes", f.getName(), f.length());

        readProduct(f.getPath());

        dos.close();
        scan.close();
        ps.close();
    }

    public static void readProduct(String file) throws IOException {

        // foi criado só para ter mais controle sobre o caminho do arquivo
        File f = new File(file);

//        InputStream is = new FileInputStream(f.getPath());
//        DataInputStream dis = new DataInputStream(is);
        // abrindo o arquivo
        DataInputStream dis = new DataInputStream(new FileInputStream(f.getPath()));

        // lendo os dados primitivos que está no arquivo que foi aberto na linha de cima
        String name = dis.readUTF();
        char size = dis.readChar();
        int quant = dis.readInt();
        double price = dis.readDouble();

        System.out.printf("\nName................: %s\n", name);
        System.out.printf("Size................: %s\n", size);
        System.out.printf("Quant...............: %s\n", quant);
        System.out.printf("Price...............: %s\n", price);
        System.out.print("Total part values: " + (price * quant));

        dis.close();
    }

    public static void main(String[] args) throws IOException {
        includesProduct();
    }
}
