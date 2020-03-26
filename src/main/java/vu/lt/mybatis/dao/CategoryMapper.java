package vu.lt.mybatis.dao;

import java.util.List;
import vu.lt.mybatis.model.Category;

public interface CategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CATEGORY
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CATEGORY
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    int insert(Category record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CATEGORY
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    Category selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CATEGORY
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    List<Category> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.CATEGORY
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    int updateByPrimaryKey(Category record);
}