import java.io.IOException;
import java.util.Scanner;

public class Merchant {
    Scanner scanner = new Scanner(System.in);
    public void seller(Hero hero) throws IOException {
        System.out.println("Рад приветствовать тебя в своей лавке " + hero.getName());
        System.out.println("Хочешь купить у меня что то?");
        System.out.println("Введите Да/Нет");
        comandSeller(scanner.nextLine(), hero);

    }

    public void comandSeller(String str, Hero hero) throws IOException {
        if(str.equals("Да")){
            System.out.println("Вот взгляни чт о у меня есть:");
            for (Good product:Good.values ()){
                System.out.println((product.ordinal() + 1) + "." + product.getNameForRussian() + " стоит:" + product.getCash());
            }
            comandOfSeller();
            purchaseSelection(scanner.nextInt(),hero);
            seller(hero);
        }else if(str.equals("Нет")){

        }else
            comandSeller(scanner.nextLine(),hero);
    }

    public void purchaseSelection(int numberComand, Hero sellerHero) throws IOException {
        int price;
        switch (numberComand){
            case 1:
                price = sellerHero.getGold() - Good.POTION_OF_LIFE.getCash();
                if(enoughMoney(price)){
                    sellerHero.setGold(price);
                    if(sellerHero.getHealthPoints() + Good.POTION_OF_LIFE.getTreatment() >=
                            sellerHero.getMaxHealfPoint()){
                        sellerHero.setHealthPoints(sellerHero.getHealthPoints() + Good.POTION_OF_LIFE.getTreatment());
                    }else System.out.println("Вы здоровы");
                }else System.out.println("У вас недостаточно средств!");
                break;
            case 2:
                price = sellerHero.getGold() - Good.POTIOM_OF_XP.getCash();
                if(enoughMoney(price)){
                    sellerHero.setGold(price);
                    sellerHero.setXp(sellerHero.getXp() + Good.POTIOM_OF_XP.getTheExperienceGained());
                    sellerHero.checkingTheLevel(sellerHero.getXp());
                }else System.out.println("У вас недостаточно денег");
                break;
            case 3:
                price = sellerHero.getGold() - Good.SWORD.getCash();
                if(enoughMoney(price)){
                    if(!sellerHero.bag.contains(Good.SWORD)){
                        System.out.println("Поздравляю с покупкой Вы купили" + Good.SWORD.getNameForRussian());
                        sellerHero.setStrength(Good.SWORD.getIncreasedDamage());
                        sellerHero.bag.add(Good.SWORD);
                    }else System.out.println("У вас уже есть меч!");
                }else System.out.println("У вас недостаточно денег");
                break;
            case 4:
                price = sellerHero.getGold() - Good.SHILD.getCash();
                if(enoughMoney(price)){
                    if(!sellerHero.bag.contains(Good.SHILD)){
                        System.out.println("Поздравляю с покупкой Вы купили" + Good.SHILD.getNameForRussian());
                        sellerHero.setMaxHealfPoint(Good.SHILD.getIncreasedLife());
                        sellerHero.bag.add(Good.SHILD);
                    }else System.out.println("У вас уже есть " + Good.SHILD.getNameForRussian());
                }else System.out.println("У вас недостаточно денег");
                break;
            case 5:
                price = sellerHero.getGold() - Good.ARMOR.getCash();
                if(enoughMoney(price)){
                    if(!sellerHero.bag.contains(Good.ARMOR)){
                        System.out.println("Поздравляю с покупкой Вы купили" + Good.ARMOR.getNameForRussian());
                        sellerHero.setDexterity(Good.ARMOR.getIncreasedDexterity());
                        sellerHero.bag.add(Good.ARMOR);
                    }else System.out.println("У вас уже есть " + Good.ARMOR.getNameForRussian());
                }else System.out.println("У вас недостаточно денег");
                break;
            case 6:
                System.out.println("У вас золота:" + sellerHero.getGold());
                System.out.println("У вас опыт " + sellerHero.getXp() + "до следующего уровня " +
                        (sellerHero.getNextLevel() - sellerHero.getXp()));
                System.out.println("У вас " + sellerHero.getHealthPoints());
                if(sellerHero.bag.isEmpty()){
                    System.out.println("Ваш рэкзак пуст");
                }else {
                    System.out.println("В вашем рюкзаке есть" + sellerHero.bag.toString());
                }
                break;
            case 7:
                Main.command(scanner.nextLine());
                break;
            default:
                System.out.println("Вы ввели неправильную команду");
                purchaseSelection(scanner.nextInt(), sellerHero);
                break;
        }
    }
    private boolean enoughMoney(int x){
        return x > 0;
    }

    private void comandOfSeller(){
        System.out.println("1. Купить зелье жизни 2.Купить опыт. 3. Купить меч");
        System.out.println("4.Купить щит 5.Купить броню. 6. Посмотреть что у меня есть");
        System.out.println("7. Выход");
    }

}
