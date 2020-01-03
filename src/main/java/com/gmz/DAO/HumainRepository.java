package com.gmz.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmz.entity.Humain;

public interface HumainRepository extends JpaRepository<Humain, Integer> {

}
