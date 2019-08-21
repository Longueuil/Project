
package model.dto;


public class updateCourse {
    
    private String COURSE_NAME;
    private String STUDENT_USERNAME;
    private String TEACHER_USERNAME;
    private Integer CREDIT;
    private Integer COURSE_ID;
    private String USERNAME;

    
    public String getCOURSE_NAME() {
        return COURSE_NAME;
    }

    public void setCOURSE_NAME(String COURSE_NAME) {
        this.COURSE_NAME = COURSE_NAME;
    }

    public String getSTUDENT_USERNAME() {
        return STUDENT_USERNAME;
    }

    public void setSTUDENT_USERNAME(String STUDENT_USERNAME) {
        this.STUDENT_USERNAME = STUDENT_USERNAME;
    }

    public String getTEACHER_USERNAME() {
        return TEACHER_USERNAME;
    }

    public void setTEACHER_USERNAME(String TEACHER_USERNAME) {
        this.TEACHER_USERNAME = TEACHER_USERNAME;
    }

    public Integer getCREDIT() {
        return CREDIT;
    }

    public void setCREDIT(Integer CREDIT) {
        this.CREDIT = CREDIT;
    }

    public Integer getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(Integer COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }
   
}
