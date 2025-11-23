package SmartGymApp;

import java.util.*;
import java.time.*;
import java.time.format.*;
// ======== CLASE PRINCIPAL ========
public class SmartGymApp {
    private static Scanner sc = new Scanner(System.in);
    private static ArrayList<Cliente> clientes = new ArrayList<>();
    private static ArrayList<Entrenador> entrenadores = new ArrayList<>();
    private static ArrayList<Reserva> reservas = new ArrayList<>();

    private static final LocalTime[] TURNOS_DISPONIBLES = {
        LocalTime.of(8, 0),   // Mañana: 08:00 - 10:00
        LocalTime.of(10, 0),  // Mañana: 10:00 - 12:00
        LocalTime.of(14, 0),  // Tarde:  14:00 - 16:00
        LocalTime.of(16, 0)   // Tarde:  16:00 - 18:00
    };

    public static void main(String[] args) {
        int opcion = 0;
        boolean continuar = true;

        while (continuar) {
            mostrarMenu();
            try {
                System.out.print("Seleccione una opción: ");
                opcion = sc.nextInt();
                sc.nextLine();

                switch (opcion) {
    case 1 -> registrarCliente();
    case 2 -> registrarEntrenador();
    case 3 -> agendarReserva();
    case 4 -> verReservas();
    case 5 -> historialPorCliente();
    case 6 -> historialPorEntrenador();
    case 7 -> relacionClientes();
    case 8 -> relacionEntrenadores();
    case 9 -> verDisponibilidadCompleta();
    case 10 -> {  
        System.out.println("Saliendo del sistema... ¡Gracias por usar SmartGym!");
        continuar = false;
    }
    default -> System.out.println("Opción no válida. Intente nuevamente.");
}
            } catch (InputMismatchException e) {
                System.out.println("Error: Debe ingresar un número entre 1 y 9.");
                sc.nextLine();
            } catch (Exception e) {
                System.out.println("Ocurrió un error inesperado: " + e.getMessage());
            }
        }
    }

    private static void mostrarMenu() {
        System.out.println("\n========= SISTEMA DE RESERVAS SMARTGYM =========");
        System.out.println("1. Registrar Cliente");
        System.out.println("2. Registrar Entrenador");
        System.out.println("3. Agendar Reserva");
        System.out.println("4. Ver Todas las Reservas");
        System.out.println("5. Historial por Cliente");
        System.out.println("6. Historial por Entrenador");
        System.out.println("7. Relación de Clientes");
        System.out.println("8. Relación de Entrenadores");
        System.out.println("9. Ver Disponibilidad Completa-Entrenadores");
        System.out.println("10. Salir del Sistema");
        System.out.println("================================================");
    }

    // ==== MÉTODOS ====
    private static void registrarCliente() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         REGISTRO DE CLIENTE        ║");
        System.out.println("╚════════════════════════════════════╝");

        System.out.print("Nombre del cliente: ");
        String nombre = sc.nextLine();
        int edad = leerEntero("Edad: ");
        System.out.print("Correo: ");
        String correo = sc.nextLine();

        Cliente cliente = new Cliente(nombre, edad, correo);
        clientes.add(cliente);

        System.out.println("\n╔══════════════════════════════════════════════╗");
        System.out.println("║ Cliente registrado correctamente             ║");
        System.out.println("╚══════════════════════════════════════════════╝");
        System.out.println("ID Asignado: " + cliente.getIdCliente());
    }

    private static void registrarEntrenador() {
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║       REGISTRO DE ENTRENADOR       ║");
        System.out.println("╚════════════════════════════════════╝");

        System.out.print("Nombre del entrenador: ");
        String nombre = sc.nextLine();
        int edad = leerEntero("Edad: ");
        System.out.print("Correo: ");
        String correo = sc.nextLine();
        System.out.print("Especialidad: ");
        String especialidad = sc.nextLine();

        Entrenador entrenador = new Entrenador(nombre, edad, correo, especialidad);
        entrenadores.add(entrenador);

        System.out.println("\nEntrenador registrado correctamente.");
        System.out.println("ID Asignado: " + entrenador.getIdEntrenador());
    }

    private static void agendarReserva() {
    System.out.println("\n╔════════════════════════════════════╗");
    System.out.println("║         AGENDAR RESERVA            ║");
    System.out.println("╚════════════════════════════════════╝");

    // 1. Seleccionar cliente
    System.out.print("Ingrese ID del Cliente: ");
    String idCliente = sc.nextLine().toUpperCase();
    Cliente cliente = buscarCliente(idCliente);
    if (cliente == null) {
        System.out.println(" Cliente no encontrado.");
        return;
    }

    // 2. Seleccionar entrenador
    System.out.print("Ingrese ID del Entrenador: ");
    String idEntrenador = sc.nextLine().toUpperCase();
    Entrenador entrenador = buscarEntrenador(idEntrenador);
    if (entrenador == null) {
        System.out.println(" Entrenador no encontrado.");
        return;
    }

    try {
        // 3. Seleccionar fecha
        System.out.print("Fecha (DD-MM-AAAA): ");
        String fechaStr = sc.nextLine();
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaStr, dateFormatter);

        // 4. Mostrar turnos disponibles
        System.out.println("\n╔════════════════════════════════════╗");
        System.out.println("║         TURNOS DISPONIBLES         ║");
        System.out.println("╚════════════════════════════════════╝");
        
        System.out.println("1.  Mañana: 08:00 - 10:00");
        System.out.println("2.  Mañana: 10:00 - 12:00"); 
        System.out.println("3.  Tarde:  14:00 - 16:00");
        System.out.println("4.  Tarde:  16:00 - 18:00");
        
        System.out.print("\nSeleccione el turno (1-4): ");
        int opcionTurno = sc.nextInt();
        sc.nextLine();  // Limpiar buffer
        
        if (opcionTurno < 1 || opcionTurno > 4) {
            System.out.println(" Opción de turno inválida.");
            return;
        }
        
        LocalTime horaSeleccionada = TURNOS_DISPONIBLES[opcionTurno - 1];
        Reserva.Horario nuevoHorario = new Reserva.Horario(fecha, horaSeleccionada);

        // 5.  MEJORADO: Validar que no hay superposición
        boolean haySuperposicion = false;
        for (Reserva r : reservas) {
            if (r.getEntrenador().equals(entrenador) && 
                r.getHorario().seSuperponeCon(nuevoHorario)) {
                haySuperposicion = true;
                System.out.println(" El entrenador ya tiene reserva en ese horario:");
                System.out.println("    " + r.getHorario().toString());
                System.out.println("    Cliente: " + r.getCliente().getNombre());
                break;
            }
        }
        
        if (haySuperposicion) {
            return;
        }

        // 6. Comentario y confirmación
        System.out.print("Comentario (opcional): ");
        String comentario = sc.nextLine();

        // 7. Crear reserva
        Reserva reserva = new Reserva(cliente, entrenador, nuevoHorario, comentario);
        reservas.add(reserva);
        
        System.out.println("\n Reserva agendada correctamente!");
        System.out.println(" ID Reserva: " + reserva.getIdReserva());
        System.out.println(" Cliente: " + cliente.getNombre());
        System.out.println(" Entrenador: " + entrenador.getNombre());
        System.out.println(" Fecha: " + fecha.format(dateFormatter));
        System.out.println(" Turno: " + horaSeleccionada + " - " + nuevoHorario.getHoraFin());
        
    } catch (DateTimeParseException e) {
        System.out.println(" Formato de fecha inválido. Use: DD-MM-AAAA");
    } catch (Exception e) {
        System.out.println(" Error: " + e.getMessage());
    }
}

private static void verDisponibilidadCompleta() {
    System.out.print("Ingrese ID del Entrenador: ");
    String idEntrenador = sc.nextLine().toUpperCase();
    Entrenador entrenador = buscarEntrenador(idEntrenador);
    if (entrenador == null) {
        System.out.println(" Entrenador no encontrado.");
        return;
    }

    System.out.print("Fecha a consultar (DD-MM-AAAA): ");
    String fechaStr = sc.nextLine();
    
    try {
        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate fecha = LocalDate.parse(fechaStr, dateFormatter);
        
        System.out.println("\n╔══════════════════════════════════════════════════════╗");
        System.out.printf("║    DISPONIBILIDAD COMPLETA - %-20s ║%n", entrenador.getNombre().toUpperCase());
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println(" Fecha: " + fecha.format(dateFormatter));
        System.out.println(" Especialidad: " + entrenador.getEspecialidad());
        System.out.println("\n ESTADO DE TURNOS:");
        
        for (int i = 0; i < TURNOS_DISPONIBLES.length; i++) {
            LocalTime turno = TURNOS_DISPONIBLES[i];
            Reserva.Horario horarioConsulta = new Reserva.Horario(fecha, turno);
            boolean ocupado = false;
            String clienteOcupante = "";
            
            // Verificar si el turno está ocupado
            for (Reserva r : reservas) {
                if (r.getEntrenador().equals(entrenador) && 
                    r.getHorario().seSuperponeCon(horarioConsulta)) {
                    ocupado = true;
                    clienteOcupante = r.getCliente().getNombre();
                    break;
                }
            }
            
            String estado = ocupado ? " OCUPADO" : " LIBRE";
            String descripcion = (i < 2) ? "Mañana" : "Tarde";
            String infoCliente = ocupado ? " (por " + clienteOcupante + ")" : "";
            
            System.out.printf("%d.  %s - %s (%s) %s %s%n", 
                i + 1, 
                turno,
                horarioConsulta.getHoraFin(),
                descripcion, 
                estado,
                infoCliente);
        }
        
        //  RESUMEN
        long turnosLibres = java.util.Arrays.stream(TURNOS_DISPONIBLES)
            .filter(turno -> {
                Reserva.Horario horario = new Reserva.Horario(fecha, turno);
                return reservas.stream().noneMatch(r -> 
                    r.getEntrenador().equals(entrenador) && 
                    r.getHorario().seSuperponeCon(horario));
            })
            .count();
            
        System.out.println("\n RESUMEN:");
        System.out.println(" Turnos libres: " + turnosLibres + "/" + TURNOS_DISPONIBLES.length);
        System.out.println(" Turnos ocupados: " + (TURNOS_DISPONIBLES.length - turnosLibres) + "/" + TURNOS_DISPONIBLES.length);
        
    } catch (DateTimeParseException e) {
        System.out.println(" Formato de fecha inválido.");
    }
}
    private static void verReservas() {
        System.out.println("\n╔══════════════════════════════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                                     LISTADO DE RESERVAS                                      ║");
        System.out.println("╚══════════════════════════════════════════════════════════════════════════════════════════════╝");
        System.out.printf("%-8s | %-25s | %-25s | %-20s | %-20s%n",
                "ID", "Cliente (ID)", "Entrenador (ID)", "Fecha y Hora", "Comentario");
        System.out.println("--------------------------------------------------------------------------------------------------------------");
        for (Reserva r : reservas) {
            System.out.println(r);
        }
    }

    private static void historialPorCliente() {
        System.out.print("Ingrese ID del Cliente: ");
        String idCliente = sc.nextLine().toUpperCase();
        Cliente cliente = buscarCliente(idCliente);
        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ HISTORIAL DE RESERVAS DEL CLIENTE: %-34s ║%n", cliente.getNombre());
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");

        System.out.printf("%-8s | %-28s | %-25s | %-20s%n",
                "ID", "Cliente (ID)", "Entrenador (ID)", "Fecha y Hora");
        System.out.println("---------------------------------------------------------------------------------------");

        boolean tieneReservas = false;
        for (Reserva r : reservas) {
            if (r.getCliente().equals(cliente)) {
                System.out.printf("%-8s | %-28s | %-25s | %-20s%n",
                        r.getIdReserva(),
                        r.getCliente().getNombre() + " (" + r.getCliente().getIdCliente() + ")",
                        r.getEntrenador().getNombre() + " (" + r.getEntrenador().getIdEntrenador() + ")",
                        r.getHorario().toString());
                tieneReservas = true;
            }
        }

        if (!tieneReservas) {
            System.out.println("No se encontraron reservas para este cliente.");
        }
    }

    private static void historialPorEntrenador() {
        System.out.print("Ingrese ID del Entrenador: ");
        String idEntrenador = sc.nextLine().toUpperCase();
        Entrenador entrenador = buscarEntrenador(idEntrenador);
        if (entrenador == null) {
            System.out.println("Entrenador no encontrado.");
            return;
        }

        System.out.println("\n╔════════════════════════════════════════════════════════════════════════╗");
        System.out.printf("║ HISTORIAL DE RESERVAS DEL ENTRENADOR: %-30s ║%n", entrenador.getNombre());
        System.out.println("╚════════════════════════════════════════════════════════════════════════╝");

        System.out.printf("%-8s | %-28s | %-25s | %-20s%n",
                "ID", "Cliente (ID)", "Entrenador (ID)", "Fecha y Hora");
        System.out.println("---------------------------------------------------------------------------------------");

        boolean tieneReservas = false;
        for (Reserva r : reservas) {
            if (r.getEntrenador().equals(entrenador)) {
                System.out.printf("%-8s | %-28s | %-25s | %-20s%n",
                        r.getIdReserva(),
                        r.getCliente().getNombre() + " (" + r.getCliente().getIdCliente() + ")",
                        r.getEntrenador().getNombre() + " (" + r.getEntrenador().getIdEntrenador() + ")",
                        r.getHorario().toString());
                tieneReservas = true;
            }
        }

        if (!tieneReservas) {
            System.out.println("No se encontraron reservas para este entrenador.");
        }
    }

    private static void relacionClientes() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                        RELACIÓN DE CLIENTES                         ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.printf("%-10s | %-25s | %-5s | %-25s%n", "ID", "Nombre", "Edad", "Correo");
        System.out.println("-----------------------------------------------------------------------");
        clientes.forEach(System.out::println);
    }

    private static void relacionEntrenadores() {
        System.out.println("\n╔════════════════════════════════════════════════════════════════════╗");
        System.out.println("║                      RELACIÓN DE ENTRENADORES                      ║");
        System.out.println("╚════════════════════════════════════════════════════════════════════╝");
        System.out.printf("%-10s | %-20s | %-5s | %-25s | %-15s%n",
                "ID", "Nombre", "Edad", "Correo", "Especialidad");
        System.out.println("----------------------------------------------------------------------------------");
        entrenadores.forEach(System.out::println);
    }

    // ==== MÉTODOS AUXILIARES ====
    private static Cliente buscarCliente(String id) {
        for (Cliente c : clientes) {
            if (c.getIdCliente().equalsIgnoreCase(id))
                return c;
        }
        return null;
    }

    private static Entrenador buscarEntrenador(String id) {
        for (Entrenador e : entrenadores) {
            if (e.getIdEntrenador().equalsIgnoreCase(id))
                return e;
        }
        return null;
    }

    private static int leerEntero(String mensaje) {
        int valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.print(mensaje);
                valor = sc.nextInt();
                sc.nextLine();
                valido = true;
            } catch (InputMismatchException e) {
                System.out.println("Ingrese un número válido.");
                sc.nextLine();
            }
        }
        return valor;
    }
}
