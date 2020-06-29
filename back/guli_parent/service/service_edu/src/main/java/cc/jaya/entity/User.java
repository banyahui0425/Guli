package cc.jaya.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;
import lombok.experimental.Accessors;

import java.util.Date;

@Data
@Accessors(chain = true)
public class User {
    @TableId(type = IdType.ID_WORKER)
    private Long id;
    private String uname;
    private String pawd;
    private Integer age;
    private String email;
    private Integer version;
    private Boolean isDisabled;
    @TableLogic
    private Boolean isDeleted;
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;
    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtUpdate;
}
