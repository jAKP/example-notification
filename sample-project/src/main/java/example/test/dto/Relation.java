package example.test.dto;

public class Relation {

	private long relationId;
	private String firstName;
	private String lastName;
	private String street;
	private String zipCode;
	private String poBox;
	private String city;
	private String country;

	private Relation(RelationBuilder builder) {
		this.relationId = builder.relationId;
		this.firstName = builder.firstName;
		this.lastName = builder.lastName;
		this.street = builder.street;
		this.poBox = builder.poBox;
		this.country = builder.country;
		this.zipCode = builder.zipCode;
		this.city = builder.city;
	}

	public static class RelationBuilder {
		private long relationId;
		private String firstName;
		private String lastName;
		private String street;
		private String zipCode;
		private String poBox;
		private String city;
		private String country;

		public RelationBuilder(long relationId) {
			this.relationId = relationId;
		}

		public RelationBuilder firstName(String firstName) {
			this.firstName = firstName;
			return this;
		}

		public RelationBuilder lastName(String lastName) {
			this.lastName = lastName;
			return this;
		}

		public RelationBuilder street(String street) {
			this.street = street;
			return this;
		}

		public RelationBuilder zipCode(String zipCode) {
			this.zipCode = zipCode;
			return this;
		}

		public RelationBuilder poBox(String poBox) {
			this.poBox = poBox;
			return this;
		}

		public RelationBuilder city(String city) {
			this.city = city;
			return this;
		}

		public Relation build() {
			return new Relation(this);
		}

	}

	public long getRelationId() {
		return relationId;
	}

	public void setRelationId(long relationId) {
		this.relationId = relationId;
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

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public String getPoBox() {
		return poBox;
	}

	public void setPoBox(String poBox) {
		this.poBox = poBox;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
