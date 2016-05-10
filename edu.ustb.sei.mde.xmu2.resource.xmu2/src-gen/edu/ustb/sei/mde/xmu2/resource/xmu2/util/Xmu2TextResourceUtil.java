/**
 * <copyright>
 * </copyright>
 *
 * 
 */
package edu.ustb.sei.mde.xmu2.resource.xmu2.util;

/**
 * Class Xmu2TextResourceUtil can be used to perform common tasks on text
 * resources, such as loading and saving resources, as well as, checking them for
 * errors. This class is deprecated and has been replaced by
 * edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.
 */
public class Xmu2TextResourceUtil {
	
	/**
	 * Use edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource getResource(org.eclipse.core.resources.IFile file) {
		return new edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2EclipseProxy().getResource(file);
	}
	
	/**
	 * Use edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource getResource(java.io.File file, java.util.Map<?,?> options) {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResource(file, options);
	}
	
	/**
	 * Use edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource getResource(org.eclipse.emf.common.util.URI uri) {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResource(uri);
	}
	
	/**
	 * Use edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResource()
	 * instead.
	 */
	@Deprecated	
	public static edu.ustb.sei.mde.xmu2.resource.xmu2.mopp.Xmu2Resource getResource(org.eclipse.emf.common.util.URI uri, java.util.Map<?,?> options) {
		return edu.ustb.sei.mde.xmu2.resource.xmu2.util.Xmu2ResourceUtil.getResource(uri, options);
	}
	
}
