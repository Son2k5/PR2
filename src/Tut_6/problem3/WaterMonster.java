package Tut_6.problem3;

public class WaterMonster extends Monster {
    public WaterMonster() {
        super();
    }
    public WaterMonster(String name) {
        super(name);
    }
    @Override
    public String getName(){
        return name;
    }
    @Override
    public void setName(String name){
        super.setName(name);
    }
    public String attack(){
        return getName() + " attacks with water!";
    }
}
