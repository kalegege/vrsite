package com.wasu.vrsite.dao;

import com.wasu.vrsite.entity.CityHotel;
import com.wasu.vrsite.entity.CityHotelExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CityHotelMapper {
    int countByExample(CityHotelExample example);

    int deleteByExample(CityHotelExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(CityHotel record);

    int insertSelective(CityHotel record);

    List<CityHotel> selectByExample(CityHotelExample example);

    CityHotel selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") CityHotel record, @Param("example") CityHotelExample example);

    int updateByExample(@Param("record") CityHotel record, @Param("example") CityHotelExample example);

    int updateByPrimaryKeySelective(CityHotel record);

    int updateByPrimaryKey(CityHotel record);
}