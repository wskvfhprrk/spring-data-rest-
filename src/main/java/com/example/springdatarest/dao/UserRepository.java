package com.example.springdatarest.dao;

import com.example.springdatarest.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;


@RepositoryRestResource(collectionResourceRel = "users", path = "users")
public interface UserRepository extends PagingAndSortingRepository<User, Integer>, JpaSpecificationExecutor<User> {
    @RestResource(path = "findByUsername", rel = "findByUsername")
    public Page findByUsernameContaining(String username, Pageable p);
}
