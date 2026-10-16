package ch.walica.a38_temp161026_4tp2_listview.model;

import androidx.annotation.NonNull;

import java.util.concurrent.ThreadLocalRandom;

public class Person {

    private String name;
    private int age;

    public Person(String name) {
        this.name = name;
        this.age = ThreadLocalRandom.current().nextInt(18, 100);
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @NonNull
    @Override
    public String toString() {
        return name;
    }
}
