/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu.resource.xmu.util;

/**
 * Class XmuTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.
 */
public class XmuTextResourceUtil {
	
	/**
	 * Use edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource getResource(org.eclipse.core.resources.IFile file) {
		return new edu.ustb.sei.mde.xmu.resource.xmu.util.XmuEclipseProxy().getResource(file);
	}
	
	/**
	 * Use edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource getResource(org.eclipse.emf.common.util.URI uri) {
		return edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResource(uri);
	}
	
	/**
	 * Use edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu.resource.xmu.mopp.XmuResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return edu.ustb.sei.mde.xmu.resource.xmu.util.XmuResourceUtil.getResource(uri, options);
	}
	
}
