/**
 * @Author: lty
 * @Date: 2020/11/18 09:10
 */
public class Main {
    public static void main(String[] args) {
        OrderCommand orderCommand = new OrderCommand();
        orderCommand.basedo();

        PayCommand payCommand = new PayCommand();
        payCommand.basedo();
    }
}
