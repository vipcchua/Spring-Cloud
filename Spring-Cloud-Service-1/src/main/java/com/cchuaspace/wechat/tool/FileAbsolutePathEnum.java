package com.cchuaspace.wechat.tool;
/**
 */
public enum FileAbsolutePathEnum{
	/** 图片*/
	IMAGE_PATH("image_path"),
	/** 头像，缩略图*/
	ICON_PATH("icon_path"),
	/** 资源 */
	RESOURCE_PATH("resource_path"),
	/** cache_address */
	CACHE_ADDRESS("cache_address"),
	/** uploadfile_path */
	UPLOADFILE_PATH("uploadfile_path"),
	/**faceImage**/
	FACEIMAGE_PATH("faceImage_path"),
	/**shaerImage**/
	SHAREIMAGE_PATH("shareImage_path"),
	/**图片的网络路径**/
	HTTP_PATH("http_path");
	 
	
	private String value;
	private FileAbsolutePathEnum(String value) {
		this.value = value;
	}
	public String getValue(){
		return this.value;
	}
}
