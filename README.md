# BadPics

A utility library for scanning damaged image file.

*For Java version 11 and up*

### Usage:
```
ImageScanner.Result result = ImageScanner.scan(Files.newInputStream(Path.of("image.jpg")), ImageFormat.JPEG); 
System.out.println(result.isCorrupt());
System.out.println(result); // Show more details
```

#### or
```
ImageScanner.Result result = ImageScanner.scan(Path.of("image.jpg")); 
System.out.println(result.isCorrupt());
System.out.println(result); // Show more details
```
