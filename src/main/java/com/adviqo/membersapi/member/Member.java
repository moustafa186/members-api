package com.adviqo.membersapi.member;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import java.time.LocalDate;

@Entity(name = "members")
@XmlRootElement(name="member")
public class Member {
    @Id
    @GeneratedValue
    private Long id;

    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "lastName")
    @NotNull
    private String lastName;

    @Column(name = "dateOfBirth")
    @NotNull
    private LocalDate dateOfBirth;

    @Column(name = "postalCode")
    private String postalCode;

    public Member() {
    }

    public Member(Long id, String firstName, String lastName, LocalDate dateOfBirth, String postalCode) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.postalCode = postalCode;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    @Override
    public String toString() {
        return String.format("Member [id=%s, firstName=%s, lastName=%s, dateOfBirth=%s, postalCode=%s]",
                id, firstName, lastName, dateOfBirth, postalCode);
    }
}
