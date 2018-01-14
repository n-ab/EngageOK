package com.engageok.prototype_1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

@Entity
@Table(name="issueAreas")
public class IssueArea {
	@Id
    @GeneratedValue
    private Long id;
    
	@Size(min=1, message="Name cannot be blank")
    private String name;
	
	@Size(min=10, message="Elaborate!")
	private String description;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "orgs_tags",
			joinColumns = @JoinColumn(name = "tag_id"),
			inverseJoinColumns = @JoinColumn(name = "org_id"))
	private List<Organization> orgs;
	
	private Integer numberOfOrgs;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "events_tags",
    		joinColumns = @JoinColumn(name = "tag_id"),
    		inverseJoinColumns = @JoinColumn(name = "event_id")
    		)
	private List<Event> events;
	
	//
	
	public IssueArea() {}
	
	// 			GETTERS AND SETTERS
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Organization> getOrgs() {
		return orgs;
	}

	public void setOrgs(List<Organization> orgs) {
		this.orgs = orgs;
	}

	public Integer getNumberOfOrgs() {
		return numberOfOrgs;
	}

	public void setNumberOfOrgs(Integer numberOfOrgs) {
		this.numberOfOrgs = numberOfOrgs;
	}
	
	
}
