package io.egen.movieflix.entity;

import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery (name="User.FindAll", query="SELECT u from User u ORDER BY u.email"),
				@NamedQuery (name="User.FindByEmail", query="SELECT u from User u WHERE u.email=:pEmail")
})
public class User {
	
	@Id
	private String id;
	private String firstname;
	private String lastname;
	
	@Column(unique = true)
	private String email;
	private String password;
	private String userrole;
	/*@OneToOne(cascade = CascadeType.ALL)
	private MovieList ml;*/
	
	public User(){
		id = UUID.randomUUID().toString();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	/*public MovieList getMl() {
		return (MovieList) ml;
	}

	public void setMl(MovieList ml) {
		this.ml = ml;
	}*/

	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserrole() {
		return userrole;
	}
	public void setUserrole(String userrole) {
		this.userrole = userrole;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", userrole=" + userrole + "]";
	}
	
}
