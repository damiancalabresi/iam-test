package com.dcalabresi.iamtest.repository;

import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.entities.WatchDirectory;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by damian on 3/18/16.
 */
public interface ImageMetadataRepository extends CrudRepository<ImageMetadata, Integer> {

    List<ImageMetadata> findAll();

    List<ImageMetadata> findByFilePathContainingAndDimensionContainingAndFormatContaining(String filePath,
                                                                                          String dimension,
                                                                                          String format);

    void deleteByWatchDirectoryId(Integer watchDirectoryId);

    List<ImageMetadata> findByWatchDirectoryId(Integer watchDirectoryId);

}
