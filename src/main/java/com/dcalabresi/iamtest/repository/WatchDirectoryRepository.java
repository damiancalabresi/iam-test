package com.dcalabresi.iamtest.repository;

import com.dcalabresi.iamtest.entities.WatchDirectory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
public interface WatchDirectoryRepository extends CrudRepository<WatchDirectory, Integer> {

    List<WatchDirectory> findAll();

}
