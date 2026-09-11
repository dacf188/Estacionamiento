package estacionamiento.diegocalderon;

public class MediaJornada extends TipoEstacionamiento{
    private static int contadorMediaJornada = 0;
    double descuento = 0;
    private static double sumaMedia = 0;
    @Override
    public void calcularParqueo() {
        contadorMediaJornada++;
        precio = 15.0;
        descuento = 0.05;
        pagar = precio - (precio * descuento);
        cantidadDescuento = precio * descuento;
        sumatotal += pagar;
        sumaMedia += pagar;
    }
    public static int getContadorMediaJornada (){
        return contadorMediaJornada;
    }
    public static double getSumaMedia (){
        return sumaMedia;
    }
    @Override
    public void imprimir() {
        System.out.println("\nEscogio la opcion 'MEDIA JORNADA'");
        super.imprimir();
    }
}
