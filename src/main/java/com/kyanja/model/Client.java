package com.kyanja.model;

import java.util.Date;

public class Client {
	
	
	
	 private String username;
	    private String password;
	    private String email;
	    private Date birthDate;
	    private String profession;
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
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public Date getBirthDate() {
			return birthDate;
		}
		public void setBirthDate(Date birthDate) {
			this.birthDate = birthDate;
		}
		public String getProfession() {
			return profession;
		}
		public void setProfession(String profession) {
			this.profession = profession;
		}
		public Client(String username, String password, String email, Date birthDate, String profession) {
			super();
			this.username = username;
			this.password = password;
			this.email = email;
			this.birthDate = birthDate;
			this.profession = profession;
		}
		@Override
		public String toString() {
			return "Client [username=" + username + ", password=" + password + ", email=" + email + ", birthDate="
					+ birthDate + ", profession=" + profession + "]";
		}
		public Client() {
			
		}
	    
	    
	    

}
