package com.cunoc.practicagit.juegocarta.utilidades;

import java.util.Scanner;

/**
 *
 * @author Augusto Vicente
 */
public class Validaciones {

    public static boolean validar(Scanner INPUT) {
        char respuesta = Validaciones.obtenerRespuestaValida(INPUT);
        return respuesta == 'S' || respuesta == 's';
    }

    private static char obtenerRespuestaValida(Scanner scanner) {
        String s = scanner.nextLine().trim();

        if (s.length() == 1) {
            char respuesta = s.charAt(0);
            if (respuesta == 'S' || respuesta == 's' || respuesta == 'N' || respuesta == 'n') {
                return respuesta;
            } else {
                System.out.println("\nRespuesta inválida. Ingresa S (Si) o N (No):");
                return obtenerRespuestaValida(scanner);
            }
        } else {
            System.out.println("\nDebes ingresar solo un carácter. Ingresa S (Si) o N (No):");
            return obtenerRespuestaValida(scanner);
        }
    }

}
