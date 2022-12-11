import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    //Класс для чтения введенных строк из консоли
    private static BufferedReader br;
    //Игрок должен храниться на протяжении всей игры
    private static Merchant merchant = new Merchant();
    private static Hero player = null;
    //Класс для битвы можно не создавать каждый раз, а переиспользовать
    private static BattleScene battleScene = null;


    public static void main(String[] args) {
        br = new BufferedReader(new InputStreamReader(System.in));
        //Инициализируем класс для боя
        battleScene = new BattleScene();
        System.out.println("Введите имя персонажа:");
        try {
            command(br.readLine());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    protected static void command(String string) throws IOException {
        //Если это первый запуск, то мы должны создать игрока, именем будет служить первая введенная строка из консоли
        if (player == null) {
            System.out.println("Выберите персонажа: 1.Танк 2.Дамагер");
            String com = br.readLine();
            player = isHero(string, com);
            System.out.println(String.format("Спасти наш мир от драконов вызвался %s! Да будет его броня крепка и бицепс кругл!", player.getName()));
            //Метод для вывода меню
            printNavigation();
        }
        //Варианты для команд
        switch (string) {
            case "1": {
                merchant.seller(player);
            }
            break;
            case "2": {
                battle(player);
            }
            break;
            case "3":
                System.exit(1);
                break;
            case "да":
                command("2");
                break;
            case "нет": {
                printNavigation();
                command(br.readLine());
            }
        }
        //Снова ждем команды от пользователя
        command(br.readLine());
    }
    private static void printNavigation() {
        System.out.println("Куда вы хотите пойти?");
        System.out.println("1. К Торговцу");
        System.out.println("2. В темный лес");
        System.out.println("3. Выход");
    }
    private static Hero isHero (String str1, String str2){
        Hero hr = null;
        switch (str2){
            case "1":
                hr = new TankHero(str1, 150, 20, 20, 0,0, 1);
                break;
            case "2":
                hr = new DamageHero(str1, 100,30,20,0,0,1);
                break;
        }
        return hr;
    }

    private static void battle(Hero hero) throws IOException {
        battleScene.fight(hero);
        System.out.println("У вас осталось " + hero.getHealthPoints() + "жизни");
        System.out.println("У вас " + hero.getGold() + "золота");
        System.out.println("Вы хотите продолжить битву? Да/Нет");
        command(br.readLine());
    }

}
