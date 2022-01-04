package com.learning.java.IOBytes;

import java.io.*;

/**
 * fazer uma copia do arquivo movie-recommendations-copy.txt
 */
public class ExampleIOBytes {

    public static void copyFile() throws IOException {
        File f = new File("C:\\Users\\josev\\Documents\\Bootcamp Java - Amdocs\\learning-io-in-practice\\movie-recommendations-copy.txt");
        String nameFile = f.getName();

//        InputStream is = new FileInputStream(nameFile);
//        BufferedInputStream bis = new BufferedInputStream(is);

        // fazendo a abertura do documento
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream(nameFile));

        // criando o nome do novo arquivo, copiando o mesmo nome do outro com algumas modificações
        String nameFileCopy = nameFile.substring(0, nameFile.indexOf(".")).concat("2.txt");
        File fCopy = new File(nameFileCopy);

//        OutputStream os = new FileOutputStream(nameFileCopy);
//        BufferedOutputStream bos = new BufferedOutputStream(os);
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(nameFileCopy));

        int line = 0;
        while ((line = bis.read()) != -1) {
            bos.write((char) line);
            bos.flush();
        }
        bis.close();
        bos.close();

        PrintStream ps = new PrintStream(System.out);
        ps.printf("File %s copied successfully with size %d bytes", fCopy.getName(), fCopy.length());
    }

    public static void main(String[] args) throws IOException {
        copyFile();
    }
}
