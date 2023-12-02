package src.FamilyTree;

import src.FamilyTree.HR.Human;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private int countPeople;

    private List<Human> humanList;

    public FamilyTree(){
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {
        this.humanList = humanList;
    }

    public boolean add(Human human){
        if (!humanList.contains(human)){
            humanList.add(human);
            human.setId(countPeople++);

            addToParents(human);
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){
        for(Human parent: human.getParents()){
            parent.addChild(human);
        }
    }

    private void addToChildren(Human human){
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id){
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> result = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human)){
                    result.add(child);
                }
            }
        }
        return result;
    }

    public List<Human> getByName(String name){
        List<Human> result = new ArrayList<>();
        for (Human human: humanList){
            if (human.getName().equals(name)){
                result.add(human);
            }
        }
        return result;
    }
    public boolean setWedding(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }
    public boolean setWedding(Human human1, Human human2){
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean setDivorce(long humanId1, long humanId2){
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }
    public boolean setDivorce(Human human1, Human human2) {
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }
    public boolean remove(long humansId){
        if (checkId(humansId)){
            Human e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }
    private boolean checkId(long id) {
        return id < countPeople && id >= 0;
    }
    public Human getById(long id){
        if (checkId(id)){
            for (Human human: humanList){
                if (human.getId() == id) {
                    return human;
                }
            }
        }
        return null;
    }
    @Override
    public String toString() {
        return getInfo();
    }
    public String getInfo(){
        StringBuilder ftbase = new StringBuilder();
        ftbase.append("В дереве ");
        ftbase.append(humanList.size());
        ftbase.append("объектов: \n");
        for (Human human: humanList){
            ftbase.append(human);
            ftbase.append("\n");
        }

        return ftbase.toString();
    }

}
