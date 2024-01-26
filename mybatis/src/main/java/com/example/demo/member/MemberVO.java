package com.example.demo.member;

import lombok.Data;

@Data
	public class MemberVO { 
		String mid;
		String pass;
		String name;
		String ssn;
		String phone;
		String email;
		String responsibility;
		public String getMid() {
			return mid;
		}
		public void setMid(String mid) {
			this.mid = mid;
		}
		public String getPass() {
			return pass;
		}
		public void setPass(String pass) {
			this.pass = pass;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public String getSsn() {
			return ssn;
		}
		public void setSsn(String ssn) {
			this.ssn = ssn;
		}
		public String getPhone() {
			return phone;
		}
		public void setPhone(String phone) {
			this.phone = phone;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
		public String getResponsibility() {
			return responsibility;
		}
		public void setResponsibility(String responsibility) {
			this.responsibility = responsibility;
		}
		
		
		public String toString() {
			return mid + " " + pass + " " + name + " " + email;
		}
		
	}

