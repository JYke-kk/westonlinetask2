package task1;

public abstract class Animal {
    //抽象类 不可以创建具体对象 必须重写父类中的抽象方法 否则子类也必须是抽象类
  protected   String name;
  protected   int age;
  protected   String gender;
  protected   double price;

    public Animal(String name, int age, String gender, double price) {//全参构造
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.price = price;
    }
    @Override//抽象类toString
    public abstract String toString();

}

