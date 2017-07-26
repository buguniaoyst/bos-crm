package cn.itcast.crm.service.impl;

import cn.itcast.crm.dao.CustomerDao;
import cn.itcast.crm.domain.Customer;
import cn.itcast.crm.service.CustomerService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by yst on 2017/7/25.
 */
@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerDao customerDao;

    public List<Customer> getNoAssociations() {
        // TODO Auto-generated method stub
        return customerDao.getNoAssociations();
    }

    public List<Customer> getInUserAssociations(String decidezone_id) {
        // TODO Auto-generated method stub
        return customerDao.getInUserAssociations(decidezone_id);
    }

    // 1,2,3,4
    public void assignedCustomerToDecidedZone(String customerids, String decidedZone_id) {
        // 给客户 重新关联定区 先解除之前用户定区绑定 再重新绑定
        // 先取消所有定区关联客户
        customerDao.cancleDecidedZoneCustomers(decidedZone_id);
        // 重新绑定
        if (StringUtils.isNoneBlank(customerids)) {
            String customerIds[] = customerids.split(",");
            for (String id : customerIds) {
                customerDao.assignedCustomerToDecidedZone(Integer.parseInt(id), decidedZone_id);
            }
        }

    }


}
