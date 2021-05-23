package com.example.AlphaRestBackEnd.Entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "user_detail")
public class UserDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "email")
    private String email;

    @Column(name = "age")
    private String age;

    @Column(name = "phone_number")
    private String phoneNumber;

    @Column(name = "address")
    private String address;

    @Column(name = "occupation")
    private String occupation;

    //BI-Directional relationship
    @OneToOne(mappedBy = "userDetail", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JsonIgnoreProperties("userDetail")
    private User user;

    public UserDetail() {
    }

    public UserDetail(String email, String age, String phoneNumber, String address, String occupation) {
        this.email = email;
        this.age = age;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.occupation = occupation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        if (user == null) {
            if (this.user != null) {
                this.user.setUserDetail(null);
            }
        } else {
            user.setUserDetail(this);
        }
        this.user = user;
    }


    @Override
    public String toString() {
        return "UserDetail{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", age='" + age + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", address='" + address + '\'' +
                ", occupation='" + occupation + '\'' +
                '}';
    }
}
