# Evaluacion-n3
# Sistema de control de rutinas y asistencia
 ## Breve descripcion del sistema 

El sistema integra patrones de diseño como Prototype, Singleton, Adapter e Iterator para estructurar el código de forma limpia y eficiente.

# Patrones de diseño aplicados al sistema.
## Clase rutina (patron creaacional Prototype)

### ¿Por que se uso?

El patrón Prototype se utilizó para evitar crear rutinas desde cero cada vez que un cliente la solicita. En lugar de construir manualmente una nueva rutina con sus atributos, se clona una rutina base (plantilla) y luego se personaliza con el nombre del cliente. Esto permite reutilizar estructuras comunes, mejorando la eficiencia.

### ¿Cómo se uso?
La clase Rutina implementa cloneable y define el metodo clone(), que permite duplicar una rutina ya existente. Al clonar, se genera una copia en memoria con los mismos datos, que luego se ajusta al cliente.

### ¿Donde se uso?
Este patrón está aplicado en la clase Rutina y se usa directamente dentro del metodo crearRutina() de GestorGimnasio. En ese metodo, se clona una plantilla (Rutina plantillaBasica) y se le asigna el nombre del cliente que solicita la rutina.

![Image](https://github.com/user-attachments/assets/a77dcfda-2b3b-4c26-a7ba-93f2ca43318c)

![Image](https://github.com/user-attachments/assets/6add9484-0970-4b4e-a0bf-6a16a5488906)

## clase GestorGimnasio (Patron creacional singleton)
# ¿Por que se uso?
El patrón Singleton se aplico para asegurar que solo exista una única instancia del sistema que gestiona el gimnasio. Esto garantiza que todos los modulos del programa trabajen sobre los mismos datos: mismas asistencias, mismas rutinas y el mismo historial.

# ¿Como se uso?
La clase GestorGimnasio implementa este patrón mediante un constructor privado y un metodo estático llamado getInstancia(). Este metodo se encarga de crear la instancia si no existe y devolverlo si es que ya existe.

# ¿Donde se uso?
a instancia de GestorGimnasio es utilizada en toda la aplicación, especialmente por el adaptador de consola (AdaptadorConsolaGimnasio) para registrar asistencias y crear rutinas.

![Image](https://github.com/user-attachments/assets/f4343fa0-f568-4896-a7ad-87fef9eabfbb)

## Clase AsistenciaIterator (patron de comportamiento Iterator)

# ¿Por que se uso?
Se utilizó el patrón Iterator para permitir recorrer de manera controlada y ordenada el historial de asistencias del gimnasio, sin exponer directamente cómo están almacenadas internamente










