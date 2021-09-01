package tw.da.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


import org.springframework.stereotype.Component;

@Entity @Table(name="House")
@Component("house")
public class House {
	@Id @Column(name="houseId")
	private int houseid;
	@Column(name="housename")
	private String housename;

	
	public int getHouseid() {
		return houseid;
	}

	public void setHouseid(int houseid) {
		this.houseid = houseid;
	}

	public String getHousename() {
		return housename;
	}

	public void setHousename(String housename) {
		this.housename = housename;
	}

	
	
}

