package swd20.hh.bookstore.domain;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


@Entity
public class Category {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long categoryid;
	private String name;
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "category")
	@JsonIgnoreProperties("category")
	private List<Book> books;
	
	public Category() {}

	public Category(String name) {
		super();
		this.name = name;
	}

	public long getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(long categoryid) {
		this.categoryid = categoryid;
	}

	public String getName() {
		return name;
	}
	
	public List<Book> getStudents() {
		return books;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	@Override
	public String toString() { 
		return "Category [categoryid=" + categoryid + ", name=" + name + "]";
	}

}
