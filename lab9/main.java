import java.util.List;
import java.util.Random;

// ===== Главный класс =====
public class Main {

    public static void main(String[] args) {

        // Создаем персонажей
        List<Character> party = List.of(
            new Warrior("Thor"),
            new Mage("Merlin"),
            new Archer("Legolas")
        );

        // Все персонажи атакуют случайную цель
        Random rand = new Random();
        for (Character attacker : party) {
            Character target = party.get(rand.nextInt(party.size()));
            while (target == attacker) { // чтобы не атаковать себя
                target = party.get(rand.nextInt(party.size()));
            }
            attacker.attack(target);
        }

        // Показываем состояние здоровья
        System.out.println("\n=== Состояние здоровья ===");
        for (Character c : party) {
            System.out.println(c.name + ": " + c.health + " HP");
        }
    }
}

// ===== Абстрактный базовый класс =====
abstract class Character {

    String name;
    int health = 100;

    Character(String name) {
        this.name = name;
    }

    // Полиморфный метод атаки
    abstract void attack(Character target);

    // Метод для получения урона
    void takeDamage(int damage) {
        health -= damage;
        if (health < 0) health = 0;
    }
}

// ===== Интерфейсы для специальных способностей =====
interface Magic {
    void castSpell(Character target);
}

interface Ranged {
    void shoot(Character target);
}

// ===== Warrior =====
class Warrior extends Character {

    Warrior(String name) {
        super(name);
    }

    @Override
    void attack(Character target) {
        int damage = 15;
        target.takeDamage(damage);
        System.out.println(name + " attacks " + target.name + " with a sword for " + damage + " damage!");
    }
}

// ===== Mage =====
class Mage extends Character implements Magic {

    Mage(String name) {
        super(name);
    }

    @Override
    void attack(Character target) {
        castSpell(target);
    }

    @Override
    public void castSpell(Character target) {
        int damage = 20;
        target.takeDamage(damage);
        System.out.println(name + " casts a fireball on " + target.name + " for " + damage + " damage!");
    }
}

// ===== Archer =====
class Archer extends Character implements Ranged {

    Archer(String name) {
        super(name);
    }

    @Override
    void attack(Character target) {
        shoot(target);
    }

    @Override
    public void shoot(Character target) {
        int damage = 12;
        target.takeDamage(damage);
        System.out.println(name + " shoots an arrow at " + target.name + " for " + damage + " damage!");
    }
}
