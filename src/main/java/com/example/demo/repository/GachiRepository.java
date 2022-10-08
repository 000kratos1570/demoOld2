package com.example.demo.repository;

import com.example.demo.models.Gachi;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface GachiRepository extends CrudRepository<Gachi, Long> {

    List<Gachi> findBytitlegachi(String titlegachi);
}

