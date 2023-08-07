

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class    User {
    private String name;
    private String surname;
    private String email;
    private String password;
    private String occupation;
    private int age;
    private ArrayList<Address> addressList;
    private LocalDate lastInput;

    public User(String name, String surname, String email, String password, String occupation,
                int age) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.occupation = occupation;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ArrayList<Address> getAddressList() {

        return addressList;
    }

    public void setAddressList(ArrayList<Address> addressList) {
        this.addressList = addressList;
    }

    public void addAddress(Address address) {
        this.addressList.add(address);
    }

    public void removeAddress(Address address) {
        this.addressList.remove(address);
    }
    public LocalDate getLastInput() {
        return lastInput;
    }

    public void setLastInput(LocalDate lastInput) {
        this.lastInput = lastInput;
    }
    public boolean checkPassword(String password) {
        return this.password.equals(password);
    }
    public void updateLastLogin() {
        this.lastInput = LocalDate.now();
    }

}
