
package model.dto;


public class Student {

    private String first_name;
    private String last_name;
    private String address;
    private String city;
    private String country;
    private Long PHONE_NUMBER;
    private Integer COURSE_ID;
    private String Username;
    private String Password;
    private Integer student_id;
    private String TEACHER_USERNAME;
    private String Role;

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getUsernameRole() {
        return UsernameRole;
    }

    public void setUsernameRole(String UsernameRole) {
        this.UsernameRole = UsernameRole;
    }
    private String UsernameRole;
    
    public String getTEACHER_USERNAME() {
        return TEACHER_USERNAME;
    }

    public void setTEACHER_USERNAME(String TEACHER_USERNAME) {
        this.TEACHER_USERNAME = TEACHER_USERNAME;
    }

    
    public Integer getStudent_id() {
        return student_id;
    }

    public void setStudent_id(Integer student_id) {
        this.student_id = student_id;
    }

    public String getUsername() {
        return Username;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String Password) {
        this.Password = Password;
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

    
    public Integer getCOURSE_ID() {
        return COURSE_ID;
    }

    public void setCOURSE_ID(Integer COURSE_ID) {
        this.COURSE_ID = COURSE_ID;
    }

}
