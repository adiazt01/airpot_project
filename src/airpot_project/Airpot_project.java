package airpot_project;

import airport.Airport;
import java.util.Scanner;

import airplane.Airplane;

/* 
Por último su programa debe tener una clase Principal, en la que se debe crear un objeto de tipo aeropuerto. Una vez creado, debe mostrar el siguiente menú:

 Aeropuerto

1. Listar el ID de todos los aviones.
2. La cantidad de pasajeros actuales en todos los aviones.
3. La cantidad de asientos disponibles en todos los aviones.
4. Mostrar todos los datos de un avión a través de su ID.
5. Subir pasajeros (recibiendo el ID del avión).
6. Bajar pasajeros (recibiendo el ID del avión).
7. Salir

 */

public class Airpot_project {
    public static void main(String[] args) {
        Airport airport = new Airport("Aeropuerto Internacional de Tocumen");
        Scanner input = new Scanner(System.in);
        int option = 0;

        do {
            System.out.println("Aeropuerto\n");
            System.out.println("1. Listar el ID de todos los aviones.");
            System.out.println("2. La cantidad de pasajeros actuales en todos los aviones.");
            System.out.println("3. La cantidad de asientos disponibles en todos los aviones.");
            System.out.println("4. Mostrar todos los datos de un avión a través de su ID.");
            System.out.println("5. Subir pasajeros (recibiendo el ID del avión).");
            System.out.println("6. Bajar pasajeros (recibiendo el ID del avión).");
            System.out.println("7. Salir\n");

            System.out.println("Seleccione una opción:");
            option = Integer.parseInt(input.nextLine());

            int id = 0;
            int quantity = 0;

            switch (option) {
                case 1:
                    System.out.println("Tabla de aviones:");
                    System.out.println("-----------------");
                    System.out.printf("%-10s %-10s %-15s\n", "ID", "Pasajeros", "Pasajeros Max");
                    for (int i = 0; i < airport.getAirplanes().length; i++) {
                        Airplane airplane = airport.getAirplanes()[i];
                        System.out.printf("%-10d %-10d %-15d\n", airplane.getId(), airplane.getQuantityCurrent(),
                                airplane.getQuantityMax());
                    }
                    break;
                case 2:
                    System.out.println(
                            "Cantidad de pasajeros actuales en todos los aviones: " + airport.getTotalPassengers());
                    break;
                case 3:
                    System.out.println("Cantidad de asientos disponibles en todos los aviones: "
                            + airport.getTotalAvailableSeats());
                    break;
                case 4:
                    System.out.println("Mostrar todos los datos de un avión a través de su ID:");
                    id = Integer.parseInt(input.nextLine());
                    Airplane airplane = airport.getAirplaneById(id);
                    if (airplane != null) {
                        System.out.println("Tabla de aviones:");
                        System.out.println("-----------------");
                        System.out.printf("%-10s %-10s %-15s\n", "ID", "Pasajeros", "Pasajeros Max");
                        System.out.printf("%-10d %-10d %-15d\n", airplane.getId(), airplane.getQuantityCurrent(),
                                airplane.getQuantityMax());
                    } else {
                        System.out.println("No se encontró un avión con el ID proporcionado.");
                    }
                    break;
                case 5:
                    System.out.println("Subir pasajeros (recibiendo el ID del avión):");
                    id = Integer.parseInt(input.nextLine());
                    System.out.println("Cantidad de pasajeros a subir:");
                    quantity = Integer.parseInt(input.nextLine());
                    airport.getAirplaneById(id).addPassengers(quantity);
                    break;
                case 6:
                    System.out.println("Bajar pasajeros (recibiendo el ID del avión):");
                    id = Integer.parseInt(input.nextLine());
                    System.out.println("Cantidad de pasajeros a bajar:");
                    quantity = Integer.parseInt(input.nextLine());
                    airport.getAirplaneById(id).dropPassengers(quantity);
                    break;
                case 7:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;

            }

        } while (option != 7);
    }
}
