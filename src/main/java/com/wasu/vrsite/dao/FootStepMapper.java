package com.wasu.vrsite.dao;

import com.wasu.vrsite.entity.FootStep;
import com.wasu.vrsite.entity.FootStepExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FootStepMapper {
    int countByExample(FootStepExample example);

    int deleteByExample(FootStepExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(FootStep record);

    int insertSelective(FootStep record);

    List<FootStep> selectByExample(FootStepExample example);

    FootStep selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") FootStep record, @Param("example") FootStepExample example);

    int updateByExample(@Param("record") FootStep record, @Param("example") FootStepExample example);

    int updateByPrimaryKeySelective(FootStep record);

    int updateByPrimaryKey(FootStep record);
}