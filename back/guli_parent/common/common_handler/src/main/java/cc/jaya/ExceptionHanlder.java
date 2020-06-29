package cc.jaya;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class ExceptionHanlder {

    @ExceptionHandler(Exception.class)
    @ResponseBody
    public RespData error(Exception e) {
        e.printStackTrace();
        return RespData.wrong(0, "执行了全局异常处理..");
    }

}
