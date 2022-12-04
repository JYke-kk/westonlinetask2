package task1;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        MyAnimalShop myAnimalShop=new MyAnimalShop();
        myAnimalShop.set_double(1000);
        myAnimalShop.animal_list.add("Cat");
        myAnimalShop.animal_list.add("Dog");
        myAnimalShop.animal_list.add("Pig");
//        myAnimalShop.customer_list.add("ada");
//        myAnimalShop.customer_list.add("lynn");
//        myAnimalShop.customer_list.add("lainey");

        Animal Cat= new Cat("一只可爱的小猫", 1, "female", 200) {
            @Override
            public String toString() {
                return null;
            }
        };

        Animal Dog=new Dog("一只温顺的小狗",2,"male",100) {
            @Override
            public String toString() {
                return null;
            }
        };
        Customer customer1=new Customer("ada",1, LocalDate.now());
        Customer customer2=new Customer("lynn",2, LocalDate.now());
        Customer customer3=new Customer("lainey",3, LocalDate.now());

        System.out.println("=================");
       myAnimalShop.buy_animal(Cat);
       myAnimalShop.buy_animal(Dog);
        System.out.println("=================");
       myAnimalShop.entertain_customer(customer1);
        System.out.println("=================");
     // myAnimalShop.entertain_customer(customer2);
     //  myAnimalShop.entertain_customer(customer3);
        myAnimalShop.close_(customer1);
        myAnimalShop.close_(customer2);
        myAnimalShop.close_(customer3);
    }

}
