package ar.edu.unju.escmi.tp4.dominio;

public abstract class Inmueble {
    protected String codigo;
    protected String direccion;
    protected double precio;
    protected boolean disponible;

    public Inmueble(String codigo, String direccion, double precio, boolean disponible) {
        this.codigo = codigo;
        this.direccion = direccion;
        this.precio = precio;
        this.disponible = disponible;
    }

    public abstract void mostrarDatos();

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public double getPrecio() {
		return precio;
	}

	public void setPrecio(double precio) {
		this.precio = precio;
	}

	public boolean isDisponible() {
		return disponible;
	}

	public void setDisponible(boolean disponible) {
		this.disponible = disponible;
	}
	
}
