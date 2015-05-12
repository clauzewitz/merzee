package vo;


public class MerzeeMember {
	protected String		email;
	protected String		birth;
	protected String 	password;
	protected String		phone;
	protected String 	name;
	protected String 	nickname;
	protected String 	mem_photo;	
	protected int		gender;

	public static String getValue(String studentString, String itemName) {
		String[] items = studentString.split(",");
		for (int i = 0; i < items.length; i++) {
			if (items[i].indexOf(itemName) > -1) {
				return items[i].split("=")[1];
			}
		}
		return null;
	}
	
	public MerzeeMember() {}
	
	public String getEmail(){
		return email;
	}
	public MerzeeMember setEmail(String email){
		this.email = email;
		return this;
	}
	
	public String getBirth() {
		return birth;
	}

	public MerzeeMember setBirth(String birth) {
		this.birth = birth;
		return this;
	}

	public String getPassword() {
		return password;
	}

	public MerzeeMember setPassword(String password) {
		this.password = password;
		return this;
	}

	public String getPhone() {
		return phone;
	}

	public MerzeeMember setPhone(String phone) {
		this.phone = phone;
		return this;
	}

	public String getName() {
		return name;
	}

	public MerzeeMember setName(String name) {
		this.name = name;
		return this;
	}

	public String getNickname() {
		return nickname;
	}

	public MerzeeMember setNickname(String nickname) {
		this.nickname = nickname;
		return this;
	}

	public String getMem_photo() {
		return mem_photo;
	}

	public MerzeeMember setMem_photo(String mem_photo) {
		this.mem_photo = mem_photo;
		return this;
	}

	public int getGender() {
		return gender;
	}

	public MerzeeMember setGender(int gender) {
		this.gender = gender;
		return this;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((birth == null) ? 0 : birth.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + gender;
		result = prime * result
				+ ((mem_photo == null) ? 0 : mem_photo.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result
				+ ((nickname == null) ? 0 : nickname.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((phone == null) ? 0 : phone.hashCode());
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
		MerzeeMember other = (MerzeeMember) obj;
		if (birth == null) {
			if (other.birth != null)
				return false;
		} else if (!birth.equals(other.birth))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (gender != other.gender)
			return false;
		if (mem_photo == null) {
			if (other.mem_photo != null)
				return false;
		} else if (!mem_photo.equals(other.mem_photo))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (nickname == null) {
			if (other.nickname != null)
				return false;
		} else if (!nickname.equals(other.nickname))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (phone == null) {
			if (other.phone != null)
				return false;
		} else if (!phone.equals(other.phone))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Member [email=" + email + ", birth=" + birth + ", password="
				+ password + ", phone=" + phone + ", name=" + name
				+ ", nickname=" + nickname + ", mem_photo=" + mem_photo
				+ ", gender=" + gender + "]";
	}

	/*public static Member fromCSV(String csv) throws StudentException{
		String[] cols = csv.split(",");
		if (cols.length < 8) {
			throw new StudentException("형식이 맞지 않습니다.");
		}
		
		return new Member(cols[1], cols[2], cols[3])
						.setNo(Long.parseLong(cols[0]))
						.setAddress(cols[4])
						.setWorking(Boolean.parseBoolean(cols[5]))
						.setGender(Integer.parseInt(cols[6]))
						.setPoint(Integer.parseInt(cols[7]));
	}*/

	/*public String toCSV() {
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
	}*/
}









