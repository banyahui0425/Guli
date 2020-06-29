package cc.jaya.vo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;

@Data
public class UserVO implements Serializable {
    private String uname;
    private String pawd;
    private Integer age;
    private String email;
    private Boolean isDisabled;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtCreateStart;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtCreateEnd;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtUpdateStart;
    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm:ss")
    private Date gmtUpdateEnd;
}
