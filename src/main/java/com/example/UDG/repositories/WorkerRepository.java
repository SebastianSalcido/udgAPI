package com.example.UDG.repositories;

import com.example.UDG.Models.WorkerModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface WorkerRepository extends CrudRepository<WorkerModel,Long> {

    //editar (ya lo tenemos)
    //buscar por codigo
    public abstract Optional<WorkerModel> findWorkerByCode(Integer code);
    //buscar por nombre
    public abstract Optional<ArrayList<WorkerModel>> findWorkerByName(String name);
    //eliminar por código
    public void deleteWorkerByCode(Integer code);

}
