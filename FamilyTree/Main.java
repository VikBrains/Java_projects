package FamilyTree;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = myTree();
        System.out.println(tree);
    }

    static FamilyTree myTree(){
        FamilyTree tree = new FamilyTree();

        Human Viktor = new Human("Виктор", Gender.Male, LocalDate.of(1967,4,9));
        Human Vika = new Human("Виктория", Gender.Female, LocalDate.of(1969,9,7));
        tree.add(Viktor);
        tree.add(Vika);
        tree.setWedding(Viktor, Vika);

        Human Olga = new Human("Ольга", Gender.Female, LocalDate.of(1990, 2, 13));
        tree.add(Olga);

        Human grandMother = new Human("Полина", Gender.Female,LocalDate.of(1936, 9 ,16));
        tree.add(grandMother);

        return tree;
    }

   
}
