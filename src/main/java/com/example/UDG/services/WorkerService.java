package com.example.UDG.services;

import com.example.UDG.Models.WorkerModel;
import com.example.UDG.repositories.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class WorkerService {
    @Autowired
    WorkerRepository workerRepository;

    //obtener todos los freelancers registrados
    public ArrayList<WorkerModel> findAllWorkers(){
        return (ArrayList<WorkerModel>) workerRepository.findAll();
    }

    //guardar un freelancer
    public WorkerModel saveWorker(WorkerModel worker){
        return workerRepository.save(worker);
    }

    //buscar por nombre
    public Optional<ArrayList<WorkerModel>> findWorkerByName(String name){
        return workerRepository.findWorkerByName(name);
    }

    //buscar por codigo
    public Optional<WorkerModel> findWorkerByCode(Integer code){
        return workerRepository.findWorkerByCode(code);
    }

    //eliminar por codigo
    public String deleteWorkerByCode(Integer code){
        String response = "";

        Optional<WorkerModel> foundWorker = findWorkerByCode(code);
        if(foundWorker.isPresent()){
            workerRepository.delete(foundWorker.get());
            response = "Worker deleted seccessfully";
        }else{
            response = "Worker not found";
        }

        return response;
    }

    //actualizar
    public WorkerModel updateWorkerByCode(Integer code, WorkerModel workerModel){
        return findWorkerByCode(code).isPresent() ? workerRepository.save(workerModel) : new WorkerModel();
    }
}
