import java.util.Random;

/*
 * 1. Создать классы Собака, Лошадь, Птица и Кот с наследованием от класса Животное.
 * 2. Животные могут выполнять действия: бежать, плыть, перепрыгивать препятствие.
 * В качестве параметра каждому методу передается величина, означающая или длину препятствия (для бега и плавания),
 * или высоту (для прыжков).
 * 3. У каждого животного есть ограничения на действия
 * (бег: кот 200 м., собака 500 м., Лошадь 1500 м., Птица 5 м.,;
 * прыжок: кот 2 м., собака 0.5 м., Лошадь 3 м., Птица 0.2 м. ;
 *  плавание: кот и птица не умеет плавать, собака 10 м., лошадь 100 м.).
 * 4. При попытке животного выполнить одно из этих действий, оно должно сообщить результат.
 * (Например, dog1.run(150); -> результат: 'Пёсик пробежал!')
 * 5. Добавить животным разброс в ограничениях. То есть у одной собаки ограничение на бег может быть 400 м., у другой 600 м.
 * */
abstract class Animal {
    protected final double runningLimit;
    protected final double jumpingLimit;


    Animal(double rl, double jl) {
        runningLimit = rl;
        jumpingLimit = jl;
    }

    protected abstract String run(double distance);

    protected abstract String jump(double distance);
}

class Dog extends Animal {
    private double swimmingLimit;

    public Dog() {
        super(500, 0.5);
        swimmingLimit = 10;
    }

    public Dog(double runDistance, double jumpHeight, double swimDistance) {
        super(runDistance, jumpHeight);
        swimmingLimit = swimDistance;
    }

    @Override
    public String run(double distance) {
        if (distance <= runningLimit)
            return "Dog runs";
        else
            return "Dog cannot run that far";
    }

    public String swim(double distance) {
        if (distance <= swimmingLimit)
            return "Dog swims";
        else
            return "Dog cannot swim that far";
    }

    @Override
    public String jump(double distance) {
        if (distance <= jumpingLimit)
            return "Dog jumps over";
        else
            return "Dog cannot jump that high";
    }
}

class Horse extends Animal {
    private double swimmingLimit;

    public Horse() {
        super(1500, 3);
        swimmingLimit = 100;
    }

    public Horse(double runDistance, double jumpHeight, double swimDistance) {
        super(runDistance, jumpHeight);
        swimmingLimit = swimDistance;
    }

    @Override
    public String run(double distance) {
        if (distance <= runningLimit)
            return "Horse runs";
        else
            return "Horse cannot run that far";
    }

    public String swim(double distance) {
        if (distance <= swimmingLimit)
            return "Horse swims";
        else
            return "Horse cannot swim that far";
    }

    @Override
    public String jump(double distance) {
        if (distance <= jumpingLimit)
            return "Horse jumps over";
        else
            return "Horse cannot jump that high";
    }
}

class Cat extends Animal {

    public Cat() {
        super(200, 2);
    }

    public Cat(double runDistance, double jumpHeight) {
        super(runDistance, jumpHeight);
    }

    @Override
    public String run(double distance) {
        if (distance <= runningLimit)
            return "Cat runs";
        else
            return "Cat cannot run that far";
    }

    @Override
    public String jump(double distance) {
        if (distance <= jumpingLimit)
            return "Cat jumps over";
        else
            return "Cat cannot jump that high";
    }
}

class Bird extends Animal {

    public Bird() {
        super(5, 0.2);
    }

    public Bird(double runDistance, double jumpHeight) {
        super(runDistance, jumpHeight);
    }

    @Override
    public String run(double distance) {
        if (distance <= runningLimit)
            return "Bird runs";
        else
            return "Bird cannot run that far";
    }

    @Override
    public String jump(double distance) {
        if (distance <= jumpingLimit)
            return "Bird jumps over";
        else
            return "Bird cannot jump that high";
    }
}

public class AnimalTest {
    public static void main(String[] args) {
        // тест со стандартными ограничениями
        Animal[] farm = {
                new Dog(),
                new Horse(),
                new Cat(),
                new Bird(),
        };
        for (Animal creature : farm) {
            System.out.println(creature.run(250));
            System.out.println(creature.jump(1));
            if (creature instanceof Dog)
                System.out.println(((Dog) creature).swim(10));
            if (creature instanceof Horse)
                System.out.println(((Horse) creature).swim(50));
        }
        System.out.println("-----------------------");
        // тест собачек с вариабельными ограничениями
        Dog[] pack = new Dog[5];
        for (int i = 0; i < 5; i++) {
            Random rand = new Random();
            double runDistance = rand.nextDouble() * 600;
            double jumpHeight = rand.nextDouble();
            double swimDistance = rand.nextDouble() * 15;
            pack[i] = new Dog(runDistance, jumpHeight, swimDistance);
            System.out.println("\nDog" + (i + 1) + ":");
            System.out.println(pack[i].run(300));
            System.out.println(pack[i].jump(0.5));
            System.out.println(pack[i].swim(10));
        }
    }
}
