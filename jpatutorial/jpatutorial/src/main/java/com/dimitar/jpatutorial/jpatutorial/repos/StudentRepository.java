package com.dimitar.jpatutorial.jpatutorial.repos;

import com.dimitar.jpatutorial.jpatutorial.entities.Student;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;


import java.util.List;

public interface StudentRepository extends CrudRepository<Student, Long> {

    @Query("from Student")
    public List<Student> findAllStudents(Pageable pagable);


    @Query("select st.firstName, st.lastName from Student st")
    public List<Object[]> findAllStudentsPartialData();


    @Query("from Student where firstName=:firstName")
    public List<Student> findAllStudentsByFirstName(final @Param("firstName") String firstName);


    @Query("from Student where score >=:min and score<=:max")
    public List<Student> findAllStudentsForGivenScores(final @Param("min") int min, final @Param("max") int max);


    @Modifying
    @Query("delete from Student where firstName=:firstName")
    void deleteStudentsByFirstName(@Param("firstName") String firstName);


    @Query(value="select * from student", nativeQuery = true)
    List<Student> findAllStudentsNQ();

    @Query(value="select * from student where f_name=:firstName", nativeQuery = true)
    List<Student> findAllByFirstNameNQ(@Param("firstName") String firstName);
}
