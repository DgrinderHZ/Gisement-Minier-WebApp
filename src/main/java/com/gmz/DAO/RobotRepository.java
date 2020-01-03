package com.gmz.DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import com.gmz.entity.Robot;

public interface RobotRepository extends JpaRepository<Robot, Integer> {

}
