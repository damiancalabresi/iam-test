package com.dcalabresi.iamtest;

import com.dcalabresi.iamtest.entities.ImageMetadata;
import com.dcalabresi.iamtest.utils.ImageMetadataReader;
import org.apache.commons.imaging.ImageReadException;
import org.junit.Test;

import java.io.IOException;

public class UnitTests {

	@Test
	public void jpgMetadataTest() throws IOException, ImageReadException {
		ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFilePath("/home/damian/example.jpg");
		System.out.println(imageMetadata.toString());
	}

	@Test
	public void pngMetadataTest() throws IOException, ImageReadException {
		ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFilePath("/home/damian/Pictures/sauron.png");
		System.out.println(imageMetadata.toString());
	}

	@Test
	public void nonExistentDirectoryMetadataTest() throws IOException, ImageReadException {
		ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFilePath("/home/damian/Pictured/sauron.png");
		System.out.println(imageMetadata.toString());
	}

	@Test
	public void nonExistentFileMetadataTest() throws IOException, ImageReadException {
		ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFilePath("/home/damian/Pictures/sauros.png");
		System.out.println(imageMetadata.toString());
	}

	@Test
	public void nonPermissionTest() throws IOException, ImageReadException {
		ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFilePath("/root/sauron.png");
		System.out.println(imageMetadata.toString());
	}

	@Test
	public void nonImageTest() throws IOException, ImageReadException {
		ImageMetadata imageMetadata = ImageMetadataReader.readMetadataFromFilePath("/home/damian/email.html");
		System.out.println(imageMetadata.toString());
	}

}
