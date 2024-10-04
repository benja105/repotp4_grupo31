package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoCompraVentaTerreno extends Contrato {
    private Terreno terreno;
    private double impuestos;

    public ContratoCompraVentaTerreno(Cliente cliente, Terreno terreno, double impuestos, Inmobiliaria inmobiliaria, LocalDate fechaContrato) {
        super(cliente, inmobiliaria, fechaContrato);
        this.terreno = terreno;
        this.impuestos = impuestos;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Contrato de Compra-Venta: Comprador: " + cliente.getNombre() + " " + cliente.getApellido() + ", Terreno Código: " + terreno.getCodigo() + ", Precio: " + terreno.getPrecio() + ", Impuestos: " + impuestos + ", Monto Total: " + (terreno.getPrecio() + impuestos) + ", Fecha Contrato: " + fechaContrato);
    }

	public Terreno getTerreno() {
		return terreno;
	}

	public void setTerreno(Terreno terreno) {
		this.terreno = terreno;
	}

	public double getImpuestos() {
		return impuestos;
	}

	public void setImpuestos(double impuestos) {
		this.impuestos = impuestos;
	}
	
}
