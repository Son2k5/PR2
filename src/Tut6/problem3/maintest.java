package Tut6.problem3;

public class maintest {
    public static void main(String[] args) {
        // Polymorphism: Substituting superclass reference with subclass instances
        Monster m1 = new FireMonster("Inferno");
        Monster m2 = new WaterMonster("Aqua");
        Monster m3 = new StoneMonster("Rocky");

        // Invoking attack() on each monster
        System.out.println(m1.attack()); // Calls FireMonster's attack
        System.out.println(m2.attack()); // Calls WaterMonster's attack
        System.out.println(m3.attack()); // Calls StoneMonster's attack

        // Reassigning superclass reference to another subclass instance
        m1 = new StoneMonster("Golem");
        System.out.println(m1.attack()); // Now calls StoneMonster's attack

        // Handling scenario where an instance of the superclass is directly created using an anonymous class
        Monster m5 = new Monster("Unknown") {
            @Override
            public String attack() {
                return "I am a generic monster and have no specific attack!";
            }
        };
        System.out.println(m5.attack()); // Generic attack message
    }
}
