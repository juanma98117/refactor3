package com.juanma;

import java.util.List;

/**
 * Código refactorizado de ProcesadorPedidos
 * - Nombres claros
 * - Constantes para números mágicos
 * - Métodos extraídos para cada responsabilidad
 * - Uso de List en lugar de ArrayList
 */
public class ProcesadorPedidos {

    // ===== Constantes =====
    private static final double DESCUENTO_LIMITE = 100;
    private static final double DESCUENTO = 0.10;
    private static final double IVA = 0.21;
    private static final double ENVIO_GRATIS_LIMITE = 500;
    private static final double GASTOS_ENVIO = 15.95;

    // ===== Método principal =====
    public double procesar(List<String> listaNombres, List<Double> precios) {

        double total = calcularTotal(listaNombres, precios);
        total = aplicarDescuento(total);
        total = aplicarIVA(total);
        total = aplicarGastosEnvio(total);

        return total;
    }

    // ===== Métodos extraídos =====

    private double calcularTotal(List<String> nombres, List<Double> precios) {
        double total = 0;
        for (int i = 0; i < precios.size(); i++) {
            System.out.println("Añadiendo producto: " + nombres.get(i));
            total += precios.get(i);
        }
        return total;
    }

    private double aplicarDescuento(double total) {
        if (total > DESCUENTO_LIMITE) {
            System.out.println("Descuento aplicado.");
            total -= total * DESCUENTO;
        }
        return total;
    }

    private double aplicarIVA(double total) {
        return total + total * IVA;
    }

    private double aplicarGastosEnvio(double totalFinal) {
        if (totalFinal < ENVIO_GRATIS_LIMITE) {
            totalFinal += GASTOS_ENVIO;
        }
        return totalFinal;
    }
}