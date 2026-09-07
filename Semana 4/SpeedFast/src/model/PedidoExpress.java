package model;

public class PedidoExpress extends model.Pedido {
    public PedidoExpress(int idPedido, String direccion, double distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        // Regla: Entrega prioritaria, 2 min por km[cite: 2]
        return Math.max(10, (int)(distanciaKm * 2));
    }

    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Carlos Pérez (Bicicleta Express)";
    }

    @Override
    public void mostrarResumen() {
        System.out.print("[Pedido Express] ");
        super.mostrarResumen();
    }
}