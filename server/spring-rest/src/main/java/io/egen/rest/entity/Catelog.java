/**
 * 
 */
package io.egen.rest.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;


@Entity
@Table
@NamedQueries({ 
		@NamedQuery(name = "Catelog.findAll", query = "SELECT c FROM Catelog c ORDER BY c.title ASC"),
		@NamedQuery(name = "Catelog.findByType", query = "SELECT c FROM Catelog c WHERE c.type=:pType"),
		@NamedQuery(name = "Catelog.findByTitle", query = "SELECT c FROM Catelog c WHERE c.title=:pTitle"),
		@NamedQuery(name = "Catelog.findByYear", query = "SELECT c FROM Catelog c WHERE c.year=:pYear"),
		@NamedQuery(name = "Catelog.findByGenre", query = "SELECT c FROM Catelog c WHERE c.genre=:pGenre"),
		@NamedQuery(name = "Catelog.findTopRatedCatelog", query = "SELECT c FROM Catelog c WHERE c.type=:pType ORDER BY c.imdbRating DESC")
})
public class Catelog {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	@Column(unique = true)
	private String title;
	private String year;
	private String rated;
	private Date releasedOn;
	private String runtime;
	private String genre;
	private String director;
	@Column(name="writer",length=2000)
	private String writer;
	private String actors;
	@Column(name="plot",length=2000)
	private String plot;
	private String language;
	private String country;
	private String awards;
	private String poster;
	private Integer metascore;
	private Double imdbRating;
	private Long imdbVotes;
	private String imdbId;
	private String type;
	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the year
	 */
	public String getYear() {
		return year;
	}
	/**
	 * @param year the year to set
	 */
	public void setYear(String year) {
		this.year = year;
	}
	/**
	 * @return the rated
	 */
	public String getRated() {
		return rated;
	}
	/**
	 * @param rated the rated to set
	 */
	public void setRated(String rated) {
		this.rated = rated;
	}
	/**
	 * @return the releasedOn
	 */
	public Date getReleasedOn() {
		return releasedOn;
	}
	/**
	 * @param releasedOn the releasedOn to set
	 */
	public void setReleasedOn(Date releasedOn) {
		this.releasedOn = releasedOn;
	}
	/**
	 * @return the runtime
	 */
	public String getRuntime() {
		return runtime;
	}
	/**
	 * @param runtime the runtime to set
	 */
	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}
	/**
	 * @return the genre
	 */
	public String getGenre() {
		return genre;
	}
	/**
	 * @param genre the genre to set
	 */
	public void setGenre(String genre) {
		this.genre = genre;
	}
	/**
	 * @return the director
	 */
	public String getDirector() {
		return director;
	}
	/**
	 * @param director the director to set
	 */
	public void setDirector(String director) {
		this.director = director;
	}
	/**
	 * @return the writer
	 */
	public String getWriter() {
		return writer;
	}
	/**
	 * @param writer the writer to set
	 */
	public void setWriter(String writer) {
		this.writer = writer;
	}
	/**
	 * @return the actors
	 */
	public String getActors() {
		return actors;
	}
	/**
	 * @param actors the actors to set
	 */
	public void setActors(String actors) {
		this.actors = actors;
	}
	/**
	 * @return the plot
	 */
	public String getPlot() {
		return plot;
	}
	/**
	 * @param plot the plot to set
	 */
	public void setPlot(String plot) {
		this.plot = plot;
	}
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}
	/**
	 * @param language the language to set
	 */
	public void setLanguage(String language) {
		this.language = language;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the awards
	 */
	public String getAwards() {
		return awards;
	}
	/**
	 * @param awards the awards to set
	 */
	public void setAwards(String awards) {
		this.awards = awards;
	}
	/**
	 * @return the poster
	 */
	public String getPoster() {
		return poster;
	}
	/**
	 * @param poster the poster to set
	 */
	public void setPoster(String poster) {
		this.poster = poster;
	}
	/**
	 * @return the metascore
	 */
	public Integer getMetascore() {
		return metascore;
	}
	/**
	 * @param metascore the metascore to set
	 */
	public void setMetascore(Integer metascore) {
		this.metascore = metascore;
	}
	/**
	 * @return the imdbRating
	 */
	public Double getImdbRating() {
		return imdbRating;
	}
	/**
	 * @param imdbRating the imdbRating to set
	 */
	public void setImdbRating(Double imdbRating) {
		this.imdbRating = imdbRating;
	}
	/**
	 * @return the imdbVotes
	 */
	public Long getImdbVotes() {
		return imdbVotes;
	}
	/**
	 * @param imdbVotes the imdbVotes to set
	 */
	public void setImdbVotes(Long imdbVotes) {
		this.imdbVotes = imdbVotes;
	}
	/**
	 * @return the imdbId
	 */
	public String getImdbId() {
		return imdbId;
	}
	/**
	 * @param imdbId the imdbId to set
	 */
	public void setImdbId(String imdbId) {
		this.imdbId = imdbId;
	}
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}
	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Catelog [id=" + id + ", title=" + title + ", year=" + year + ", rated=" + rated + ", releasedOn="
				+ releasedOn + ", runtime=" + runtime + ", genre=" + genre + ", director=" + director + ", writer="
				+ writer + ", actors=" + actors + ", plot=" + plot + ", language=" + language + ", country=" + country
				+ ", awards=" + awards + ", poster=" + poster + ", metascore=" + metascore + ", imdbRating="
				+ imdbRating + ", imdbVotes=" + imdbVotes + ", imdbId=" + imdbId + ", type=" + type + "]";
	}
	
}
