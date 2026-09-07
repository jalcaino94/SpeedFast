package model;

public class PedidoComida extends model.Pedido {
    public PedidoComida(int idPedido, String direccion, double distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        // Regla: 15 min de preparación + 3 min por km[cite: 2]
        return 15 + (int)(distanciaKm * 3);
    }

    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Luis Díaz (Moto - Comida rápida)";
    }

    @Override
    public void mostrarResumen() {
        System.out.print("[Pedido Comida] ");
        super.mostrarResumen();
    }
}