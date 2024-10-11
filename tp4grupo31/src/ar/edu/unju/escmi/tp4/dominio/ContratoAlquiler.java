package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoAlquiler extends Contrato {
    private double duracion;
    private double gastosInm;
    private Vivienda vivienda;

    public ContratoAlquiler(String codigo, LocalDate fechaContrato, Cliente cliente, Inmobiliaria inmobiliaria,
                            double duracion, double gastosInm, Vivienda vivienda) {
        super(codigo, fechaContrato, cliente, inmobiliaria);
        this.duracion = duracion;
        this.gastosInm = gastosInm;
        this.vivienda = vivienda;
    }

    public double calcularMontoTotal() {
        return vivienda.getPrecio() + gastosInm;
    }

    @Override
    public void mostrarDatos() {
    	
        super.mostrarDatos();

        System.out.println("Duración: " + duracion + " meses");
        System.out.println("Precio de Alquiler: $" + vivienda.getPrecio());
        System.out.println("Gastos de Inmobiliaria: $" + gastosInm);
        System.out.println("Dirección de la Vivienda: " + vivienda.getDireccion());
        System.out.println("Monto Total: $" + calcularMontoTotal());
    }
}
