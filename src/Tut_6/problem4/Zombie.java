package Tut_6.problem4;

class Zombie extends Monster {
    protected Point2D position = new Point2D(0,0);

    public Zombie(String name) {
        super(name);
    }
    public Zombie(String name, int health) {
        super(name, health);
    }
    public Zombie(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    public Zombie(String name, int health, int attackPower, Point2D position) {
        super (name, health, attackPower, position);
    }
    @Override
    public void transform() {
        System.out.println(getName()+" transforms into Terminal!");
    }
    @Override
    public void attack() {
        System.out.println( getName() + " (Zombie) attacks by biting!");
    }
}