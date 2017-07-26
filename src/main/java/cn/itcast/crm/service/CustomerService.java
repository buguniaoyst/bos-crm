package cn.itcast.crm.service;

import cn.itcast.crm.domain.Customer;

import javax.ws.rs.*;
import java.util.List;

/**
 * Created by yst on 2017/7/25.
 */
@Produces("*/*")
public interface CustomerService {
    @GET
    @Path("/customer")
    @Produces({ "application/xml", "application/json" })
    public List<Customer> getNoAssociations();

    @GET
    // 客户端 查询请求
    @Path("/customer/{decidezoneId}")
    // http://xxxx/user/1
    @Consumes({ "application/xml", "application/json" })
    // 客户端 只能发送 xml 数据类型
    @Produces({ "application/xml", "application/json" })
    public List<Customer> getInUserAssociations(@PathParam("decidezoneId") String decidezone_id);

    @PUT
    @Path("/customer/{cids}/{decidezoneId}")
    // /customer/1,2,3/dq001
    @Consumes({ "application/xml", "application/json" })
    public void assignedCustomerToDecidedZone(@PathParam("cids") String customerids, @PathParam("decidezoneId") String decidedZone_id);

}
