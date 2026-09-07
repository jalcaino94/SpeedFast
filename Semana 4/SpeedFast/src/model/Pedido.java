package model;

import interfaces.Cancelable;
import interfaces.Despachable;


public abstract class Pedido implements Despachable, Cancelable { //
    protected int idPedido;
    protected String direccion;
    protected double distanciaKm;
    protected String repartidorAsignado;
    protected boolean cancelado;

    public Pedido(int idPedido, String direccion, double distanciaKm) {
        this.idPedido = idPedido;
        this.direccion = direccion;
        this.distanciaKm = distanciaKm;
        this.repartidorAsignado = "Sin asignar";
        this.cancelado = false;
    }

    // Método abstracto
    public abstract int calcularTiempoEntrega(); //[cite: 2]

    // Sobrescritura
    public abstract void asignarRepartidor(); //[cite: 2]

    // Sobrecarga de métodos
    public void asignarRepartidor(String nombre) { //[cite: 2]
        this.repartidorAsignado = nombre;
    }

    // Método concreto
    public void mostrarResumen() { //[cite: 2]
        System.out.println("Pedido #" + idPedido);
        System.out.println("Dirección: " + direccion);
        System.out.println("Distancia: " + distanciaKm + " km");
        System.out.println("Repartidor asignado: " + repartidorAsignado);
        System.out.println("Tiempo estimado: " + calcularTiempoEntrega() + " minutos");
    }

    @Override
    public void despachar() { //[cite: 2]
        if (!cancelado) {
            System.out.println("Pedido despachado correctamente.");
        } else {
            System.out.println("No se puede despachar un pedido cancelado.");
        }
    }

    @Override
    public void cancelar() { //[cite: 2]
        this.cancelado = true;
        System.out.println("Cancelando Pedido #" + idPedido + "...");
        System.out.println("-> Pedido cancelado exitosamente.");
    }

    // Getters
    public int getIdPedido() { return idPedido; }
    public String getRepartidorAsignado() { return repartidorAsignado; }
    public boolean isCancelado() { return cancelado; }
}