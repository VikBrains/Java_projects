package FamilyTree;

import java.util.ArrayList;
import java.util.List;

public class FamilyTree {
    private long countPeople;    // ошибка
    private List<Human> humanList;

    public FamilyTree(){                                // конструктор без аргументов
        this(new ArrayList<>());
    }

    public FamilyTree(List<Human> humanList) {       // конструктор с аргументами
        this.humanList = humanList;
    }

    public boolean add(Human human){                   // добавление человека
        if (human == null) {                           // этот if можно не брать
            return false;
        }
        if (!humanList.contains(human)){                 // проверка на наличие человека в дереве
            humanList.add(human);
            human.setId(countPeople++);

            addToParents(human);                        // методы создания связи с родственниками
            addToChildren(human);

            return true;
        }
        return false;
    }

    private void addToParents(Human human){               // добавление связи с родителями
        for(Human parent: human.getParents()){
            parent.addChild(human);                       // прибавление ребёнка нововведённому человеку
        }
    }

    private void addToChildren(Human human){               // прибавление родителя нововведённому ребёнку
        for (Human child: human.getChildren()){
            child.addParent(human);
        }
    }

    public List<Human> getSiblings(int id){               // нахождение братьев и сестёр ( не исп. пока)
        Human human = getById(id);
        if (human == null){
            return null;
        }
        List<Human> res = new ArrayList<>();
        for (Human parent: human.getParents()){
            for (Human child: parent.getChildren()){
                if (!child.equals(human)){
                    res.add(child);                        // добавление братьев и сестёр
                }
            }
        }
        return res;
    }

    public List<Human> getByName(String name){             // поиск по имени (список "однофамильцев")
        List<Human> res = new ArrayList<>();                // не исп.
        for (Human human: humanList){
            if (human.getName().equals(name)){
                res.add(human);
            }
        }
        return res;
    }
    public boolean setWedding(long humanId1, long humanId2){         // создания супружеских связей по Id
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setWedding(human1, human2);
        }
        return false;
    }
    public boolean setWedding(Human human1, Human human2){              // создания супружеских связей по имени
        if(human1.getSpouse() == null && human2.getSpouse() == null){
            human1.setSpouse(human2);
            human2.setSpouse(human1);
            return true;
        }
        else {
            return false;
        }
    }
    public boolean setDivorce(long humanId1, long humanId2){              // метод развода  по Id   (не исп)
        if (checkId(humanId1) && checkId(humanId2)){
            Human human1 = getById(humanId1);
            Human human2 = getById(humanId2);
            return setDivorce(human1, human2);
        }
        return false;
    }
    public boolean setDivorce(Human human1, Human human2) {               // метод развода  по имени
        if (human1.getSpouse() != null && human2.getSpouse() != null) {
            human1.setSpouse(null);
            human2.setSpouse(null);
            return true;
        } else {
            return false;
        }
    }
    public boolean remove(long humansId){                          // метод удаления по Id   ( не исп)
        if (checkId(humansId)){
            Human e = getById(humansId);
            return humanList.remove(e);
        }
        return false;
    }
    private boolean checkId(long id) {                    // проверка что заданный номер по списка не более последнего числа списка
        return id < countPeople && id >= 0;
    }
    public Human getById(long id){                     //  метод поиска человека по Id
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
    public String getInfo(){                               // (ИТОГОВЫЙ) метод вывода информации
        StringBuilder treebase = new StringBuilder();
        treebase.append("В дереве ");
        treebase.append(humanList.size());
        treebase.append("объектов: \n");
        for (Human human: humanList){
            treebase.append(human);
            treebase.append("\n");
        }

        return treebase.toString();
    }

}
