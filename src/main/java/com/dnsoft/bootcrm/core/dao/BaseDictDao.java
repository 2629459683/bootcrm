package com.dnsoft.bootcrm.core.dao;

import com.dnsoft.bootcrm.core.pojo.BaseDict;

import java.util.List;

public interface BaseDictDao {
    //根据类别代码查询数据字典
    public List<BaseDict> selectBaseDictByTypeCode(String typecode);

//    计算数据字典名称
    public List<BaseDict> selectBaseDictforTypeName();

    //数据字典列表
    public List<BaseDict> selectBaseDictList(BaseDict baseDict);

    //字典数
    public  Integer selectBaseDictListCount(BaseDict baseDict);

    //创建字典信息
    public int createBaseDict(BaseDict baseDict);

    //通过id查询字典信息
    public BaseDict getBaseDictById(Integer id);

    //更新字典信息
    public int updateBaseDict(BaseDict baseDict);

    //删除字典
    public int deleteBaseDict(Integer id);

}
