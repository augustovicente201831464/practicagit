package com.cunoc.practicagit;

import com.cunoc.practicagit.juegos.Ahorcado;
import com.cunoc.practicagit.juegos.Basketball;
import com.cunoc.practicagit.juegos.Casino;
import com.cunoc.practicagit.juegos.Juego;
import java.util.InputMismatchException;
import java.util.Scanner;

public class App {

    private Juego ahorcado;
    private Juego basquetball;
    private Juego casino;
    private boolean ejecutandoApp;

    public App() {
        this.ahorcado = new Ahorcado();
        this.basquetball = new Basketball();
        this.casino = Casino.getCasino();
        ejecutandoApp = true;
    }

    public void iniciar(String[] argumento) {
        switch (argumento.length) {
            case 0:
                iniciarSinArgumento();
                break;
            case 1:
                iniciarConArgumento(argumento[0]);
                break;
            default:
                System.out.println("ERRO AL INICIAR LA APLICACION, INGRESE MAXIMO 1 ARGUMENTO. Ingrese \"ahorcado\" , \"basketball\" o \"cartas\" ");
        }
    }

    private void iniciarSinArgumento() {
        do {
            mostrarMenu();
        } while (ejecutandoApp);
    }

    private void iniciarConArgumento(String argumento) {
        switch (argumento.toLowerCase()) {
            case Juego.AHORCADO:
                ahorcado.jugar();
                break;
            case Juego.BASKETBALL:
                basquetball.jugar();
                break;
            case Juego.CASINO:
                casino.jugar();
                break;
            default:
                System.out.println("Argumento inicial equivocado. Ingrese \"ahorcado\" , \"basketball\" o \"cartas\" ");
        }
        iniciarSinArgumento();
    }

    private void mostrarMenu() {
        System.out.println("MENU DE JUEGOS");
        System.out.println("1.Juego de Ahorcado");
        System.out.println("2.Juego de Basketball");
        System.out.println("3.Juego de Cartas");
        System.out.println("4.Salir");
        seleccionarOpcion();
    }

    private void seleccionarOpcion() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("numero de opcion: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    ahorcado.jugar();
                    break;
                case 2:
                    basquetball.jugar();
                    break;
                case 3:
                    casino.jugar();
                    break;
                case 4:
                    salir();
                    break;
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese una opcion valida (numero entre 1 y 4)");
            seleccionarOpcion();
        }
    }

    private void salir() {
        ejecutandoApp = false;
        System.out.println("ha salido de la aplicacion");
    }
}
