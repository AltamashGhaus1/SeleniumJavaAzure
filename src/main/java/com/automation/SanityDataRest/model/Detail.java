package com.automation.SanityDataRest.model;

public class Detail {

	
	private int id;
	private String url;
	private String username;
	private String password;
	private String dataset;
	private String mailto;
	
	public Detail(String url, String username, String password, String dataset, String mailto)
	{
		super();
		this.url = url;
		this.username = username;
		this.password = password;
		this.dataset = dataset;
		this.mailto = mailto;
	}
	
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getDataset() {
		return dataset;
	}
	public void setDataset(String dataset) {
		this.dataset = dataset;
	}
	public String getMailto() {
		return mailto;
	}
	public void setMailto(String mailto) {
		this.mailto = mailto;
	}
	
	@Override
	public String toString() {
		return "Details [url=" + url + ", username=" + username + ", password=" + password + ", dataset="
				+ dataset + ", mailto=" + mailto + "]";
	}
	
	
	
}
