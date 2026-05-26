package org.example;

import org.example.entity.Nationality;
import org.example.entity.PassportStrength;
import org.example.entity.Person;
import org.example.entity.Sex;

import java.util.*;


public class Main {
    public static void main(String[] args) {
        Person[] people = new Person[]{
                new Person("Alice", 25, Sex.FEMALE, Nationality.AFGHANISTAN),
                new Person("Bob", 15, Sex.MALE, Nationality.AFGHANISTAN),
                new Person("Clara", 22, Sex.FEMALE, Nationality.GERMANY),
                new Person("David", 28, Sex.MALE, Nationality.USA),
                new Person("Eva", 35, Sex.FEMALE, Nationality.CANADA),
                new Person("Frank", 40, Sex.MALE, Nationality.GERMANY),
                new Person("Grace", 27, Sex.FEMALE, Nationality.USA),
                new Person("Henry", 33, Sex.MALE, Nationality.CANADA),
                new Person("Isabella", 24, Sex.FEMALE, Nationality.GERMANY),
                new Person("Jack", 29, Sex.MALE, Nationality.USA),
                new Person("Sophia", 31, Sex.FEMALE, Nationality.CANADA),
                new Person("Liam", 38, Sex.MALE, Nationality.GERMANY)
        };

        print(people);
        System.out.println("--- Germany (16+) ---");
        print(filterByCanDrinkAlcoholInGermany(people));

        System.out.println("--- USA (21+) ---");
        print(filterByCanDrinkAlcoholInUSA(people));

        System.out.println("--- Afghanistan (14+ and sex male) ---");
        print(filterByCanDrinkAlcoholInAfghanistan(people));

        System.out.println("--- USA or Canada ---");
        print(filterByCanFreelySpeakEnglish(people));

        System.out.println("--- WEAK AND STRONG ---");
        printMap(groupByPassportStrength(people));
    }

    public static void print(Person[] people) {
        for (Person person : people) {
            System.out.println(person.getName() + " " + person.getAge() + " " + person.getSex() + " " + person.getNationality());

        }
    }

    public static Person[] filterByCanDrinkAlcoholInGermany(Person[] people) {
        ArrayList<Person> list = new ArrayList<>();
        for (Person p : people) {
            if (p.getAge() >= 16) {
                list.add(p);
            }
        }
        return list.toArray(new Person[0]);
    }

    public static Person[] filterByCanDrinkAlcoholInUSA(Person[] people) {
        ArrayList<Person> list = new ArrayList<>();
        for (Person p : people) {
            if (p.getAge() >= 21) {
                list.add(p);
            }
        }
        return list.toArray(new Person[0]);
    }

    public static Person[] filterByCanDrinkAlcoholInAfghanistan(Person[] people) {
        ArrayList<Person> list = new ArrayList<>();
        for (Person p : people) {
            if (p.getAge() >= 14 && p.getSex() == Sex.MALE) {
                list.add(p);
            }
        }
        return list.toArray(new Person[0]);
    }

    public static Person[] filterByCanFreelySpeakEnglish(Person[] people) {
        ArrayList<Person> list = new ArrayList<>();
        for (Person p : people) {
            if (p.getNationality() == Nationality.USA || p.getNationality() == Nationality.CANADA) {
                list.add(p);
            }
        }
        return list.toArray(new Person[0]);
    }

    public static Map<PassportStrength, List<Person>> groupByPassportStrength(Person[] people) {
        HashMap<PassportStrength, List<Person>> map = new HashMap<>();
        for (Person p : people) {
            if (p.getNationality() == Nationality.AFGHANISTAN) {
                if (!map.containsKey(PassportStrength.WEAK)) {
                    map.put(PassportStrength.WEAK, new ArrayList<>());
                }
                map.get(PassportStrength.WEAK).add(p);
            } else {
                if (!map.containsKey(PassportStrength.STRONG)) {
                    map.put(PassportStrength.STRONG, new ArrayList<>());
                }
                map.get(PassportStrength.STRONG).add(p);
            }
        }
        return map;
    }

    public static void printMap(Map<PassportStrength, List<Person>> map) {
        for (Map.Entry<PassportStrength, List<Person>> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ":");
            for (Person p : entry.getValue()) {
                System.out.println(" " + p);
            }
        }
    }
}