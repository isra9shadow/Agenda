package org.example;

import org.example.models.Contacto;
import org.example.utils.AgendaService;

import java.util.List;
import java.util.Scanner;

public class AgendaApp {
    private static final Scanner scanner = new Scanner(System.in);
    private static final AgendaService servicio = new AgendaService();

    public static void main(String[] args) {
        mostrarMenu();
    }

    private static void mostrarMenu(){
        int opcion;
        do{
            System.out.println("1. Añadir contacto en agenda.");
            System.out.println("2. Ver contactos de agenda.");
            System.out.println("0. Salir");
            System.out.println("Elige una de las opciones");

            opcion = Integer.parseInt(scanner.nextLine());
            switch (opcion){
                case 1:
                    addContact();
                    break;
                case 2:
                    getContact();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion no valida");
            }

        }while (opcion != 0);
    }

    private static void addContact(){
        System.out.println("Nombre:");
        String nombre= scanner.nextLine();

        System.out.println("Apellidos:");
        String apellidos= scanner.nextLine();

        String telefono;
        do {
            System.out.print("Teléfono (9 dígitos): ");
            telefono = scanner.nextLine();
        } while (!telefono.matches("\\d{9}"));

        String email;
        do {
            System.out.println("Email:");
            email= scanner.nextLine();
        }while(!email.matches("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$"));

        System.out.print("Notas: ");
        String notas = scanner.nextLine();

        Contacto nuevo = new Contacto(nombre, apellidos, Integer.parseInt(telefono), email, notas);
        servicio.addContact(nuevo);

        System.out.println("Contacto añadido correctamente.");
    }
    private static void getContact() {
        List<Contacto> lista = servicio.getContactos();
        for (Contacto c : lista) {
            System.out.println(c);
        }
    }
}
