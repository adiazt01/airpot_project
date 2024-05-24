package aeropuerto;

import aeropuertoaviones.AeropuertoAviones;

public class Aeropuerto {
    private String nombre;
    private AeropuertoAviones[] aviones = new AeropuertoAviones[50];

    public Aeropuerto(String nombre) {
        this.nombre = nombre;
        for (int i = 0; i < aviones.length; i++) {
            aviones[i] = new AeropuertoAviones();
        }
    }

    public int getTotalPasajeros() {
        int totalPasajeros = 0;
        for (AeropuertoAviones aeropuertoaviones : aviones) {
            totalPasajeros += aeropuertoaviones.getCantidadActual();
        }
        return totalPasajeros;
    }

    public int getTotalAsientosDisponibles() {
        int totalAsientosDisponibles = 0;
        for (AeropuertoAviones aeropuertoaviones : aviones) {
            totalAsientosDisponibles += aeropuertoaviones.getCantidadMaxima() - aeropuertoaviones.getCantidadActual();
        }
        return totalAsientosDisponibles;
    }

    public AeropuertoAviones getAvionPorId(int id) {
        for (AeropuertoAviones aeropuertoaviones : aviones) {
            if (aeropuertoaviones.getId() == id) {
                return aeropuertoaviones;
            }
        }
        return null;
    }

    public AeropuertoAviones[] getAviones() {
        return this.aviones;
    }

    public void setAviones(AeropuertoAviones[] aviones) {
        this.aviones = aviones;
    }

    public String getNombre() {
        return this.nombre;
    }

    public void retirarPasajeros(int id, int cantidad) {
        AeropuertoAviones aeropuertoaviones = getAvionPorId(id);
        if (aeropuertoaviones != null) {
            aeropuertoaviones.Pasajeros(cantidad);
        }
    }

}

