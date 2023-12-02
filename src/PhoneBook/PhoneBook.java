package PhoneBook;

import java.util.*;

public class PhoneBook {

    public static void main(String[] args) {
        HashMap<String, ArrayList<String>> phoneBook = new HashMap<>();
        

        // Scanner inn = new Scanner (System.in);
        // System.out.println("input name: ");
        // String name = inn.next();
        // inn.close();
        // Scanner inp = new Scanner (System.in);
        // System.out.println("input number of his phone: ");
        // String phoneNumber = inp.next();
        // inp.close();

        // addContact(phoneBook, name, phoneNumber);

        addContact(phoneBook, "Игорь", "79874563231");
        addContact(phoneBook, "Мария", "79123654847");
        addContact(phoneBook, "Иосиф", "79321456854");
        addContact(phoneBook, "Мария", "79524321098");
        addContact(phoneBook, "Игорь", "79213474847");
        addContact(phoneBook, "Ирина", "79311435874");
        addContact(phoneBook, "Игорь", "79534378096");

        printPhoneBook(phoneBook);
    }

    public static void addContact(HashMap<String, ArrayList<String>> phoneBook, String name, String phoneNumber) {
        if (phoneBook.containsKey(name)) {
            phoneBook.get(name).add(phoneNumber);
        } 
        else {
            ArrayList<String> phoneNumbers = new ArrayList<>();
            phoneNumbers.add(phoneNumber);
            phoneBook.put(name, phoneNumbers);
        }
    }

    public static void printPhoneBook(HashMap<String, ArrayList<String>> phoneBook) {
        HashMap<Integer, ArrayList<String>> sortedPhoneBook = new HashMap<>();

        for (String name : phoneBook.keySet()) {
            int numOfPhoneNumbers = phoneBook.get(name).size();

            if (sortedPhoneBook.containsKey(numOfPhoneNumbers)) {
                sortedPhoneBook.get(numOfPhoneNumbers).add(name);
            } 
            else {
                ArrayList<String> names = new ArrayList<>();
                names.add(name);
                sortedPhoneBook.put(numOfPhoneNumbers, names);
            }
        }

        List<Integer> sortedKeys = new ArrayList<>(sortedPhoneBook.keySet());
        Collections.sort(sortedKeys, Collections.reverseOrder());

        for (int key : sortedKeys) {
            ArrayList<String> names = sortedPhoneBook.get(key);
            for (String name : names) {
                System.out.println(name + ": " + key + " phone number(s)");
            }
        }
    }
}
