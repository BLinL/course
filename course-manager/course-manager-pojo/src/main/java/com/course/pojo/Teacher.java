package com.course.pojo;

public class Teacher {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.id
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private Integer id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.name
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.username
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String username;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.password
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String password;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.sex
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String sex;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.title
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String title;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column teacher.departmentID
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private Integer departmentid;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.id
     *
     * @return the value of teacher.id
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public Integer getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.id
     *
     * @param id the value for teacher.id
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.name
     *
     * @return the value of teacher.name
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getName() {
        return name;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.name
     *
     * @param name the value for teacher.name
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.username
     *
     * @return the value of teacher.username
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getUsername() {
        return username;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.username
     *
     * @param username the value for teacher.username
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.password
     *
     * @return the value of teacher.password
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getPassword() {
        return password;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.password
     *
     * @param password the value for teacher.password
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.sex
     *
     * @return the value of teacher.sex
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getSex() {
        return sex;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.sex
     *
     * @param sex the value for teacher.sex
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.title
     *
     * @return the value of teacher.title
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getTitle() {
        return title;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.title
     *
     * @param title the value for teacher.title
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column teacher.departmentID
     *
     * @return the value of teacher.departmentID
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public Integer getDepartmentid() {
        return departmentid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column teacher.departmentID
     *
     * @param departmentid the value for teacher.departmentID
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setDepartmentid(Integer departmentid) {
        this.departmentid = departmentid;
    }
}