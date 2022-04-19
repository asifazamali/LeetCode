package PracticeJava8.ComparatorDemo;

import com.sun.imageio.plugins.jpeg.JPEGImageReaderSpi;
import com.sun.org.apache.regexp.internal.RE;
import com.sun.org.apache.xalan.internal.xsltc.compiler.util.CompareGenerator;

import java.util.*;
import java.util.concurrent.*;
import java.util.function.Predicate;

public class Main {
    public static boolean isEligibleForVoting(Person p, Predicate<Person> predicate) {
        return predicate.test(p);
    }

    public static boolean isEligibleForRationCard(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }

    public static boolean isEconomicallyWeak(Person person, Predicate<Person> predicate){
        return predicate.test(person);
    }
    public static boolean isWellEstablished(Person person, Predicate<Person> predicate){
        return predicate.negate().test(person);
    }

    public static void main(String[] args) {
        Person p1 = new Person(1, "B", 23, 1, 500);
        List<Person> personList = new ArrayList<>();
        personList.add(p1);
        personList.add(new Person(2, "B", 4, 0, 100));
        personList.add(new Person(3, "A", 24, 2, 2000));
        Predicate<Person> greaterThan18= p -> p.getAge() > 18;
        Predicate<Person> minSalary = p -> p.getSalary() < 1000;
        Predicate<Person> childrenCondition = p -> p.getChildren() > 1;
        Collections.sort(personList, Comparator.comparing(Person::getName));

        for(Person person: personList)  {
            if(isEligibleForVoting(person, greaterThan18))
                System.out.println("Eligible for voting: " + person);
            if (isEligibleForRationCard(person, greaterThan18.and(minSalary))) {
                System.out.println("Eligible for ration: " + person);
            }
            if(isEconomicallyWeak(person, greaterThan18.and(minSalary.or(childrenCondition)))) {
                System.out.println("Economically weak: " + person);
            }
            if(isWellEstablished(person, greaterThan18.and(minSalary.or(childrenCondition)))){
                System.out.println("Well established: " + person);
            }
        }
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j", "k", "l"));
        list.stream()
                .flatMap(x -> x.stream())
                .filter(x -> x.equals("a"))
                .map(String::toUpperCase)
                .forEach(System.out::println);
        //Completable Future
        ExecutorService service = Executors.newFixedThreadPool(5);
        CompletableFuture<Integer> completableFuture = CompletableFuture.supplyAsync(() -> {
            try {
                System.out.println("Thread Name: " + Thread.currentThread().getName());
            } catch (Exception exception) {
                exception.printStackTrace();
            }
            return 5;
        }, service);
        CompletableFuture<Void> resFuture = completableFuture.thenApplyAsync(num -> {
            System.out.println("Res Future: Thread Name: " + Thread.currentThread().getName());
            return num * 2;
        }, service)
                .thenAccept(System.out::println);

        CompletableFuture<Void> resFuture2 = completableFuture
                .thenCombine(CompletableFuture.supplyAsync(() -> 20), (num1, num2) -> num1 + num2)
                .thenAccept(num -> System.out.println(num));
        System.out.println("Priting sysout");
        try {
//            System.out.println(resFuture.get());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
