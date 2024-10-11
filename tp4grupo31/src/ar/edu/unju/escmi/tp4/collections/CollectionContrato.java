package ar.edu.unju.escmi.tp4.collections;

import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCompraVentaTerreno;
import java.util.ArrayList;
import java.util.List;

public class CollectionContrato { 
    private static List<ContratoCompraVentaTerreno> contratosCVT = new ArrayList<>();
    private static List<ContratoAlquiler> contratosAlquiler = new ArrayList<>();

    public static void agregarContratoCVT(ContratoCompraVentaTerreno contratoCVT) {
        contratosCVT.add(contratoCVT);
    }

    public static void agregarContratoAlquiler(ContratoAlquiler contrato) {
        contratosAlquiler.add(contrato);
    }
}
