package task1;

import java.time.LocalDate;

public class Customer {
    String customer_name;
    int number;//到店次数
    LocalDate date;

    public Customer(String customer_name, int number, LocalDate date) {
        this.customer_name = customer_name;
        this.number = number;
        this.date = date;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customer_name='" + customer_name + '\'' +
                ", number=" + number +
                ", date=" + date +
                '}';
    }


}
