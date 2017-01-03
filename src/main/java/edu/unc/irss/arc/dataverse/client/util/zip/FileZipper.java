package edu.unc.irss.arc.dataverse.client.util.zip;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;
import org.apache.commons.lang3.StringUtils;

/**
 * Creates a zip file by using NIO2 API.
 *
 * @author asone
 */
public class FileZipper {

    private static final Logger logger = Logger.getLogger(FileZipper.class.getName());

    final static Map<String, String> DEFAULT_ENV = new HashMap<>();

    static {
        // see http://docs.oracle.com/javase/8/docs/technotes/guides/io/fsp/zipfilesystemproviderprops.html
        // there are two properties: create (true|false[default]) and encoding (default
        // value is UTF-8) | env.put("encoding", "UTF-8")
        DEFAULT_ENV.put("create", "true");
    }

    private FileSystem createZipFileSystem(String zipFilename, boolean create)
            throws IOException {

        Path path = Paths.get(zipFilename);

        if (Files.exists(path)) {
            logger.log(Level.INFO, "the target zip file [{0}] already exists: delete it", path);
            Files.delete(path);
        } else {
            logger.log(Level.INFO, "the target zip file [{0}] does not exist", path);
        }
        //path = Paths.get(zipFilename);
        final URI uri = URI.create("jar:file:" + path.toUri().getPath());
        logger.log(Level.INFO, "uri={0}", uri.toString());

        final Map<String, String> env = new HashMap<>();

        // see http://docs.oracle.com/javase/8/docs/technotes/guides/io/fsp/zipfilesystemproviderprops.html
        // there are two properties: create (true|false[default]) and encoding (default
        // value is UTF-8) 
        if (create) {
            env.put("create", "true");
            //env.put("encoding", "UTF-8");
        }
        return FileSystems.newFileSystem(uri, env);
    }

    private FileSystem createZipFileSystem(String zipFilename) throws IOException {

        Path path = Paths.get(zipFilename);

        if (Files.exists(path)) {
            logger.log(Level.INFO,
                    "the target zip file [{0}] already exists: delete it", path);
            Files.delete(path);
        } else {
            logger.log(Level.INFO,
                    "the target zip file [{0}] does not exist", path);
        }

        URI uri = URI.create("jar:file:" + path.toUri().getPath());

        logger.log(Level.INFO, "uri={0}", uri.toString());

        return FileSystems.newFileSystem(uri, DEFAULT_ENV);
    }

    /**
     * Creates a zip file whose pathname is denoted by 
     * {@code zipFilename} from {@code srcPath} with a relative path
     * {@code relativizeBase}.
     * 
     * @param srcPath
     * @param relativizeBase
     * @param zipFilename
     */
    public void create(Path srcPath, Path relativizeBase, String zipFilename) {

        logger.log(Level.INFO, "srcPath={0}", srcPath);
        logger.log(Level.INFO, "relativizeBase={0}", relativizeBase);

        try (FileSystem zipFileSystem = createZipFileSystem(zipFilename)) {
            logger.log(Level.INFO, "target is a directory");
            Files.walkFileTree(srcPath, new FileVisitorForZipping(zipFileSystem,
                    relativizeBase));
        } catch (IOException ie) {
            logger.log(Level.INFO,
                    "IOException was thrown from FileZipper#create()", ie);
        }
    }
    
    
    /**
     * Creates a zip file whose path is specified by the first one from
     * the second one.
     * 
     * @param sourcePath the path to the source file or directory
     * @param zipPath  the path to the resulting zip file
     */
    public void create(Path sourcePath, Path zipPath) {

        try (ZipOutputStream zs = new ZipOutputStream(Files.newOutputStream(zipPath));) {

            Files.walk(sourcePath).filter(path -> !Files.isDirectory(path)).forEach(path -> {

                String sp = path.toAbsolutePath().toString().replace(sourcePath.toAbsolutePath().toString(), "").replace(path.getFileName().toString(), "").replace("\\", "/");

                // the following works for dataverse
                logger.log(Level.INFO, "sp={0}", sp);

                logger.log(Level.INFO, "filename={0}", path.getFileName().toString());

                sp = sp.replaceFirst("/", "") + path.getFileName().toString();

                logger.log(Level.INFO, "sp={0}", sp);

                ZipEntry zipEntry = new ZipEntry(sp);
                
                // the following line uses "\" as a path-separator and
                // dataverse upload failure (2016-11-30)

                try {
                    zs.putNextEntry(zipEntry);
                    zs.write(Files.readAllBytes(path));
                    zs.closeEntry();
                } catch (IOException ex) {
                    logger.log(Level.SEVERE, "IO Exception was thrown within the inner loop", ex);
                }
            });
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IO Exception was thrown from the outer loop", ex);
        }
    }

    
    /**
     * Creates a zip file whose pathname is specified by
     * the second pathname from the source file denoted by the first 
     * pathname. 
     * 
     * @param sourceDirPath
     * @param zipFilePath 
     */
    public void create(String sourceDirPath, String zipFilePath) {
        Path p;
        Path pp;
        try {
            p = Files.createFile(Paths.get(zipFilePath));
            pp = Paths.get(sourceDirPath);
            create(pp, p);
        } catch (IOException ex) {
            logger.log(Level.SEVERE, "IOException was thrown", ex);
        }
    }
    
    
    
    /**
     * Tests whether the file denoted by this pathname string is a zip file.
     * 
     * @param pathString
     * @return {@code true} if the given pathname string points to a zip file ; 
     *          otherwise {@code false}
     */
    public static boolean isZipFile(String pathString) {
        // null or blank test
        if (StringUtils.isBlank(pathString)) {
            return false;
        }
        File testFile = new File(pathString);
        
        if (testFile.exists() && !testFile.isDirectory()) {
            try (FileInputStream fis = new FileInputStream(testFile)) {
                return new ZipInputStream(fis).getNextEntry() != null;
            } catch (FileNotFoundException ex ) {
                logger.log(Level.SEVERE, "FileNotFoundException was thrown", ex);
                return false;
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "IOException was thrown", ex);
                return false;
            }
        } else {
            logger.log(Level.INFO, "pathString[{0}] points to a directory",
                    pathString);
            return false;
        }
    }
    
    
    /**
     * Tests whether the specified file is a zip file.
     *
     * @param payloadFile the file to be uploaded to the target dataset.
     * @return {@code true} if the given File is a zip file ; 
     *          otherwise {@code false}
     */
    public static boolean isZipFile(File payloadFile) {
        // null test
        if (payloadFile == null) {
            return false;
        }
        
        if (payloadFile.exists() && !payloadFile.isDirectory()) {
            try (FileInputStream fis = new FileInputStream(payloadFile)) {
                return new ZipInputStream(fis).getNextEntry() != null;
            } catch (FileNotFoundException ex ) {
                logger.log(Level.SEVERE, "FileNotFoundException was thrown", ex);
                return false;
            } catch (IOException ex) {
                logger.log(Level.SEVERE, "IOException was thrown", ex);
                return false;
            }
        } else {
            logger.log(Level.INFO, "File[{0}] a directory; not a zip file",
                    payloadFile);
            return false;
        }
    }
}
