package com.example.demo.repository;

import com.example.demo.models.Windows;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface WindowsRepository extends CrudRepository<Windows, Long> {
    List<Windows> findByname(String name);
}
