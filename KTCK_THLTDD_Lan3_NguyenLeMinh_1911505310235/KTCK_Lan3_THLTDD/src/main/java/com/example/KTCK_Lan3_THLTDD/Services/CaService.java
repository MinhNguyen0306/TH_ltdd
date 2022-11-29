package com.example.KTCK_Lan3_THLTDD.Services;

import com.example.KTCK_Lan3_THLTDD.Entities.Ca;

import java.util.List;

public interface CaService {

    List<Ca> getAllItem();

    Ca getCaById(Integer id);

    Ca addItem(Ca ca);

    Ca editItem(Ca ca, Integer id);

    void deleteItem(Integer id);
}
