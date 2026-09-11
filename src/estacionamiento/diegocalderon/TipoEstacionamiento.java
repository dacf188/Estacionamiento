package estacionamiento.diegocalderon;

import java.util.Scanner;

public abstract class TipoEstacionamiento {
    static Scanner scanner = new Scanner(System.in);
    protected String patente;
    protected double precio;
    protected double pagar;
    protected double cantidadDescuento;
    //PERMANECE ACTIVO MIENTRAS SE EJECUTA
    protected static double sumatotal = 0;
    
    public TipoEstacionamiento (){
        this.patente = "";
        this.precio = 0;
    }
    public TipoEstacionamiento (String patente, double precio){
        this.patente = patente;
        this.precio = precio;
    }
    public String getPatente (){
        return patente;
    }
    public void setPatente (String patente){
        this.patente = patente;
    }
    public double getPrecio (){
        return precio;
    }
    public void setPrecio (double precio){
        this.precio = precio;
    }
    public static double getSumaTotal (){
        return sumatotal;
    }
    public boolean ingresar() {
        //SE DEJA DE ESA MANERA YA QUE SOLAMENTE PORHORA ES EL QUE AÑADE OTRA VALIDACIÓN
        return true;
    }
    public abstract void calcularParqueo ();
    
    public void imprimir (){
        System.out.println("Tiene un precio de: " + precio);
        System.out.println("Se le hizo un descuento de: " + cantidadDescuento);
        System.out.println("Debera Pagar: " + pagar + " USD");
    }
}
