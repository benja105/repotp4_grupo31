package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;
import java.util.ArrayList;
import java.util.List;

public class CollectionInmueble { 
    public static List<Terreno> terrenos = new ArrayList<>();
    public static List<Vivienda> viviendas = new ArrayList<>();

    public static void agregarTerreno(Terreno terreno) {
        terrenos.add(terreno);
    }

    public static Terreno buscarTerreno(String codigo) {
        return terrenos.stream()
                .filter(terreno -> terreno.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public static void cambiarEstadoTerreno(String codigo) {
        Terreno terreno = buscarTerreno(codigo);
        if (terreno != null) {
            terreno.setEstado(false);
        }
    }

    public static double calcularMontoTotalVentas() {
        return terrenos.stream()
                .filter(terreno -> !terreno.isEstado())
                .mapToDouble(Terreno::getPrecio)
                .sum();
    }

    public static void agregarVivienda(Vivienda vivienda) {
        viviendas.add(vivienda);
    }

    public static Vivienda buscarVivienda(String codigo) {
        return viviendas.stream()
                .filter(vivienda -> vivienda.getCodigo().equals(codigo))
                .findFirst()
                .orElse(null);
    }

    public static void cambiarEstadoVivienda(String codigo) {
        Vivienda vivienda = buscarVivienda(codigo);
        if (vivienda != null) {
            vivienda.setEstado(false);
        }
    }
}
