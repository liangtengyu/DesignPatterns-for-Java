import com.lty.designs.Menu.Builder;
import org.junit.Test;

/**
 * @Author: lty
 * @Date: 2020/11/13 10:57
 */
public class APITest {
    @Test
    public void T(){
        Builder builder = new Builder();
        System.out.println(builder.levelOne(122D).getDetail());

    }

}
