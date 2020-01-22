package com.naren.inheritance;

public class Inheritance extends InheritanceBase {

    public static void main(String...a)
    {
        InheritanceBase ib = new Inheritance();
        ib.call();
        ib = new InheritanceBase();
        ib.call();

        Inheritance i = (Inheritance)new InheritanceBase();
        i.call();
    }

    void call(){
        System.out.println("Inheritance.call");
    }
}

class InheritanceBase {

    void call(){
        System.out.println("InheritanceBase.call");
    }
}

