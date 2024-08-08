package com.quynhtadinh.finalexample.repository;


import com.quynhtadinh.finalexample.entity.Import;
import com.quynhtadinh.finalexample.entity.ImportDetail;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ImportDetailRepository extends JpaRepository<ImportDetail, Long>{

}