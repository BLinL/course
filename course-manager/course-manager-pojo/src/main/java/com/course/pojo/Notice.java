package com.course.pojo;

public class Notice {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.tittle
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String tittle;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.content
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String content;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.status
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column notice.authorId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private Integer authorid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.tittle
     *
     * @return the value of notice.tittle
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getTittle() {
        return tittle;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.tittle
     *
     * @param tittle the value for notice.tittle
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setTittle(String tittle) {
        this.tittle = tittle == null ? null : tittle.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.content
     *
     * @return the value of notice.content
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.content
     *
     * @param content the value for notice.content
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.status
     *
     * @return the value of notice.status
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.status
     *
     * @param status the value for notice.status
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column notice.authorId
     *
     * @return the value of notice.authorId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public Integer getAuthorid() {
        return authorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column notice.authorId
     *
     * @param authorid the value for notice.authorId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }
}