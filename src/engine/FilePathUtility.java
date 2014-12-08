package engine;

public class FilePathUtility {
    private final String SLASH = "/";
    //private final String DOT = ".";
    //private final String IMAGES = "images";
    //private String myFolder;
   // private String myRelativePath;
   // private String BASE_ASSET_PATH;
    private String myPath;
    
    public FilePathUtility (String folder, String relativePath) { 
        //myFolder = folder;
        //myRelativePath = relativePath;
        myPath = relativePath+SLASH+folder+SLASH;
    }
    
    public String getFilePath () {
        return myPath;
    }
}
