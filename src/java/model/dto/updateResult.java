package model.dto;

public class updateResult {
    
    private int MARK;
    private String USERNAME;
    private String TEACHER_USERNAME;
    private String STUDENT_USERNAME;
    private String COURSE_NAME;

    

    public int getMARK() {
        return MARK;
    }

    public void setMARK(int MARK) {
        this.MARK = MARK;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
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

    public String getCOURSE_NAME() {
        return COURSE_NAME;
    }

    public void setCOURSE_NAME(String COURSE_NAME) {
        this.COURSE_NAME = COURSE_NAME;
    }
    
}
