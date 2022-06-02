package ProyectoFinal;

public class Agente {
    private String nombre, estadoA;
    private String [] estado = new String[3];
    private int s;
    
    public Agente(String nombre, String estado1, String estado2){
        this.nombre = nombre;
        estado[0] = estado1;
        estado[1] = estado2;
    }
    
    public Agente(String nombre, String estado1, String estado2, String estado3){
        this.nombre = nombre;
        estado[0] = estado1;
        estado[1] = estado2;
        estado[2] = estado3;
    }
    
    public void setEstado(int es){
        this.estadoA = estado[es];
    }
    
    public String getEstado(){
        return estadoA;
    }
    
    @Override
    public String toString(){
        return nombre + ": " + estadoA;
    }
}
