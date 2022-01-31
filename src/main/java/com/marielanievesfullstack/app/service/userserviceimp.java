package com.marielanievesfullstack.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.marielanievesfullstack.app.entity.user;
import com.marielanievesfullstack.app.repository.userrepository;

@Service
public class userserviceimp implements userservice{
    @Autowired
    private userrepository useRrepository;
    
	@Override
	@Transactional(readOnly = true)
	
	public Iterable<user> findAll() {
		return useRrepository.findAll();
	}

	@Override
	@Transactional(readOnly = true)
	public Page<user> findAll(Pageable pageable) {
		return useRrepository.findAll(pageable);
	}

	@Override
	@Transactional(readOnly = true)
	public Optional<user> findById(Long id) {
		return useRrepository.findById(id);
	}

	@Override
	@Transactional
	public user save(user User) {
		return useRrepository.save(User);
	}

	@Override
	@Transactional
	public void deleteById(Long id) {
		useRrepository.deleteById(id);
		
	}

}
