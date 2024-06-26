
// Реализуйте структуру телефонной книги с помощью HashMap, учитывая, 
// что 1 человек может иметь несколько телефонов.
// Пусть дан список сотрудников:Иван Иванов (и остальные)
// Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
// Отсортировать по убыванию популярности.

// import java.util.ArrayList;
// import java.util.HashMap;
// import java.util.Map;
// public class zachet{
//        // Метод, который добавляет номера в книгу
//     public static void addNumber(String key, int value, Map<String, ArrayList<Integer>> map){
//         if (map.containsKey(key)) {
//             map.get(key).add(value);
//         } else {
//             ArrayList<Integer> list = new ArrayList<>();
//             list.add(value);
//             map.put(key, list);
//         }
//     }
//     // Метод, который печатает список контактов
//     public static void printBook(Map<String, ArrayList<Integer>> map){
//         for (var item : map.entrySet()) {
//             String phones = "";
//             for(int el: item.getValue()){
//                 phones = phones + el + ", ";
//             }
//             System.out.printf("%s: %s \n", item.getKey(), phones);
//         }
//     }
//     public static void main(String[] args) {
//         Map<String, ArrayList<Integer>> bookPhone = new HashMap<>();
//         addNumber("Ivanov", 123, bookPhone);
//         addNumber("Ivanov", 1234, bookPhone);
//         addNumber("Petrov", 546585, bookPhone);
//         addNumber("Sidorov", 8956477, bookPhone);
//         addNumber("Ivanov", 12356233, bookPhone);
//         addNumber("Petrov", 787897, bookPhone);
//         printBook(bookPhone);
//        }
// }

import java. util.HashMap;
public class zachet {

    public static void main(final String[] args) {
        var dict = new HashMap<String, String>();
        dict.put("88001122333", "Иван Иванов");
        dict.put("88001662333", "Иван Курицин");
        dict.put("88001112333", "Иван Курицин");
        dict.put("88001122432", "Иван Незлобин");
        dict.put("88001112453", "Сергей Потапов");
        dict.put("88001632145", "Сергей Потапов");
        dict.put("88001424214", "Сергей Курицин");
        dict.put("88001424215", "Сергей Курицин");
        dict.put("88001424216", "Сергей Курицин");
        dict.put("88001234374", "Михаил Незлобин");
        dict.put("88001424217", "Сергей Курицин");
        dict.put("88001112334", "Иван Курицин");

        var a = get(dict);

        a.entrySet().stream()
                .sorted((k1, k2) -> -k1.getValue().compareTo(k2.getValue()))
                .forEach(k -> System.out.println(k.getKey() + ": " + k.getValue()));
    }


    public static HashMap<String, Integer> get(HashMap<String, String> dict){
        var result = new HashMap<String, Integer>();
        for (var item : dict.entrySet()) {
            if (result.containsKey(item.getValue())) {
                var key = item.getValue();
                var value = result.get(item.getValue());
                result.replace(key, value + 1);
            } else {
                result.put(item.getValue(), 1);
            }
        }
        return result;
    }
}