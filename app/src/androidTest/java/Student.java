public class Student {
    private String lastName;
    private String firstName;
    private String major;

    public Student(String lastName, String firstName, String major) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.major = major;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }
}