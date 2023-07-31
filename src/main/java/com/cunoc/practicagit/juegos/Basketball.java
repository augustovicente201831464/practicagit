package com.cunoc.practicagit.juegos;

import com.cunoc.practicagit.jugadores.Basquetbolista;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author usuario
 */
public class Basketball extends Juego {

    private Basquetbolista basquetbolista1;
    private Basquetbolista basquetbolista2;
    private int cantidadDeTurnos;
    private int turnosCompletados;
    private boolean jugando;
    private boolean partidoTerminado;
    private int jugadasCompletadas;
    private Basquetbolista atacante;
    private Basquetbolista defensor;

    @Override
    public void jugar() {
        iniciarCampos();
        ingresarNombres();
        ingresarTurnos();
        do {
            mostrarJuego();
        } while (jugando);
        mostrarOpcionesFinales();
    }

    private void iniciarCampos() {
        basquetbolista1 = new Basquetbolista();
        basquetbolista2 = new Basquetbolista();
        cantidadDeTurnos = 0;
        jugando = true;
        partidoTerminado = false;
        jugadasCompletadas = 0;
        turnosCompletados = 0;
    }

    private void mostrarOpcionesFinales() {
        System.out.println("\n\n--------------------------------------------------");
        System.out.println("             JUEGO DE BASKETBALL");
        System.out.println("--------------------------------------------------");
        System.out.println("1.Jugar de nuevo");
        System.out.println("2.Regresar al Menu de Juegos o Salir");
        seleccionarOpcionFinal();
    }

    private void seleccionarOpcionFinal() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("opcion seleccionada: ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    jugar();
                    break;
                case 2:
                    //regresa al menu principal
                    break;
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("Ingrese una opcion valida (numero entre 1 y 2)");
            seleccionarOpcionFinal();
        }
    }

    private void mostrarJuego() {
        if (!partidoTerminado) {
            if (jugadasCompletadas % 2 == 0) {
                mostrarEncabezado();
                if (turnosCompletados % 2 == 0) {
                    atacante = basquetbolista1;
                    defensor = basquetbolista2;
                } else {
                    atacante = basquetbolista2;
                    defensor = basquetbolista1;
                }
                atacar();
            } else {
                defender();
                if (jugando) {
                    mostrarResultadoLanzamiento();
                    if (turnosCompletados == cantidadDeTurnos) {
                        partidoTerminado = true;
                    }
                }
            }
        } else {
            mostrarResultadoPartido();
            jugando = false;
        }
    }

    private void mostrarResultadoPartido() {
        mostrarEncabezado();
        if (basquetbolista1.getPuntosTotales() > basquetbolista2.getPuntosTotales()) {
            System.out.println("el ganador es: " + basquetbolista1.getNombre());
        } else if (basquetbolista1.getPuntosTotales() < basquetbolista2.getPuntosTotales()) {
            System.out.println("el ganador es: " + basquetbolista2.getNombre());
        } else if (basquetbolista1.getPuntosTotales() == basquetbolista2.getPuntosTotales()) {
            System.out.println("el resultado es empate");
        }
    }

    private void mostrarEncabezado() {
        System.out.println("\n\n--------------------------------------------------");
        System.out.println("             JUEGO DE BASKETBALL");
        System.out.println("--------------------------------------------------");
        System.out.println("nombre: " + basquetbolista1.getNombre() + "\t puntos: " + basquetbolista1.getPuntosTotales());
        System.out.println("nombre: " + basquetbolista2.getNombre() + "\t puntos: " + basquetbolista2.getPuntosTotales());
        System.out.println(turnosCompletados + "/" + cantidadDeTurnos + " turnos completados");
    }

    private void mostrarResultadoLanzamiento() {
        System.out.println("--------------------------------------------------");
        System.out.println("\n\n             Resultados del turno #" + turnosCompletados);
        System.out.println("--------------------------------------------------");
        Random random = new Random();
        int numero;
        //lanzamiento
        numero = random.nextInt(100) + 1;
        if (numero > 0 && numero <= atacante.getProbabilidadLanzamiento()) {
            System.out.println("Jugador en ataque (" + atacante.getNombre() + ") ha anotado " + atacante.getPuntosLanzamiento() + " puntos");
            atacante.aumentarPuntos();
        } else if (numero > atacante.getProbabilidadLanzamiento() && numero <= 100) {
            System.out.println("Jugador en ataque (" + atacante.getNombre() + ") ha fallado el lanzamiento");
        }
        //falta
        numero = random.nextInt(100) + 1;
        if (numero > 0 && numero <= atacante.getProbabilidadFalta()) {
            System.out.println("Jugador en defensa (" + defensor.getNombre() + ") ha cometido falta ");
            System.out.println("Jugador en ataque (" + atacante.getNombre() + ") PRESIONE \"ENTER\" PARA LAZAR EL TIRO LIBRE");
            Scanner scanner = new Scanner(System.in);
            String enter = scanner.nextLine();
            //lanzamiento tiro libre
            numero = random.nextInt(100) + 1;
            if (numero > 0 && numero <= Basquetbolista.PROBABILIDAD_ANOTAR_LIBRE) {
                System.out.println("Jugador en ataque (" + atacante.getNombre() + ") ha anotado el Tiro Libre de " + Basquetbolista.PUNTOS_TIRO_LIBRE + " puntos");
                atacante.aumentarPuntos();
            } else if (numero > Basquetbolista.PROBABILIDAD_ANOTAR_LIBRE && numero <= 100) {
                System.out.println("Jugador en ataque (" + atacante.getNombre() + ") ha fallado el Tiro Libre");
            }
        } else if (numero > atacante.getProbabilidadFalta() && numero >= 100) {
            System.out.println("Jugador en defensa (" + defensor.getNombre() + ") no ha cometido falta ");
        }
    }

    private void atacar() throws InputMismatchException {
        System.out.println("--------------Turno de la ofensiva----------------");
        System.out.println("1.Lanzamiento largo desde 5 metros (3 puntos). La probabilidad de anotar es de 65%");
        System.out.println("2.Lanzamiento corto desde 3 metros (2 puntos). La probabilidad de anotar es de 80%");
        System.out.println("3.Abandonar juego (perderá automáticamente)");
        seleccionarAtaque();
        jugadasCompletadas++;
    }

    private void seleccionarAtaque() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("seleccione opcion jugador(" + atacante.getNombre() + "): ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    atacante.lanzarLargo();
                    break;
                case 2:
                    atacante.lanzarCorto();
                    break;
                case 3:
                    atacante.abandonarJuego(defensor);
                    jugando = false;
                    break;
                default:
                    throw new InputMismatchException();
            }
        } catch (InputMismatchException e) {
            System.out.println("\nIngrese una opcion valida (numero entre 1 y 3)");
            seleccionarAtaque();
        }
    }

    private void defender() {
        System.out.println("---------------Turno de la defensiva--------------");
        System.out.println("\n1.Defensa cuerpo a cuerpo, reduce la probabilidad de anotar en un 15% y probabilidad de hacer falta del 35%");
        System.out.println("2.Defensa fuerte, reduce la probabilidad de anotar en un 30%  y probabilidad de hacer falta del 65%");
        System.out.println("3.Abandonar juego (perderá automáticamente)");
        SeleccionarDefensa();
        jugadasCompletadas++;
        turnosCompletados++;
    }

    private void SeleccionarDefensa() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.print("seleccione opcion jugador(" + defensor.getNombre() + "): ");
            int opcion = scanner.nextInt();
            switch (opcion) {
                case 1:
                    defensor.defenderCuerpoACuerpo(atacante);
                    break;
                case 2:
                    defensor.defenderFuerte(atacante);
                    break;
                case 3:
                    defensor.abandonarJuego(atacante);
                    jugando = false;
                    break;
                default:
                    throw new InputMismatchException();
            }
        } catch (Exception e) {
            System.out.println("\nIngrese una opcion valida (numero entre 1 y 3)");
            SeleccionarDefensa();
        }
    }

    private void tirarLibre() {
        System.out.println("Tiro libre dado a un jugador cuando se le realiza una falta, vale 2 puntos y la probabilidad de anotar es de 90% ");
    }

    private void ingresarNombres() {
        System.out.println("\n\n--------------------------------------------------");
        System.out.println("             JUEGO DE BASKETBALL");
        System.out.println("--------------------------------------------------");
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese nombre de un jugador: ");
        String nombre1 = scanner.nextLine();
        System.out.print("Ingrese nombre del otro jugador: ");
        String nombre2 = scanner.nextLine();

        //sortear orden de turno.
        Random random = new Random();
        int numero = random.nextInt(100);
        if (numero <= 49) {
            basquetbolista1.setNombre(nombre2);
            basquetbolista2.setNombre(nombre1);
        } else {
            basquetbolista1.setNombre(nombre1);
            basquetbolista2.setNombre(nombre2);
        }
    }

    private void ingresarTurnos() {
        try {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Ingrese la cantidad de turnos del juego: ");
            cantidadDeTurnos = scanner.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Ingrese un numero");
            ingresarTurnos();
        }
    }

}
