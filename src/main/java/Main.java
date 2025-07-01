// Main.java
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        IReservationRepository repo = new ReservationRepository();
        HotelManager manager = new HotelManager(repo);

        int option;
        do {
            System.out.println("\n===== Sistema de Reservas de Hotel =====");
            System.out.println("1. Registrar cliente");
            System.out.println("2. Registrar habitación");
            System.out.println("3. Realizar reserva");
            System.out.println("4. Listar reservas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            option = sc.nextInt();
            sc.nextLine(); // limpiar buffer

            switch (option) {
                case 1:
                    System.out.print("Nombre del cliente: ");
                    String name = sc.nextLine();
                    System.out.print("Documento de identidad: ");
                    String document = sc.nextLine();
                    manager.registerClient(name, document);
                    break;
                case 2:
                    System.out.print("Número de habitación: ");
                    int number = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Tipo de habitación: ");
                    String type = sc.nextLine();
                    manager.registerRoom(number, type);
                    break;
                case 3:
                    System.out.print("Documento del cliente: ");
                    String doc = sc.nextLine();
                    System.out.print("Número de habitación: ");
                    int roomNum = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Fecha check-in (YYYY-MM-DD): ");
                    String checkIn = sc.nextLine();
                    System.out.print("Fecha check-out (YYYY-MM-DD): ");
                    String checkOut = sc.nextLine();
                    manager.makeReservation(doc, roomNum, checkIn, checkOut);
                    break;
                case 4:
                    manager.listReservations();
                    break;
                case 5:
                    System.out.println(" Saliendo del sistema...");
                    break;
                default:
                    System.out.println("Opción inválida.");
            }
        } while (option != 5);

        sc.close();
    }
}
