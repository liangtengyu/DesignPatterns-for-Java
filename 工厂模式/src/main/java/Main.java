import entity.Cocacola;
import factory.ColaFactory;

/**
 * @Author: lty
 * @Date: 2020/12/3 09:20
 */
public class Main {
    public static void main(String[] args) {
        String drink = ColaFactory.getInstance(1).drink();
        System.out.println(drink);
    }
}
