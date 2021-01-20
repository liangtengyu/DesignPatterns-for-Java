import com.lty.dao.DatabaseDao;
import com.lty.entity.Entity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author: lty
 * @Date: 2021/1/20 10:02
 */
public class APITest {
    @Test
    public void test(){
        List<Entity> list = DatabaseDao.getList();
        //输出从数据库中获取的数据
        System.out.println("数据库中获取的数据为:"+list);

        List<Entity> copyList = new ArrayList<>(list);
        System.out.println("复制的数据为:" + copyList);

        list.remove(0);//删除原始List的第一个
        System.out.println("删除后数据库中获取的数据为:"+list);

        System.out.println("删除后复制的数据为:" + copyList);
    }
}
