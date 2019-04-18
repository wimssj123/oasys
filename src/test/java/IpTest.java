import com.cc.common.JsonIp;
import com.cc.utils.IpUtils;
import org.junit.Test;

import java.io.UnsupportedEncodingException;

public class IpTest extends BaseTest {
    @Test
    public void IpUtilsTest() {
        JsonIp info = null;
        IpUtils ipUtils = new IpUtils();
        try {
             info = ipUtils.getAddresses("ip=122.49.20.247", "utf-8");

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        if (info.getCode() == 0) {
            System.out.println(info.getData().getArea());
        } else {
            System.out.println("");
        }
    }
}
