package com.dcalabresi.iamtest.dto;

/**
 * Created by damian on 3/18/16.
 */
public class ImageFilterDto {

    private String filePath;

    private String dimension;

    private String format;

    public ImageFilterDto() {
        this.filePath = "";
        this.dimension = "";
        this.format = "";
    }

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getFormat() {
        return format;
    }

    public void setFormat(String format) {
        this.format = format;
    }
}
