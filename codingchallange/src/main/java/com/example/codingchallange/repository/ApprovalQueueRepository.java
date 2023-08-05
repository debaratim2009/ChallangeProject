package com.example.codingchallange.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.codingchallange.Entity.Queue;
import com.example.codingchallange.Entity.Product;


@Repository
public interface ApprovalQueueRepository extends JpaRepository<Queue, Long> {

	

}
