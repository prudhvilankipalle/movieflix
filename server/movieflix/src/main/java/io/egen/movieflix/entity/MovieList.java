package io.egen.movieflix.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table
@NamedQueries({ @NamedQuery (name="MovieList.FindAll", query="SELECT ml from MovieList ml"),
	@NamedQuery (name="MovieList.FindByTitle", query="SELECT ml from MovieList ml WHERE ml.Title=:mlTitle")
})
public class MovieList {
	
	@Id
	@Column(unique = true)
	private String Title;
	private String poster;
	@OneToMany(mappedBy="title",cascade = CascadeType.ALL)
	private Collection<UserRatings> ur;
	public MovieList(){
		
	}
	public MovieList(String Title, String poster,UserRatings ur){
		super();
		this.Title = Title;
		this.poster = poster;
		this.ur = (List<UserRatings>) ur;
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPoster() {
		return poster;
	}
	public void setPoster(String poster) {
		this.poster = poster;
	}

	public Collection<UserRatings> getUr() {
		return ur;
	}
	public void setUr(Collection<UserRatings> objUR) {
		this.ur = objUR;
	}
	@Override
	public String toString() {
		return "MovieList [Title=" + Title + ", poster=" + poster + "]";
	}

}
