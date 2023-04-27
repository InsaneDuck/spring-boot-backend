package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "enrollment_data", schema = "data", catalog = "")
public class EnrollmentData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "student_id")
    private int studentId;
    @Basic
    @Column(name = "course_id")
    private int courseId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public int getCourseId() {
        return courseId;
    }

    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EnrollmentData that = (EnrollmentData) o;
        return id == that.id && studentId == that.studentId && courseId == that.courseId;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studentId, courseId);
    }
}
