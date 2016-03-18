package com.dcalabresi.iamtest.dto;

/**
 * Created by damian on 3/18/16.
 */
public class WatchDirectoryDto {

    private Integer id;

    private String directory;

    public WatchDirectoryDto() {
    }

    public WatchDirectoryDto(Integer id, String directory) {
        this.id = id;
        this.directory = directory;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDirectory() {
        return directory;
    }

    public void setDirectory(String directory) {
        this.directory = directory;
    }

}
