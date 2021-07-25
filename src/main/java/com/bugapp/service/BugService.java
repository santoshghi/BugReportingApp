package com.bugapp.service;

import java.util.List;
import java.util.Optional;

public interface BugService<T> {
	
	Object bug_save(T t);
	
	public void bug_delete(Long id);
	
	Optional<T> get_bug_by_id(Long id);
	
	List<T> list_all_bug();

}
