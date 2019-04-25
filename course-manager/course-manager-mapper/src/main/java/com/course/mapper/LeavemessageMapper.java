package com.course.mapper;

import com.course.pojo.Leavemessage;
import com.course.pojo.LeavemessageExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LeavemessageMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leavemessage
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    long countByExample(LeavemessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leavemessage
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int deleteByExample(LeavemessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leavemessage
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int insert(Leavemessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leavemessage
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int insertSelective(Leavemessage record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leavemessage
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    List<Leavemessage> selectByExample(LeavemessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leavemessage
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int updateByExampleSelective(@Param("record") Leavemessage record, @Param("example") LeavemessageExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table leavemessage
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    int updateByExample(@Param("record") Leavemessage record, @Param("example") LeavemessageExample example);
}