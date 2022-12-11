

public class BattleScene {


    public void fight(Hero hero) {
        Monster monster = createMonster();
        int turn = 1;
        while (isLeave(hero) && isLeave(monster)) {
            System.out.println("----Ход: " + turn + "----");
            if (hero.attack() != 0) {
                monster.setHealthPoints(monster.getHealthPoints() - hero.getStrength());
                System.out.println(String.format("%s Нанес удар в %d единиц!", hero.getName(), hero.getStrength()));
                if (!isLeave(monster)) {
                    System.out.println(String.format("Враг повержен! Вы получаете %d опыт и %d золота", monster.getXp(), monster.getGold()));
                    hero.setXp(hero.getXp() + monster.getXp());
                    hero.setGold(hero.getGold() + monster.getGold());
                    if(hero.getXp() > hero.getNextLevel()){
                        hero.setNewLevel();
                    }
                    break;// вызов меню
                }
            } else {
                System.out.println(String.format("%s промахнулся!", hero.getName()));
            }
            if (monster.attack() != 0) {
                hero.setHealthPoints(hero.getHealthPoints() - monster.getStrength());
                System.out.println(String.format("%s Нанес удар в %d единиц!", monster.getName(), monster.getStrength()));
                if (!isLeave(hero)) {
                    System.out.println("Вы проиграли");
                    System.exit(1);
                }
            } else {
                System.out.println(String.format("%s промахнулся!", monster.getName()));
            }
            turn++;
            try {
                //Чтобы бой не проходил за секунду, сделаем имитацию работы, как если бы
                //у нас была анимация
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }


    private static Monster createMonster() {
        //Рандомайзер
        int random = (int) (Math.random() * 10);
        //С вероятностью 50% создается или скелет, или гоблин
        if (random % 2 == 0) return new GoblinMonster(
                "Гоблин",
                50,
                10,
                10,
                100,
                20
        );
        else return new SkeletonMonster(
                "Скелет",
                25,
                20,
                20,
                100,
                10
        );
    }

    private boolean isLeave(FantasyCharacter fc) {
        if (fc.getHealthPoints() > 0) {
            return true;
        } else return false;
    }


}
