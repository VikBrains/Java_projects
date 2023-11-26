package FamilyTree;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

public class Human {
        private long id;
    private String name;
    private Gender gender;
    private LocalDate birthDate;
    private LocalDate deathDate;
    private Human mother;
    private Human father;
    private Human spouse;
    private List<Human> children;

    public Human(String name, Gender gender, LocalDate birthDate, LocalDate deathDate, Human father, Human mother) {
        id = -1;
        this.name = name;
        this.birthDate = birthDate;
        this.deathDate = deathDate;
        this.gender = gender;
        this.father = father;
        this.mother = mother;
        children = new ArrayList<>();
    }

    public Human(String name, Gender gender, LocalDate birthDate, Human father, Human mother) {
        this(name, gender, birthDate, null, father, mother);
    }
    public Human(String name, Gender gender, Human father, Human mother) {
        this(name, gender, null, null, father, mother);
    }
    public Human(String name, Gender gender, LocalDate deathDate) {
        this(name, gender, null, deathDate, null, null);
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
    public List<Human> getParents(){                               // вспомогательный метод для создания списка двух людей
        List<Human> list = new ArrayList<Human>(2);    //для метода addToParents в классе FamilyTree
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
    private int getPeriod(LocalDate birthDate, LocalDate deathDate){
        Period diff = Period.between(birthDate, deathDate);
        return diff.getYears();
    }
    public void setSpouse(Human spouse){
        this.spouse = spouse;
    }
    public Human getSpouse(){
        return spouse;
    }
    public void setId(long id){
        this.id = id;
    }
    public long getId(){
        return id;
    }
    public List<Human> getChildren(){
        return children;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder treebase = new StringBuilder();
        treebase.append("id: ");
        treebase.append(id);
        treebase.append(", имя: ");
        treebase.append(name);
        treebase.append(", пол: ");
        treebase.append(getGender());
        treebase.append(", возраст: ");
        treebase.append(getAge());
        treebase.append(", ");
        treebase.append(getSpouseInfo());
        treebase.append(", ");
        treebase.append(getMotherInfo());
        treebase.append(", ");
        treebase.append(getFatherInfo());
        treebase.append(", ");
        treebase.append(getChildrenInfo());
        return treebase.toString();
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
