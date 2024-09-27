package ar.edu.unju.escmi.tp4.dominio;

public class Terreno extends Inmueble {
    private double superficie;
    private double latitud;
    private double longitud;

    public Terreno(String codigo, String direccion, double precio, boolean disponible, double superficie, double latitud, double longitud) {
        super(codigo, direccion, precio, disponible);
        this.superficie = superficie;
        this.latitud = latitud;
        this.longitud = longitud;
    }

    @Override
    public void mostrarDatos() {
        System.out.println("Terreno: Código: " + codigo + ", Dirección: " + direccion + ", Superficie: " + superficie + " m2, Precio: " + precio + ", Disponible: " + disponible);
    }

	public double getSuperficie() {
		return superficie;
	}

	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}

	public double getLatitud() {
		return latitud;
	}

	public void setLatitud(double latitud) {
		this.latitud = latitud;
	}

	public double getLongitud() {
		return longitud;
	}

	public void setLongitud(double longitud) {
		this.longitud = longitud;
	}
    
}
