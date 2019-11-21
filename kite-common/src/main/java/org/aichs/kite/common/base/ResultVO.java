package org.aichs.kite.common.base;

import lombok.Data;

/**
 * @ProjectName: kite
 * @Package: org.aichs.kite.common.base
 * @ClassName: ResultVO
 * @Author: MECHREVO
 * @Description: Http请求返回的最外层对象
 * @Date: 2019/11/21 11:19
 */
@Data
public class ResultVO {
    
    private Integer code;
    private String msg;
    private Object data;
    private Boolean success;
}
