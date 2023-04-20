package org.example;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        menu();
    }

    public static void menu5(String[][] registro) {

        int c = 0;
        int d = 0;
        for (String[] persona : registro) {
            if (persona[1].equals("casado") || persona[1].equals("casada")) {
                c++;
            } else if (persona[1].equals("soltero") || persona[1].equals("soltera")) {
                d++;
            }
        }


        System.out.println("Hay " + d + " casados/as.");
        System.out.println("Hay " + c + " solteros/as.");
    }

    public static void menu4(String[][] registro) {

        int mmmm = 0;


        for (String[] persona : registro) {
            if (Integer.parseInt(persona[2]) >= 60 && persona[1].equals("casado/a")) {
                mmmm++;
            } else if (Integer.parseInt(persona[2]) >= 65 && persona[1].equals("soltero/a")) {
                mmmm++;
            }
        }
        System.out.println("Hay " + mmmm + " personas de tercera edad");
    }

    public static void menu3(String[][] registro) {

        int menoresDeEdad = 0;
        int queSera = obtenerUltimoEspacio(registro);


        for (int i = 0; i < queSera; i++) {
            if (Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
        }


        System.out.println("Hay " + menoresDeEdad + " menores de edad.");
    }

    public static void menu2(String[][] registro) {

        int mayoresDeEdad = 0;


        for (String[] persona : registro) {
            if (Integer.parseInt(persona[2]) >= 18) mayoresDeEdad++;
        }


        System.out.println("Hay " + mayoresDeEdad + " mayores de edad.");
    }

    public static void menu1(String[][] registro) {
        Scanner s = new Scanner(System.in);
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre = null;
            String estadocivil = null;
            int edad = 0;


            try {
                System.out.println("Ingrese el nombre:");
                nombre = s.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }


            try {
                System.out.println("Ingrese el estado civil:");
                estadocivil = s.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }

            try {
                System.out.println("Ingrese la edad:");
                edad = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }

            registro[indiceDisponible][0] = nombre;
            registro[indiceDisponible][1] = estadocivil;
            registro[indiceDisponible][2] = String.valueOf(edad);
            System.out.println("Persona agregada.");
        } else {
            System.out.println("No hay cupo.");
        }
    }

    public static void menu() {
        String[][] registro = new String[50][3];
        do {
            System.out.println("""
                    Menú
                    1) Agregar persona.
                    2) Mostrar la cantidad de personas mayores de edad.
                    3) Mostrar la cantidad de personas menores de edad.
                    4) Mostrar la cantidad de personas de tercera edad.
                    5) Mostrar la cantidad de personas según estado civil (Soltero/a - Casado/a).
                    6)Salir.
                    """);

            switch (opcion()) {
                case 1:
                    menu1(registro);
                case 2:
                    menu2(registro);
                case 3:
                    menu3(registro);
                case 4:
                    menu4(registro);
                case 5:
                    menu5(registro);
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static int opcion() {
        int a = 0;
        do {
            try {
                a = new Scanner(System.in).nextInt();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }
        } while (a < 0 || a > 6);
        return a;
    }

    public static int obtenerUltimoEspacio(String[][] registro) {
        return registro.length - opa(registro);
    }


    public static boolean hayCupo(String[][] registro) {
        return opa(registro) != 0;
    }


    public static int opa(String[][] registro) {
        for (int i = 0; i < registro.length; i++) {
            if (registro[i][0] == null) {
                return registro.length - i;
            }
        }


        return 0;
    }
}
