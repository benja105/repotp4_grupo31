package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoCompraVentaTerreno extends Contrato {
    private Terreno terreno;
    private double impuesto;

    public ContratoCompraVentaTerreno(String codigo, LocalDate fechaContrato, Cliente cliente, Inmobiliaria inmobiliaria,
                       Terreno terreno, double impuesto) {
        super(codigo, fechaContrato, cliente, inmobiliaria);
        this.terreno = terreno;
        this.impuesto = impuesto;
    }

    public double montoTotal() {
        return impuesto + terreno.getPrecio();
    }

    @Override
    public void mostrarDatos() {
        System.out.println("\nCódigo del contrato: " + codigo);
        System.out.println("Fecha del contrato: " + fechaContrato);
        System.out.println("DNI del comprador: " + cliente.getDni());
        System.out.println("Nombre de la inmobiliaria: " + inmobiliaria.getNombre());
        System.out.println("Código del terreno: " + terreno.getCodigo());
        System.out.println("Impuesto: " + impuesto);
        System.out.println("Precio total: " + montoTotal());
    }
}
