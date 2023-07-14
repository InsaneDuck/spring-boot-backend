package dev.insaneduck.springbootbackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "enrollment_data", schema = "data")
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
}
