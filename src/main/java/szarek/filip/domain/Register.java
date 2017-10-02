package szarek.filip.domain;

import java.time.LocalDate;

/**
 * Created by Filip on 04.05.2017.
 */
public class Register {
    private Integer id;
    private Integer studentId;
    private Integer universityId;
    private LocalDate registerDate;

    public Register(){}
    public Register(Integer studentId, Integer universityId, LocalDate registerDate) {
        this.studentId = studentId;
        this.universityId = universityId;
        this.registerDate = registerDate;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public Integer getUniversityId() {
        return universityId;
    }

    public void setUniversityId(Integer universityId) {
        this.universityId = universityId;
    }

    public LocalDate getRegisterDate() {
        return registerDate;
    }

    public void setRegisterDate(LocalDate registerDate) {
        this.registerDate = registerDate;
    }

    @Override
    public String toString() {
        return "Register{" +
                "id=" + id +
                ", studentId=" + studentId +
                ", universityId=" + universityId +
                ", registerDate=" + registerDate +
                '}';
    }
}
