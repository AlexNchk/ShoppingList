
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    protected static int shop;

    public static void main(String[] args) {
        shop = 0;
        List<String> list = new ArrayList<>();
        list.add("Молоко");
        list.add("Кефир");
        list.add("Хлеб");
        list.add("Батон");
        list.add("Курица");
        list.add("Яйцо");
        List<String> shopping = new ArrayList<>();

        Scanner scanner = new Scanner(System.in);
        int operations1 = 0;
        while (true) {
            System.out.println("Выберите операцию или введите end:");
            System.out.println("1. Добавить");
            System.out.println("2. Показать");
            System.out.println("3. Удалить");
            System.out.println("4. Найти");
            String number = scanner.nextLine();
            if ("end".equals(number)) {
                break;
            }
            try {
                operations1 = Integer.parseInt(number);
            } catch (Exception e) {
                operations1 = 0;
                System.out.print("ВНИМАНИЕ! ");
            }
            switch (operations1) {
                case 1:
                    System.out.println("Какую покупку хотите совершить?");
                    String name = scanner.nextLine();
                    if (list.contains(name)) {
                        shopping.add(name);
                        shop++;
                        System.out.println("Итого в списке покупок: " + shop);
                    } else {
                        System.out.println("Такого товара нет, итого в списке покупок: " + shop);
                    }
                    break;
                case 2:
                    System.out.println("Список покупок:");
                    for (int i = 0; i < shopping.size(); i++) {
                        for (String s : shopping) {
                            System.out.println((++i) + ". " + s);
                        }
                    }
                    break;
                case 3:
                    System.out.println("Список покупок:");
                    for (int i = 0; i < shopping.size(); i++) {
                        for (String s : shopping) {
                            System.out.println((++i) + ". " + s);
                        }
                    }
                    System.out.println("Какую хотите удалить? Введите номер или название");
                    String delShop = scanner.nextLine();
                    try {
                        int choiceDelNumb = Integer.parseInt(delShop);
                        System.out.println("Покупка " + shopping.get(--choiceDelNumb) + " удалена. Список покупок");
                        shopping.remove(choiceDelNumb);
                        shop--;
                        for (int i = 0; i < shopping.size(); i++) {
                            for (String s : shopping) {
                                System.out.println((++i) + ". " + s);
                            }
                        }
                    } catch (Exception e) {
                        String choiceDelName = String.valueOf(delShop);
                        if (list.contains(choiceDelName)) {
                            shopping.remove(choiceDelName);
                            shop--;
                            System.out.println("Покупка " + choiceDelName + " удалена. Список покупок");
                            for (int i = 0; i < shopping.size(); i++) {
                                for (String s : shopping) {
                                    System.out.println((++i) + ". " + s);
                                }
                            }
                        } else {
                            System.out.println("Такого товара нет, итого в списке покупок: " + shop);
                        }
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Введите текст для поиска:");
                    String searchShop = scanner.nextLine();
                    String queryLower = searchShop.toLowerCase();
                    System.out.println("Найдено:");
                    for (int i = 0; i < shopping.size(); i++) {
                        for (String s : shopping) {
                            String itemLower = s.toLowerCase();
                            if (itemLower.contains(queryLower)) {
                                System.out.println((++i) + ". " + s);
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }

    }
}
