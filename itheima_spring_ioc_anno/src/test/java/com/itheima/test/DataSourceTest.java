package com.itheima.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidPooledConnection;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.util.ResourceBundle;

/**
 * @Author: zxy
 * @Date: 2022/4/2 - 04 - 02 - 13:28
 * @Description: com.itheima.test
 * @version: 1.0
 */
public class DataSourceTest {
    @Test
    //测试spring容器产生c3p0数据源(加载配置properties配置文件)
    public void test4() throws Exception {
        ApplicationContext app=new ClassPathXmlApplicationContext("applicationContext.xml");
//        Object dataSource = app.getBean("dataSource");
        DataSource dataSource = app.getBean(DataSource.class);
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();//释放资源
    }

    @Test
    //测试手动创建c3p0数据源(加载配置properties配置文件)
    public void test3() throws Exception {
       //读取配置文件
        ResourceBundle rb=ResourceBundle.getBundle("jdbc");
        String drive=rb.getString("jdbc.driver");
        String url=rb.getString("jdbc.url");
        String username=rb.getString("jdbc.username");
        String password=rb.getString("jdbc.password");
        //创建数据源对象，设置链接参数
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass(drive);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        //获得资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭资源
        connection.close();
        //抽取配置文件是为了方便解耦。因为代码后期要进行编译，编译后在打完的包中看到的就是字节码文件，字节码文件我们是看不懂的，但是
        //配置文件就不一样了，配置文件张什么样，打完包还是张什么样，可以直接在对应的包中进行修改就好了
    }

    @Test
    //测试手动创建druid数据源
    public void test2() throws Exception {
        //导入坐标
        //创建数据源对象
        DruidDataSource dataSource=new DruidDataSource();
        //设置基本链接信息
        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUsername("root");
        dataSource.setPassword("123456");
        //数据源可以用了，现在获取资源
        DruidPooledConnection connection = dataSource.getConnection();
        System.out.println(connection);
        //释放资源
        connection.close();
    }


    @Test
    //测试手动创建c3p0数据源
    public void test1() throws Exception {
        ComboPooledDataSource dataSource=new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.jdbc.Driver");
        //
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/test");
        dataSource.setUser("root");
        dataSource.setPassword("123456");
        //获取资源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        //关闭
        connection.close();
    }

}
