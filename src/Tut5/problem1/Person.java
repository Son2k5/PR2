package Tut5.problem1;

class Person {
    private String name;
    private String address;


    public Person(String name, String address) {
        this.name = name;
        this.address = address;
    }


    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }


    @Override
    public String toString() {
        return "Person[name=" + name + ",address=" + address + "]";
    }
}
