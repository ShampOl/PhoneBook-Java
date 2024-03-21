import java.util.*;

public class PhoneBook {
    public static void main(String[] args) {
        Map<String, Set<String>> phoneBook = new HashMap<>();

        // Пример входных данных (имя - список телефонов)
        String[][] contacts = {
            {"Иванов", "123-456-789", "987-654-321"},
            {"Петров", "111-222-333"},
            {"Иванов", "555-666-777"},
            {"Сидоров", "444-555-666"},
            {"Филатова", "449-505-666"},
            {"Игнатенко", "124-555-666"},
            {"Филатова", "444-555-6096"}
        };

        // Заполнение телефонной книги
        for (String[] contact : contacts) {
            String name = contact[0];
            Set<String> phones = phoneBook.getOrDefault(name, new HashSet<>());
            for (int i = 1; i < contact.length; i++) {
                phones.add(contact[i]);
            }
            phoneBook.put(name, phones);
        }

        // Сортировка по убыванию числа телефонов
        List<Map.Entry<String, Set<String>>> sortedEntries = new ArrayList<>(phoneBook.entrySet());
        sortedEntries.sort((e1, e2) -> Integer.compare(e2.getValue().size(), e1.getValue().size()));

        // Вывод результатов
        System.out.println("Телефонная книга:");
        for (Map.Entry<String, Set<String>> entry : sortedEntries) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}
