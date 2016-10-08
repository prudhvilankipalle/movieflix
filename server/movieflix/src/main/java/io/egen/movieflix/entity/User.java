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
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

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
	@OneToMany(mappedBy="user",cascade = CascadeType.PERSIST)
	@JsonManagedReference(value="userratings-user")
	private List<UserRatings> ur;
	/*@OneToOne(cascade = CascadeType.ALL)
	private MovieList ml;*/
	
	public User(){
		id = UUID.randomUUID().toString();
	}
	
	public User(String firstname,String lastname, String email, String password,String userrole){
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.userrole = userrole;
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

	public List<UserRatings> getUserRatings() {
		return ur;
	}

	public void setUserRatings(List<UserRatings> objUR) {
		this.ur = objUR;
	}


	@Override
	public String toString() {
		return "User [id=" + id + ", firstname=" + firstname + ", lastname=" + lastname + ", email=" + email
				+ ", password=" + password + ", userrole=" + userrole + ", ur=" + ur + "]";
	}
	
}
