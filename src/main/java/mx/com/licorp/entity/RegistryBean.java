package mx.com.licorp.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;

@Entity
public class RegistryBean implements Serializable {
	
    /**
	 * 
	 */
	private static final long serialVersionUID = -1055896879915127647L;

	@Id
    @GeneratedValue(strategy=GenerationType.SEQUENCE)
    private Long id;
    
    @Size(min = 0, max = 19, message = "Name cannot be longer than 19 characters")
	public String name;
    
    @Size(min = 0, max = 250, message = "Description cannot be longer than 250 characters")
	public String description;
	public Date dateCreated = new Date();
	
	@Size(min = 0, max = 20, message = "Extra data cannot be longer than 20 characters")
	public String extraData;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public Date getDateCreated() {
		return dateCreated;
	}
	public void setDateCreated(Date dateCreated) {
		this.dateCreated = dateCreated;
	}
	public String getExtraData() {
		return extraData;
	}
	public void setExtraData(String extraData) {
		this.extraData = extraData;
	}
	
	
}
