package com.admin.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.admin.model.Admin;
@Repository
public interface AdminRepo extends JpaRepository<Admin, Integer> {

}
