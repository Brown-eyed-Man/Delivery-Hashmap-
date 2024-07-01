import java.util.*;

public class Main {
    public static void main(String[] args) {
        Address spb = new Address("Россия", "Санкт-Петербург");
        Address moscow = new Address("Россия", "Москва");
        Address vladivostok = new Address("Россия", "Владивосток");
        Address novorossiysk = new Address("Россия", "Новороссийск");
        Address chelyabinsk = new Address("Россия", "Челябинск");
        Address miami = new Address("США", "Майами");
        Address washington = new Address("США", "Вашингтон");
        Address barcelona = new Address("Испания", "Барселона");
        Address paris = new Address("Франция", "Париж");

        Map<Address, Integer> costPerAddress = new HashMap<>();
        costPerAddress.put(spb, 1500);
        costPerAddress.put(moscow, 2000);
        costPerAddress.put(vladivostok, 7500);
        costPerAddress.put(novorossiysk, 3500);
        costPerAddress.put(chelyabinsk, 4500);
        costPerAddress.put(miami, 54_500);
        costPerAddress.put(washington, 48_900);
        costPerAddress.put(barcelona, 22_300);
        costPerAddress.put(paris, 17_777);

        int sum = 0;
        Set<String> uniqueCountry = new HashSet<>();

        while (true) {
            Scanner sc = new Scanner(System.in);
            System.out.println("Для создания нового заказа нажмите Enter или введите end");
            String input = sc.nextLine();
            if (input.equalsIgnoreCase("end")) {
                break;
            } else {
                System.out.println("Заполнение нового заказа.");
                System.out.print("Введите страну: ");
                String country = sc.nextLine();
                System.out.print("Введите город: ");
                String city = sc.nextLine();

                Address orderAddress = new Address(country, city);

                System.out.print("Введите вес (кг): ");
                try {
                    int weight = Integer.parseInt(sc.nextLine());
                    if (weight <= 0) {
                        System.out.println("Введён недопустимый вес.");
                    } else if (costPerAddress.containsKey(orderAddress)) {
                        int currentDealPrice = weight * costPerAddress.get(orderAddress);
                        System.out.println("Стоимость доставки составит: " + currentDealPrice + " руб.");
                        sum += currentDealPrice;
                        System.out.println("Общая стоимость всех доставок: " + sum + " руб.");
                        uniqueCountry.add(country);
                        System.out.println("Количество уникальных стран: " + uniqueCountry.size());
                        System.out.println("Уникальные страны: " + uniqueCountry);
                    } else {
                        System.out.println("Доставки по этому адресу нет.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ошибка: Введено не числовое значение. Введите корректное значение веса.");
                }
            }
        }
    }
}