import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Hero extends FantasyCharacter{
    private int level = 1;

    public Set<Good> bag = new HashSet<>() {
    };
    private int nextLevel = 500;
    private int maxHealfPoint;
    public Hero(String name, int healthPoints, int strength, int dexterity, int xp, int gold, int maxHealfPoint){
        super(name, healthPoints, strength, dexterity, xp, gold);
        this.maxHealfPoint = maxHealfPoint;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }



    public int getNextLevel() {
        return nextLevel;
    }





    public void setNewLevel(){
        setHealthPoints(maxHealfPoint + 25);
        setLevel(getLevel() + 1);
        setXp(nextLevel - getXp());
        setStrength(getStrength() + 10);
        setHealthPoints(getMaxHealfPoint());
        System.out.println("Поздравляем " + getName() + "! У Вас новый уровень: " + getLevel());
    }
    public void checkingTheLevel(int nowXP){
        if (nowXP > nextLevel) {
            setNewLevel();
        }
    }



    public void setNextLevel(int nextLevel) {
        this.nextLevel = nextLevel;
    }

    public void setMaxHealfPoint(int maxHealfPoint) {
        this.maxHealfPoint = maxHealfPoint;
    }

    public int getMaxHealfPoint() {
        return maxHealfPoint;
    }
}
