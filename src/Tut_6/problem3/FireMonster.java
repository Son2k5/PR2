package Tut_6.problem3;

public class FireMonster extends Monster {
    public FireMonster() {
        super();
    }
    public FireMonster(String name) {
        super(name);
    }
    @Override
    public void setName(String name){
        super.setName(name);
    }
    @Override
    public String getName(){
        return name;
    }
    public String attack(){
        return getName() + " attacks with fire!";
    }
}
