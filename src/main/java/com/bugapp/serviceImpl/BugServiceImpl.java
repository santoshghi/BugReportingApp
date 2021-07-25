package com.bugapp.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bugapp.model.Bug;
import com.bugapp.repo.BugRepo;
import com.bugapp.service.BugService;

@Service
public class BugServiceImpl implements BugService<Bug> {
	
	@Autowired
	private BugRepo bugRepo;
	

	@Override
	public Object bug_save(Bug t) {
		return bugRepo.save(t);
	}

	@Override
	public void bug_delete(Long id) {
		bugRepo.deleteById(id);
		
	}

	@Override
	public Optional<Bug> get_bug_by_id(Long id) {
		return bugRepo.findById(id);
	}

	@Override
	public List<Bug> list_all_bug() {
		return bugRepo.findAll();
	}

}
