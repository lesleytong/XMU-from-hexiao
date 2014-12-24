/**
 */
package edu.ustb.sei.mde.emg.library;

import java.util.List;
import java.util.Map.Entry;

import org.eclipse.emf.ecore.EObject;

import edu.ustb.sei.mde.emg.runtime.Context;
import edu.ustb.sei.mde.morel.Executable;

public interface IModuleProvider  {
	
	Executable find(String name);

	Object execute(String name, Object... parameters);
	
	void pushParentContext(Context context);
	
	Context popParentContext();

}
