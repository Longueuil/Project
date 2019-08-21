
package model.dto;


public class Course {
    
    private int COURSE_ID;
    private String COURSE_NAME;
    private Integer CREDIT;
    private String TEACHER_USERNAME;
    private String STUDENT_USERNAME;
    private String USERNAME;

    public int getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(int COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getCOURSE_NAME() {
        return COURSE_NAME;
    }

    public void setCOURSE_NAME(String COURSE_NAME) {
        this.COURSE_NAME = COURSE_NAME;
    }

    public Integer getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(Integer CREDIT) {
        this.CREDIT = CREDIT;
    }

    public String getTEACHER_USERNAME() {
        return TEACHER_USERNAME;
    }

    public void setTEACHER_USERNAME(String TEACHER_USERNAME) {
        this.TEACHER_USERNAME = TEACHER_USERNAME;
    }

    public String getSTUDENT_USERNAME() {
        return STUDENT_USERNAME;
    }

    public void setSTUDENT_USERNAME(String STUDENT_USERNAME) {
        this.STUDENT_USERNAME = STUDENT_USERNAME;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

}
