package model.dto;

public class TeacherV {

    private int TEACHER_ID;
    private String FIRST_NAME;
    private String LAST_NAME;
    private String ADDRESS;
    private String CITY;
    private String COUNTRY;
    private Long PHONE_NUMBER;
    private Long SALARY;
    private String USERNAME;
    private String PASSWORD;

    public TeacherV() {
    }

    public int getTEACHER_ID() {
        return TEACHER_ID;
    }

    public void setTEACHER_ID(int TEACHER_ID) {
        this.TEACHER_ID = TEACHER_ID;
    }

    public Long getSALARY() {
        return SALARY;
    }

    public void setSALARY(Long SALARY) {
        this.SALARY = SALARY;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

    public String getFIRST_NAME() {
        return FIRST_NAME;
    }

    public void setFIRST_NAME(String FIRST_NAME) {
        this.FIRST_NAME = FIRST_NAME;
    }

    public String getLAST_NAME() {
        return LAST_NAME;
    }

    public void setLAST_NAME(String LAST_NAME) {
        this.LAST_NAME = LAST_NAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }

    public String getCOUNTRY() {
        return COUNTRY;
    }

    public void setCOUNTRY(String COUNTRY) {
        this.COUNTRY = COUNTRY;
    }

    public Long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(Long PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

}
