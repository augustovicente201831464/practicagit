package com.cunoc.practicagit.ahorcado;

/**
 *
 * @author Augusto Vicente
 */
public class DibujoAhorcado {

    private DibujoAhorcado() {
        dibujo = new char[][]{
            {' ', '|', ' '},
            {' ', 'O', ' '},
            {' ', '|', ' '},
            {'/', '|', '\\'},
            {'/', ' ', '\\'}
        };

        dibujoBase = valorPorDefecto();

        intentosMaximos = cantDeIntentosSegunDibujo();
    }

    public void dibujar(int fila, int col) {
        char c = getDibujo()[fila][col];

        getDibujoBase()[fila + 1][col] = c;
    }

    /*
     * Retorna la fila y columna de la posicion actual a dibujar, después que el jugador haya fallado
     * i = fila
     * j = columna
     *
     */
    public int[] getPosicionFallaActual(int intentosFallidos) {
        int caracteresEncontrados = 0;
        for (int i = 0; i < dibujo.length; i++) {
            for (int j = 0; j < dibujo[i].length; j++) {

                if (dibujo[i][j] != ' ') {
                    caracteresEncontrados++;
                }

                if (intentosFallidos == caracteresEncontrados) {
                    return new int[]{i, j};
                }

            }
        }

        return new int[]{0, 0};
    }

    private int cantDeIntentosSegunDibujo() {
        int caracteresEncontrados = 0;
        for (char[] dibujo1 : dibujo) {
            for (int j = 0; j < dibujo1.length; j++) {
                if (dibujo1[j] != ' ') {
                    caracteresEncontrados++;
                }
            }
        }
        return caracteresEncontrados;
    }

    public void decretarFalla(int intentoFallidos, DibujoAhorcado da) {
        int[] posActual = da.getPosicionFallaActual(intentoFallidos);
        da.setFilaDibujada(posActual[0]);
        da.setColumnaDibujada(posActual[1]);
        da.dibujar(da.getFilaDibujada(), da.getColumnaDibujada());
    }

    public void dibujarPersonaje() {
        for (char[] dibujo1 : dibujo) {
            for (int j = 0; j < dibujo1.length; j++) {
                System.out.print(dibujo1[j]);
            }
            System.out.println();
        }
    }

    public void dibujarAhorca() {
        for (char[] dibujoBase1 : dibujoBase) {
            for (int j = 0; j < dibujoBase1.length; j++) {
                System.out.print(dibujoBase1[j]);
            }
            System.out.println();
        }
    }

    public void resetBase() {
        dibujoBase = valorPorDefecto();
    }

    public static DibujoAhorcado getDibujoAhorcado() {
        return (dibujoAhorcado != null) ? dibujoAhorcado : new DibujoAhorcado();
    }

    public char[][] getDibujo() {
        return dibujo;
    }

    public char[][] getDibujoBase() {
        return dibujoBase;
    }

    private char[][] valorPorDefecto() {
        return new char[][]{
            {'-', '+', '-', '-', '-', '+'},
            {' ', ' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', ' ', '|'},
            {' ', ' ', ' ', ' ', ' ', '|'},
            {'-', '-', '-', '-', '-', '+'}
        };
    }

    public int getIntentosMaximos() {
        return intentosMaximos;
    }

    public int getFilaDibujada() {
        return filaDibujada;
    }

    public int getColumnaDibujada() {
        return columnaDibujada;
    }

    public void setColumnaDibujada(int columnaDibujada) {
        this.columnaDibujada = columnaDibujada;
    }

    public void setFilaDibujada(int filaDibujada) {
        this.filaDibujada = filaDibujada;
    }

    private static DibujoAhorcado dibujoAhorcado;

    private final char[][] dibujo;
    private char[][] dibujoBase;
    private int filaDibujada;
    private int columnaDibujada;

    private final int intentosMaximos;
}
