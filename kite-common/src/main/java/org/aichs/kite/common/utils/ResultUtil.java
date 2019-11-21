package org.aichs.kite.common.utils;

import org.aichs.kite.common.base.ResultVO;
import org.aichs.kite.common.enums.ResultEnum;

/**
 * @ClassName: ResultUtil
 * @Author: MECHREVO
 * @Description: 接口返回工具
 * @Date: 2019/11/21 22:19
 */
public class ResultUtil {
    
    public static ResultVO success(Object object){
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(true);
        resultVO.setCode(ResultEnum.OK.getCode());
        resultVO.setMsg(ResultEnum.OK.getMsg());
        resultVO.setData(object);
        return resultVO;
    }
    
    public static ResultVO success(){ return success(null); }
    
    public static ResultVO error(ResultEnum resultEnum){
        ResultVO resultVO = new ResultVO();
        resultVO.setSuccess(false);
        resultVO.setCode(resultEnum.getCode());
        resultVO.setMsg(resultEnum.getMsg());
        return 
    }
}
