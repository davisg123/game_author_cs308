package engine;

/**
 * Sets up the filepath
 * @author Will
 *
 */

public class FilePathUtility {
    private final String SLASH = "/";
    private String myPath;
    
    public FilePathUtility (String folder, String relativePath) { 
        myPath = relativePath+SLASH+folder+SLASH;
    }
    
    public String getFilePath () {
        return myPath;
    }
}
