package com.anushka.vrsManagerConsole;

import com.anushka.vrsManagerConsole.concretes.ApplicationManager;

public class Main {

    public static void main(String[] args) {
        System.out.println("-------------------------------------");
        System.out.println("Vehicle Rental System Manager Console");
        System.out.println("-------------------------------------");
        ApplicationManager.start();
        System.out.println("-------------------------------------");
    }
}
