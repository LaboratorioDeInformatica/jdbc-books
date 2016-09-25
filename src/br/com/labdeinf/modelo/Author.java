package br.com.labdeinf.modelo;

public class Author {

	private Integer  authorId;
	private String firstName ;
	private String lastname;
	
	
	
	public Author(String firstName, String lastname) {
		super();
		this.firstName = firstName;
		this.lastname = lastname;
	}
	
	public Integer getAuthorId() {
		return authorId;
	}
	public void setAuthorId(Integer authorId) {
		this.authorId = authorId;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	@Override
	public String toString(){
		return String.format("[Author : %d , %s, %s ]",authorId,firstName, lastname);
	}
}
