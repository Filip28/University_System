package szarek.filip.domain;

import java.util.List;

/**
 * Created by Filip on 04.05.2017.
 */
public class University {

    private Integer id;
    private String name;
    private String adress;
    private Integer setYear;
    private String deanName;
    private String direction;

    public University(){}
    public University(String name, String adress, Integer setYear, String deanName, String direction) {
        this.name = name;
        this.adress = adress;
        this.setYear = setYear;
        this.deanName = deanName;
        this.direction = direction;
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

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Integer getSetYear() {
        return setYear;
    }

    public void setSetYear(Integer setYear) {
        this.setYear = setYear;
    }

    public String getDeanName() {
        return deanName;
    }

    public void setDeanName(String deanName) {
        this.deanName = deanName;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    @Override
    public String toString() {
        return "University{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", adress='" + adress + '\'' +
                ", setYear=" + setYear +
                ", deanName='" + deanName + '\'' +
                ", direction='" + direction + '\'' +
                '}';
    }

    public static University getUniversityInformation(List<University> universities, String name){
        return universities
                .stream()
                .filter(u -> u.getName().equals(name))
                .findFirst()
                .orElseThrow(() -> new NullPointerException("There is not univeristy who have got that name "));
    }
}
