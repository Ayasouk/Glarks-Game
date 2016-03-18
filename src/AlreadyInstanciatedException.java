/**
 * 
 */

/**
 * @author oukache
 * this class allows methods to throw an exception when 
 * a user try to instantiate a second object of a class which use
 * the singleton pattern
 * @see Exception
 */
public class AlreadyInstanciatedException extends Exception {
	private static final long serialVersionUID = 1L;
	
	private String name_class;
	
	public AlreadyInstanciatedException(String name_class){
		this.name_class = name_class; 
	}
	
	public String toString(){
		return "class error : you try to instanciated singleton class ("+ this.name_class+")";
	}
}
