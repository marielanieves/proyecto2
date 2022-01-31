package com.marielanievesfullstack.app.service;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.marielanievesfullstack.app.entity.user;

public interface userservice {
	
	public Iterable<user>findAll();
	
	public Page<user>findAll(Pageable pageable);
	
	public Optional <user>findById(Long id);
	
	public user save (user User);
	
	public void deleteById(Long id);
	

}
