package models.pojo;
// Generated May 30, 2016 4:44:37 PM by Hibernate Tools 4.3.1.Final

import java.util.HashSet;
import java.util.Set;

/**
 * Movie generated by hbm2java
 */
@SuppressWarnings("serial")
public class Movie implements java.io.Serializable {

	private Integer id;
	private Director director;
	private String title;
	private String description;
	private Integer publishDay;
	@SuppressWarnings("rawtypes")
	private Set comments = new HashSet(0);

	public Movie() {
	}

	@SuppressWarnings("rawtypes")
	public Movie(Director director, String title, String description, Integer publishDay, Set comments) {
		this.director = director;
		this.title = title;
		this.description = description;
		this.publishDay = publishDay;
		this.comments = comments;
	}

	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Director getDirector() {
		return this.director;
	}

	public void setDirector(Director director) {
		this.director = director;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getPublishDay() {
		return this.publishDay;
	}

	public void setPublishDay(Integer publishDay) {
		this.publishDay = publishDay;
	}

	@SuppressWarnings("rawtypes")
	public Set getComments() {
		return this.comments;
	}

	@SuppressWarnings("rawtypes")
	public void setComments(Set comments) {
		this.comments = comments;
	}

}
