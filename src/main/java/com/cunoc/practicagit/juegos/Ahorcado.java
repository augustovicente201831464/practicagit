package com.cunoc.practicagit.juegos;

import com.cunoc.practicagit.ahorcado.DibujoAhorcado;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Ahorcado extends Juego {

    @Override
    public void jugar() {
        //Mostrar menu
        iniciarAhorcado(INPUT);
    }

    private Ahorcado() {
        INPUT = new Scanner(System.in);
    }

    public static Ahorcado getAhorcado() {
        return (ahorcado != null) ? ahorcado : new Ahorcado();
    }

    private void iniciarAhorcado(Scanner INPUT) {

        System.out.println("\nBienvenido(a) al juego 1: Ahorcado");

        System.out.println("\n--- MENU AHORCADO ---"
                + "\n1. Nuevo juego"
                + "\n2. Ingresar jugador"
                + "\n3. Mostrar dato jugadores"
                + "\n4. Salir");

        int opcion = 4;
        boolean jugando = true;

        try {
            System.out.print("\nIngrese una opción: ");
            opcion = Integer.parseInt(INPUT.nextLine());

            switch (opcion) {
                case 1:
                    
                    break;
                case 2:
                    
                    break;
                case 3:
                    
                    break;
                case 4:
                    
                    break;
                default:
                    throw new Exception();
            }

        } catch (Exception ex) {
            System.out.println("\n¡Ingrese un valor númerico válido!");
        }

        if (jugando) {
            iniciarAhorcado(INPUT);
        }

        /*

        System.out.println("\nIngrese una palabra que un jugador lo adivine: ");

        DibujoAhorcado da = DibujoAhorcado.getDibujoAhorcado();
        da.dibujarPersonaje();

        //Primera falla
        int intentoFallidos = 1;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Segunda falla
        intentoFallidos = 2;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Tercero falla
        intentoFallidos = 3;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Cuarta falla
        intentoFallidos = 4;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Quinta falla
        intentoFallidos = 5;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Sexta falla
        intentoFallidos = 6;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Septima falla
        intentoFallidos = 7;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();

        //Octava falla
        intentoFallidos = 8;
        da.decretarFalla(intentoFallidos, da);
        da.dibujarAhorca();
         */
    }

    private static Ahorcado ahorcado;
    private static Scanner INPUT;
}
