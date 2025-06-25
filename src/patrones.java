import java.util.*;
import java.util.Scanner;
class Rutina implements Cloneable {
    private String nombreCliente;
    private String tipoRutina;
    private String nivel;

    public Rutina(String tipoRutina, String nivel) {
        this.tipoRutina = tipoRutina;
        this.nivel = nivel;
    }
    @Override
        public Rutina clone() {
            try {
                return (Rutina) super.clone();
            } catch (CloneNotSupportedException e) {
                throw new AssertionError("No se pudo clonar la rutina");
            }
        }

    public void setNombreCliente(String nombre) {
        this.nombreCliente = nombre;
    }

    public String toString() {
        return "Rutina de " + nombreCliente + ": Tipo: " + tipoRutina + ", Nivel: " + nivel;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }
}
class GestorGimnasio {
    private static GestorGimnasio instancia;
    private List<Rutina> rutinas = new ArrayList<>();
    private List<String> asistencias = new ArrayList<>();

    private GestorGimnasio() {}

    public static GestorGimnasio getInstancia() {
        if (instancia == null) {
            instancia = new GestorGimnasio();
        }
        return instancia;
    }

    public Rutina crearRutina(String nombreCliente, Rutina plantilla) {
        Rutina personalizada = plantilla.clone();
        personalizada.setNombreCliente(nombreCliente);
        rutinas.add(personalizada);
        return personalizada;
    }

    public void registrarAsistencia(String cliente) {
        asistencias.add(cliente + " - " + new Date());
    }

    public List<String> getAsistencias() {
        return asistencias;
    }

    public List<Rutina> getRutinas() {
        return rutinas;
    }
}
class AsistenciaIterator implements Iterator<String> {
    private Iterator<String> iterator;

    public AsistenciaIterator(List<String> asistencias) {
        this.iterator = asistencias.iterator();
    }

    public boolean hasNext() {
        return iterator.hasNext();
    }

    public String next() {
        return iterator.next();
    }
}
interface CanalInterfaz {
    void registrarAsistencia();
    void solicitarRutina();
    void mostrarHistorialAsistencia();
    void mostrarRutinas();
}
class AdaptadorConsolaGimnasio implements CanalInterfaz {
    private Scanner scanner = new Scanner(System.in);
    private GestorGimnasio gestor = GestorGimnasio.getInstancia();
    private Rutina plantillaBasica = new Rutina("Full Body", "Básico");

    public void registrarAsistencia() {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        gestor.registrarAsistencia(nombre);
        System.out.println("Asistencia registrada.");
    }

    public void solicitarRutina() {
        System.out.print("Nombre del cliente: ");
        String nombre = scanner.nextLine();
        Rutina r = gestor.crearRutina(nombre, plantillaBasica);
        System.out.println("Rutina creada: " + r);
    }

    public void mostrarHistorialAsistencia() {
        System.out.println("\nHistorial de asistencias:");
        AsistenciaIterator it = new AsistenciaIterator(gestor.getAsistencias());
        while (it.hasNext()) {
            System.out.println(it.next());
        }
    }

    public void mostrarRutinas() {
        System.out.println("\nRutinas asignadas:");
        for (Rutina r : gestor.getRutinas()) {
            System.out.println(r);
        }
    }
}
public class patrones {
    public static void main(String[] args) {
        CanalInterfaz interfaz = new AdaptadorConsolaGimnasio();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("\n--- Opciones ---");
            System.out.println("1. Registrar asistencia");
            System.out.println("2. Solicitar rutina");
            System.out.println("3. Ver historial de asistencias");
            System.out.println("4. Ver rutinas asignadas");
            System.out.println("5. Salir");
            System.out.print("Opción: ");
            opcion = Integer.parseInt(scanner.nextLine());

            switch (opcion) {
                case 1: interfaz.registrarAsistencia(); break;
                case 2: interfaz.solicitarRutina(); break;
                case 3: interfaz.mostrarHistorialAsistencia(); break;
                case 4: interfaz.mostrarRutinas(); break;
                case 5: System.out.println("Cerrando sesión..."); break;
                default: System.out.println("Opción inválida");
            }
        } while (opcion != 5);
    }
}


