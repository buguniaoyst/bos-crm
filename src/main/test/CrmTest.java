import cn.itcast.crm.domain.Customer;
import org.apache.cxf.jaxrs.client.WebClient;

import javax.ws.rs.core.MediaType;
import java.util.Collection;

/**
 * Created by yst on 2017/7/25.
 */
public class CrmTest {
    public static void main(String[] args) {
        String url = "http://localhost:9999/ws/customerService/customer";
       Collection<? extends  Customer> customers =  WebClient.create(url).accept(MediaType.APPLICATION_JSON).getCollection(Customer.class);
        System.out.println(customers);
    }
}
