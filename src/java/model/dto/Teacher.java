
package model.dto;


public class Teacher {

    private String first_name;
    private String last_name;
    private String address;
    private String city;
    private String country;
    private Long PHONE_NUMBER;
    private Long  Salary;
    private String Username;
    private String Password;
    private String Role;
    private Integer teacher_id;

    public Integer getTeacher_id() {
        return teacher_id;
    }

    public void setTeacher_id(Integer teacher_id) {
        this.teacher_id = teacher_id;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String Role) {
        this.Role = Role;
    }

    public String getUsernameRole() {
        return usernameRole;
    }

    public void setUsernameRole(String usernameRole) {
        this.usernameRole = usernameRole;
    }
    private String usernameRole;
    
    
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

    public Long getSalary() {
        return Salary;
    }

    public void setSalary(Long Salary) {
        this.Salary = Salary;
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
    
    
    
}
