package com.lou.springboot.dao;

import com.lou.springboot.entity.TPzUser;

public interface TPzUserMapper {
    int deleteByPrimaryKey(String id);

    int insert(TPzUser record);

    int insertSelective(TPzUser record);

    TPzUser selectByPrimaryKey(String id);

    int updateByPrimaryKeySelective(TPzUser record);

    int updateByPrimaryKey(TPzUser record);
}