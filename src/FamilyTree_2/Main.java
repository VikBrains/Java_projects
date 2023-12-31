package src.FamilyTree_2;

import src.FamilyTree_2.HR.Gender;
import src.FamilyTree_2.HR.Human;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        FamilyTree tree = myTree();
        System.out.println(tree);
    }

    static FamilyTree myTree(){
        FamilyTree tree = new FamilyTree();

        Human polina = new Human("Полина", Gender.Female,LocalDate.of(1936, 9 ,16), LocalDate.of(1997, 5, 2));
        tree.add(polina);

        Human Viktor = new Human("Виктор", Gender.Male, LocalDate.of(1967, 4, 9), null, polina);
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
