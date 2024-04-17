package org.example;


import java.util.Objects;
import java.util.OptionalInt;

public class Person {

    private final String name;
    private final String surname;
    private int age;
    private String city;

    OptionalInt num = OptionalInt.empty();


    public Person(String name, String surname, int age, String city) {
        this.name = name;
        this.surname = surname;
        if (age > 0 && age < 115) {
            this.age = age;
            num = OptionalInt.of(this.age);
        } else {
            this.age = 0;
        }
        this.city = city;
    }

    public Person(String name, String surname) {
        this.name = name;
        this.surname = surname;


    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public OptionalInt getAge() {
        return num;
    }

    public String getCity() {
        return city;
    }

    public boolean hasAge() {
        if (num.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }

    public void happyBirthday() {
        if (hasAge()) {
            this.age++;
            num = OptionalInt.of(this.age);
        }
    }

    public boolean hasAddress() {
        if (this.city == null) {
            return false;
        } else {
            return true;
        }
    }

    public PersonBuilder newChildBuilder() {
        PersonBuilder child = new PersonBuilder();
        child.setSurname(this.surname);
        child.setAge(4);
        child.setAddress(this.city);
        return child;
    }


    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Person{" +
                "NAME='" + name + '\'' +
                ", SURNAME='" + surname + '\'' +
                ", AGE=" + num +
                ", CITY='" + city + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname) && Objects.equals(city, person.city);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age, city);
    }
}