package Tut6.problem4;

abstract class Monster implements SpecialAbility , Moveable  {
    protected String name;
    protected int health = 100;
    protected int attackPower = 1;
    protected Point2D position = new Point2D();
    public Monster() {

    }
    public Monster(String name) {
        this.name = name;
    }
    public Monster (String name, int health) {
        this.name = name;
        this.health = health;
    }
    public Monster (String name, int health, int attackPower) {
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
    }
    public Monster (String name, int health, int attackPower, Point2D position) {
        this.name = name;
        this.attackPower = attackPower;
        this.health = health;
        this.position = position;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getHealth() {
        return health;
    }
    public void decreaseHealth() {
        this.health -= getAttackPower();
    }
    public int getAttackPower() {
        return attackPower;
    }
    public void raiseAttackPower() {

    }

    public String getPosition() {
        return position.toString();
    }

    public void moveUp() { position.setY(position.getY() + 1); }
    public void moveDown() { position.setY(position.getY() - 1); }
    public void moveLeft() { position.setX(position.getX() - 1); }
    public void moveRight() { position.setX(position.getX() + 1); }
    public void teleport(Point2D position) {
        this.position = position;

    }
    public abstract void attack();
}
