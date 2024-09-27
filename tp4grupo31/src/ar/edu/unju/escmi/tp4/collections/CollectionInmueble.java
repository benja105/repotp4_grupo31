package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.Inmueble;
import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;

import java.util.ArrayList;
import java.util.List;

public class CollectionInmueble {
    public static List<Inmueble> inmuebles = new ArrayList<>();

    public static void agregarInmueble(Inmueble inmueble) {
        inmuebles.add(inmueble);
    }

    public static List<Vivienda> obtenerViviendasDisponibles() {
        List<Vivienda> viviendasDisponibles = new ArrayList<>();
        for (Inmueble inmueble : inmuebles) {
            if (inmueble instanceof Vivienda && inmueble.isDisponible()) {
                viviendasDisponibles.add((Vivienda) inmueble);
            }
        }
        return viviendasDisponibles;
    }

    public static List<Terreno> obtenerTerrenosDisponibles() {
        List<Terreno> terrenosDisponibles = new ArrayList<>();
        for (Inmueble inmueble : inmuebles) {
            if (inmueble instanceof Terreno && inmueble.isDisponible()) {
                terrenosDisponibles.add((Terreno) inmueble);
            }
        }
        return terrenosDisponibles;
    }

    public static void mostrarInmueblesDisponibles() {
        boolean hayDisponibles = false;
        for (Inmueble inmueble : inmuebles) {
            if (inmueble.isDisponible()) {
                inmueble.mostrarDatos();
                hayDisponibles = true;
            }
        }
        if (!hayDisponibles) {
            System.out.println("No hay inmuebles disponibles.");
        }
    }

    public static void mostrarViviendasAlquiladas() {
        boolean hayAlquiladas = false;
        for (Inmueble inmueble : inmuebles) {
            if (inmueble instanceof Vivienda && !inmueble.isDisponible()) {
                inmueble.mostrarDatos();
                hayAlquiladas = true;
            }
        }
        if (!hayAlquiladas) {
            System.out.println("No hay viviendas alquiladas.");
        }
    }

    public static void mostrarTerrenosVendidos() {
        double montoTotalVentas = 0;
        boolean hayVendidos = false;
        for (Inmueble inmueble : inmuebles) {
            if (inmueble instanceof Terreno && !inmueble.isDisponible()) {
                inmueble.mostrarDatos();
                montoTotalVentas += inmueble.getPrecio();
                hayVendidos = true;
            }
        }
        if (hayVendidos) {
            System.out.println("Monto total de todas las ventas de terrenos: " + montoTotalVentas);
        } else {
            System.out.println("No hay terrenos vendidos.");
        }
    }
}
