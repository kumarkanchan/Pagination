package com.pagination.repository;

import com.pagination.entities.User;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface PagingAndSortingRepo extends PagingAndSortingRepository<User, Integer> {

}
