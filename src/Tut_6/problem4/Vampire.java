package Tut_6.problem4;

class Vampire extends Monster {
    protected Point2D position = new Point2D(0,0);

    public Vampire(String name) {
        super(name);
    }
    public Vampire (String name, int health) {
        super(name, health);
    }
    public Vampire(String name, int health, int attackPower) {
        super(name, health, attackPower);
    }
    public Vampire(String name, int health, int attackPower, Point2D position) {
        super (name, health, attackPower, position);
    }
    @Override
    public void transform() {
        System.out.println(getName()+" transforms into a bat!");
    }
    @Override
    public void attack() {
        System.out.println( getName() + " (Vampire) attacks by sucking blood!");
    }
}