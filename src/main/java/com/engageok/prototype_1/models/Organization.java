package com.engageok.prototype_1.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="organizations")
public class Organization {

	@Id
	@GeneratedValue
	private Long id;
	
	private String title;
	
	private String description;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "orgs_users",
		joinColumns = @JoinColumn(name = "org_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<User> users;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
		name = "orgs_tags",
		joinColumns = @JoinColumn(name = "org_id"),
		inverseJoinColumns = @JoinColumn(name = "user_id")
		)
	private List<User> issueAreas;
	
	//
	
	public Organization() {}

	//			GETTERS AND SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public List<User> getIssueAreas() {
		return issueAreas;
	}

	public void setIssueAreas(List<User> issueAreas) {
		this.issueAreas = issueAreas;
	}
}
