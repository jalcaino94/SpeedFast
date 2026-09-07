package model;

public class PedidoEncomienda extends model.Pedido {
    public PedidoEncomienda(int idPedido, String direccion, double distanciaKm) {
        super(idPedido, direccion, distanciaKm);
    }

    @Override
    public int calcularTiempoEntrega() {
        // Regla: 10 min de carga + 4 min por km[cite: 2]
        return 10 + (int)(distanciaKm * 4);
    }

    @Override
    public void asignarRepartidor() {
        this.repartidorAsignado = "Daniela Tapia (Furgón)";
    }

    @Override
    public void mostrarResumen() {
        System.out.print("[Pedido Encomienda] ");
        super.mostrarResumen();
    }
}