package com.course.pojo;

public class Leavemessage {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leavemessage.authorId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private Integer authorid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leavemessage.replyId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private Integer replyid;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leavemessage.status
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private Integer status;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column leavemessage.content
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    private String content;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column leavemessage.authorId
     *
     * @return the value of leavemessage.authorId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public Integer getAuthorid() {
        return authorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column leavemessage.authorId
     *
     * @param authorid the value for leavemessage.authorId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setAuthorid(Integer authorid) {
        this.authorid = authorid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column leavemessage.replyId
     *
     * @return the value of leavemessage.replyId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public Integer getReplyid() {
        return replyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column leavemessage.replyId
     *
     * @param replyid the value for leavemessage.replyId
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setReplyid(Integer replyid) {
        this.replyid = replyid;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column leavemessage.status
     *
     * @return the value of leavemessage.status
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column leavemessage.status
     *
     * @param status the value for leavemessage.status
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column leavemessage.content
     *
     * @return the value of leavemessage.content
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public String getContent() {
        return content;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column leavemessage.content
     *
     * @param content the value for leavemessage.content
     *
     * @mbg.generated Fri Apr 05 23:30:20 CST 2019
     */
    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}