# SpeedFast - Simulación de Entregas Concurrentes (Semana 4)

Este repositorio contiene la solución correspondiente a la **Semana 4** de la asignatura **Desarrollo Orientado a Objetos II** (Duoc UC). En esta etapa se incorpora **programación concurrente (multihilo)** sobre la estructura previa del sistema de reparto SpeedFast.

---

Conceptos y Tecnologías Aplicadas

* **Multitarea con Hilos (`Runnable`):** La clase `Repartidor` implementa `Runnable` para permitir que cada repartidor procese su lista de pedidos de forma independiente y simultánea.
* **Gestión de Pools de Hilos (`ExecutorService`):** Se utiliza `Executors.newFixedThreadPool()` para administrar la ejecución paralela de los repartidores y coordinar el apilamiento y cierre de hilos (`shutdown()` y `awaitTermination()`).
* **Simulación de Tiempos Asíncronos:** Uso de `Thread.sleep()` con intervalos aleatorios para simular desplazamientos reales en ruta.
* **Manejo de Excepciones Concurrente:** Captura de `InterruptedException` para garantizar que la interrupción de un hilo no afecte el flujo global del sistema.

---

Estructura del Proyecto

```text
semana 4/
└── src/
    ├── app/              # Punto de entrada principal
    │   └── Main.java     # Configuración y ejecución de ExecutorService
    ├── interfaces/       # Interfaces funcionales del sistema
    │   ├── Cancelable.java
    │   ├── Despachable.java
    │   └── Rastreable.java
    ├── model/            # Entidades del dominio y Runnable
    │   ├── Pedido.java          (Clase abstracta base)
    │   ├── PedidoComida.java    (Subclase)
    │   ├── PedidoEncomienda.java(Subclase)
    │   ├── PedidoExpress.java   (Subclase)
    │   └── Repartidor.java      (Implementa Runnable)
    └── service/          # Lógica de soporte y rastreo
        └── ControladorDeEnvios.java
