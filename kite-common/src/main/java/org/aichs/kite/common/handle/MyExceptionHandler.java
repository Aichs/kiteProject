package org.aichs.kite.common.handle;

import org.aichs.kite.common.base.ResultVO;
import org.springframework.validation.BindException;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: MyExceptionHandler
 * @Author: MECHREVO
 * @Description: 全局异常处理
 * @Date: 2019/11/21 22:08
 */
@RestControllerAdvice
public class MyExceptionHandler {
    
    public ResultVO bindExceptionGetHandler(BindException execution){
        List<String> resultMsg = new ArrayList<>();
        execution.getBindingResult().getAllErrors().forEach(x  -> resultMsg.add(x.getDefaultMessage()));
        return ResultUtil.errorParam(CollUtil.join(resultMsg,","));
    }
}
