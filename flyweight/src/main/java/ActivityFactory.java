import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: lty
 * @Date: 2020/11/24 15:40
 */
public class ActivityFactory {

    public static ConcurrentHashMap<String, Activity> cacheMap = new ConcurrentHashMap<>();

    public Activity getActivity(String id) {
        Activity activity = cacheMap.get(id);
        if (null == activity) {
            activity = new Activity();
            activity.setBookno("1");
            activity.setBookprice("188");
            activity.setId("1");
            activity.setName("JAVA宝典");
            cacheMap.put("1", activity);
        }
        return activity;
    }
}
