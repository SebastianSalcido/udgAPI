package com.example.UDG.controllers;

import com.example.UDG.Models.StudentModel;
import com.example.UDG.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/student")
public class StudentController {
    @Autowired
    StudentService studentService;

    //get
    @GetMapping()
    public ArrayList<StudentModel> findAllStudents(){
        return studentService.findAllStudents();
    }

    //post
    @PostMapping()
    public StudentModel saveStudent(@RequestBody StudentModel student){
        return studentService.saveStudent(student);
    }

    //buscar por codigo
    @GetMapping(path = "/findByCode={code}") //localhost:8080/student/findByCode?
    public Optional<StudentModel> findStudentByCode(@PathVariable Integer code){
        return studentService.findStudentByCode(code);
    }

    //buscar por nombre
    @GetMapping(path = "/findByName={name}") //localhost:8080/student/findByCode?
    public Optional<ArrayList<StudentModel>> findStudentByName(@PathVariable  String name){
        return studentService.findStudentByName(name);
    }

    //borrar
    @DeleteMapping("/deleteStudentByCode={code}")
    public String deleteStudentByCode(@PathVariable Integer code) {
        return studentService.deleteStudentByCode(code);
    }

    //editar
    @PutMapping()
    public StudentModel updateStudent(@RequestBody StudentModel studentModel){
        return studentService.saveStudent(studentModel);
    }

    //actualizar
    @PutMapping("/updateStudentByCode={code}")
    public StudentModel updateStudentByCode(@PathVariable Integer code, @RequestBody StudentModel studentModel){
        return studentService.updateStudentByCode(code,studentModel);
    }
}
