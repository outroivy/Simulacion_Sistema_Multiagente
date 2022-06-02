package ProyectoFinal;

import java.util.Random;

public final class Ambiente {
    static Agente[] agentes;
    private Random r;
    private int i = 0;
    
    public Ambiente(){
        r = new Random();
        agentes = new Agente[]{new Agente("Sensor de apertura forzada","Inactivo","Activo"),  new Agente("Sensor de movimientos por infrarrojos","Inactivo","Activo"),
                               new Agente("Sensor de luz","Bajo","Alto"),                     new Agente("Detector de humo","Inactivo","Activo"),
                               new Agente("Sensor de temperatura","Bajo","Alto"),             new Agente("Sensor de persianas","Inactivo","Activo"),
                               new Agente("Alarma","Inactivo","Activo"),                      new Agente("Aire acondicionado","Modo frío","Modo calor"),
                               new Agente("Persianas","Cerradas","Inclinadas","Abiertas"),    new Agente("Cerradura inteligente","Inactiva","Activa"),
                               new Agente("Focos inteligentes","Apagado","Encendido")};
        this.inicioAmbiente();
    }
    
    public void inicioAmbiente(){
        agentes[0].setEstado(1);
        for (int i = 1; i < agentes.length; i++) {
            agentes[i].setEstado(0);
        }
    }
    
    public void definirReglasAmbiente(){
        i++;
        
        do{
            if(i == 1){
                if("Activo".equals(agentes[0].getEstado())){
                agentes[1].setEstado(1);
                agentes[2].setEstado(r.nextInt(2));
                agentes[4].setEstado(r.nextInt(2));
                agentes[9].setEstado(1);
                break;
                }
            }if(i == 2){
                if("Bajo".equals(agentes[4].getEstado())){
                    agentes[7].setEstado(1);
                }if("Alto".equals(agentes[4].getEstado())){
                    agentes[7].setEstado(0);
                }if("Bajo".equals(agentes[2].getEstado())){
                    agentes[10].setEstado(0);
                }if("Alto".equals(agentes[2].getEstado())){
                    agentes[10].setEstado(1);
                    agentes[8].setEstado(1);
                }if("Bajo".equals(agentes[2].getEstado()) || "Inactivo".equals(agentes[1].getEstado()) || "Inactivo".equals(agentes[0].getEstado())){
                    agentes[8].setEstado(2);
                }if("Inactivo".equals(agentes[1].getEstado()) || "Inactivo".equals(agentes[0].getEstado())){
                    agentes[8].setEstado(0);
                }if("Activa".equals(agentes[9].getEstado())){
                    agentes[3].setEstado(1);
                    agentes[5].setEstado(1);
                }break;
            }if(i == 3){
                if("Activo".equals(agentes[1].getEstado()) || "Activo".equals(agentes[0].getEstado()) || "Activo".equals(agentes[3].getEstado())){
                    agentes[6].setEstado(1);
                }i = 0;break;
            }
        }while(true);
    }
    
}
