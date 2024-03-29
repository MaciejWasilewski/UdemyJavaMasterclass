package sample;

public class Contact {
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private String notes;

    public Contact() {
    }

    public Contact(String first, String lName, String number, String notes) {
        this.firstName = first;
        this.lastName = lName;
        this.phoneNumber = number;
        this.notes = notes;
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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
}
