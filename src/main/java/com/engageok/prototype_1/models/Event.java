package com.engageok.prototype_1.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import com.engageok.prototype_1.models.User;

@Entity
@Table(name="events")
public class Event {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message="Name cannot be blank")
    private String name;
	
	private String relatedOrg;
	
	private Date occurringOn;
	
	private Date rsvpBy;
	
	@ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    		name = "events_tags",
    		joinColumns = @JoinColumn(name = "event_id"),
    		inverseJoinColumns = @JoinColumn(name = "tag_id")
    		)
	private List<IssueArea> issueAreas;
	
	
	
	//
	
	public Event() {}

	//			GETTERS AND SETTERS
	
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

	public String getRelatedOrg() {
		return relatedOrg;
	}

	public void setRelatedOrg(String relatedOrg) {
		this.relatedOrg = relatedOrg;
	}

	public Date getOccurringOn() {
		return occurringOn;
	}

	public void setOccurringOn(Date occurringOn) {
		this.occurringOn = occurringOn;
	}

	public Date getRsvpBy() {
		return rsvpBy;
	}

	public void setRsvpBy(Date rsvpBy) {
		this.rsvpBy = rsvpBy;
	}

	public List<IssueArea> getIssueAreas() {
		return issueAreas;
	}

	public void setIssueAreas(List<IssueArea> issueAreas) {
		this.issueAreas = issueAreas;
	}
	
	
	
	
	
}
