import java.io.PrintStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.Map;
import java.util.Set;

public abstract class MyExtensionPlus extends MyExtension implements Serializable {
	private Map<String, Map<Object, MyExtensionPlus>> links = new Hashtable<>();
	private static Set<MyExtensionPlus> allParts = new HashSet<>();
	
	private void addLink(String roleName, String reverseRoleName, MyExtensionPlus targetObject, Object qualifier, int counter) {
		Map<Object, MyExtensionPlus> objectLinks;
		if(counter < 1) return;

		if(links.containsKey(roleName)) {
			objectLinks = links.get(roleName);
		}
		else {
			objectLinks = new HashMap<>();
			links.put(roleName, objectLinks);
		}
		
		if(!objectLinks.containsKey(qualifier)) {
			objectLinks.put(qualifier, targetObject);
			targetObject.addLink(reverseRoleName, roleName, this, this, counter - 1);
		}
	}
	
	public void addLink(String roleName, String reverseRoleName, MyExtensionPlus targetObject, Object qualifier) {
		addLink(roleName, reverseRoleName, targetObject, qualifier, 2);
	}
	
	public void addLink(String roleName, String reverseRoleName, MyExtensionPlus targetObject) {
		addLink(roleName, reverseRoleName, targetObject, targetObject);
	}
	
	public void addPart(String roleName, String reverseRoleName, MyExtensionPlus partObject) throws Exception {
		if(allParts.contains(partObject)) {
			throw new Exception("The part is already connected to a whole!");
		}
		addLink(roleName, reverseRoleName, partObject);
		allParts.add(partObject);
	}
	
	public MyExtensionPlus[] getLinks(String roleName) throws Exception {
		Map<Object, MyExtensionPlus> objectLinks;
		if(!links.containsKey(roleName)) {
			throw new Exception("No links for the role: " + roleName);
		}
		
		objectLinks = links.get(roleName);
		return (MyExtensionPlus[]) objectLinks.values().toArray(new MyExtensionPlus[0]);
	}
	
	public void showLinks(String roleName, PrintStream stream) throws Exception {
		Map<Object, MyExtensionPlus> objectLinks;
		if(!links.containsKey(roleName)) {
			throw new Exception("No links for the role: " + roleName);
		}
		
		objectLinks = links.get(roleName);
		Collection col = objectLinks.values();
		stream.println(this.getClass().getSimpleName() + " links, role '" + roleName + "':");
		
		for(Object obj : col) {
			stream.println(" " + obj);
		}
	}
	
	public MyExtensionPlus getLinkedObject(String roleName, Object qualifier) throws Exception {
		Map<Object, MyExtensionPlus> objectLinks;
		if(!links.containsKey(roleName)) {
			throw new Exception("No links for the role: " + roleName);
		}
		
		objectLinks = links.get(roleName);
		if(!objectLinks.containsKey(qualifier)) {
			throw new Exception("No link for the qualifer: " + qualifier);
		}
		return objectLinks.get(qualifier);
	}
	
}
