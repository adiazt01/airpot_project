package aeropuertoaviones;

import java.util.Random;

public class AeropuertoAviones {
    private int ID;
    private int cantidad_maxima;
    private int cantidad_actual;
    private boolean estado;
    static int cuenta_aviones = 1;

    
    private void agregarId(){
        this.ID = AeropuertoAviones.cuenta_aviones++;
    }

    public AeropuertoAviones() {
        this.agregarId();
        Random random = new Random();
        this.cantidad_maxima = random.nextInt(100) + 1; 
        this.cantidad_actual = random.nextInt(this.cantidad_maxima);
    }
    
    public AeropuertoAviones(int cantidad_maxima, int cantidad_actual) {
        this.agregarId();
        this.cantidad_maxima = cantidad_maxima;
        this.cantidad_actual = cantidad_actual;
    }

    public int getId() {
        return this.ID;
    }

    public int getCantidadMaxima() {
        return this.cantidad_maxima;
    }

    public int getCantidadActual() {
        return this.cantidad_actual;
    }

    public boolean estaEnVuelo() {
        return this.estado;
    }

    public void Pasajeros(int pasajeros) {
        if (pasajeros < 0) {
            throw new IllegalArgumentException("El numero de pasajeros a caer debe ser positivo.");
        }
        if (pasajeros > this.cantidad_actual) {
            throw new IllegalArgumentException("El numero de pasajeros para bajar no debe exceder el numero actual de pasajeros :) .");
        }
        this.cantidad_actual -= pasajeros;
    }

    public void agregarPasajeros(int pasajeros) {
        if (pasajeros < 0) {
            throw new IllegalArgumentException("EL numero de pasajeros para agregar al avion debe ser positivo.");
        }
        if (this.cantidad_actual + pasajeros > this.cantidad_maxima) {
            throw new IllegalArgumentException("El numero de pasajeros para agregar al avion no debe exceder la cantidad_maxima :) .");
        }
        this.cantidad_actual += pasajeros;
    }

    public static void reinicioDelContador() {
        AeropuertoAviones.cuenta_aviones = 1;
    }
}
