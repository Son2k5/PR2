package Tut_6.problem3;

public class StoneMonster extends Monster {
    public StoneMonster() {
        super();
    }
    public StoneMonster(String name) {
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
        return getName() + " attacks with stone!";
    }
}
