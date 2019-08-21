
package model.dto;


public class updateStudent {

    private String first_name;
    private String last_name;
    private String address;
    private String city;
    private String country;
    private Long PHONE_NUMBER;
    private Integer MARK;
    private Integer COURSE_ID;
    private String USERNAME;

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

   
    
    
    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getPHONE_NUMBER() {
        return PHONE_NUMBER;
    }

    public void setPHONE_NUMBER(Long PHONE_NUMBER) {
        this.PHONE_NUMBER = PHONE_NUMBER;
    }

    public Integer getMARK() {
        return MARK;
    }

    public void setMARK(Integer MARK) {
        this.MARK = MARK;
    }

    public Integer getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(Integer COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }
    
     
    
}
