package estacionamiento.diegocalderon;

public class JornadaCompleta extends TipoEstacionamiento{
    private static int contadorJornada = 0;
    double descuento = 0;
    private static double sumaJornadaCompleta = 0;
    @Override
    public void calcularParqueo() {
        //SE TOMA EN CUENTA UN CONTADOR PARA TOMAR EN CUENTA CUANTOS ESCOGIERON ESTA OPCIÓN
        contadorJornada++;
        //SE PREDEFINE EL PRECIO Y EL DESCUENTO DADOS
        precio = 30.0;
        descuento = 0.10;
        //SE HACEN OPERACIONES
        pagar = precio - (precio * descuento);
        cantidadDescuento = precio * descuento;
        sumatotal += pagar;
        sumaJornadaCompleta += pagar;
    }
    public static int getContadorJornada (){
        return contadorJornada;
    }
    public static double getSumaJornadaCompleta (){
        return sumaJornadaCompleta;
    }
    @Override
    public void imprimir() {
        System.out.println("\nEscogio la opcion 'JORNADA COMPLETA'");
        super.imprimir();
    }
}
