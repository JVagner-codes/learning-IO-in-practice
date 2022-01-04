package com.learning.java.IOBytes.IOObject;

import java.io.*;

public class ExampleIOObject {

    public static void serialization() throws IOException {
        Cat cat = new Cat("Snow", 6, "White", true, false);

        File f = new File("file-cat");

//        OutputStream os = new FileOutputStream(f.getName());
//        ObjectOutputStream oos = new ObjectOutputStream(os);
        // criando o arquivo e a corrente de transmissão
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(f.getName()));

        // escrevendo um objeto no arquivo
        oos.writeObject(cat);

        System.out.printf("File \"%s\" created successfully! With the size: '%d bytes'", f.getName(), f.length());

        oos.close();
    }

    public static void deserialization(String file) throws IOException, ClassNotFoundException {

//        InputStream is = new FileInputStream(file);
//        ObjectInputStream ois = new ObjectInputStream(is);

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));

        Cat objectCat = (Cat) ois.readObject();

        System.out.printf("\nName...............: %s\n", objectCat.getName());
        System.out.printf("Age................: %d\n", objectCat.getAge());
        System.out.printf("Color..............: %s\n", objectCat.getColor());
        System.out.printf("Castrated..........: %s\n", objectCat.isCastrated());
        System.out.printf("Purrs..............: %s\n", objectCat.isPurrs());
        System.out.println(objectCat);

        ois.close();
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        serialization();
        deserialization("C:\\Users\\josev\\Documents\\Bootcamp Java - Amdocs\\learning-io-in-practice\\file-cat");
    }
}
