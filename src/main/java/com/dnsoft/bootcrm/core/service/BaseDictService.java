package com.dnsoft.bootcrm.core.service;

import com.dnsoft.bootcrm.common.utils.Page;
import com.dnsoft.bootcrm.core.pojo.BaseDict;

import java.util.List;

public interface BaseDictService {
    //根据类别代码查询数据字典
    public List<BaseDict> findBaseDictByTypeCode(String typecode);

    //计算数据字典名称
    public List<BaseDict> selectBaseDictforTypeName();

    //查询数据字典列表
    public Page<BaseDict> findBaseDictList(Integer page, Integer rows, String dict_type_Name);

    //添加字典数据
    public int createBaseDict(BaseDict baseDict);

    //通过id查询字典数据
    public BaseDict getBaseDictById(Integer id);

    //更新字典数据
    public int updateBaseDict(BaseDict baseDict);

    //删除字典数据
    public int deleteBaseDict(Integer id);
}
