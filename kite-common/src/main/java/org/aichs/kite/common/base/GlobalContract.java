package org.aichs.kite.common.base;

/**
 * @ClassName GlobalContract
 * @Deacription 应用内常量类
 * @Author Kite
 * @Date 2019/11/29 15:03
 **/
public class GlobalContract {

    /** MD5 盐值 */
    public static final String MD5_SALT = "903347d5-2dfe-4ead-80af-5515e0b7a184";

    /** AES 干扰码 */
    public static final String AES_KEY = "35c7b69c-97e2-4b7b-8fb1-4338c7413e68";

    /** CMS用户session中的key */
    public static final String SESSION_CMSUSER_KEY = "CMS_USER";

    /** 数据删除标识 未删除 */
    public static final String DEL_FLAG_0 = "0";

    /** 数据删除标识 已删除 */
    public static final String DEL_FLAG_1 = "1";

    /** 文件临时存放路径 */
    public static final String UPLOAD_TEPM_PATH = "\\statics\\";

    /** 文章图片存放路径 */
    public static final String ARTICLE_IMG = "article_img/";

    /** 文章文件存放路径 */
    public static final String ARTICLE_FILE = "article_file/";

    public static final String ARTICLE_VIDEO = "article_video/";

    /** 本机地址自动保存图片路径 */
    public static final String UE_PATHP = "/upload/";
    /** 文章图片存放目录 */
    public static final String LOC_ARTICLE_IMG = "articleimg/";
    /** 文章视频存放目录 */
    public static final String LOC_ARTICLE_VIDEO = "articlevideo/";

}
