package practice;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class PhoneBook {

    private final TreeMap <String, String> contacts = new TreeMap<>();

    public void addContact(String phone, String name) {
        boolean work = true;
        if (contacts.containsValue(phone)) {
            for (Map.Entry<String, String> entry : contacts.entrySet()) {
                String key = entry.getKey();
                String value = entry.getValue();
                if (value.equals(phone)) {
                    contacts.remove(key, value);
                }
            }
            contacts.put(name, phone);
            work = false;
        }
        if (contacts.containsKey(name) && work) {
            contacts.put(name, contacts.get(name) + ", " + phone);
            work = false;
        }
        if (validName(name) && validPhone(phone) && work) {
            contacts.put(name, phone);
        }
        // проверьте корректность формата имени и телефона
        // (рекомедуется написать отдельные методы для проверки является строка именем/телефоном)
        // если такой номер уже есть в списке, то перезаписать имя абонента
    }

    public String getContactByPhone(String phone) {
        // формат одного контакта "Имя - Телефон"
        // если контакт не найдены - вернуть пустую строку
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
        // формат одного контакта "Имя - Телефон"
        // если контакт не найден - вернуть пустой TreeSet
        TreeSet <String> contact = new TreeSet<>();
        if (contacts.containsKey(name)) {
            contact.add(name + " - " + contacts.get(name));
            return contact;
        }
        return contact;
    }

    public Set<String> getAllContacts() {
        // формат одного контакта "Имя - Телефон"
        // если контактов нет в телефонной книге - вернуть пустой TreeSet
        TreeSet <String> setContacts = new TreeSet<>();
        for (Map.Entry<String, String> entry : contacts.entrySet()) {
            String key = entry.getKey();
            String value = entry.getValue();
            setContacts.add(key + " - " + value);
        }
        if (setContacts.isEmpty()) {
            return new TreeSet<>();
        } return setContacts;
    }

    // для обхода Map используйте получение пары ключ->значение Map.Entry<String,String>
    // это поможет вам найти все ключи (key) по значению (value)
    /*
        for (Map.Entry<String, String> entry : map.entrySet()){
            String key = entry.getKey(); // получения ключа
            String value = entry.getValue(); // получения ключа
        }
    */
    public boolean validName (String name) {
        String regex = "[АБВГДЕЁЖЗИКЛМНОПРСТУФХЦЧШЩЭЮЯ][абвгдеёжзийклмнопрстуфхцчшщьыъэюя]+";
        return name.matches(regex);
    }
    public boolean validPhone (String phone) {
        String regex = "7[0-9]{10}";
        return phone.matches(regex);
    }
    public boolean containsKey (String key) {
        return contacts.containsKey(key);
    }
    public boolean containsValue (String velue) {
        return contacts.containsValue(velue);
    }
}