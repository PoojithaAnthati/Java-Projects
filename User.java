import java.util.*;

public class User {
    private static int counter =1;
    private int userId;
    private String firstName;
    private String lastName;
    private Address address;
    private Contact contact;
    private Date registrationTimeStamp;

    public User(String firstName, String lastName, String city, String locality, String state, int pinCode, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = new Address(city, locality, state, pinCode);
        this.contact = new Contact(email, phoneNumber);
        this.userId = counter;
        counter++;
        this.registrationTimeStamp = new Date();
    }

    public int getUserId() {
        return this.userId;
    }

    public static class Address {
     private String city;
     private String locality;
     private String state;
     private int pinCode;

     public Address(String city, String locality, String state, int pinCode) {
         this.city = city;
         this.locality = locality;
         this.state =state;
         this.pinCode =pinCode;
     }

     public String getCity() {
         return this.city;
     }

     public String getLocality() {
        return this.locality;
     }

     public String getState() {
        return this.state;
     }

     public int getPinCode() {
        return this.pinCode;
    }

    }

    public static class Contact {
        private String email;
        private String phoneNumber;

        public Contact(String email, String phoneNumber) {
            this.email = email;
            this.phoneNumber = phoneNumber;
        }

        public String getEmail() {
            return this.email;
        }

        public String getPhoneNumber() {
            return this.phoneNumber;
        }
    }
}
