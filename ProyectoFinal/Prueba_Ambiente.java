package ProyectoFinal;

public class Prueba_Ambiente {

    public static void main(String[] args) {
        Ambiente a = new Ambiente();

        for (int i = 0; i < 5; i++) {
            System.out.println("    Iteración " + (i + 1) + ": \n");
            a.definirReglasAmbiente();

            for (Agente agente : Ambiente.agentes) {
                System.out.println(agente.toString());
            }

            System.out.println("\n");
        }
    }

}
