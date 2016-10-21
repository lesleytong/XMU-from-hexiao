package edu.ustb.sei.mde.xmuxtext.customize.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

import org.eclipse.emf.common.util.EList;
import org.eclipse.emf.ecore.EClassifier;
import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EPackage;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.ecore.EcorePackage;
import org.eclipse.xtext.EcoreUtil2;
import org.eclipse.xtext.naming.QualifiedName;
import org.eclipse.xtext.resource.EObjectDescription;
import org.eclipse.xtext.resource.IEObjectDescription;
import org.eclipse.xtext.scoping.IScope;
import org.eclipse.xtext.scoping.Scopes;
import org.eclipse.xtext.scoping.impl.SimpleScope;

import com.google.common.base.Objects;

import edu.ustb.sei.mde.xmu2.TransformationModel;
import edu.ustb.sei.mde.xmu2.util.Constants;
import edu.ustb.sei.mde.xmuxtext.customize.common.IReferenceResolver;

public class TypeResolver implements IReferenceResolver {

	public TypeResolver() {
		// TODO Auto-generated constructor stub
		initPrimitiveTypes();
	}

	@Override
	public IScope getScope(EObject context, EReference reference) {
		TransformationModel model = (TransformationModel)EcoreUtil2.getRootContainer(context);
		
		ArrayList<IEObjectDescription> objDesc = new ArrayList<IEObjectDescription>();
		
		objDesc.addAll(primitiveTypes);
		
		for(EPackage p : model.getPackages()) {
			objDesc.addAll(collectTypesFromPackage(p.getName(), p));
		}
		
		return new SimpleScope(IScope.NULLSCOPE,objDesc);
	}
	
	protected List<IEObjectDescription> primitiveTypes = new ArrayList<IEObjectDescription>();
	protected void initPrimitiveTypes() {
		
		primitiveTypes.add(EObjectDescription.create(QualifiedName.create(Constants.STRING_NAME), Constants.STRING));
		primitiveTypes.add(EObjectDescription.create(QualifiedName.create(Constants.INTEGER_NAME), Constants.INT));
		primitiveTypes.add(EObjectDescription.create(QualifiedName.create(Constants.BOOLEAN_NAME), Constants.BOOLEAN));
		primitiveTypes.add(EObjectDescription.create(QualifiedName.create(Constants.OCLANY_NAME), Constants.OCLANY));
		primitiveTypes.add(EObjectDescription.create(QualifiedName.create(Constants.RESOURCE_NAME), Constants.RESOURCE));
		primitiveTypes.add(EObjectDescription.create(QualifiedName.create(Constants.OCLOBJECT_NAME), Constants.EOBJECT));
	}
	
	
	private Map<EPackage, List<IEObjectDescription>> typesOfPackage = new HashMap<EPackage, List<IEObjectDescription>>();
	private List<IEObjectDescription> collectTypesFromPackage(String pkgName, EPackage pkg) {
		List<IEObjectDescription> list = typesOfPackage.get(pkg);
		if(list!=null)
			return list;
		else {
			list = new ArrayList<IEObjectDescription>();
			final EList<EClassifier> classifiers = pkg.getEClassifiers();			
			final Function<EClassifier, QualifiedName> func = (EClassifier c) -> {
	            String _shortname = pkgName;
	            String _name = c.getName();
	            return QualifiedName.create(_shortname, _name);
	          };
	          
	          
	        for(EClassifier c : classifiers) {
	        	IEObjectDescription d = EObjectDescription.create(func.apply(c), c);
	        	list.add(d);
	        }
	        
	        for(EPackage s : pkg.getESubpackages()) {
	        	list.addAll(collectTypesFromPackage(pkgName,s));
	        }
	        
	        typesOfPackage.put(pkg, list);
	        return list;
	        
		}
	}
}
