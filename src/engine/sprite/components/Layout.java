//Class is Deprecated
package engine.sprite.components;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.ResourceBundle;
import java.util.Set;

import engine.sprite.components.properties.IProperty;


/**
 * Contains Image of Sprite, its location, will be grouped with Physics body to be rendered.
 * @author ArihantJain
 * 
 * This Class holds Layout Information for Sprite;
 *
 */
@Deprecated 
public class Layout extends SpriteComponent{

	protected HashMap<String,Double> myPropertiesMap;
    private final String resources = "resources/";
    Properties defaultProps = new Properties();
    
	
	
	 public void constructPropertiesMap (String comp) {
	        Map<String, Double> propertiesMap = new HashMap<String, Double>();
	        ResourceBundle properties = ResourceBundle.getBundle(resources + comp);
	       try{
	        FileInputStream in = new FileInputStream(properties.toString());
	        defaultProps.load(in);
	        in.close();
	       }
	       catch (FileNotFoundException e){
	       }
	       catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	       }
		
	        Enumeration<String> enumerator = properties.getKeys();
	        
	        while (enumerator.hasMoreElements()) {
	        	String prop = enumerator.nextElement();
	            propertiesMap.put(prop, Double.parseDouble(defaultProps.getProperty(prop)));
	            
	        }
	       
	    }
	

    @Override
    public void addProperty(IProperty property) {
        // TODO Auto-generated method stub

    }


    @Override
    public void update() {
        // TODO Auto-generated method stub

    }


    @Override
    public void removeProperty (IProperty property) {
        // TODO Auto-generated method stub
        
    }


}