package com.quynhtadinh.finalexample.repository;

import com.quynhtadinh.finalexample.entity.Employees;
import com.quynhtadinh.finalexample.entity.Import;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ImportRepository extends JpaRepository<Import, Long>{
//    Page<Import> findByImport_idContaining(String id, Pageable pageable);


}
