package estacionamiento.diegocalderon;

import java.util.InputMismatchException;

public class PorHora extends TipoEstacionamiento{
    //STATIC NOS INDICA QUE ES PROPIO DE LA CLASE
    private static int contadorHora = 0;
    double horas;
    private static double sumahora = 0;
    @Override
    public boolean ingresar (){
        try {
            System.out.println("\nIngrese la cantidad de horas");
            horas = scanner.nextDouble();
            scanner.nextLine();
            return true;
        } catch (InputMismatchException e) {
            System.out.println("TIPO DE DATO INVALIDO");
            scanner.nextLine();
            return false;
        }
    }
    @Override
    public void calcularParqueo() {
        if (horas >= 0.5) {
            precio = 3.0f;
            contadorHora++;
            //SE REDONDEA LA CANTIDAD DE HORAS SI EN CASO EL USUARIO ESCRIBE ALGÚN NÚMERO DECIMAL
            pagar = precio * Math.round(horas);
        } else {
            //SE TOMA EN CUENTA EL MENSAJE AL MOMENTO QUE INGRESE HORAS MENORES A 1
            System.out.println("Ha ingresado una cantidad de horas incorrecta");
        }
        sumahora += pagar;
        sumatotal += pagar;
    }
    //UTILIZAMOS EL GET PARA ADQUIRIR LA CANTIDAD DE PERSONAS QUE HAN ESCOGIDO ESTA OPCION
    public static int getContadorHora (){
        return contadorHora;
    }
    public static double getSumaHora (){
        return sumahora;
    }
    @Override
    public void imprimir() {
        System.out.println("\nEscogio la opcion 'POR HORA'");
        System.out.println("No tiene ningun descuento");
        System.out.println("Cada hora vale " + precio);
        System.out.println("Debera Pagar: " + pagar + " USD");
    }
}
