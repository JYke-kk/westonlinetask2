package task1;

public class AnimalNotFountException extends RuntimeException{
    public AnimalNotFountException(String msg){
        super(msg);//这是继承异常类中的方法？
    }
}
