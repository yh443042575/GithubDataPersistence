package edu.hit.GithubDataModel;

import javax.persistence.Entity;
import javax.persistence.Id;


public class CreateEvent {

	private String id;
	private String actor;
	private String repo;
	/*
	 * 只能是branch,tag,repository
	 */
	private String ref_type;
	/*
	 * ref_type在repository中对应的具体名字
	 */
	private String ref;
	private String description;
	private String createdAt;
	private String target;
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getRepo() {
		return repo;
	}
	public void setRepo(String repo) {
		this.repo = repo;
	}
	public String getRef_type() {
		return ref_type;
	}
	public void setRef_type(String ref_type) {
		this.ref_type = ref_type;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(String createdAt) {
		this.createdAt = createdAt;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	
	
	
}