package com.example.UDG.controllers;

import com.example.UDG.Models.WorkerModel;
import com.example.UDG.services.WorkerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping("/worker")
public class WorkerController {
    @Autowired
    WorkerService workerService;

    //get
    @GetMapping()
    public ArrayList<WorkerModel> findAllWorkers(){
        return workerService.findAllWorkers();
    }

    //post
    @PostMapping()
    public WorkerModel saveWorker(@RequestBody WorkerModel worker){
        return workerService.saveWorker(worker);
    }

    //buscar por codigo
    @GetMapping(path = "/findByCode={code}") //localhost:8080/worker/findByCode?
    public Optional<WorkerModel> findWorkerByCode(@PathVariable Integer code){
        return workerService.findWorkerByCode(code);
    }

    //buscar por nombre
    @GetMapping(path = "/findByName={name}") //localhost:8080/worker/findByName?
    public Optional<ArrayList<WorkerModel>> findWorkerByName(@PathVariable  String name){
        return workerService.findWorkerByName(name);
    }

    //borrar
    @DeleteMapping("/deleteWorkerByCode={code}")
    public String deleteWorkerByCode(@PathVariable Integer code) {
        return workerService.deleteWorkerByCode(code);
    }

    //editar
    @PutMapping()
    public WorkerModel updateWorker(@RequestBody WorkerModel workerModel){
        return workerService.saveWorker(workerModel);
    }

    //actualizar
    @PutMapping("/updateWorkerByCode={code}")
    public WorkerModel updateWorkerByCode(@PathVariable Integer code, @RequestBody WorkerModel workerModel){
        return workerService.updateWorkerByCode(code,workerModel);
    }
}

