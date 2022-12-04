package task1;

import org.omg.CORBA.PUBLIC_MEMBER;

import java.time.LocalDateTime;
import java.util.ArrayList;

//接口支持多实现
public class MyAnimalShop implements AnimalShop {
    double _double;//余额
    ArrayList<String> animal_list=new ArrayList<>();//动物列表
   // list.add("Cat");不能在这里直接设置列表报错

    ArrayList<String> customer_list=new ArrayList<>();//顾客列表留做纪念？
    boolean close;

    public double get_double() {
        return _double;
    }

    public void set_double(double _double) {
        this._double = _double;
    }

    public void buy_animal(Animal a) throws InsufficientBalanceException {
        if (_double-a.price>0){
            System.out.println("买了"+a.name+",年龄是"+a.age+",性别是"+a.gender+",余额充足，可以买入该动物" + "账户里还有"+(_double-a.price)+"元");
        }else {//抛出异常
            throw new InsufficientBalanceException("余额不足，买不了改动物");
        }
    }

    public void entertain_customer(Customer c) throws AnimalNotFountException{
        if (animal_list!=null){
            System.out.println("店内有动物，可以用来招待顾客,店里还有"+animal_list);
        }else {
            throw new AnimalNotFountException("没有动物了，不能招待顾客");
        }
    }

    public void close_(Customer c1){
        //不知道如何用localdate判断
     //   System.out.println("顾客的名字叫"+c1.customer_name);
        LocalDateTime localDate = LocalDateTime.now();
        if (localDate.getHour() < 10 && localDate.getHour() > 21) {
            close = true;
        } else {
            close = false;
        }
        System.out.println("输出当天顾客信息"+c1.toString());
        for (int i = 0; i < customer_list.size(); i++) {
            System.out.println(customer_list.get(i));
        }
        System.out.println("一天的利润"+(_double+200*c1.number));
      //  System.out.print(_double);
    }


    @Override
    public void buy() {

    }

    @Override
    public void entertain(Customer customer_name) {
    }
    @Override
    public void close() {
    }

}
