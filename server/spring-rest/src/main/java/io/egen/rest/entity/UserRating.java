/**
 * 
 */
package io.egen.rest.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table
@NamedQueries({ 
        @NamedQuery(name="UserRating.fingAvg", query = "SELECT avg(u.rating) FROM UserRating u where u.catelog.id=:pCatelogId")
})
public class UserRating {

	@Id
	@GenericGenerator(name = "customUUID", strategy = "uuid2")
	@GeneratedValue(generator = "customUUID")
	private String id;
	
	@ManyToOne
	@PrimaryKeyJoinColumn(name="userId", referencedColumnName="id")
	private AppUser user;
	@ManyToOne
	@PrimaryKeyJoinColumn(name="catelogId", referencedColumnName="id")
	private Catelog catelog;
	
	private Double rating;
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
	 * @return the user
	 */
	public AppUser getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(AppUser user) {
		this.user = user;
	}
	/**
	 * @return the catelog
	 */
	public Catelog getCatelog() {
		return catelog;
	}
	/**
	 * @param catelog the catelog to set
	 */
	public void setCatelog(Catelog catelog) {
		this.catelog = catelog;
	}
	/**
	 * @return the rating
	 */
	public Double getRating() {
		return rating;
	}
	/**
	 * @param rating the rating to set
	 */
	public void setRating(Double rating) {
		this.rating = rating;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "UserRating [id=" + id + ", user=" + user + ", catelog=" + catelog + ", rating=" + rating + "]";
	}
	
}
