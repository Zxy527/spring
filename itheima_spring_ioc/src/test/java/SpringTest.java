import com.itheima.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author: zxy
 * @Date: 2022/4/1 - 04 - 01 - 9:59
 * @Description: PACKAGE_NAME
 * @version: 1.0
 */
public class SpringTest {
  @Test
    //测试scope属性
    public void test(){
      ClassPathXmlApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
        //用接口接收一下，我们知道这个是UserDao类型的，所以用UserDao接收
        UserDao userDao1 = (UserDao) app.getBean("userDao");
        System.out.println(userDao1);
        //app.close();

    }
}
