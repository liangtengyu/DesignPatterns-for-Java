
import com.lty.designs.ResourceConfig;
import org.junit.Test;

/**
 * @Author: lty
 * @Date: 2020/11/13 10:57
 */
public class APITest {
    @Test
    public void T(){
        ResourceConfig config = new ResourceConfig.ResourceConfigBuilder()
                .setName("test")
                .setMaxTotal(10)
                .setMaxIdle(1)
                .setMinIdle(0)
                .build();

        System.out.println(config);


    }

    @Test
    public void T2(){
        ResourceConfig config = new ResourceConfig.ResourceConfigBuilder()
                .setName("test")
                .setMaxTotal(10)
                .setMaxIdle(1)
                .setMinIdle(11)
                .build();

        System.out.println(config);

        /**
         * java.lang.IllegalArgumentException: 无效的参数, cause : minIdle > maxTotal
         *
         * 	at com.lty.designs.ResourceConfig$ResourceConfigBuilder.build(ResourceConfig.java:100)
         * 	at APITest.T2(APITest.java:31)
         */

    }

}
