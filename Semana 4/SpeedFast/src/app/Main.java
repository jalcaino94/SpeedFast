package app;

import model.PedidoComida;
import model.PedidoEncomienda;
import model.PedidoExpress;
import model.Repartidor;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * Punto de entrada principal para la simulación concurrente de SpeedFast.
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("=== SPEEDFAST - SIMULACIÓN DE ENTREGAS CONCURRENTE ===\n");

        // 1. Instanciar repartidores
        Repartidor r1 = new Repartidor("Camila");
        Repartidor r2 = new Repartidor("Luis");
        Repartidor r3 = new Repartidor("Carlos");

        // 2. Crear y asignar pedidos a cada repartidor
        r1.agregarPedido(new PedidoComida(101, "Av. Grecia 123", 3.5));
        r1.agregarPedido(new PedidoExpress(104, "Pajaritos 456", 2.0));

        r2.agregarPedido(new PedidoExpress(102, "Av. Santa Rosa 567", 5.0));
        r2.agregarPedido(new PedidoEncomienda(105, "Las Condes 890", 8.0));

        r3.agregarPedido(new PedidoEncomienda(103, "Moneda 111", 4.0));
        r3.agregarPedido(new PedidoComida(106, "Providencia 222", 1.5));

        // 3. Crear ExecutorService para gestionar los hilos
        ExecutorService executor = Executors.newFixedThreadPool(3);

        // 4. Ejecutar hilos concurrentemente
        executor.execute(r1);
        executor.execute(r2);
        executor.execute(r3);

        // 5. Apagar executor y esperar a que todos terminen
        executor.shutdown();
        try {
            if (!executor.awaitTermination(60, TimeUnit.SECONDS)) {
                executor.shutdownNow();
            }
            System.out.println("\n=== TODAS LAS ENTREGAS HAN SIDO COMPLETADAS ===");
        } catch (InterruptedException e) {
            executor.shutdownNow();
            Thread.currentThread().interrupt();
        }
    }
}