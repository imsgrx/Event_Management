package com.eventmanagement.reg.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "staff")
public class Staff {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int staffId;
	
	@Column(name = "staff_name", nullable = false)
	private String staffName;
	
	@Column(name = "email_id", nullable = false)
	private String emailId;
	
	@Column(name = "contact_no", nullable = false)
	private String contactNo;
	
	@Column(name = "full_address", nullable = false)
	private String fullAddress;
	
	@Column(name = "adhaarcard_no", nullable = false)
	private long adhaarcardNo;
	
	public Staff() {
		// TODO Auto-generated constructor stub
	}

	public Staff(int staffId, String staffName, String emailId, String contactNo, String fullAddress,
			long adhaarcardNo) {
		super();
		this.staffId = staffId;
		this.staffName = staffName;
		this.emailId = emailId;
		this.contactNo = contactNo;
		this.fullAddress = fullAddress;
		this.adhaarcardNo = adhaarcardNo;
	}

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getStaffName() {
		return staffName;
	}

	public void setStaffName(String staffName) {
		this.staffName = staffName;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getContactNo() {
		return contactNo;
	}

	public void setContactNo(String contactNo) {
		this.contactNo = contactNo;
	}

	public String getFullAddress() {
		return fullAddress;
	}

	public void setFullAddress(String fullAddress) {
		this.fullAddress = fullAddress;
	}

	public long getAdhaarcardNo() {
		return adhaarcardNo;
	}

	public void setAdhaarcardNo(long adhaarcardNo) {
		this.adhaarcardNo = adhaarcardNo;
	}
	
	
}
