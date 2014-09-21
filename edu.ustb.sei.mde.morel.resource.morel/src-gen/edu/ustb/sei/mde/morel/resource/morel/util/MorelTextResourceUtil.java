/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.morel.resource.morel.util;

/**
 * Class MorelTextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.
 */
public class MorelTextResourceUtil {
	
	/**
	 * Use edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource getResource(org.eclipse.core.resources.IFile file) {
		return new edu.ustb.sei.mde.morel.resource.morel.util.MorelEclipseProxy().getResource(file);
	}
	
	/**
	 * Use edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource getResource(java.io.File file, java.util.Map<?,?> options) {
		return edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource getResource(org.eclipse.emf.common.util.URI uri) {
		return edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResource(uri);
	}
	
	/**
	 * Use edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.morel.resource.morel.mopp.MorelResource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return edu.ustb.sei.mde.morel.resource.morel.util.MorelResourceUtil.getResource(uri, options);
	}
	
}
