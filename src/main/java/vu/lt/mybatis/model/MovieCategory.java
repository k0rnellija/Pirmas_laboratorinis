package vu.lt.mybatis.model;

public class MovieCategory {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MOVIE_CATEGORY.MOVIE_ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    private Integer movieId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.MOVIE_CATEGORY.CATEGORY_ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    private Integer categoryId;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MOVIE_CATEGORY.MOVIE_ID
     *
     * @return the value of PUBLIC.MOVIE_CATEGORY.MOVIE_ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public Integer getMovieId() {
        return movieId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MOVIE_CATEGORY.MOVIE_ID
     *
     * @param movieId the value for PUBLIC.MOVIE_CATEGORY.MOVIE_ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public void setMovieId(Integer movieId) {
        this.movieId = movieId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.MOVIE_CATEGORY.CATEGORY_ID
     *
     * @return the value of PUBLIC.MOVIE_CATEGORY.CATEGORY_ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public Integer getCategoryId() {
        return categoryId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.MOVIE_CATEGORY.CATEGORY_ID
     *
     * @param categoryId the value for PUBLIC.MOVIE_CATEGORY.CATEGORY_ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }
}