package AgenteInteligente;

import java.awt.Color;
import java.awt.GridLayout;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Pantalla {
    protected static JFrame pantalla;
    protected static JPanel [][] paneles;
    private JPanel plano, espacio;
    private Ambiente a;
    private Aspiradora agenteA;
    protected static int[][] amb;
    protected static int contarBasura;
    private Color verde;
    Random random = new Random();
    protected static ImageIcon basura, aspiradora;
    protected static JLabel [][] imagenes;
    protected static JLabel aspiradoraI;
    
    public Pantalla(){
        a = new Ambiente();
        pantalla = new JFrame("Agente Aspiradora.");
        plano = new JPanel();
        espacio = new JPanel();
        paneles = new JPanel[40][40];
        for (int i = 0; i < paneles.length; i++) {
            for(int j = 0; j < paneles[i].length; j++){
                paneles[i][j] = new JPanel();
            }
        }
        imagenes = new JLabel[40][40];
        for (int i = 0; i < imagenes.length; i++) {
            for(int j = 0; j < imagenes[i].length; j++){
                imagenes[i][j] = new JLabel();
            }
        }
        amb = new int[40][40];
        verde = new Color(53,169,63);
        contarBasura = 0;
        basura = new ImageIcon("src/imgs/basura.png");
        aspiradora = new ImageIcon("src/imgs/aspiradora.png");
        agenteA = new Aspiradora();
        aspiradoraI = new JLabel();
    }
    
    public void modificar(){
        pantalla.setLayout(null);
        plano.setLayout(new GridLayout(40, 40, 1, 1));
        plano.setBounds(0, 0, 600, 600);
        pantalla.setSize(630, 630);
        pantalla.setLocationRelativeTo(null);
        pantalla.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        pantalla.setResizable(false);
        amb = a.generarMatriz();
        for (int ren = 0; ren < paneles.length; ren++) {
            for(int col = 0; col < paneles[ren].length; col++){
                switch (amb[ren][col]) {
                    case 3:
                        paneles[ren][col].setBackground(Color.LIGHT_GRAY);
                        break;
                    case 0:
                        paneles[ren][col].setBackground(Color.WHITE);
                        paneles[1][1].setBackground(Color.WHITE);
                        amb[ren][col] = random.nextInt(2);
                        if(amb[ren][col] == 1){
                            imagenes[ren][col].setIcon(basura);
                            paneles[ren][col].add(imagenes[ren][col]);
                            contarBasura++;
                        }break;
                    case 2:
                        paneles[ren][col].setBackground(verde);
                        break;
                    default:
                        break;
                }
            }
        }
        aspiradoraI.setIcon(aspiradora);
        paneles[1][1].add(aspiradoraI);
    }
    
    public void armado(){
        for (int ren = 0; ren < paneles.length; ren++) {
            for(int col = 0; col < paneles[ren].length; col++){
                plano.add(paneles[ren][col]);
            }
        }
        pantalla.add(plano);
        pantalla.add(espacio);
    }
    
    public void ejecutar(){
        pantalla.setVisible(true);
        aver();
    }
    
    public void aver(){
        agenteA.comenzar(amb, 1, 1);
    }
    
}
