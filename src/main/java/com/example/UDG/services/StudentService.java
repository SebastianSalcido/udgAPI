package com.example.UDG.services;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.repositories.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;

    //obtener todos los estudiantes registrados
    public ArrayList<StudentModel> findAllStudents(){
        return (ArrayList<StudentModel>) studentRepository.findAll();
    }

    //guardar un estudiante
    public StudentModel saveStudent(StudentModel student){
        return studentRepository.save(student);
    }

    //buscar por nombre
    public Optional<ArrayList<StudentModel>> findStudentByName(String name){
        return studentRepository.findStudentByName(name);
    }

    //buscar por codigo
    public Optional<StudentModel> findStudentByCode(Integer code){
        return studentRepository.findStudentByCode(code);
    }

    //eliminar por codigo
    public String deleteStudentByCode(Integer code){
        String response = "";

        Optional<StudentModel> foundStudent = findStudentByCode(code);
        if(foundStudent.isPresent()){
            studentRepository.delete(foundStudent.get());
            response = "Student deleted seccessfully";
        }else{
            response = "Student not found";
        }

        return response;
    }

    //actualizar
    public StudentModel updateStudentByCode(Integer code, StudentModel studentModel){
        return findStudentByCode(code).isPresent() ? studentRepository.save(studentModel) : new StudentModel();
    }
}
