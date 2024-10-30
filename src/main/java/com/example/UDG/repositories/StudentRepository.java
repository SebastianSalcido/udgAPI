package com.example.UDG.repositories;

import com.example.UDG.Models.StudentModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface StudentRepository extends CrudRepository<StudentModel,Long> {

    //editar (ya lo tenemos)
    //busacar por codigo
    public abstract Optional<StudentModel> findStudentByCode(Integer code);
    //buscar por nombre
    public abstract Optional<ArrayList<StudentModel>> findStudentByName(String name);
    //eliminar por código
    public void deleteStudentByCode(Integer code);

}
