package ar.edu.unju.escmi.tp4.main;

import ar.edu.unju.escmi.tp4.dominio.*;
import ar.edu.unju.escmi.tp4.collections.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("Menú de opciones:");
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
            int opcion = scanner.nextInt();

            switch (opcion) {
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
                    realizarAlquiler(scanner);
                    break;
                case 5:
                    realizarVenta(scanner);
                    break;
                case 6:
                    CollectionInmueble.mostrarInmueblesDisponibles();
                    break;
                case 7:
                    CollectionInmueble.mostrarViviendasAlquiladas();
                    break;
                case 8:
                    CollectionInmueble.mostrarTerrenosVendidos();
                    break;
                case 9:
                    salir = true;
                    break;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }

        scanner.close();
    }

    private static void registrarTerreno(Scanner scanner) {
        System.out.println("Ingrese los datos del terreno:");
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Dirección: ");
        String direccion = scanner.next();
        System.out.print("Superficie (en metros cuadrados): ");
        double superficie = scanner.nextDouble();
        System.out.print("Latitud: ");
        double latitud = scanner.nextDouble();
        System.out.print("Longitud: ");
        double longitud = scanner.nextDouble();
        System.out.print("Precio de venta: ");
        double precio = scanner.nextDouble();

        Terreno terreno = new Terreno(codigo, direccion, precio, true, superficie, latitud, longitud);
        CollectionInmueble.agregarInmueble(terreno);

        System.out.println("Terreno registrado con éxito.");
    }

    private static void registrarVivienda(Scanner scanner) {
        System.out.println("Ingrese los datos de la vivienda:");
        System.out.print("Código: ");
        String codigo = scanner.next();
        System.out.print("Dirección: ");
        String direccion = scanner.next();
        System.out.print("Cantidad de habitaciones: ");
        int habitaciones = scanner.nextInt();
        System.out.print("Precio de alquiler mensual: ");
        double alquilerMensual = scanner.nextDouble();
        System.out.print("Precio de venta: ");
        double precio = scanner.nextDouble();

        Vivienda vivienda = new Vivienda(codigo, direccion, precio, true, habitaciones, alquilerMensual);
        CollectionInmueble.agregarInmueble(vivienda);

        System.out.println("Vivienda registrada con éxito.");
    }

    private static void registrarCliente(Scanner scanner) {
        System.out.println("Ingrese los datos del cliente:");
        System.out.print("Nombre: ");
        String nombre = scanner.next();
        System.out.print("Apellido: ");
        String apellido = scanner.next();
        System.out.print("DNI: ");
        String dni = scanner.next();
        System.out.print("Teléfono: ");
        String telefono = scanner.next();
        System.out.print("Dirección: ");
        String direccion = scanner.next();
        System.out.print("Email: ");
        String email = scanner.next();

        Cliente cliente = new Cliente(nombre, apellido, dni, telefono, direccion, email);
        CollectionCliente.agregarCliente(cliente);

        System.out.println("Cliente registrado con éxito.");
    }

    private static void realizarAlquiler(Scanner scanner) {
        System.out.println("Realizar Alquiler de Vivienda:");

        List<Vivienda> viviendasDisponibles = CollectionInmueble.obtenerViviendasDisponibles();
        if (viviendasDisponibles.isEmpty()) {
            System.out.println("No hay viviendas disponibles para alquilar.");
            return;
        }

        System.out.print("Ingrese el DNI del cliente: ");
        String dni = scanner.next();
        Cliente cliente = CollectionCliente.buscarClientePorDNI(dni);
        if (cliente == null) {
            System.out.println("Cliente no encontrado. Debe registrar el cliente primero.");
            return;
        }

        System.out.println("Viviendas disponibles para alquilar:");
        for (int i = 0; i < viviendasDisponibles.size(); i++) {
            System.out.print((i + 1) + ". ");
            viviendasDisponibles.get(i).mostrarDatos();
        }

        System.out.print("Seleccione la vivienda (número): ");
        int indiceVivienda = scanner.nextInt() - 1;
        Vivienda viviendaSeleccionada = viviendasDisponibles.get(indiceVivienda);

        System.out.print("Duración del alquiler (en meses): ");
        int duracion = scanner.nextInt();
        double precio = viviendaSeleccionada.getAlquilerMensual() * duracion;

        System.out.print("Gastos de inmobiliaria: ");
        double gastosInmobiliaria = scanner.nextDouble();

        System.out.print("Nombre de la inmobiliaria: ");
        String nombreInmobiliaria = scanner.next();
        System.out.print("Teléfono de la inmobiliaria: ");
        String telefonoInmobiliaria = scanner.next();
        System.out.print("Dirección de la inmobiliaria: ");
        String direccionInmobiliaria = scanner.next();

        Inmobiliaria inmobiliaria = new Inmobiliaria(nombreInmobiliaria, telefonoInmobiliaria, direccionInmobiliaria);

        ContratoAlquiler contrato = new ContratoAlquiler(duracion, precio, gastosInmobiliaria, cliente, viviendaSeleccionada, inmobiliaria, LocalDate.now());
        viviendaSeleccionada.setDisponible(false); 

        System.out.println("Alquiler realizado con éxito. Datos del contrato:");
        contrato.mostrarDatos();
    }

    private static void realizarVenta(Scanner scanner) {
        System.out.println("Realizar Venta de Terreno:");

        List<Terreno> terrenosDisponibles = CollectionInmueble.obtenerTerrenosDisponibles();
        if (terrenosDisponibles.isEmpty()) {
            System.out.println("No hay terrenos disponibles para vender.");
            return;
        }

        System.out.print("Ingrese el DNI del cliente (comprador): ");
        String dni = scanner.next();
        Cliente comprador = CollectionCliente.buscarClientePorDNI(dni);
        if (comprador == null) {
            System.out.println("Cliente no encontrado. Debe registrar el cliente primero.");
            return;
        }

        System.out.println("Terrenos disponibles para la venta:");
        for (int i = 0; i < terrenosDisponibles.size(); i++) {
            System.out.print((i + 1) + ". ");
            terrenosDisponibles.get(i).mostrarDatos();
        }

        System.out.print("Seleccione el terreno (número): ");
        int indiceTerreno = scanner.nextInt() - 1;
        Terreno terrenoSeleccionado = terrenosDisponibles.get(indiceTerreno);

        System.out.print("Impuestos aplicables (en $): ");
        double impuestos = scanner.nextDouble();

        System.out.print("Nombre de la inmobiliaria: ");
        String nombreInmobiliaria = scanner.next();
        System.out.print("Teléfono de la inmobiliaria: ");
        String telefonoInmobiliaria = scanner.next();
        System.out.print("Dirección de la inmobiliaria: ");
        String direccionInmobiliaria = scanner.next();

        Inmobiliaria inmobiliaria = new Inmobiliaria(nombreInmobiliaria, telefonoInmobiliaria, direccionInmobiliaria);

        ContratoCompraVentaTerreno contrato = new ContratoCompraVentaTerreno(comprador, terrenoSeleccionado, impuestos, inmobiliaria, LocalDate.now());
        terrenoSeleccionado.setDisponible(false);

        System.out.println("Venta realizada con éxito. Datos del contrato:");
        contrato.mostrarDatos();
    }
}
