package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public class ContratoAlquiler {
    private int duracion; // En meses
    private double precio;
    private double gastosInmobiliaria;
    private Cliente cliente;
    private Vivienda vivienda;
    private Inmobiliaria inmobiliaria;
    private LocalDate fechaContrato;

    public ContratoAlquiler(int duracion, double precio, double gastosInmobiliaria, Cliente cliente, Vivienda vivienda, Inmobiliaria inmobiliaria, LocalDate fechaContrato) {
        this.duracion = duracion;
        this.precio = precio;
        this.gastosInmobiliaria = gastosInmobiliaria;
        this.cliente = cliente;
        this.vivienda = vivienda;
        this.inmobiliaria = inmobiliaria;
        this.fechaContrato = fechaContrato;
    }

    public double calcularMontoTotal() {
        return precio + gastosInmobiliaria;
    }

    public void mostrarDatos() {
        System.out.println("Contrato de Alquiler: Duración: " + duracion + " meses, Precio: " + precio + ", Gastos de Inmobiliaria: " + gastosInmobiliaria + ", Monto Total: " + calcularMontoTotal() + ", Fecha Contrato: " + fechaContrato);
    }

	public int getDuracion() {
		return duracion;
	}

	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public double getGastosInmobiliaria() {
		return gastosInmobiliaria;
	}

	public void setGastosInmobiliaria(double gastosInmobiliaria) {
		this.gastosInmobiliaria = gastosInmobiliaria;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Vivienda getVivienda() {
		return vivienda;
	}

	public void setVivienda(Vivienda vivienda) {
		this.vivienda = vivienda;
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
