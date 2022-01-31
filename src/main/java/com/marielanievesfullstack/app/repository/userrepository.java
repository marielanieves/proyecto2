package com.marielanievesfullstack.app.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marielanievesfullstack.app.entity.user;

@Repository
public interface userrepository extends JpaRepository<user, Long>{

}
