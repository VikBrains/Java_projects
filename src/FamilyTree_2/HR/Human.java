package src.FamilyTree_2.HR;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
    private int id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private String place_of_residence;
    private Human mother;
    private Human father;
    private Human spouse;
    private final List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, String place_of_residence, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.place_of_residence = place_of_residence;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother) {
        this(name, gender, birthDate, null, null, null, mother);
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name, gender, birthDate, null, deathDate, null, null);
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, null, null, null, null);
    }

    public Human(String name, Gender gender, String place_of_residence, LocalDate deathDate) {
        this(name, gender, null, place_of_residence, deathDate, null, null);
    }


    public void setId(int id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }
    public void setGender(Gender gender) {
        this.gender = gender;
    }
    public Gender getGender(){
        return gender;
    }
    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
    public LocalDate getBirthDate(){
        return birthDate;
    }
    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }
    public LocalDate getDeathDate(){
        return deathDate;
    }
    public void setFather(Human father) {
        this.father = father;
    }
    public Human getFather() {
        return father;
    }
    public void setMother(Human mother) {
        this.mother = mother;
    }
    public Human getMother() {
        return mother;
    }
    public List<Human> getChildren(){
        return children;
    }
    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }
    public Human getSpouse(){
        return spouse;
    }
    public void setPlace_of_residence(String place_of_residence) {
        this.place_of_residence = place_of_residence;
    }
    public String getPlace_of_residence(){
        return place_of_residence;
    }

    public boolean addChild(Human child) {
        if (!children.contains(child)) {
            children.add(child);
            return true;
        }
        return false;
    }

    public boolean addParent(Human parent) {
        if(parent.getGender().equals(Gender.Male)) {
            setFather(parent);
        }
        else if (parent.getGender().equals(Gender.Female)) {
            setMother(parent);
        }
        return true;
    }

    public List<Human> getParents(){
        List<Human> list = new ArrayList<Human>(2);
        if (father != null) {
            list.add(father);
        }
        if (mother != null) {
            list.add(mother);
        }
        return list;
    }

    public int getAge(){
        if (deathDate == null){
            return getPeriod(birthDate, LocalDate.now());
        }
        else{
            return getPeriod(birthDate, deathDate);
        }
    }
    public LocalDate getLive(){
        if (deathDate != null){
            return deathDate;
        }
        return null;
    }
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }



    public String getMotherInfo(){
        String res = "мать: ";
        Human mother = getMother();
        if (mother != null){
            res += mother.getName();
        }
        else {
            res += "неизвестна";
        }
        return res;
    }
    public String getFatherInfo(){
        String res = "отец: ";
        Human father = getFather();
        if (father != null){
            res += father.getName();
        }
        else {
            res += "неизвестен";
        }
        return res;
    }

    public String getChildrenInfo(){
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!children.isEmpty()) {
            res.append(children.get(0).getName());
            for (int i = 1; i < children.size(); i++) {
                res.append(", ");
                res.append(children.get(i).getName());
            }
        }
        else {
            res.append("отсутствуют");
        }
        return res.toString();
    }
    public String getSpouseInfo(){
        String res = "супруг(а): ";
        if (spouse == null){
            res += "нет";
        }
        else {
            res += spouse.getName();
        }
        return res;
    }

    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder ftbase = new StringBuilder();
        ftbase.append("id: ");
        ftbase.append(id);
        ftbase.append(", имя: ");
        ftbase.append(name);
        ftbase.append(", пол: ");
        ftbase.append(getGender());
        ftbase.append(", ");
        ftbase.append(getLive());
        ftbase.append(", проживает в ");
        ftbase.append(getPlace_of_residence());
        ftbase.append(", ");
        ftbase.append(", возраст: ");
        ftbase.append(getAge());
        ftbase.append(", ");
        ftbase.append(getSpouseInfo());
        ftbase.append(", ");
        ftbase.append(getMotherInfo());
        ftbase.append(", ");
        ftbase.append(getFatherInfo());
        ftbase.append(", ");
        ftbase.append(getChildrenInfo());
                return ftbase.toString();
    }



    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Human)) {
            return false;
        }
        Human human = (Human) obj;
        return human.getId() == getId();
    }
}
