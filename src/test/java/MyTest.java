import com.carry.pojo.User;
import com.carry.service.user.UserService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {

    @Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        UserService userService = (UserService) context.getBean("UserServiceImpl");
        System.out.println("出生日期："+userService.getUserById(12).getBirthday());
        //System.out.println("日期："+userService.getUserById(12).getCreationDate());
        //System.out.println("出生日期2："+userService.getUserById(12).getBirth());
    }

}

