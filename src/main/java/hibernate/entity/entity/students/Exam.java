package hibernate.entity.entity.students;

import sample.Student;

import javax.persistence.*;

@Entity
@Table (name = "exams")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "student_id")
    private StudentExample student;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn (name = "subject_id")
    private Subject subject;

    private int grade;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public StudentExample getStudent() {
        return student;
    }

    public void setStudent(StudentExample student) {
        this.student = student;
    }

    public Subject getSubject() {
        return subject;
    }

    public void setSubject(Subject subject) {
        this.subject = subject;
    }

    public int getGrade() {
        return grade;
    }

    public void setGrade(int grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Exam{" +
                "id=" + id +
                ", student=" + student +
                ", subject=" + subject +
                ", grade=" + grade +
                '}';
    }
}
