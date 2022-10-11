package it.unibo.composition;

import java.util.Arrays;

public class Exam {

    private int id;
    private int maxStudents;
    private int registeredStudents;
    private String courseName;
    private Professor professor;
    private ExamRoom room;
    private Student[] students;

    public Exam(final int id, final int maxStudents, final String courseName, final Professor professor, final ExamRoom room) {
        this.id = id;
        this.maxStudents = maxStudents;
        this.registeredStudents = 0;
        this.courseName = courseName;
        this.professor = professor;
        this.room = room;
        this.students = new Student[this.maxStudents];
    }

    public int getId() {
        return this.id;
    }

    public int getMaxStudents() {
        return this.maxStudents;
    }

    public int getRegisteredStudents() {
        return this.registeredStudents;
    }

    public String getCourseName() {
        return this.courseName;
    }

    public void registerStudent(final Student student) {
        if (this.registeredStudents == this.maxStudents) {
            return;
        }

        this.students[this.registeredStudents] = student;
        this.registeredStudents++;
    }

    public String toString() {
        return "Exam: {"
            + "id= " + this.id
            + ", maxStudent= " + this.maxStudents
            + ", registeredStudents= " + this.registeredStudents
            + ", courseName= " + this.courseName
            + ", professor= " + this.professor
            + ", room= " + this.room
            + ", students= " + Arrays.toString(students);
    }
}