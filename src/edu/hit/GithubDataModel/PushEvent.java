package edu.hit.GithubDataModel;

/**
 * commit代码的操作
 * @author DHAO
 *
 */
public class PushEvent {
	
	private String id;
	private String actor;
	private String repo;
	
	private String pushId;
	private String before;
	/**
	 * The SHA of the HEAD commit on the repository.
	 */
	private String head;
	/**
	 * The full Git ref that was pushed. Example: “refs/heads/master”
	 */
	private String ref;
	/**
	 * 本次commit时所附带的message
	 */
	private String commitMessage;
	
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
	public String getPushId() {
		return pushId;
	}
	public void setPushId(String pushId) {
		this.pushId = pushId;
	}
	public String getBefore() {
		return before;
	}
	public void setBefore(String before) {
		this.before = before;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public String getRef() {
		return ref;
	}
	public void setRef(String ref) {
		this.ref = ref;
	}
	public String getCommitMessage() {
		return commitMessage;
	}
	public void setCommitMessage(String commitMessage) {
		this.commitMessage = commitMessage;
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
