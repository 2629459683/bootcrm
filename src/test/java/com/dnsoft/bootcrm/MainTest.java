package com.dnsoft.bootcrm;

import com.dnsoft.bootcrm.common.utils.Page;
import com.dnsoft.bootcrm.core.dao.CustomerDao;
import com.dnsoft.bootcrm.core.dao.UserDao;
import com.dnsoft.bootcrm.core.pojo.BaseDict;
import com.dnsoft.bootcrm.core.pojo.Customer;
import com.dnsoft.bootcrm.core.pojo.User;
import com.dnsoft.bootcrm.core.service.BaseDictService;
import com.dnsoft.bootcrm.core.service.CustomerService;
import com.dnsoft.bootcrm.core.service.UserService;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Random;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {
        "classpath:applicationContext.xml"
})
public class MainTest {

    @Autowired
    private CustomerDao customerDao;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    //客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;

    //客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;

    //客户级别
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;


    @Test
    public void testUserServiceImpl(){

        User user = userService.findUser("admin","123456");

        Assert.assertEquals("管理员",user.getUser_name());
    }

    @Test
    public void testUserDao(){
        User user = userDao.findUser("admin","123456");

        Assert.assertEquals("管理员",user.getUser_name());
    }

    @Test
    public void testBaseDict(){
        List<BaseDict> baseDictList = baseDictService.findBaseDictByTypeCode(INDUSTRY_TYPE);

        Assert.assertEquals("客户所属行业",baseDictList.get(0).getDict_type_name());

        List<BaseDict> baseDictList2 = baseDictService.findBaseDictByTypeCode(FROM_TYPE);

        Assert.assertEquals("客户来源",baseDictList2.get(0).getDict_type_name());

        List<BaseDict> baseDictList6 = baseDictService.findBaseDictByTypeCode(LEVEL_TYPE);

        Assert.assertEquals("客户级别",baseDictList6.get(0).getDict_type_name());
    }

    @Test
    public void testCustomerDao(){
        Customer customer1 = new Customer();

        customer1.setStart(1);
        customer1.setRows(5);

        customer1.setCust_name("李");

        List<Customer> customers = customerDao.selectCustomerList(customer1);

        Assert.assertEquals(5,customers.size());

    }

    @Test
    public void testCustomerService(){
        Customer newCustomer = new Customer();
        newCustomer.setCust_id(1);
        newCustomer.setCust_name("张三");
        newCustomer.setCust_address("美国洛杉矶");

        int r = customerService.updateCustomer(newCustomer);

        Assert.assertEquals(1,r);

        Customer customer = customerService.getCustomerById(1);

        Assert.assertEquals("美国洛杉矶",customer.getCust_address());
    }

    @Test
    @Ignore
    public void add50Customers(){
        String[] lastNames = {"张","李","王","赵"};
        String[] firstNames = {"三","四","五","六"};

        Random random = new Random();
        for(int i=0;i<50;i++){


            String name = lastNames[random.nextInt(4)]+firstNames[random.nextInt(4)];

            String source = Integer.toString(random.nextInt(2) + 1);

            String industry = Integer.toString(random.nextInt(5) + 3);

            String level = Integer.toString(random.nextInt(2) + 8);

            System.out.println(name+","+source+","+industry+","+level);

            Customer newCustomer = new Customer();

            newCustomer.setCust_name(name);
            newCustomer.setCust_user_id(1);
            newCustomer.setCust_create_id(1);
            newCustomer.setCust_source(source);
            newCustomer.setCust_industry(industry);
            newCustomer.setCust_level(level);
            newCustomer.setCust_linkman("1");
            newCustomer.setCust_phone("027-83625877");
            newCustomer.setCust_mobile("1360000000");
            newCustomer.setCust_zipcode("430000");
            newCustomer.setCust_address("湖北武汉");

            Date date = new Date();
            Timestamp timestamp = new Timestamp(date.getTime());
            newCustomer.setCust_createtime(timestamp);

            customerService.createCustomer(newCustomer);
        }

    }
}
