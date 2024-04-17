package org.example;

import java.util.HashMap;

public class PersonBuilder {

    private String name;
    private String surname;
    private int age;
    private String city;

    public PersonBuilder(String name) {
        this.name = name;
    }

    public PersonBuilder() {
        name = "unknown";
        surname = "unknown";
        age = 0;
        city = "unknown";
    }


    public PersonBuilder setName(String name) {
        if (name == null || name == "") {
            throw new IllegalStateException("Не указанно имя!");
        }
        for (int i = 0; i < name.length(); i++) {
            if (Character.isDigit(name.charAt(i))) {
                throw new IllegalArgumentException("Не допустымий символ в имени: " + "[" + name.charAt(i) + "]");
            }
        }
        this.name = name;
        return this;

    }

    public PersonBuilder setSurname(String surname) {
        if (surname == null || surname == "") {
            throw new IllegalStateException("Не указанно имя!");
        }
        for (int i = 0; i < surname.length(); i++) {
            if (Character.isDigit(surname.charAt(i))) {
                throw new IllegalArgumentException("Не допустымий символ в имени: " + "[" + surname.charAt(i) + "]");
            }
        }
        this.surname = surname;
        return this;
    }

    public PersonBuilder setAge(int age) {
        if (age == 0) {
            throw new IllegalStateException("Не указан возраст!");
        }
        if (age < 0 || age > 100) {
            throw new IllegalArgumentException("Указан не корректный возраст " + "[" + age + "]");
        }
        this.age = age;
        return this;
    }

    public PersonBuilder setAddress(String address) {
        if (address == null || address == "") {
            throw new IllegalStateException("Не указан адрес!");
        }
        this.city = address;
        return this;
    }

    public Person build() {
        if (age != 0) {
            HashMap<String, String> list = new HashMap<>();
            list.put(name, "Nмя");
            list.put(surname, "Фамилия");
            list.put(city, "Адрес");
            for (String step : list.keySet()) {
                if (step.equals("unknown")) {
                    throw new IllegalStateException("Не заполнена графа: " + list.get(step) + "!");
                }
            }
            Person person = new Person(name, surname, age, city);
            return person;
        } else {
            throw new IllegalStateException("Не указан адрес!");
        }
//        if (NAME==null){
//            throw new IllegalStateException("Не указанно  имя !");
//        }
//        if (SURNAME==null){
//            throw new IllegalStateException("Не указана фамилия !");
//        }
//        if (AGE==-1){
//            throw new IllegalStateException("Не указан возраст!");
//        }
//        if (CITY==null){
//            throw new IllegalStateException("Не указан Адрес!");
//        }
//        Person person = new Person(NAME,SURNAME,AGE,CITY);
//        return person;
    }

    @Override
    public String toString() {
        return "PersonBuilder{" +
                "NAME='" + name + '\'' +
                ", SURNAME='" + surname + '\'' +
                ", AGE=" + age +
                ", CITY='" + city + '\'' +
                '}';
    }
}
