package models;

import javafx.beans.property.SimpleStringProperty;

public class Person {

    private final SimpleStringProperty num;
    private final SimpleStringProperty firstName;
    private final SimpleStringProperty lastName;

    public Person(String id, String fName, String lName) {
        this.firstName = new SimpleStringProperty(fName);
        this.lastName = new SimpleStringProperty(lName);
        this.num = new SimpleStringProperty(id);
    }

    public String getFirstName() {
        return firstName.get();
    }

    public void setFirstName(String fName) {
        firstName.set(fName);
    }

    public String getLastName() {
        return lastName.get();
    }

    public void setLastName(String fName) {
        lastName.set(fName);
    }

    public String getNum() {
        return num.get();
    }

    public void setNum(String id) {
        num.set(id);
    }
}