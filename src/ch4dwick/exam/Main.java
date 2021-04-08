package ch4dwick.exam;

import ch4dwick.exam.models.Child;
import ch4dwick.exam.models.Parent;

import java.util.List;
import java.util.stream.Collectors;

public class Main {
    static Parent parent = new Parent("Parent 01");

    public static void main(String[] args) {
        initData();
        // If parent has daughters who ONLY have sons (no daughters) that are aged 40 and above.
        boolean fortyYrOldGrandKids = parent.getChildren()
                .stream()
                .filter(c -> "F".equals(c.getGender()) && !c.getChildren().isEmpty())
                .anyMatch(c ->
                        c.getChildren()
                                .stream()
                                .allMatch(g -> "M".equals(g.getGender()) && g.getAge() > 40));
        System.out.println("fortyYrOldGrandKids Matched? " + fortyYrOldGrandKids);

        // v2
        long countFortyYrOldGrandKids = parent.getChildren()
                .stream()
                .filter(c -> "F".equals(c.getGender()) && !c.getChildren().isEmpty() &&
                        c.getChildren()
                                .stream()
                                .allMatch(g -> "M".equals(g.getGender()) && g.getAge() > 40))
                .count();
        System.out.println("countFortyYrOldGrandKids Matched? " + countFortyYrOldGrandKids);

        // Who are these children?
        parent.getChildren()
                .stream()
                .filter(c -> "F".equals(c.getGender()) && !c.getChildren().isEmpty() &&
                        c.getChildren()
                                .stream()
                                .allMatch(g -> "M".equals(g.getGender()) && g.getAge() > 40))
                .forEach(c -> System.out.println(c.getName()));

        // If parent has sons who only have daughters that are aged 40 and below.
        boolean ltFortyYrOldGrandKids = parent.getChildren()
                .stream()
                .filter(c -> "M".equals(c.getGender()) && !c.getChildren().isEmpty())
                .anyMatch(c -> c.getChildren()
                        .stream()
                        .allMatch(g -> "F".equals(g.getGender()) && g.getAge() <= 40));

        System.out.println("ltFortyYrOldGrandKids Matched? " + ltFortyYrOldGrandKids);
        parent.getChildren()
                .stream()
                .filter(c -> "M".equals(c.getGender()) && !c.getChildren().isEmpty() &&
                        c.getChildren()
                                .stream()
                                .allMatch(g -> "F".equals(g.getGender()) && g.getAge() < 40))
                .forEach(c -> System.out.println(c.getName()));

        // Return a list if parent has sons who only have daughters that are aged 40 and below.
        List<Child> children = parent.getChildren()
                .stream()
                .filter(c -> "M".equals(c.getGender()) && !c.getChildren()
                        .isEmpty() &&
                        c.getChildren()
                                .stream()
                                .allMatch(g -> "F".equals(g.getGender()) && g.getAge() < 40))
                .collect(Collectors.toUnmodifiableList());
        children.forEach(c -> System.out.println(c.getName()));

        // Number of childless children.
        long childless = parent.getChildren()
                .stream()
                .filter(c -> c.getChildren()
                        .isEmpty())
                .count();
        System.out.println("childless count? " + childless);
    }

    private static void initData() {
        Child child = new Child("Child 01", "F", 85);
        Child grandChild = new Child("Child 011", "M", 50);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 012", "M", 46);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 013", "M", 47);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 014", "M", 49);
        child.getChildren()
                .add(grandChild);
        parent.getChildren()
                .add(child);

        child = new Child("Child 02", "M", 75);
        grandChild = new Child("Child 021", "F", 40);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 022", "F", 38);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 023", "F", 25);
        child.getChildren()
                .add(grandChild);
        parent.getChildren()
                .add(child);


        child = new Child("Child 03", "M", 30);
        parent.getChildren()
                .add(child);

        child = new Child("Child 04", "F", 31);
        parent.getChildren()
                .add(child);

        child = new Child("Child 05", "F", 90);
        grandChild = new Child("Child 051", "M", 60);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 052", "F", 56);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 053", "M", 29);
        child.getChildren()
                .add(grandChild);
        grandChild = new Child("Child 054", "M", 25);
        child.getChildren()
                .add(grandChild);
        parent.getChildren()
                .add(child);

    }
}
