package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PedidoTest {

    private Pedido criarPedidoTradicional() {
        HamburgueriaFactory fabrica = FabricaTradicional.getInstancia();
        Hamburguer hamburguer = fabrica.criarBase(new PreparoGrelhado());
        return new Pedido(hamburguer);
    }

    @Test
    void deveAceitarUmPedido() {
        Pedido pedido = criarPedidoTradicional();
        assertEquals(PedidoEstadoAceito.getInstancia(), pedido.getEstado());
    }

    @Test
    void devePrepararUmPedido() {
        Pedido pedido = criarPedidoTradicional();
        assertTrue(pedido.preparar());
        assertEquals(PedidoEstadoEmPreparacao.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveFicarProntoUmPedidoEmPreparacao() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmPreparacao.getInstancia());
        assertTrue(pedido.pronto());
        assertEquals(PedidoEstadoPronto.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveEntrarEmRotaUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.emRota());
        assertEquals(PedidoEstadoEmRota.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveEntregarUmPedidoPronto() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoPronto.getInstancia());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveEntregarUmPedidoEmRota() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEmRota.getInstancia());
        assertTrue(pedido.entregar());
        assertEquals(PedidoEstadoEntregue.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveDevolverUmPedidoEntregue() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoEntregue.getInstancia());
        assertTrue(pedido.devolver());
        assertEquals(PedidoEstadoDevolucao.getInstancia(), pedido.getEstado());
    }

    @Test
    void deveCancelarUmPedidoDevolvido() {
        Pedido pedido = criarPedidoTradicional();
        pedido.setPedidoEstado(PedidoEstadoDevolucao.getInstancia());
        assertTrue(pedido.cancelar());
        assertEquals(PedidoEstadoCancelado.getInstancia(), pedido.getEstado());
    }
}