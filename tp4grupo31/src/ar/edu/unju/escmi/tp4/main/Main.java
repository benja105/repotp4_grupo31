package ar.edu.unju.escmi.tp4.main;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

import ar.edu.unju.escmi.tp4.collections.CollectionCliente;
import ar.edu.unju.escmi.tp4.collections.CollectionContrato;
import ar.edu.unju.escmi.tp4.collections.CollectionInmueble;
import ar.edu.unju.escmi.tp4.dominio.Cliente;
import ar.edu.unju.escmi.tp4.dominio.ContratoAlquiler;
import ar.edu.unju.escmi.tp4.dominio.ContratoCompraVentaTerreno;
import ar.edu.unju.escmi.tp4.dominio.Inmobiliaria;
import ar.edu.unju.escmi.tp4.dominio.Terreno;
import ar.edu.unju.escmi.tp4.dominio.Vivienda;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opc;

        do {
            mostrarMenu();
            opc = scanner.nextInt();
            scanner.nextLine(); // Consumir salto de línea

            switch (opc) {
                case 1:
                    registrarTerreno(scanner);
                    break;
                case 2:
                    registrarVivienda(scanner);
                    break;
                case 3:
                    registrarCliente(scanner);
                    break;
                case 4:
                    realizarAlquilerVivienda(scanner);
                    break;
                case 5:
                    realizarVentaTerreno(scanner);
                    break;
                case 6:
                    consultarInmueblesDisponibles(scanner);
                    break;
                case 7:
                    consultarViviendasAlquiladas();
                    break;
                case 8:
                    consultarTerrenosVendidos();
                    break;
                case 9:
                    System.out.println("\n***** SALIENDO DEL MENÚ *****\n");
                    break;
                default:
                    System.out.println("\nOPCIÓN INVÁLIDA. Inténtelo nuevamente.\n");
            }
        } while (opc != 9);

        scanner.close();
    }

    private static void mostrarMenu() {
        System.out.println("******** MENÚ ******** ");
        System.out.println("1. Registrar terreno");
        System.out.println("2. Registrar vivienda");
        System.out.println("3. Registrar cliente");
        System.out.println("4. Alquiler de vivienda");
        System.out.println("5. Venta de terreno");
        System.out.println("6. Consultar inmuebles disponibles");
        System.out.println("7. Consultar viviendas alquiladas");
        System.out.println("8. Consultar terrenos vendidos");
        System.out.println("9. Salir");
        System.out.print("Seleccione una opción: ");
    }

    private static void realizarAlquilerVivienda(Scanner scanner) {
        List<Vivienda> viviendasDisponibles = CollectionInmueble.viviendas.stream()
                .filter(Vivienda::isEstado)
                .toList();

        if (viviendasDisponibles.isEmpty()) {
            System.out.println("No hay viviendas disponibles para alquilar.");
            return;
        }

        viviendasDisponibles.forEach(Vivienda::mostrarDatos);
        System.out.print("\nSeleccione el código de la vivienda que desea alquilar: ");
        String codVivienda = scanner.nextLine();

        Cliente inquilino = seleccionarCliente(scanner, "inquilino");
        Vivienda viviendaSeleccionada = CollectionInmueble.buscarVivienda(codVivienda);

        if (inquilino != null && viviendaSeleccionada != null) {
            ContratoAlquiler contrato = crearContratoAlquiler(scanner, inquilino, viviendaSeleccionada);
            CollectionContrato.agregarContratoAlquiler(contrato);
            CollectionInmueble.cambiarEstadoVivienda(codVivienda);

            System.out.println("\nCONTRATO DE ALQUILER REALIZADO CORRECTAMENTE");
            contrato.mostrarDatos();
        } else {
            System.out.println("\nERROR AL REALIZAR EL CONTRATO\n");
        }
    }

    private static ContratoAlquiler crearContratoAlquiler(Scanner scanner, Cliente inquilino, Vivienda vivienda) {
        System.out.print("\nIngrese el nombre de la inmobiliaria: ");
        String nombreInm = scanner.nextLine();

        System.out.print("Ingrese el teléfono de la inmobiliaria: ");
        int telefonoInm = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la dirección de la inmobiliaria: ");
        String direccionInm = scanner.nextLine();

        Inmobiliaria inmobiliaria = new Inmobiliaria(nombreInm, telefonoInm, direccionInm);

        System.out.print("\nIngrese el código del contrato de alquiler: ");
        String codContrato = scanner.nextLine();

        System.out.print("Ingrese la duración del contrato (en meses): ");
        double duracionContrato = scanner.nextDouble();

        System.out.print("Ingrese los gastos de la inmobiliaria: ");
        double gastosInm = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea

        return new ContratoAlquiler(codContrato, LocalDate.now(), inquilino, inmobiliaria, duracionContrato, gastosInm, vivienda);
    }

    private static void realizarVentaTerreno(Scanner scanner) {
        List<Terreno> terrenosDisponibles = CollectionInmueble.terrenos.stream()
                .filter(Terreno::isEstado)
                .toList();

        if (terrenosDisponibles.isEmpty()) {
            System.out.println("No hay terrenos disponibles para vender.");
            return;
        }

        terrenosDisponibles.forEach(Terreno::mostrarDatos);
        System.out.print("\nSeleccione el terreno a vender: ");
        String codTerreno = scanner.nextLine();

        Cliente comprador = seleccionarCliente(scanner, "comprador");
        Terreno terrenoSeleccionado = CollectionInmueble.buscarTerreno(codTerreno);

        if (comprador != null && terrenoSeleccionado != null) {
        	ContratoCompraVentaTerreno contrato = crearContratoVenta(scanner, comprador, terrenoSeleccionado);
            CollectionContrato.agregarContratoCVT(contrato);
            CollectionInmueble.cambiarEstadoTerreno(codTerreno);

            System.out.println("\nCONTRATO DE VENTA REALIZADO CORRECTAMENTE");
            contrato.mostrarDatos();
        } else {
            System.out.println("\nERROR AL REALIZAR EL CONTRATO\n");
        }
    }

    private static ContratoCompraVentaTerreno crearContratoVenta(Scanner scanner, Cliente comprador, Terreno terreno) {
        System.out.print("\nIngrese el nombre de la inmobiliaria: ");
        String nombreInm = scanner.nextLine();

        System.out.print("Ingrese el teléfono de la inmobiliaria: ");
        int telefonoInm = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Ingrese la dirección de la inmobiliaria: ");
        String direccionInm = scanner.nextLine();

        Inmobiliaria inmobiliaria = new Inmobiliaria(nombreInm, telefonoInm, direccionInm);

        System.out.print("\nIngrese el código del contrato de venta: ");
        String codContrato = scanner.nextLine();

        System.out.print("Ingrese los impuestos: ");
        double impuestos = scanner.nextDouble();
        scanner.nextLine(); // Consumir salto de línea

        return new ContratoCompraVentaTerreno(codContrato, LocalDate.now(), comprador, inmobiliaria, terreno, impuestos);
    }

    private static Cliente seleccionarCliente(Scanner scanner, String tipoCliente) {
        List<Cliente> clientes = CollectionCliente.clientes;
        clientes.forEach(Cliente::mostrarDatos);

        System.out.printf("\nSeleccione el DNI del %s: ", tipoCliente);
        String dni = scanner.nextLine();
        return CollectionCliente.buscarClientePorDNI(dni);
    }

    private static void consultarInmueblesDisponibles(Scanner scanner) {
        System.out.println("\n1. Consultar Viviendas");
        System.out.println("2. Consultar Terrenos");
        int op = scanner.nextInt();
        scanner.nextLine();

        if (op == 1) {
            List<Vivienda> viviendas = CollectionInmueble.viviendas.stream()
                    .filter(Vivienda::isEstado)
                    .toList();
            viviendas.forEach(Vivienda::mostrarDatos);
        } else if (op == 2) {
            List<Terreno> terrenos = CollectionInmueble.terrenos.stream()
                    .filter(Terreno::isEstado)
                    .toList();
            terrenos.forEach(Terreno::mostrarDatos);
        } else {
            System.out.println("\nOpción inválida.");
        }
    }

    private static void consultarViviendasAlquiladas() {
        System.out.println("\nViviendas alquiladas:");
        List<Vivienda> viviendasAlquiladas = CollectionInmueble.viviendas.stream()
                .filter(v -> !v.isEstado())
                .toList();
        viviendasAlquiladas.forEach(Vivienda::mostrarDatos);
    }

    private static void consultarTerrenosVendidos() {
        System.out.println("\nTerrenos vendidos:");
        List<Terreno> terrenosVendidos = CollectionInmueble.terrenos.stream()
                .filter(t -> !t.isEstado())
                .toList();
        terrenosVendidos.forEach(Terreno::mostrarDatos);

        double montoTotalVentas = CollectionInmueble.calcularMontoTotalVentas();
        System.out.printf("Monto total de todas las ventas: %.2f\n", montoTotalVentas);
    }

    private static void registrarTerreno(Scanner scanner) {
		System.out.println("\nINGRESE LOS DATOS DEL TERRENO");
        
		System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        
        System.out.print("Precio de venta: ");
        double precio = scanner.nextDouble();
        
        System.out.print("Latitud: ");
        double latitud = scanner.nextDouble();
        
        System.out.print("Longitud: ");
        double longitud = scanner.nextDouble();
        
        System.out.print("Superficie (m²): ");
        double superficie = scanner.nextDouble();
        scanner.nextLine();  
        
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();
        scanner.nextLine(); 
    
        Terreno terreno = new Terreno(codigo, precio, latitud, longitud, superficie, disponible);
        CollectionInmueble.agregarTerreno(terreno);
        
        System.out.println("\nTerreno agregado correctamente");
        terreno.mostrarDatos();
    }

    private static void registrarVivienda(Scanner scanner) {
		System.out.println("\nINGRESE LOS DATOS DE LA VIVIENDA");
        
		System.out.print("Codigo: ");
        String codigo = scanner.nextLine();
        
        System.out.print("Precio de alquiler mensual: ");
        double precioAlquiler = scanner.nextDouble();
        scanner.nextLine();  
        
        System.out.print("Dirección: ");
        String direccion = scanner.nextLine();
        
        System.out.print("Cantidad de habitaciones: ");
        int cantidadHabitaciones = scanner.nextInt();
        
        System.out.print("¿Está disponible? (true/false): ");
        boolean disponible = scanner.nextBoolean();
        scanner.nextLine(); 

        Vivienda vivienda = new Vivienda(codigo, precioAlquiler, direccion, cantidadHabitaciones, disponible);
        CollectionInmueble.agregarVivienda(vivienda);
        
        System.out.println("\nVivienda agregada correctamente");
        vivienda.mostrarDatos();
	}

    private static void registrarCliente(Scanner scanner) {
		System.out.println("\nINGRESE LOS DATOS DEL CLIENTE");
		
    	System.out.print("Ingrese el nombre del cliente:");
        String nombre = scanner.next();
        
        System.out.print("Ingrese el apellido del cliente:");
        String apellido = scanner.next();
        
        System.out.print("Ingrese el DNI del cliente:");
        String dni = scanner.next();
        
        System.out.print("Ingrese el teléfono del cliente:");
        String telefono = scanner.next();
        
        System.out.print("Ingrese la dirección del cliente:");
        String direccion = scanner.next();
        
        System.out.print("Ingrese el email del cliente:");
        String email = scanner.next();

        Cliente cliente = new Cliente(nombre, apellido, dni, telefono, direccion, email);
        CollectionCliente.agregarCliente(cliente);
        
        System.out.println("\nCliente agregado correctamente");
        cliente.mostrarDatos();
	}
}
