package cn.itcast.crm.dao;

import cn.itcast.crm.domain.Customer;

import java.util.List;

/**
 * Created by yst on 2017/7/25.
 */
public interface CustomerDao {
    // 获取定区未关联的客户信息
    public List<Customer> getNoAssociations();

    // 获取指定定区绑定客户信息
    public List<Customer> getInUserAssociations(String decidezone_id);

    // 定区绑定客户
    public void assignedCustomerToDecidedZone(Integer customer_id, String decidedZone_id);

    // 取消定区关联所有客户
    public void cancleDecidedZoneCustomers(String decidedZone_id);

}
