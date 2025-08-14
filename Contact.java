package com.cms;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Contact {
	@Override
	public String toString() {
		return "Contact [mob=" + mob + ", name=" + name + "]";
	}
	@Id
	private Long  mob;
    @Column(length=20)
    private String name;
	public Long getMob() {
		return mob;
	}
	public void setMob(Long mob) {
		this.mob = mob;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    
    
}
