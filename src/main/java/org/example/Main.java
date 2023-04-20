package org.example;

import java.util.InputMismatchException;
import java.util.Objects;
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

    public static int terEdad(String[][] registro) {
        int mmmm = 0;
        int queSera = obtenerUltimoEspacio(registro);
        for (int i = 0; i < queSera; i++) {
            if (Integer.parseInt(registro[i][2]) >= 60) {
                mmmm++;
            }
        }
        return mmmm;
    }

    public static int menoresEdad(String[][] registro) {
        int menoresDeEdad = 0;
        int queSera = obtenerUltimoEspacio(registro);
        for (int i = 0; i < queSera; i++) {
            if (Integer.parseInt(registro[i][2]) < 18) menoresDeEdad++;
        }
        return menoresDeEdad;
    }

    public static int mayoresEdad(String[][] registro) {
        int mayoresDeEdad = 0;
        int queSera = obtenerUltimoEspacio(registro);
        System.out.println(queSera);
        for (int i = 0; i < queSera; i++) {
            System.out.println(Integer.parseInt(registro[i][2]));
            if (Integer.parseInt(registro[i][2]) >= 18) {
                mayoresDeEdad++;
            }
        }
        return mayoresDeEdad;
    }

    public static void agregar(String[][] registro) {
        Scanner s = new Scanner(System.in);
        if (hayCupo(registro)) {
            int indiceDisponible = obtenerUltimoEspacio(registro);
            String nombre = null;
            String estadocivil = null;
            int edad = 0;

            boolean a;

            try {
                System.out.println("Ingrese el nombre:");
                nombre = s.nextLine();
            } catch (InputMismatchException e) {
                System.err.println("Opción inválida");
            }


            do {
                try {
                    System.out.println("Ingrese el estado civil:");
                    estadocivil = s.nextLine();
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                }
                a = !Objects.equals(estadocivil, "casado") && (!Objects.equals(estadocivil, "soltero") && !Objects.equals(estadocivil, "casada") && !Objects.equals(estadocivil, "soltera"));
            } while (a);

            do {
                try {
                    System.out.println("Ingrese la edad:");
                    edad = new Scanner(System.in).nextInt();
                    a = false;
                } catch (InputMismatchException e) {
                    System.err.println("Opción inválida");
                    a = true;
                }
            } while (a);


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
                    agregar(registro);
                    menu();
                case 2:
                    mostrarMayoresEdad(mayoresEdad(registro));
                    menu();
                case 3:
                    mostrarMenoresEdad(menoresEdad(registro));
                    menu();
                case 4:
                    mostrarTerEdad(terEdad(registro));
                    menu();
                case 5:
                    menu5(registro);
                    menu();
                case 6:
                    System.exit(0);
            }
        } while (true);
    }

    public static void mostrarMenoresEdad(int i) {
        System.out.println("Hay " + i + " menores de edad.");
    }

    public static void mostrarMayoresEdad(int i) {
        System.out.println("Hay " + i + " mayores de edad.");
    }

    public static void mostrarTerEdad(int i) {
        System.out.println("Hay " + i + " personas de tercera edad");
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
        return 50 - opa(registro);
    }


    public static boolean hayCupo(String[][] registro) {
        return opa(registro) != 0;
    }


    public static int opa(String[][] registro) {
        int cont = 0;
        for (int i = 0; i < 50; i++) {
            if (registro[i][0] == null) {
                cont++;
            }
        }


        return 50 - cont;
    }
}
