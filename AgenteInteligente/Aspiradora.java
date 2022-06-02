package AgenteInteligente;

import java.awt.Color;
import java.util.Random;

public class Aspiradora {

    private int contador, pos_x, pos_y;
    private boolean accion;
    private Random r;
    private Ambiente a;

    public Aspiradora() {
        r = new Random();
        a = new Ambiente();
    }

    public void comenzar(int[][] amb, int i, int j) {
        contador = Pantalla.contarBasura;
        pos_x = i;
        pos_y = j;

        while (contador != 0) {
            int pasoR = r.nextInt(4);
            switch (pasoR) {
                case 0:
                    accion = arriba();
                    Pantalla.pantalla.repaint();
                    if (accion == true) {
                        limpiar();
                    }
                    break;
                case 1:
                    accion = abajo();
                    Pantalla.pantalla.repaint();
                    if (accion == true) {
                        limpiar();
                    }
                    break;
                case 2:
                    accion = izquierda();
                    Pantalla.pantalla.repaint();
                    if (accion == true) {
                        limpiar();
                    }
                    break;
                case 3:
                    accion = derecha();
                    Pantalla.pantalla.repaint();
                    if (accion == true) {
                        limpiar();
                    }
                    break;
                default:
                    break;
            }
        }
    }

    public void limpiar() {
        accion = a.aceptar("limpiar", pos_x, pos_y);
        limpiarBasura();
    }

    public boolean arriba() {
        accion = a.aceptar("arriba", pos_x, pos_y);
        if (accion == true) {
            Pantalla.paneles[pos_x][pos_y].remove(Pantalla.aspiradoraI);
            pos_x = pos_x - 1;
            dibujarArriba(pos_x, pos_y);
            return true;
        }
        return false;
    }

    public boolean abajo() {
        accion = a.aceptar("abajo", pos_x, pos_y);
        if (accion == true) {
            Pantalla.paneles[pos_x][pos_y].remove(Pantalla.aspiradoraI);
            pos_x = pos_x + 1;
            dibujarAbajo(pos_x, pos_y);
            return true;
        }
        return false;
    }

    public boolean izquierda() {
        accion = a.aceptar("izquierda", pos_x, pos_y);
        if (accion == true) {
            Pantalla.paneles[pos_x][pos_y].remove(Pantalla.aspiradoraI);
            pos_y = pos_y - 1;
            dibujarIzquierda(pos_x, pos_y);
            return true;
        }
        return false;
    }

    public boolean derecha() {
        accion = a.aceptar("derecha", pos_x, pos_y);
        if (accion == true) {
            Pantalla.paneles[pos_x][pos_y].remove(Pantalla.aspiradoraI);
            pos_y = pos_y + 1;
            dibujarDerecha(pos_x, pos_y);
            return true;
        }
        return false;
    }

    public void limpiarBasura() {
        Pantalla.pantalla.repaint();
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
        }
        Pantalla.paneles[pos_x][pos_y].remove(Pantalla.imagenes[pos_x][pos_y]);
        Pantalla.paneles[pos_x][pos_y].setBackground(Color.white);
    }

    public void dibujarArriba(int x, int y) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
        }
        Pantalla.paneles[x][y].add(Pantalla.aspiradoraI);
    }

    public void dibujarAbajo(int x, int y) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
        }
        Pantalla.paneles[x][y].add(Pantalla.aspiradoraI);
    }

    public void dibujarIzquierda(int x, int y) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
        }
        Pantalla.paneles[x][y].add(Pantalla.aspiradoraI);
    }

    public void dibujarDerecha(int x, int y) {
        try {
            Thread.sleep(10);
        } catch (InterruptedException ex) {
        }
        Pantalla.paneles[x][y].add(Pantalla.aspiradoraI);
    }
}
