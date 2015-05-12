package vo;

import exception.StudentException;

public class Student {
	protected long		no;
	protected String 	name;
	protected String		mobile;
	protected String		email;
	protected String		address;
	protected boolean	working;
	protected int		gender;
	protected int		point;

	public static String getValue(String studentString, String itemName) {
		String[] items = studentString.split(",");
		for (int i = 0; i < items.length; i++) {
			if (items[i].indexOf(itemName) > -1) {
				return items[i].split("=")[1];
			}
		}
		return null;
	}
	
	public Student() {}
	
	public Student(String name, String mobile, String email) {
		this.name = name;
		this.mobile = mobile;
		this.email = email;
	}

	public long getNo() {
		return no;
	}

	public Student setNo(long no) {
		this.no = no;
		return this;
	}

	public String getName() {
		return name;
	}

	public Student setName(String name) {
		this.name = name;
		return this;
	}

	public String getMobile() {
		return mobile;
	}

	public Student setMobile(String mobile) {
		this.mobile = mobile;
		return this;
	}

	public String getEmail() {
		return email;
	}

	public Student setEmail(String email) {
		this.email = email;
		return this;
	}

	public String getAddress() {
		return address;
	}

	public Student setAddress(String address) {
		this.address = address;
		return this;
	}

	public boolean isWorking() {
		return working;
	}
	
	public int getWorking2() {
		if (working)
			return 1;
		else
			return 0;
	}

	public Student setWorking(boolean working) {
		this.working = working;
		return this;
	}
	
	public Student setWorking2(int working) {
		if (working == 1)
			this.working = true;
		else 
			this.working = false;
		return this;
	}

	public int getGender() {
		return gender;
	}

	public Student setGender(int gender) {
		this.gender = gender;
		return this;
	}

	public int getPoint() {
		return point;
	}

	public Student setPoint(int point) {
		this.point = point;
		return this;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((address == null) ? 0 : address.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gender;
		result = prime * result + ((mobile == null) ? 0 : mobile.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (no ^ (no >>> 32));
		result = prime * result + point;
		result = prime * result + (working ? 1231 : 1237);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (address == null) {
			if (other.address != null)
				return false;
		} else if (!address.equals(other.address))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (mobile == null) {
			if (other.mobile != null)
				return false;
		} else if (!mobile.equals(other.mobile))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no != other.no)
			return false;
		if (point != other.point)
			return false;
		if (working != other.working)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", mobile=" + mobile
				+ ", email=" + email + ", address=" + address + ", working="
				+ working + ", gender=" + gender + ", point=" + point + "]";
	}

	public static Student fromCSV(String csv) throws StudentException{
		String[] cols = csv.split(",");
		if (cols.length < 8) {
			throw new StudentException("형식이 맞지 않습니다.");
		}
		
		return new Student(cols[1], cols[2], cols[3])
						.setNo(Long.parseLong(cols[0]))
						.setAddress(cols[4])
						.setWorking(Boolean.parseBoolean(cols[5]))
						.setGender(Integer.parseInt(cols[6]))
						.setPoint(Integer.parseInt(cols[7]));
	}

	public String toCSV() {
		StringBuffer buf = new StringBuffer();
		buf.append(no);
		buf.append(",");
		buf.append(name);
		buf.append(",");
		buf.append(mobile);
		buf.append(",");
		buf.append(email);
		buf.append(",");
		buf.append(address);
		buf.append(",");
		buf.append(working);
		buf.append(",");
		buf.append(gender);
		buf.append(",");
		buf.append(point);
		return buf.toString();
	}
}









