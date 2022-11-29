package com.example.KTCK_Lan3_THLTDD.Repositories;

import com.example.KTCK_Lan3_THLTDD.Entities.Ca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CaRepository extends JpaRepository<Ca,Integer> {
}
