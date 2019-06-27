package com.topica.annotation.example3;

@MyTable(value = "human")
public class Human {
	@MyId
	private Long id;
	@MyColumn
	private String name;
	@MyColumn
	private Integer age;
	@MyColumn
	private String phone;

	public Human(String name, Integer age, String phone) {
		super();
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

	public Human(Long id, String name, Integer age, String phone) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.phone = phone;
	}

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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
