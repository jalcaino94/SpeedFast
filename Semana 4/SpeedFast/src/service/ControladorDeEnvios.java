package service;

import interfaces.Rastreable;
import model.Pedido;
import java.util.ArrayList;
import java.util.List;

public class ControladorDeEnvios implements Rastreable { //[cite: 2]
    private List<Pedido> historialEntregas;

    public ControladorDeEnvios() {
        this.historialEntregas = new ArrayList<>();
    }

    public void registrarEntrega(Pedido pedido) {
        if (!pedido.isCancelado()) {
            historialEntregas.add(pedido);
        }
    }

    @Override
    public void verHistorial() { //[cite: 2]
        System.out.println("Historial:");
        if (historialEntregas.isEmpty()) {
            System.out.println("- No hay entregas registradas.");
            return;
        }
        for (Pedido p : historialEntregas) {
            System.out.println("- " + p.getClass().getSimpleName() + " #" + p.getIdPedido()
                    + " – entregado por " + p.getRepartidorAsignado());
        }
    }
}