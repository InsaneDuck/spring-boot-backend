package dev.insaneduck.springbootbackend.repository;

import dev.insaneduck.springbootbackend.entities.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface CourseRepository
        extends JpaRepository<Course, Integer> {

    //exposed by default at /courses/search/
    @Query(nativeQuery = false,value = "select c from Course c where c.department=:department")
    List<Course> findByDepartment(@Param("department") String department);

    @Query(nativeQuery = false,value = "select c from Course c where c.code=:code")
    Course getCourseByCode(@Param("code") String code);
}
