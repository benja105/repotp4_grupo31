package ar.edu.unju.escmi.tp4.dominio;

public class Vivienda extends Inmueble {
    private int habitaciones;
    private double alquilerMensual;

    public Vivienda(String codigo, String direccion, double precio, boolean disponible, int habitaciones, double alquilerMensual) {
        super(codigo, direccion, precio, disponible);
        this.habitaciones = habitaciones;
        this.alquilerMensual = alquilerMensual;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Vivienda: Código: " + codigo + ", Dirección: " + direccion + ", Habitaciones: " + habitaciones + ", Alquiler Mensual: " + alquilerMensual + ", Disponible: " + disponible);
    }

	public int getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(int habitaciones) {
		this.habitaciones = habitaciones;
	}

	public double getAlquilerMensual() {
		return alquilerMensual;
	}

	public void setAlquilerMensual(double alquilerMensual) {
		this.alquilerMensual = alquilerMensual;
	}
	
}
