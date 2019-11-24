package entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the archives database table.
 * 
 */
@Entity
@Table(name="archives")
@NamedQuery(name="Archive.findAll", query="SELECT a FROM Archive a")
public class Archive implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@Column(name="archive_name")
	private String archiveName;

	private String extension;

	private String route;

	//bi-directional many-to-one association to User
	@ManyToOne
	@JoinColumn(name="user_name")
	private User user;

	public Archive() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getArchiveName() {
		return this.archiveName;
	}

	public void setArchiveName(String archiveName) {
		this.archiveName = archiveName;
	}

	public String getExtension() {
		return this.extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getRoute() {
		return this.route;
	}

	public void setRoute(String route) {
		this.route = route;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}