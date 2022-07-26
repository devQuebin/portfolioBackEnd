package com.portfoliomatsuda.Matsuda.services;

import com.portfoliomatsuda.Matsuda.exception.UserNotFoundException;
import com.portfoliomatsuda.Matsuda.models.Info;
import com.portfoliomatsuda.Matsuda.repository.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class InfoService {
    private final InfoRepo infoRepo;

    @Autowired
    public InfoService(InfoRepo infoRepo) {
        this.infoRepo = infoRepo;

    }
    public Info addInfo(Info info){
        return infoRepo.save(info);
    }

    public List<Info> buscarInfo(){
        return infoRepo.findAll();
    }

    public Info editarInfo(Info info){
        return infoRepo.save(info);
    }

    public void borrarInfo(Long id){
        infoRepo.deleteById(id);
    }
    public Info buscarInfoId(Long id){
        return infoRepo.findById(id).orElseThrow(()->new UserNotFoundException("Usuario no encontrado"));
    }
}
