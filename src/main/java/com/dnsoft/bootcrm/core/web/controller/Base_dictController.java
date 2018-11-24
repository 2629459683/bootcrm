package com.dnsoft.bootcrm.core.web.controller;

import com.dnsoft.bootcrm.common.utils.Page;
import com.dnsoft.bootcrm.core.pojo.BaseDict;
import com.dnsoft.bootcrm.core.pojo.Customer;
import com.dnsoft.bootcrm.core.pojo.User;
import com.dnsoft.bootcrm.core.service.BaseDictService;
import com.dnsoft.bootcrm.core.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

@Controller
public class Base_dictController {

    //客户来源
    @Value("${customer.from.type}")
    private String FROM_TYPE;

    //客户所属行业
    @Value("${customer.industry.type}")
    private String INDUSTRY_TYPE;

    //客户级别
    @Value("${customer.level.type}")
    private String LEVEL_TYPE;

    @Autowired
    private BaseDictService baseDictService;

    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/toBase_dict.action")
    public String toBase_dict(@RequestParam(defaultValue = "1") Integer page,
                              @RequestParam(defaultValue = "5") Integer rows,
                              String dict_type_Name,Model model){


        //客户来源
        List<BaseDict> fromTypeName = baseDictService.selectBaseDictforTypeName();

        //查询客户信息
        Page<BaseDict> baseDictList = baseDictService.findBaseDictList(page,rows,dict_type_Name);

       //添加页面参数
        model.addAttribute("fromTypeName",fromTypeName);
        model.addAttribute("page",baseDictList);

        return "base_dict";
    }

    //创建字典数据
    @RequestMapping("/base_dict/create.action")
    @ResponseBody
    public String customerCreate(BaseDict baseDict){
      System.out.println("客户"+baseDict.getDict_type_name());
       if(baseDict.getDict_type_name().equals("客户来源")){
           baseDict.setDict_type_code("002");
       }else if(baseDict.getDict_type_name().equals("客户所属行业")){
           baseDict.setDict_type_code("001");
       }else{
           baseDict.setDict_type_code("006");
       }


        int rows = baseDictService.createBaseDict(baseDict);

        if(rows > 0){
            return "OK";
        }else{
            return "FAIL";
        }
    }

    //通过id获取字典数据信息
    @RequestMapping("getBaseDictById.action")
    @ResponseBody
    public BaseDict getBaseDictById(Integer id){
        BaseDict baseDict = baseDictService.getBaseDictById(id);
        return baseDict;
    }

    //更新字典数据信息
    @RequestMapping("/base_dict/update.action")
    @ResponseBody
    public String base_dictUpdate(BaseDict baseDict){
        System.out.println("编号："+baseDict.getDict_id());
        System.out.println("来源"+baseDict.getDict_item_name());
        System.out.println("来源类型"+baseDict.getDict_type_name());
        int rows = baseDictService.updateBaseDict(baseDict);
        if(rows>0){
            return "OK";
        }else{
            return "FAIL";
        }
    }

    //删除字典数据
    @RequestMapping("/basedict/delete.action")
    @ResponseBody
    public String basedictDelete(Integer id){
        int rows = baseDictService.deleteBaseDict(id);
        if(rows > 0){
            return "OK";
        }else {
            return "FALL";
        }
    }

    }


