package src.FamilyTree;


import src.FamilyTree.HR.Gender;
import src.FamilyTree.HR.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = myTree();
        System.out.println(tree);
    }

    static FamilyTree myTree() {
        FamilyTree tree = new FamilyTree();

        Human полина = new Human("Полина", Gender.Female, LocalDate.of(1936, 9, 16), LocalDate.of(1997, 5, 2));
        tree.add(полина);

        Human Viktor = new Human("Виктор", Gender.Male, LocalDate.of(1967, 4, 9), null, полина);
        Human Vika = new Human("Виктория", Gender.Female, LocalDate.of(1969, 9, 7));
        tree.add(Viktor);
        tree.add(Vika);
        tree.setWedding(Viktor, Vika);

        Human Olga = new Human("Ольга", Gender.Female, LocalDate.of(1990, 2, 14), Viktor, Vika);
        tree.add(Olga);
        Human andrej = new Human("Андрей", Gender.Male, LocalDate.of(1988, 8, 9));
        tree.add(andrej);
        tree.setWedding(andrej, Olga);
        Human Sasha = new Human("Александр", Gender.Male, LocalDate.of(2004, 12, 15), Viktor, Vika);
        tree.add(Sasha);

        Human igor = new Human("Игорь", Gender.Male, LocalDate.of(2018, 8, 14), andrej, Olga);
        tree.add(igor);

        return tree;
    }

}