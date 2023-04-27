package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "course_data", schema = "data", catalog = "")
public class CourseData {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "course_id")
    private Integer courseId;
    @Basic
    @Column(name = "instructor_id")
    private Integer instructorId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public Integer getInstructorId() {
        return instructorId;
    }

    public void setInstructorId(Integer instructorId) {
        this.instructorId = instructorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CourseData that = (CourseData) o;
        return id == that.id && Objects.equals(courseId, that.courseId) && Objects.equals(instructorId, that.instructorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, courseId, instructorId);
    }
}
