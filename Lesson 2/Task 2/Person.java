public class Person {
    private String name;
    private String surname;

    Person(){
        System.out.println("Create Person");
    }

    Person(String name, String surname){
        this.name = name;
        this.surname = surname;
        System.out.println("Create Person");
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
