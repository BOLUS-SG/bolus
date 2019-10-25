package com.bolus.backend.development.employee.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.bolus.backend.development.validation.model.EmployeeValidationBean;



@Entity
@Table(name = "employee_details")
public class Employee extends EmployeeValidationBean{
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private Integer id;
	@Size(max = 20, min = 3, message = "{employee.fname.invalid.size}")
    @NotEmpty(message = "{employee.fname.invalid.empty}")
	private String firstName;
	@Size(max = 20, min = 3, message = "{employee.lname.invalid.size}")
    @NotEmpty(message = "{employee.fname.lnvalid.empty}")
	private String lastName;
	@NotNull(message = "{employee.dob.invalid.empty}")
	private Date dob;
	@NotNull(message = "{employee.phone.invalid}")
	private Long phone;
	@Email(message = "{employee.email.invalid.format}")
    @NotEmpty(message = "{employee.email.invalid.empty}")
	private String email;
	@NotNull(message = "{employee.altPhone.invalid}")
	private Long altPhone;
	@NotEmpty(message = "{employee.type.invalid}")
	private String type;
	@NotEmpty(message = "{employee.aadhar.invalid}")
	private String aadharCard;
	@OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name= "id")
	private List<Address> address = new ArrayList<Address>();
	@ManyToOne(cascade=CascadeType.ALL)
	@JoinColumn(name="assigned_area_id")
	@NotNull(message = "{employee.assignedArea.invalid}")
	private AssignedArea assignedArea;
	public Employee() {
		super();
	}
	public Employee(Integer id, String firstName, String lastName, Date dob, Long phone, String email, Long altPhone,
			String type, String aadharCard, List<Address> address, AssignedArea assignedArea) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.phone = phone;
		this.email = email;
		this.altPhone = altPhone;
		this.type = type;
		this.aadharCard = aadharCard;
		this.address = address;
		this.assignedArea = assignedArea;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public Date getDob() {
		return dob;
	}
	public void setDob(Date dob) {
		this.dob = dob;
	}
	public Long getPhone() {
		return phone;
	}
	public void setPhone(Long phone) {
		this.phone = phone;
	}
	public Long getAltPhone() {
		return altPhone;
	}
	public void setAltPhone(Long altPhone) {
		this.altPhone = altPhone;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAadharCard() {
		return aadharCard;
	}
	public void setAadharCard(String aadharCard) {
		this.aadharCard = aadharCard;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public List<Address> getAddress() {
		return address;
	}
	public void setAddress(List<Address> address) {
		this.address = address;
	}
	public AssignedArea getAssignedArea() {
		return assignedArea;
	}
	public void setAssignedArea(AssignedArea assignedArea) {
		this.assignedArea = assignedArea;
	}
	
	
}
