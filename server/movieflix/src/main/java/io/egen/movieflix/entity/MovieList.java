package io.egen.movieflix.entity;

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
@NamedQueries({ @NamedQuery (name="MovieList.FindAll", query="SELECT ml from MovieList ml ORDER BY ml.imdbRating"),
	@NamedQuery (name="MovieList.FindByTitle", query="SELECT ml from MovieList ml WHERE ml.Title=:mlTitle"),
	@NamedQuery (name="MovieList.FindMoviesAndSerials", query="SELECT ml FROM MovieList ml WHERE ml.Type=:mlType"),
	@NamedQuery (name="MovieList.sortImdbRatings", query="SELECT ml FROM MovieList ml WHERE ml.Type=:mlType ORDER BY ml.imdbRating"),
	@NamedQuery (name="MovieList.sortImdbVotes", query="SELECT ml FROM MovieList ml WHERE ml.Type=:mlType ORDER BY ml.imdbVotes"),
	@NamedQuery (name="MovieList.sortYear", query="SELECT ml FROM MovieList ml WHERE ml.Type=:mlType ORDER BY ml.Year"),
	@NamedQuery (name="MovieList.TopRated", query="SELECT ml FROM MovieList ml ORDER BY ml.imdbRating"),
	@NamedQuery (name="MovieList.TopVoted", query="SELECT ml FROM MovieList ml ORDER BY ml.imdbVotes"),
	@NamedQuery (name="MovieList.Latest", query="SELECT ml FROM MovieList ml ORDER BY ml.Year"),
	@NamedQuery (name="MovieList.SearchType", query="SELECT ml FROM MovieList ml WHERE ml.Type=:mlType AND ml.Title=:mlTitle"),
	@NamedQuery (name="MovieList.SearchYear", query="SELECT ml FROM MovieList ml WHERE ml.Year=:mlYear AND ml.Title=:mlTitle"),
	@NamedQuery (name="MovieList.SearchGenre", query="SELECT ml FROM MovieList ml WHERE ml.Genre=:mlGenre AND ml.Title=:mlTitle")
})
public class MovieList {
	
	@Id
	@Column(unique = true)
	private String Title;
	private String Year;
	private String Rated;
	private String Released;
	private String Runtime;
	private String Genre;
	private String Director;
	private String Writer;
	private String Actors;
	@Column(length = 1056)
	private String Plot;
	private String Country;
	private String Awards;
	private String Poster;
	private String Metascore;
	private String imdbRating;
	private String imdbVotes;
	private String imdbID;
	private String Type;

	@OneToMany(mappedBy="title",cascade = CascadeType.PERSIST)
	private List<UserRatings> ur;
	public MovieList(){
		
	}
	public MovieList(String Title, String poster,UserRatings ur){
		super();
		this.Title = Title;
		this.Poster = poster;
		this.ur = (List<UserRatings>) ur;
	}

	public String getTitle() {
		return Title;
	}
	public void setTitle(String title) {
		Title = title;
	}
	public String getPoster() {
		return Poster;
	}
	public void setPoster(String poster) {
		this.Poster = poster;
	}

	public String getYear() {
		return Year;
	}
	public void setYear(String year) {
		Year = year;
	}
	public String getRated() {
		return Rated;
	}
	public void setRated(String rated) {
		Rated = rated;
	}
	public String getReleased() {
		return Released;
	}
	public void setReleased(String released) {
		Released = released;
	}
	public String getRuntime() {
		return Runtime;
	}
	public void setRuntime(String runtime) {
		Runtime = runtime;
	}
	public String getGenre() {
		return Genre;
	}
	public void setGenre(String genre) {
		Genre = genre;
	}
	public String getDirector() {
		return Director;
	}
	public void setDirector(String director) {
		Director = director;
	}
	public String getWriter() {
		return Writer;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public String getActors() {
		return Actors;
	}
	public void setActors(String actors) {
		Actors = actors;
	}
	public String getPlot() {
		return Plot;
	}
	public void setPlot(String plot) {
		Plot = plot;
	}
	public String getCountry() {
		return Country;
	}
	public void setCountry(String country) {
		Country = country;
	}
	public String getAwards() {
		return Awards;
	}
	public void setAwards(String awards) {
		Awards = awards;
	}
	public String getMetascore() {
		return Metascore;
	}
	public void setMetascore(String metascore) {
		Metascore = metascore;
	}
	public String getImdbRating() {
		return imdbRating;
	}
	public void setImdbRating(String imdbRating) {
		this.imdbRating = imdbRating;
	}
	public String getImdbVotes() {
		return imdbVotes;
	}
	public void setImdbVotes(String imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	public String getImdbID() {
		return imdbID;
	}
	public void setImdbID(String imdbID) {
		this.imdbID = imdbID;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}
	public List<UserRatings> getUr() {
		return ur;
	}
	public void setUr(List<UserRatings> objUR) {
		this.ur = objUR;
	}
	@Override
	public String toString() {
		return "MovieList [Title=" + Title + ", Year=" + Year + ", Rated=" + Rated + ", Released=" + Released
				+ ", Runtime=" + Runtime + ", Genre=" + Genre + ", Director=" + Director + ", Writer=" + Writer
				+ ", Actors=" + Actors + ", Plot=" + Plot + ", Country=" + Country + ", Awards=" + Awards + ", Poster="
				+ Poster + ", Metascore=" + Metascore + ", imdbRating=" + imdbRating + ", imdbVotes=" + imdbVotes
				+ ", imdbID=" + imdbID + ", Type=" + Type + ", ur=" + ur + "]";
	}

}
