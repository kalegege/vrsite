package com.wasu.vrsite.dao;

import com.wasu.vrsite.entity.Site;
import com.wasu.vrsite.entity.SiteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface SiteMapper {
    int countByExample(SiteExample example);

    int deleteByExample(SiteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Site record);

    int insertSelective(Site record);

    List<Site> selectByExample(SiteExample example);

    Site selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Site record, @Param("example") SiteExample example);

    int updateByExample(@Param("record") Site record, @Param("example") SiteExample example);

    int updateByPrimaryKeySelective(Site record);

    int updateByPrimaryKey(Site record);
}