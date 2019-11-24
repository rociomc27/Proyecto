package entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the users database table.
 * 
 */
@Entity
@Table(name="users")
@NamedQuery(name="User.findAll", query="SELECT u FROM User u")
public class User implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name="user_name")
	private String userName;

	private String email;

	@Column(name="user_pass")
	private String userPass;

	//bi-directional many-to-one association to Archive
	@OneToMany(mappedBy="user")
	private List<Archive> archives;

	public User() {
	}

	public String getUserName() {
		return this.userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUserPass() {
		return this.userPass;
	}

	public void setUserPass(String userPass) {
		this.userPass = userPass;
	}

	public List<Archive> getArchives() {
		return this.archives;
	}

	public void setArchives(List<Archive> archives) {
		this.archives = archives;
	}

	public Archive addArchive(Archive archive) {
		getArchives().add(archive);
		archive.setUser(this);

		return archive;
	}

	public Archive removeArchive(Archive archive) {
		getArchives().remove(archive);
		archive.setUser(null);

		return archive;
	}

}