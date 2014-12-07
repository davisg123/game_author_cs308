package engine.gameObject;

/**
 * Interface allows an Object to be set to an Enabled or Disabled State
 * Also gets the ID of the Object.
 * @author Will
 *
 */

public interface IEnabled {
    public void enable ();
    
    public void disable ();
    
    public boolean isEnabled ();
    
}
