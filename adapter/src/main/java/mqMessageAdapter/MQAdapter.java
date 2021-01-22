package mqMessageAdapter;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import mq.POPOrderDelivered;
import mq.create_account;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

class MQAdapter  {

    public static RebateInfo mqHandler(JSONObject obj,HashMap linkMap)  {
        RebateInfo rebateInfo = new RebateInfo();
        linkMap.forEach((k,v)->{
            try {
                RebateInfo.class.getMethod("set" + k, String.class).invoke(rebateInfo, obj.get(v).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (InvocationTargetException e) {
                e.printStackTrace();
            } catch (NoSuchMethodException e) {
                e.printStackTrace();
            }
        });


        return rebateInfo;
    }

     public static void main(String[] args) throws ParseException {
         SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
         Date parse = s.parse("2020-06-01 23:20:16");


         create_account create_account = new create_account();
         create_account.setNumber("100001");
         create_account.setAddress("河北省.廊坊市.广阳区.大学里职业技术学院");
         create_account.setAccountDate(parse);
         create_account.setDesc("在校开户");

         HashMap<String,String> linkMap = new HashMap();
         linkMap.put("UserId", "number");
         linkMap.put("BizId", "number");
         linkMap.put("BizTime", "accountDate");
         linkMap.put("Desc", "desc");
         RebateInfo rebateInfo = mqHandler(JSON.parseObject(create_account.toString()), linkMap);
         System.out.println(rebateInfo.toString());
         System.out.println(rebateInfo.toString());
     }


}
