package vu.lt.mybatis.model;

public class Category {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CATEGORY.ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column PUBLIC.CATEGORY.NAME
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    private String name;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CATEGORY.ID
     *
     * @return the value of PUBLIC.CATEGORY.ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CATEGORY.ID
     *
     * @param id the value for PUBLIC.CATEGORY.ID
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column PUBLIC.CATEGORY.NAME
     *
     * @return the value of PUBLIC.CATEGORY.NAME
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column PUBLIC.CATEGORY.NAME
     *
     * @param name the value for PUBLIC.CATEGORY.NAME
     *
     * @mbg.generated Thu Mar 26 20:51:42 EET 2020
     */
    public void setName(String name) {
        this.name = name;
    }
}