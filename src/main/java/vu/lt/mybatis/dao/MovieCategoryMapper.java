package vu.lt.mybatis.dao;

import java.util.List;
import vu.lt.mybatis.model.MovieCategory;

public interface MovieCategoryMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE_CATEGORY
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    int insert(MovieCategory record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.MOVIE_CATEGORY
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    List<MovieCategory> selectAll();
}