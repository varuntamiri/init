package com.technoglitz.lambdaj;

/**
 * The Class Person.
 */
public class Person {

	private String firstName;
	private String lastName;
	private Integer age;
	private boolean male;

	/**
	 * @param firstName
	 * @param lastName
	 * @param age
	 * @param male
	 */
	public Person(String firstName, String lastName, Integer age, boolean male) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.male = male;
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

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public boolean isMale() {
		return male;
	}

	public void setMale(boolean male) {
		this.male = male;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + age;
		result = prime * result
				+ ((firstName == null) ? 0 : firstName.hashCode());
		result = prime * result
				+ ((lastName == null) ? 0 : lastName.hashCode());
		result = prime * result + (male ? 1231 : 1237);
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
		Person other = (Person) obj;
		if (age != other.age)
			return false;
		if (firstName == null) {
			if (other.firstName != null)
				return false;
		} else if (!firstName.equals(other.firstName))
			return false;
		if (lastName == null) {
			if (other.lastName != null)
				return false;
		} else if (!lastName.equals(other.lastName))
			return false;
		if (male != other.male)
			return false;
		return true;
	}
	
    public int compareTo(Person anotherString) {
        int len1 = getFirstName().length();
        int len2 = anotherString.getFirstName().length();
        int lim = Math.min(len1, len2);
        char v1[] = getFirstName().toCharArray();
        char v2[] = anotherString.getFirstName().toCharArray();

        int k = 0;
        while (k < lim) {
            char c1 = v1[k];
            char c2 = v2[k];
            if (c1 != c2) {
                return c1 - c2;
            }
            k++;
        }
        return len1 - len2;
    }

	@Override
	public String toString() {
		return "Person [firstName=" + firstName + ", lastName=" + lastName
				+ ", age=" + age + ", male=" + male + "]";
	}


}
