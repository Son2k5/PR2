package Tut_6.problem3;

abstract class Monster {
    protected String name;
    public Monster() {

    }
    public Monster(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public abstract String attack();
}
