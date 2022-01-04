package com.learning.java.IOBytes.IOObject;

import java.io.Serializable;

// precisa informa na classe, que o objeto será Serializable
public class Cat implements Serializable {

    // serve para criar um identificador único da classe
    private static final long serialVersionUID = 2L;
    private String name;
    private int age;
    private String color;
    private boolean castrated;
    // o transient deixa o atributo invisível, então não dara erro se tentarem desseraliazar
    private transient boolean purrs;

    public Cat(){
    }

    public Cat(String name, int age, String color, boolean castrated, boolean purrs) {
        this.name = name;
        this.age = age;
        this.color = color;
        this.castrated = castrated;
        this.purrs = purrs;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getColor() {
        return color;
    }

    public boolean isCastrated() {
        return castrated;
    }

    public boolean isPurrs() {
        return purrs;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", color='" + color + '\'' +
                ", castrated=" + castrated +
                ", purrs=" + purrs +
                '}';
    }
}
