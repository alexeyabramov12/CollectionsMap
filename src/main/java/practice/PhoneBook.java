package practice;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    private final TreeMap<String, String> contacts = new TreeMap<>();

    public void addContact(String phone, String name) {
        if (contacts.containsValue(phone)) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.equals(phone)) {
                    contacts.remove(key, value);
                }
            }
            contacts.put(name, phone);
            return;
        }
        if (contacts.containsKey(name)) {
            contacts.put(name, contacts.get(name) + ", " + phone);
            return;
        }
        if (validName(name) && validPhone(phone)) {
            contacts.put(name, phone);
        }
    }

    public String getContactByPhone(String phone) {
        String contact = "";
        if (contacts.containsValue(phone)) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.equals(phone)) {
                    contact = key + " - " + value;
                }
            }
            return contact;
        }
        return contact;
    }

    public Set<String> getContactByName(String name) {
        TreeSet<String> contact = new TreeSet<>();
        if (contacts.containsKey(name)) {
            contact.add(name + " - " + contacts.get(name));
            return contact;
        }
        return contact;
    }

    public Set<String> getAllContacts() {
        TreeSet<String> setContacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            setContacts.add(key + " - " + value);
        }
        if (setContacts.isEmpty()) {
            return new TreeSet<>();
        }
        return setContacts;
    }

    public boolean validName(String name) {
        String regex = "[АABCDEFGHIJKLMNOPQRSTUVWXYZ][abcdefghijklmnopqrstuvwxyz]+";
        return name.matches(regex);
    }

    public boolean validPhone(String phone) {
        String regex = "7[0-9]{10}";
        return phone.matches(regex);
    }

    public boolean containsKey(String key) {
        return contacts.containsKey(key);
    }

    public boolean containsValue(String velue) {
        return contacts.containsValue(velue);
    }
}