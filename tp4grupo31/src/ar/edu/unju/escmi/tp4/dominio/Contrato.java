package ar.edu.unju.escmi.tp4.dominio;

import java.time.LocalDate;

public abstract class Contrato {
    protected Cliente cliente;
    protected Inmobiliaria inmobiliaria;
    protected LocalDate fechaContrato;

    public Contrato(Cliente cliente, Inmobiliaria inmobiliaria, LocalDate fechaContrato) {
        this.cliente = cliente;
        this.inmobiliaria = inmobiliaria;
        this.fechaContrato = fechaContrato;
    }

    public abstract void mostrarDatos();

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
