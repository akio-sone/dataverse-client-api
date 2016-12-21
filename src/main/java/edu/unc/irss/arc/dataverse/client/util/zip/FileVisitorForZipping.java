package edu.unc.irss.arc.dataverse.client.util.zip;

import java.io.IOException;
import java.net.URI;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * An auxiliary class for FileZipper Class. Based on NIO2 API.
 * 
 * @author asone
 */
public class FileVisitorForZipping extends SimpleFileVisitor<Path> {

    private static final Logger logger = 
            Logger.getLogger(FileVisitorForZipping.class.getName());
    
    FileSystem zipFileSystem ;
    String baseDirectory;
    Path basePath;

    /**
     *
     * @param zipFile
     * @param baseDir
     * @throws IOException
     */
    public FileVisitorForZipping(String zipFile, String baseDir) throws IOException {
        Map<String, String> env = new HashMap<>(); 
        env.put("create", "true");
        URI uri = URI.create("jar:file:"+Paths.get(zipFile).toUri().getPath());
        
        this.zipFileSystem = FileSystems.newFileSystem(uri, env);
        this.baseDirectory = baseDir;
        this.basePath = Paths.get(baseDir);
    }

    /**
     *
     * @param zipFileSystem
     * @param basePath
     */
    public FileVisitorForZipping(FileSystem zipFileSystem, Path basePath) {
        this.zipFileSystem = zipFileSystem;
        this.basePath = basePath;
    }
    
    
    
    @Override
    public FileVisitResult visitFile(Path file,
            BasicFileAttributes attrs) throws IOException {
        
        
        logger.log(Level.INFO, "file={0}", file.toString());

        Path dirBase = basePath.relativize(file);
        logger.log(Level.INFO, "dirBase={0}", dirBase.toString());
        String tmp = dirBase.toString();
        if (dirBase.toString().equals("")) {
            tmp = "/";
        }
        Path dest = zipFileSystem.getPath(tmp);
        // dest = zipFileSystem.getPath(root.toString(), file.toString());
        Files.copy(file, dest, StandardCopyOption.REPLACE_EXISTING);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs)
            throws IOException {
        logger.log(Level.INFO, "dir={0}", dir.toString());
        // final Path dirToCreate = zipFileSystem.getPath(root.toString(), dir.toString());
        Path dirBase = basePath.relativize(dir);
        logger.log(Level.INFO, "dirBase={0}", dirBase.toString());
        String tmp = dirBase.toString();
        if (dirBase.toString().equals("")) {
            tmp = "/";
        }
        Path dirToCreate = zipFileSystem.getPath(tmp);

        logger.log(Level.INFO, "dirToCreate={0}", dirToCreate.toString());
        if (Files.notExists(dirToCreate)) {
            logger.log(Level.INFO, "Creating directory={0}", dirToCreate);
            Files.createDirectories(dirToCreate);
        } else {
            logger.log(Level.INFO, "dirToCreate exists={0}", dirToCreate.toString());
        }
        return FileVisitResult.CONTINUE;
    }

}
