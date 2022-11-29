package com.example.KTCK_Lan3_THLTDD.Services.Impl;

import com.example.KTCK_Lan3_THLTDD.Entities.Ca;
import com.example.KTCK_Lan3_THLTDD.Exception.ResourceNotFoundException;
import com.example.KTCK_Lan3_THLTDD.Repositories.CaRepository;
import com.example.KTCK_Lan3_THLTDD.Services.CaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CaServiceImpl implements CaService {

    @Autowired
    private CaRepository caRepository;

    @Override
    public List<Ca> getAllItem() {
        List<Ca> caList = this.caRepository.findAll();
        return caList;
    }

    @Override
    public Ca getCaById(Integer id) {
        Ca ca = this.caRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Ca","ID", id));
        return ca;
    }

    @Override
    public Ca addItem(Ca ca) {
        Ca newCa = this.caRepository.save(ca);
        return newCa;
    }

    @Override
    public Ca editItem(Ca ca, Integer id) {
        Ca editCa = this.caRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Ca", "ID", id));
        return editCa;
    }

    @Override
    public void deleteItem(Integer id) {
        Ca ca = this.caRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Ca","ID", id));
        this.caRepository.delete(ca);
    }
}
