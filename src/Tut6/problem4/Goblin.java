package Tut6.problem4;

class Goblin extends Monster {
    protected Point2D position = new Point2D(0,0);

    public Goblin(String name) {
        super(name);
    }
    public Goblin (String name, int health) {
        super(name, health);
    }
    public Goblin(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    public Goblin(String name, int health, int attackPower, Point2D position) {
        super (name, health, attackPower, position);
    }
    @Override
    public void transform() {
        System.out.println(getName()+" transforms into Hulk!");
    }

    @Override
    public void attack() {
        System.out.println( getName() + " (Goblin) attacks with a club!");
    }
}