package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoCompraVentaTerreno {
    private Cliente comprador;
    private Terreno terreno;
    private double impuestos;
    private Inmobiliaria inmobiliaria;
    private LocalDate fechaContrato;

    public ContratoCompraVentaTerreno(Cliente comprador, Terreno terreno, double impuestos, Inmobiliaria inmobiliaria, LocalDate fechaContrato) {
        this.comprador = comprador;
        this.terreno = terreno;
        this.impuestos = impuestos;
        this.inmobiliaria = inmobiliaria;
        this.fechaContrato = fechaContrato;
    }

    public double calcularMontoTotal() {
        return terreno.getPrecio() + impuestos;
    }

    public void mostrarDatos() {
        System.out.println("Contrato de Compra-Venta: Comprador: " + comprador.getNombre() + " " + comprador.getApellido() + ", Terreno Código: " + terreno.getCodigo() + ", Precio: " + terreno.getPrecio() + ", Impuestos: " + impuestos + ", Monto Total: " + calcularMontoTotal() + ", Fecha Contrato: " + fechaContrato);
    }

	public Cliente getComprador() {
		return comprador;
	}

	public void setComprador(Cliente comprador) {
		this.comprador = comprador;
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

	public Inmobiliaria getInmobiliaria() {
		return inmobiliaria;
	}

	public void setInmobiliaria(Inmobiliaria inmobiliaria) {
		this.inmobiliaria = inmobiliaria;
	}

	public LocalDate getFechaContrato() {
		return fechaContrato;
	}

	public void setFechaContrato(LocalDate fechaContrato) {
		this.fechaContrato = fechaContrato;
	}
    
}
