package practice;

import java.util.Scanner;
import java.util.Set;

public class Main {
    public static PhoneBook phoneBook = new PhoneBook();
    public static Scanner scanner = new Scanner(System.in);
    private static String name;
    private static String phone;
    private static String client;
    private static final String ERROR = "Invalid input format";
    private static final String SAVED = "Contact saved";


    public static void main(String[] args) {

        while (true) {
            System.out.println("Enter a number, name or command:");
            client = scanner.nextLine();
            if (client.equals("0")) {
                break;
            }
            if (validName(client.trim())) {
                if (phoneBook.containsKey(client.trim())) {
                    System.out.println(phoneBook.getContactByName(client.trim()));
                    continue;
                }
                addContactByName();
                continue;
            }
            if (validPhone(client.trim())) {
                if (phoneBook.containsValue(client.trim())) {
                    System.out.println(phoneBook.getContactByPhone(client.trim()));
                    continue;
                }
                addContactByPhone();
                continue;
            }
            if (client.trim().equals("LIST")) {
                phoneBook.getAllContacts().forEach(System.out::println);
            } else {
                System.out.println(ERROR);
            }
        }
    }

    public static boolean validName(String name) {
        String regex = "[АABCDEFGHIJKLMNOPQRSTUVWXYZ][abcdefghijklmnopqrstuvwxyz]+";
        return name.matches(regex);
    }

    public static boolean validPhone(String phone) {
        String regex = "7[0-9]{10}";
        return phone.matches(regex);
    }

    public static void addContactByName() {
        System.out.println("This name is not in the phone book");
        name = client.trim();
        System.out.println("Enter phone number for contact " + "\"" + name + "\":");
        client = scanner.nextLine();
        if (validPhone(client.trim())) {
            phone = client.trim();
            addContact(phone, name);
            System.out.println(SAVED);
        } else {
            System.out.println(ERROR);
        }
    }

    public static void addContactByPhone() {
        System.out.println("This number is not in the phone book");
        phone = client.trim();
        System.out.println("Enter the name of the subscriber for the number " + "\"" + phone + "\":");
        client = scanner.nextLine();
        if (validName(client.trim())) {
            name = client.trim();
            addContact(phone, name);
            System.out.println(SAVED);
        } else {
            System.out.println(ERROR);
        }
    }

    public static void addContact(String phone, String name) {
        phoneBook.addContact(phone, name);
    }
}
