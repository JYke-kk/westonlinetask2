package task1;

public abstract class Dog extends Animal{
    public Dog(String name, int age, String gender, double price) {
        super(name, age, gender, price);
    }
    boolean isVaccineInjected;
    double price=100;
}
