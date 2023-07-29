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

    public App() {
        this.ahorcado = new Ahorcado();
        this.basquetball = new Basketball();
        this.casino = Casino.getCasino();
    }

    public void iniciar(String[] argumentosIniciales) {
        if (argumentosIniciales.length == 0) {
            try {
                mostrarMenu();
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un numero, no letras\n\n");
                iniciar(argumentosIniciales);
            }
        } else {
            if (argumentosIniciales.length == 1) {
                switch (argumentosIniciales[0].toLowerCase()) {
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
            } else {
                System.out.println("ERRO AL INICIAR LA APLICACION, INGRESE MAXIMO 1 ARGUMENTO. Ingrese \"ahorcado\" , \"basketball\" o \"cartas\" ");
            }
        }
    }

    private void mostrarMenu()
            throws InputMismatchException {
        System.out.println("MENU DE OPCIONES");
        System.out.println("1.Juego de Ahorcado");
        System.out.println("2.Juego de Basketball");
        System.out.println("3.Juego de Cartas");
        System.out.println("4.Salir");
        System.out.print("numero de opcion: ");
        Scanner scanner = new Scanner(System.in);
        int opcion = scanner.nextInt();
        jugar(opcion);
    }

    private void jugar(int opcion) {
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
                System.out.println("Ingrese una opcion valida (numero entre 1 y 4)");
        }
    }

    private void salir() {
        System.out.println("ha salido de la aplicacion");
    }
}
