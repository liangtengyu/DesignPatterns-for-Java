/**
 * @Author: lty
 * @Date: 2020/11/18 09:07
 */

public abstract class BaseCommand {
    public void basedo(){
        System.out.println("log>>方法前置处理..");
        doit();
        System.out.println("log>>方法后置处理..");
    }

    protected abstract void doit();

}
