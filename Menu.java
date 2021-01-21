import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Menu {

    private Scanner scanner;
    private String in;
    private int numberAction;
    protected boolean isExit = false;

    //hierarchy 0
    private LinkedHashMap<Integer, String> mainMenu = new LinkedHashMap<>();

    //hierarchy 1
    private LinkedHashMap<Integer, String> shopMenu = new LinkedHashMap<>();


    private int hierarchy;

    public Menu() {

        hierarchy = 0;

        String mainMenu_0 = "Меню:";
        String mainMenu_1 = "ходить на работу и получить 100";
        String mainMenu_2 = "ходить в магазин";
        String mainMenu_3 = "выйти из игры";

        String shopMenu_0 = "Меню магазина:";
        String shopMenu_1 = "купить предмет 1";
        String shopMenu_2 = "купить предмет 2";
        String shopMenu_3 = "купить предмет 3";
        String shopMenu_4 = "выйти из магазина";

        mainMenu.put(0, mainMenu_0);
        mainMenu.put(1, mainMenu_1);
        mainMenu.put(2, mainMenu_2);
        mainMenu.put(3, mainMenu_3);

        shopMenu.put(0, shopMenu_0);
        shopMenu.put(1, shopMenu_1);
        shopMenu.put(2, shopMenu_2);
        shopMenu.put(3, shopMenu_3);
        shopMenu.put(4, shopMenu_4);

    }

    protected void checkInput() {
        while (!isExit) {
            displayMenu();
            scanner = new Scanner(System.in);
            in = scanner.nextLine();

            if ((!in.isEmpty()) && (isDigit(in))) {
                numberAction = Integer.parseInt(in);
                if ((hierarchy == 0) && (numberAction <= mainMenu.size()) && (numberAction > 0)) {
                    actionInMainMenu(numberAction);
                } else {
                    if ((hierarchy == 1) && (numberAction <= shopMenu.size()) && (numberAction > 0)) {
                        actionInShopMenu(numberAction);
                    }
                }
            } else {
                messageToConsole("Выберите пункт меню");
            }
        }

    }

    private static boolean isDigit(String s) {
        try {
            Integer.parseInt(s);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    private void displayMenu() {

        switch (hierarchy) {
            case 0:
                consoleOutput(mainMenu);
                break;
            case 1:
                consoleOutput(shopMenu);
                break;
            default:
                System.out.println("В иерархии нет такого меню, номер иерархии: " + hierarchy);
                break;

        }
    }

    private void actionInMainMenu(int numberAction) {

        switch (numberAction) {
            case 1:
                messageToConsole("Сходили на работу, получили 100");
                break;
            case 2:
                hierarchy = 1;
                break;
            case 3:
                messageToConsole("Выход");
                isExit = true;
                break;
        }
    }

    private void actionInShopMenu(int numberAction) {
        switch (numberAction) {
            case 1:
                messageToConsole("Действие 1");
                break;
            case 2:
                messageToConsole("Действие 1");
                break;
            case 3:
                messageToConsole("Действие 1");
                break;
            case 4:
                hierarchy = 0;
                break;
        }
    }

    private void consoleOutput(LinkedHashMap<Integer, String> anyptingMenu) {

        for (Map.Entry<Integer, String> entry : anyptingMenu.entrySet()) {
            if (entry.getKey() == 0) {
                System.out.println("      " + entry.getValue());
            } else {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        }
    }

    private static void messageToConsole(String s) {
        System.out.println();
        System.out.println(s);
        System.out.println();
    }
}






































