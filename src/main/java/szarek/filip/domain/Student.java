package szarek.filip.domain;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by Filip on 03.05.2017.
 */
public class Student {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthDate;
    private String address;
    private String email;
    private String phoneNumber;

    public Student(){}

    public Student(String name, String surname, LocalDate birthDate, String address, String email, String phoneNumber) {
        this.name = name;
        this.surname = surname;
        this.birthDate = birthDate;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthDate=" + birthDate +
                ", address='" + address + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }

    public static Student getStudentWithNameAndSurname(List<Student> students, String name, String surname)
    {
        return students
                .stream()
                .filter(s -> s.getName().equals(name) && s.getSurname().equals(surname))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("Nie ma studenta o podanym imieniu i nazwisku"));
    }


}
