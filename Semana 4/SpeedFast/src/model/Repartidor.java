package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Clase que representa un repartidor ejecutando entregas en un hilo independiente.
 */
public class Repartidor implements Runnable {
    private String nombre;
    private List<Pedido> listaPedidos;
    private Random random;

    public Repartidor(String nombre) {
        this.nombre = nombre;
        this.listaPedidos = new ArrayList<>();
        this.random = new Random();
    }

    public void agregarPedido(Pedido pedido) {
        pedido.asignarRepartidor(this.nombre);
        this.listaPedidos.add(pedido);
    }

    @Override
    public void run() {
        for (Pedido pedido : listaPedidos) {
            System.out.println("[Repartidor: " + nombre + "] Entregando "
                    + pedido.getClass().getSimpleName() + " #" + pedido.getIdPedido() + "...");

            try {
                // Simulación de tiempo de entrega aleatorio entre 1.5 y 3.5 segundos
                int tiempoSimulado = 1500 + random.nextInt(2000);
                Thread.sleep(tiempoSimulado);

                pedido.despachar();
                System.out.println("[Repartidor: " + nombre + "] Pedido #"
                        + pedido.getIdPedido() + " entregado.");

            } catch (InterruptedException e) {
                System.err.println("[Repartidor: " + nombre + "] Error en la entrega del Pedido #"
                        + pedido.getIdPedido() + ": " + e.getMessage());
                Thread.currentThread().interrupt();
            }
        }
    }

    public String getNombre() {
        return nombre;
    }
}