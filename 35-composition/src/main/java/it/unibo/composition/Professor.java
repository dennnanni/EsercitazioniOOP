package it.unibo.composition;

import java.util.Arrays;

public class Professor implements User {
    static final String DOT = ".";

    private final int id;
    private final String name;
    private final String surname;
    private String password;
    private String[] courses;

    public Professor(final int id, final String name, final String surname, final String password, final String[] courses) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.password = password;
        this.courses = Arrays.copyOf(courses, courses.length);
    }

    public int getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public String getSurname() {
        return this.surname;
    }

    public String getUsername() {
        return this.name + Professor.DOT + this.surname;
    }

    public String getPassword() {
        return this.password;
    }

    public String getDescription() {
        return this.toString();
    }

    public String toString() {
        return "Professor ["
            + "name=" + this.name
            + ", surname=" + this.surname
            + ", id=" + this.id
            + ", courses= " + Arrays.toString(courses)
            + "]";
    }

    public void replaceCourse(final String course, final int index) {
        if(index < 0 || index >= this.courses.length) {
            return;
        }

        this.courses[index] = course;
    }

    public void replaceAllCourses(final String[] courses) {
        this.courses = Arrays.copyOf(courses, courses.length);
    }
}