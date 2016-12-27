/*
 this is the model for User
 */
package model;

public class User {
    private int id;
    private String firstname;
    private String lastname;
    private String email;
    private String country;
    private String postal_code;
    private String password;
    private String status;

    //getters
    public int getId() {
        return this.id;
    }

    public String getFirstname() {
        return this.firstname;
    }

    public String getLastname(){
        return this.lastname;
    }

    public String getEmail(){
        return this.email;
    }

    public String getCountry(){
        return this.country;
    }

    public String getPostalCode(){
        return this.postal_code;
    }

     public String getPassword(){
        return this.password;
    }
     public String getStatus(){
        return this.status;
    }

    //setters
    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public void setCountry(String country) {
        this.country = country;
    }
    public void setEmail(String email) {
        this.email = email;
    }

    public void setPostalCode(String postal_code) {
        this.postal_code = postal_code;
    }

    public void setPassword(String password) {
        this.password = password;
    }
      public void setStatus(String status) {
        this.status = status;
    }

	public String toString(){
		return this.firstname;
	}

}
