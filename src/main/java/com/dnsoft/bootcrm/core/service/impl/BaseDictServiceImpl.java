package com.dnsoft.bootcrm.core.service.impl;

import com.dnsoft.bootcrm.common.utils.Page;
import com.dnsoft.bootcrm.core.dao.BaseDictDao;
import com.dnsoft.bootcrm.core.pojo.BaseDict;
import com.dnsoft.bootcrm.core.service.BaseDictService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("baseDictService")
public class BaseDictServiceImpl implements BaseDictService {

    @Autowired
    private BaseDictDao baseDictDao;

    //根据类别代码查询数据字典
    public List<BaseDict> findBaseDictByTypeCode(String typecode) {

        return baseDictDao.selectBaseDictByTypeCode(typecode);
    }

    @Override
    public List<BaseDict> selectBaseDictforTypeName() {
        return baseDictDao.selectBaseDictforTypeName();
    }

    @Override
    public Page<BaseDict> findBaseDictList(Integer page, Integer rows, String dict_type_Name) {

        //创建字典对象
        BaseDict baseDict = new BaseDict();

        //指定条件
        if(StringUtils.isNotBlank(dict_type_Name)){
            baseDict.setDict_type_name(dict_type_Name);
        }

        //设置当前页起始数据的行
        baseDict.setStart((page-1)*rows);

        //设置每页数
        baseDict.setRows(rows);

        List<BaseDict> baseDicts = baseDictDao.selectBaseDictList(baseDict);

        //查询总客户数
        Integer count = baseDictDao.selectBaseDictListCount(baseDict);

//创建Page对象，并且返回
        Page<BaseDict> result = new Page<>();
        result.setPage(page);
        result.setRows(baseDicts);
        result.setSize(rows);
        result.setTotal(count);

        return result;
    }

    @Override
    public int createBaseDict(BaseDict baseDict) {
        return baseDictDao.createBaseDict(baseDict);
    }

    @Override
    public BaseDict getBaseDictById(Integer id) {
        BaseDict baseDict = baseDictDao.getBaseDictById(id);
        return baseDict;
    }

    @Override
    public int updateBaseDict(BaseDict baseDict) {
        return baseDictDao.updateBaseDict(baseDict);
    }

    @Override
    public int deleteBaseDict(Integer id) {
        return baseDictDao.deleteBaseDict(id);
    }
}
