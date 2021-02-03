import util.RedisUtil;

/**
 * @Author: lty
 * @Date: 2020/11/24 15:42
 */
public class ActivityController {
    //模拟请求进来,获取activity 这时加载动态数据,Stack
    public static Activity getActivity(String id) {
        Activity activity = new ActivityFactory().getActivity("1");

        Stack stack = new Stack();
        stack.setHave(1000);
        stack.setUesd(RedisUtil.getInstance().getStack());
        activity.setStack(stack);
        return activity;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Activity activity = ActivityController.getActivity("1");
            System.out.println(activity.toString());
        }
    }
}
