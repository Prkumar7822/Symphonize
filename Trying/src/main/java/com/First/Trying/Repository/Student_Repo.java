package com.First.Trying.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.First.Trying.Model.Student_data;
import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;
@Repository
public interface Student_Repo extends JpaRepository<Student_data, Integer> {

}
