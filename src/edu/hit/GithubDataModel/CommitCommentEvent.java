package edu.hit.GithubDataModel;

public class CommitCommentEvent {

	private String commitComment_id;
	private String commit_id;
	private String actor;
	private String html_url;
	private String create_time;
	private String body;
	public String getCommitComment_id() {
		return commitComment_id;
	}
	public void setCommitComment_id(String commitComment_id) {
		this.commitComment_id = commitComment_id;
	}
	public String getCommit_id() {
		return commit_id;
	}
	public void setCommit_id(String commit_id) {
		this.commit_id = commit_id;
	}
	public String getActor() {
		return actor;
	}
	public void setActor(String actor) {
		this.actor = actor;
	}
	public String getHtml_url() {
		return html_url;
	}
	public void setHtml_url(String html_url) {
		this.html_url = html_url;
	}
	public String getCreate_time() {
		return create_time;
	}
	public void setCreate_time(String create_time) {
		this.create_time = create_time;
	}
	public String getBody() {
		return body;
	}
	public void setBody(String body) {
		this.body = body;
	}
	
	
	
	
	
}
