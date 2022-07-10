package practice;

import java.util.Scanner;

public class Main {
    public static PhoneBook phoneBook = new PhoneBook();
    public static Scanner scanner = new Scanner(System.in);
    private static String name = "";
    private static String phone = "";
    private static String client;

    public static void main(String[] args) {

        while (true) {
            System.out.println("Введите номер, имя или команду:");
            client = scanner.nextLine();
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
            }
            if (client.trim().equals("LIST")) {
                System.out.println(phoneBook.getAllContacts());
                continue;
            } else {
                System.out.println("Неверный формат ввода");
            }
        }
    }

    public static boolean validName(String name) {
        String regex = "[АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ][абвгдеёжзийклмнопрстуфхцчшщьыъэюя]+";
        return name.matches(regex);
    }

    public static boolean validPhone(String phone) {
        String regex = "7[0-9]{10}";
        return phone.matches(regex);
    }

    public static void addContactByName() {
        System.out.println("Такого имени в телефонной книги нет");
        name = client.trim();
        System.out.println("Введите номер телефона для контакта " + "\"" + name + "\":");
        client = scanner.nextLine();
        if (validPhone(client.trim())) {
            phone = client.trim();
            addContact(phone, name);
            System.out.println("Контак сохранен");
        } else {
            System.out.println("Неверный формат ввода");
        }
    }

    public static void addContactByPhone() {
        System.out.println("Такого номера телефонной книге нет");
        phone = client.trim();
        System.out.println("Введите имя абоента для номера " + "\"" + phone + "\":");
        client = scanner.nextLine();
        if (validName(client.trim())) {
            name = client.trim();
            addContact(phone, name);
            System.out.println("Контак сохранен");
        } else {
            System.out.println("Неверный формат ввода");
        }
    }

    public static void addContact(String phone, String name) {
        phoneBook.addContact(phone, name);
    }
}
