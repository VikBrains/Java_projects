package src.FamilyTree.HR;

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
        this.id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.place_of_residence = place_of_residence;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        this.children = new ArrayList();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, (String)null, (LocalDate)null, father, mother);
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human mother) {
        this(name, gender, birthDate, (String)null, (LocalDate)null, (Human)null, mother);
    }

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate) {
        this(name, gender, birthDate, (String)null, deathDate, (Human)null, (Human)null);
    }

    public Human(String name, Gender gender, LocalDate birthDate) {
        this(name, gender, birthDate, (String)null, (LocalDate)null, (Human)null, (Human)null);
    }

    public Human(String name, Gender gender, String place_of_residence, LocalDate deathDate) {
        this(name, gender, (LocalDate)null, place_of_residence, deathDate, (Human)null, (Human)null);
    }

    public void setId(int id) {
        this.id = id;
    }

    public long getId() {
        return (long)this.id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Gender getGender() {
        return this.gender;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    public LocalDate getBirthDate() {
        return this.birthDate;
    }

    public void setDeathDate(LocalDate deathDate) {
        this.deathDate = deathDate;
    }

    public LocalDate getDeathDate() {
        return this.deathDate;
    }

    public void setPlace_of_residence(String place_of_residence) {
        this.place_of_residence = place_of_residence;
    }

    public String getPlace_of_residence() {
        return this.place_of_residence;
    }

    public void setFather(Human father) {
        this.father = father;
    }

    public Human getFather() {
        return this.father;
    }

    public void setMother(Human mother) {
        this.mother = mother;
    }

    public Human getMother() {
        return this.mother;
    }

    public boolean addChild(Human child) {
        if (!this.children.contains(child)) {
            this.children.add(child);
            return true;
        } else {
            return false;
        }
    }

    public boolean addParent(Human parent) {
        if (parent.getGender().equals(Gender.Male)) {
            this.setFather(parent);
        } else if (parent.getGender().equals(Gender.Female)) {
            this.setMother(parent);
        }

        return true;
    }

    public List<Human> getParents() {
        List<Human> list = new ArrayList(2);
        if (this.father != null) {
            list.add(this.father);
        }

        if (this.mother != null) {
            list.add(this.mother);
        }

        return list;
    }

    public int getAge() {
        return this.deathDate == null ? this.getPeriod(this.birthDate, LocalDate.now()) : this.getPeriod(this.birthDate, this.deathDate);
    }

    public LocalDate getLive() {
        return this.deathDate != null ? this.deathDate : null;
    }

    private int getPeriod(LocalDate birthDate, LocalDate deathDate) {
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }

    public void setSpouse(Human spouse) {
        this.spouse = spouse;
    }

    public Human getSpouse() {
        return this.spouse;
    }

    public List<Human> getChildren() {
        return this.children;
    }

    public String getSpouseInfo() {
        String res = "супруг(а): ";
        if (this.spouse == null) {
            res = res + "нет";
        } else {
            res = res + this.spouse.getName();
        }

        return res;
    }

    public String getMotherInfo() {
        String res = "мать: ";
        Human mother = this.getMother();
        if (mother != null) {
            res = res + mother.getName();
        } else {
            res = res + "неизвестна";
        }

        return res;
    }

    public String getFatherInfo() {
        String res = "отец: ";
        Human father = this.getFather();
        if (father != null) {
            res = res + father.getName();
        } else {
            res = res + "неизвестен";
        }

        return res;
    }

    public String getChildrenInfo() {
        StringBuilder res = new StringBuilder();
        res.append("дети: ");
        if (!this.children.isEmpty()) {
            res.append(((Human)this.children.get(0)).getName());

            for(int i = 1; i < this.children.size(); ++i) {
                res.append(", ");
                res.append(((Human)this.children.get(i)).getName());
            }
        } else {
            res.append("отсутствуют");
        }

        return res.toString();
    }

    public String toString() {
        return this.getInfo();
    }

    public String getInfo() {
        StringBuilder ftbase = new StringBuilder();
        ftbase.append("id: ");
        ftbase.append(this.id);
        ftbase.append(", имя: ");
        ftbase.append(this.name);
        ftbase.append(", пол: ");
        ftbase.append(this.getGender());
        ftbase.append(", ");
        ftbase.append(this.getLive());
        ftbase.append(", проживает в ");
        ftbase.append(this.getPlace_of_residence());
        ftbase.append(", ");
        ftbase.append(", возраст: ");
        ftbase.append(this.getAge());
        ftbase.append(", ");
        ftbase.append(this.getSpouseInfo());
        ftbase.append(", ");
        ftbase.append(this.getMotherInfo());
        ftbase.append(", ");
        ftbase.append(this.getFatherInfo());
        ftbase.append(", ");
        ftbase.append(this.getChildrenInfo());
        return ftbase.toString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else if (!(obj instanceof Human)) {
            return false;
        } else {
            Human human = (Human)obj;
            return human.getId() == this.getId();
        }
    }
}
