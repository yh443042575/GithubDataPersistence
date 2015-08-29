package edu.hit.GithubDataModel;

public class ForkEvent {

	private String id;
	private String actor;
	/**
	 * fork人家的代码的repository
	 */
	private String repo;
	
	/**
	 * fork到自己仓库时新建的repository信息
	 */
	private String forkeeName;
	private String forkeeOwner;
	private String forkeeDescription;
	
	private String created_at;
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
	public String getForkeeName() {
		return forkeeName;
	}
	public void setForkeeName(String forkeeName) {
		this.forkeeName = forkeeName;
	}
	public String getForkeeOwner() {
		return forkeeOwner;
	}
	public void setForkeeOwner(String forkeeOwner) {
		this.forkeeOwner = forkeeOwner;
	}
	public String getForkeeDescription() {
		return forkeeDescription;
	}
	public void setForkeeDescription(String forkeeDescription) {
		this.forkeeDescription = forkeeDescription;
	}
	public String getCreated_at() {
		return created_at;
	}
	public void setCreated_at(String created_at) {
		this.created_at = created_at;
	}
	public String getTarget() {
		return target;
	}
	public void setTarget(String target) {
		this.target = target;
	}
	
	
}
