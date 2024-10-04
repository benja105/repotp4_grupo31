package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.Contrato;
import java.util.ArrayList;
import java.util.List;

public class CollectionContrato {
    public static List<Contrato> contratos = new ArrayList<>();

    public static void agregarContrato(Contrato contrato) {
        contratos.add(contrato);
    }

    public static void mostrarContratos() {
        if (contratos.isEmpty()) {
            System.out.println("No hay contratos registrados.");
        } else {
            for (Contrato contrato : contratos) {
                contrato.mostrarDatos();
            }
        }
    }
}
