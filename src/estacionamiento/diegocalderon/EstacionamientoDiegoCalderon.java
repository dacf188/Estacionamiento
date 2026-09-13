package estacionamiento.diegocalderon;

import java.util.InputMismatchException;
import java.util.Scanner;

public class EstacionamientoDiegoCalderon {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;
        String patente;

            do {    
                System.out.println("\nIngrese su patente");
                patente = scanner.nextLine();
                if (patente.equalsIgnoreCase("Fin")) {
                    break;
                }
                //SE INDICAN LAS OPCIONES DISPONIBLES PARA EL USUARIO
                TipoEstacionamiento estacionamiento = null;
                try {
                    System.out.println("Ingrese el tipo de estacionamiento");
                    System.out.println("1 = Por hora");
                    System.out.println("2 = Media Jornada");
                    System.out.println("3 = Jornada Completa");
                    opcion = scanner.nextInt();
                    //SE LIMPIA EL BUFFER PARA PERMITIR EL INGRESO DE LOS DEMÁS DATOS
                    scanner.nextLine();
                    estacionamiento = null;
                    switch (opcion) {
                        //SE INDICA UNA OPCIÓN PARA CADA CASO QUE EL USUARIO PUEDA ESCOGER
                        case 1 ->
                            estacionamiento = new PorHora();
                        case 2 ->
                            estacionamiento = new MediaJornada();
                        case 3 ->
                            estacionamiento = new JornadaCompleta();                        
                        default ->
                            System.out.println("Ingrese una opcion valida");
                    }
                } catch (InputMismatchException e) {
                    System.out.println("TIPO DE DATO INVALIDO");
                    scanner.nextLine();
                }
                //SE VERIFICA QUE LA INSTANCIACIÓN ESTÉ CORRECTA
                if (estacionamiento != null) {
                    //SUSTITUYE LA PATENTE USANDO EL SET
                    estacionamiento.setPatente(patente);
                    //INVOCA A LOS MÉTODOS
                    if (estacionamiento.ingresar()) {
                        estacionamiento.calcularParqueo();
                        estacionamiento.imprimir();
                    }
                }
        } while (true);
        System.out.println("\nRESUMEN");
        System.out.println("Cantidad Total de estacionamientos por hora: " + PorHora.getContadorHora());
        System.out.println("Total a pagar por estacionamientos por hora: " + PorHora.getSumaHora());
        System.out.println("_________________________________________________________");
        System.out.println("Cantidad Total de estacionamientos por Media Jornada: " + MediaJornada.getContadorMediaJornada());
        System.out.println("Total a pagar por estacionamientos de Media Jornada: " + MediaJornada.getSumaMedia());
        System.out.println("_________________________________________________________");
        System.out.println("Cantidad Total de estacionamientos por Jornada Completa: " + JornadaCompleta.getContadorJornada());
        System.out.println("Total a pagar por estacionamientos de Jornada Completa: " + JornadaCompleta.getSumaJornadaCompleta());
        System.out.println("_________________________________________________________");
        System.out.println("Suma total que hubo en el dia: " + TipoEstacionamiento.getSumaTotal() + " USD");
    }
}
