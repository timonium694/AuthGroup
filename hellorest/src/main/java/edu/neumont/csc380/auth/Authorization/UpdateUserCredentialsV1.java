package edu.neumont.csc380.auth.Authorization;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class UpdateUserCredentialsV1 {
	private String userName;
	private String oldPassword;
	private String newPassword;
	private AuthorityLevel updatedAuthLevel;
	
	public UpdateUserCredentialsV1()
	{
		
	}
	
	public UpdateUserCredentialsV1(String userName,String newPassword,String oldPassword,AuthorityLevel updatedAuthLevel)
	{
		this.userName = userName;
		this.newPassword = newPassword;
		this.oldPassword = oldPassword;
		this.updatedAuthLevel = updatedAuthLevel;
	}

	public String getUserName() {
		return userName;
	}
	
	public AuthorityLevel getUpdatedAuthLevel() {
		return updatedAuthLevel;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setUpdatedAuthLevel(AuthorityLevel updatedAuthLevel) {
		this.updatedAuthLevel = updatedAuthLevel;
	}
	

	public String getOldPassword() {
		return oldPassword;
	}

	public void setOldPassword(String oldPassword) {
		this.oldPassword = oldPassword;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String toString()
	{
		return " Username: " + this.userName;
	}
}
