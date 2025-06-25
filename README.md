# Evaluacion-n3
# Sistema de control de rutinas y asistencia
 ## Breve descripcion del sistema 
es un sistema de gestión básica para gimnasios que permite llevar el control de asistencias de los clientes y asignar rutinas de entrenamiento personalizadas. A través de una interfaz por consola, los usuarios pueden registrar su asistencia diaria, solicitar una rutina de ejercicios basada en una plantilla predefinida y revisar tanto el historial de visitas como las rutinas asignadas.

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

# ¿Como se uso?
Se creó la clase AsistenciaIterator, que implementa la interfaz Iterator, esta clase recibe la lista de asistencias y permite recorrerla usando los métodos hasNext() y next()
# ¿Donde se uso?
El iterador es utilizado dentro del AdaptadorConsolaGimnasio cuando se ejecuta la opción "Ver historial de asistencias". Así, el sistema muestra cada asistencia una por una.

![Image](https://github.com/user-attachments/assets/5b81392f-51ef-4318-a51b-eefa473cf1cf)

## Clase AdaptadorConsolaGimnasio (patron estructural Adapter)
# ¿por que se uso?
para desacoplar la lógica del sistema (gestión de rutinas y asistencias) de la forma en que el usuario interactúa con él (mediante consola). Esto permite que en el futuro se puedan implementar otras formas de interacción como una app grafica o una web.

#¿como se uso?
Se definió la interfaz CanalInterfaz con las operaciones principales del sistema: registrar asistencia, solicitar rutina, mostrar historial y ver rutinas. Luego, se creó la clase AdaptadorConsolaGimnasio, que implementa esa interfaz y actúa como un adaptador entre el usuario y el sistema. Dentro de esta clase se traduce cada acción del usuario en una llamada al GestorGimnasio.
# ¿Donde se uso?
se uso en el Main se crea una instancia de AdaptadorConsolaGimnasio que es usada como el canal principal de interacción con el sistema
![Image](https://github.com/user-attachments/assets/e0852ed2-92d8-430b-a056-23cc7f832341)

![Image](https://github.com/user-attachments/assets/3a86b87e-f0b7-48c8-80c0-0c107b7510fb)






