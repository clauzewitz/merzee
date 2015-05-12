package vo;

public class MerzeeDiary {
	protected String 	email;
	protected String 	dry_name;
	protected String 	dry_photo;
	protected String 	open_date;
	protected String 	dry_id;
	protected int	 	attr;
	protected int 		type;
	
	@Override
	public String toString() {
		return "MerzeeDiary [email=" + email + ", dry_name=" + dry_name
				+ ", dry_photo=" + dry_photo + ", open_date=" + open_date
				+ ", dry_id=" + dry_id + ", attr=" + attr + ", type=" + type
				+ "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((dry_id == null) ? 0 : dry_id.hashCode());
		result = prime * result
				+ ((open_date == null) ? 0 : open_date.hashCode());
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
		MerzeeDiary other = (MerzeeDiary) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (dry_id == null) {
			if (other.dry_id != null)
				return false;
		} else if (!dry_id.equals(other.dry_id))
			return false;
		if (open_date == null) {
			if (other.open_date != null)
				return false;
		} else if (!open_date.equals(other.open_date))
			return false;
		return true;
	}
	
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getDry_name() {
		return dry_name;
	}
	public MerzeeDiary setDry_name(String dry_name) {
		this.dry_name = dry_name;
		return this;
	}
	public String getDry_photo() {
		return dry_photo;
	}
	public MerzeeDiary setDry_photo(String dry_photo) {
		this.dry_photo = dry_photo;
		return this;
	}
	public String getOpen_date() {
		return open_date;
	}
	public MerzeeDiary setOpen_date(String open_date) {
		this.open_date = open_date;
		return this;
	}
	public String getDry_id() {
		return dry_id;
	}
	public MerzeeDiary setDry_id(String dry_id) {
		this.dry_id = dry_id;
		return this;
	}
	public int getAttr() {
		return attr;
	}
	public MerzeeDiary setAttr(int attr) {
		this.attr = attr;
		return this;
	}
	public int getType() {
		return type;
	}
	public MerzeeDiary setType(int type) {
		this.type = type;
		return this;
	}
}
