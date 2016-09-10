package io.egen.movieflix.entity;

import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table
@NamedQueries({ @NamedQuery (name="UserRatings.FindAll", query="SELECT u from UserRatings u ORDER BY u.averagerating"),
	@NamedQuery (name="UserRatings.FindByTitle", query="SELECT u from UserRatings u WHERE u.id=:pTitle")
})
public class UserRatings {
	
	@Id
	private String id;
	private String userratings;
	@Column(length = 1056)
	private String userreview;
	private String averagerating;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	private MovieList title;
	@ManyToOne(cascade = CascadeType.PERSIST)
	private User user;
	public UserRatings(){
		id = UUID.randomUUID().toString();
	}
	
	public UserRatings(String userratings, String userreview, String averagerating, MovieList title, User user){
		super();
		
		this.userratings = userratings;
		this.userreview = userreview;
		this.averagerating = averagerating;
		this.title = title;
		this.user = user;
	}
	
	public String getUserratings() {
		return userratings;
	}
	public void setUserratings(String userratings) {
		this.userratings = userratings;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAveragerating() {
		return averagerating;
	}
	public void setAveragerating(String averagerating) {
		this.averagerating = averagerating;
	}
	public String getUserreview() {
		return userreview;
	}
	public void setUserreview(String userreview) {
		this.userreview = userreview;
	}
	public MovieList getTitle() {
		return title;
	}
	public void setTitle(MovieList title) {
		this.title = title;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "UserRatings [id=" + id + ", userratings=" + userratings + ", userreview=" + userreview
				+ ", averagerating=" + averagerating + ", title=" + title + ", user =" + user + "]";
	}
	
}
