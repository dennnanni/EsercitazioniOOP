package it.unibo.composition;

public class Testing {

    public static void main(final String[] args) {

        // 1)Creare 3 studenti a piacere
        Student stud1 = new Student(1, "Riccardo", "Mazzi", "Password", 2021);
        Student stud2 = new Student(2, "Matteo", "Sartini", "Nonèunapassword", 2021);
        Student stud3 = new Student(3, "Federico", "Tamburini", "Password", 2021);

        // 2)Creare 2 docenti a piacere
        Professor prof1 = new Professor(1, "Vittorio", "Ghini", "Password", new String[]{"Sistemi operativi", "Virtualizzazione"});
        Professor prof2 = new Professor(2, "Davide", "Maltoni", "Password", new String[]{"Architetture degli elaboratori"});

        // 3) Creare due aulee di esame, una con 100 posti una con 80 posti
        ExamRoom room1 = new ExamRoom(100, "2.12", true, true);
        ExamRoom room2 = new ExamRoom(80, "2.8", true, true);

        // 4) Creare due esami, uno con nMaxStudents=10, l'altro con
        // nMaxStudents=2
        Exam exam1 = new Exam(1, 10, "Sistemi operativi", prof1, room1);
        Exam exam2 = new Exam(2, 2, "Architetture degli elaboratori", prof2, room2);

        // 5) Iscrivere tutti e 3 gli studenti agli esami
        exam1.registerStudent(stud1);
        exam1.registerStudent(stud2);
        exam2.registerStudent(stud3);

        // 6) Stampare in stdout la rapresentazione in stringa dei due esami
        System.out.println(exam1.toString());
        System.out.println(exam2.toString());
    }
}
