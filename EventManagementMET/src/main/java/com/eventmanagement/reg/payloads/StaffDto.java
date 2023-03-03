package com.eventmanagement.reg.payloads;

public class StaffDto {
	private int staffId;
	private String staffName;
	private String emailId;
	private String contactNo;
	private String fullAddress;
	private long adhaarcardNo;
	
	public StaffDto() {
		// TODO Auto-generated constructor stub
	}

	public StaffDto(int staffId, String staffName, String emailId, String contactNo, String fullAddress,
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

	@Override
	public String toString() {
		return "StaffDto [staffId=" + staffId + ", staffName=" + staffName + ", emailId=" + emailId + ", contactNo="
				+ contactNo + ", fullAddress=" + fullAddress + ", adhaarcardNo=" + adhaarcardNo + "]";
	}
	
	
}
