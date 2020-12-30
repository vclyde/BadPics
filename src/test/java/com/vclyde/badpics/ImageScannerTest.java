package com.vclyde.badpics;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Base64;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * @author Clyde Velasquez
 */
public class ImageScannerTest {
	
	private static final Path RESOURCES = Path.of("").resolve("src/main/resources/test").toAbsolutePath();

	@Test
	public void testScanInputStream() throws IOException {

		// img1
		ImageScanner.Result result = ImageScanner.scan(new ByteArrayInputStream(
			Base64.getDecoder().decode(Files.readAllBytes(RESOURCES.resolve("img1")))),
			ImageFormat.JPEG);
		Assert.assertEquals(Boolean.FALSE, result.isOk());
		
		// img2
		result = ImageScanner.scan(new ByteArrayInputStream(
			Base64.getDecoder().decode(Files.readAllBytes(RESOURCES.resolve("img2")))),
			ImageFormat.JPEG);
		Assert.assertEquals(Boolean.FALSE, result.isOk());
		
		// img3
		result = ImageScanner.scan(new ByteArrayInputStream(
			Base64.getDecoder().decode(Files.readAllBytes(RESOURCES.resolve("img3")))),
			ImageFormat.JPEG);
		Assert.assertEquals(Boolean.TRUE, result.isOk());
	}
	
	@Test
	public void testScanPath() throws IOException {
		// image1.jpg
		ImageScanner.Result result = ImageScanner.scan(RESOURCES.resolve("image1.jpg"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());

		// image2.jpg
		result = ImageScanner.scan(RESOURCES.resolve("image2.jpg"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());

		// image3.jpg
		result = ImageScanner.scan(RESOURCES.resolve("image3.jpg"));
		Assert.assertEquals(Boolean.FALSE, result.isCorrupt());
		Assert.assertEquals(Boolean.TRUE, result.isOk());
		Assert.assertEquals(0, result.getMessages().toString().length());

		// image4.jpg
		result = ImageScanner.scan(RESOURCES.resolve("image4.jpg"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());

		// image5.jpg
		result = ImageScanner.scan(RESOURCES.resolve("image5.jpg"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());

		// image6.png
		result = ImageScanner.scan(RESOURCES.resolve("image6.png"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());

		// image7.jpg
		result = ImageScanner.scan(RESOURCES.resolve("image7.jpg"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());

		// image8.jpeg
		result = ImageScanner.scan(RESOURCES.resolve("image8.jpeg"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());

		// image9.jpg
		result = ImageScanner.scan(RESOURCES.resolve("image9.jpg"));
		Assert.assertEquals(Boolean.TRUE, result.isCorrupt());
		Assert.assertEquals(Boolean.FALSE, result.isOk());
	}
}
