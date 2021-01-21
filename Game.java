public class Game {


    private static Menu menu;

    public static void main(String[] args) {
        menu = new Menu();

        game();

    }


    private static void game() {
        while (!menu.isExit) {
                menu.checkInput();
        }
    }
}
