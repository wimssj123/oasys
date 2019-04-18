import com.cc.service.UserService;
import com.cc.service.impl.UserServiceImpl;
import com.cc.vo.VUser;
import org.junit.Test;

import java.util.List;

public class Test1 {

    @Test
    public void test(){
        UserService userService  = new UserServiceImpl();

        List<VUser> list = userService.selectAll();
        System.out.println(list.get(0).getId());
    }

}
