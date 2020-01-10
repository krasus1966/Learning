package top.krasus1966.mybatisplustest.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.time.LocalDateTime;
@Data
@TableName("mp_user")
public class User {

    //主键
    @TableId
    private Long userId;
    //姓名
    @TableField("name")
    private String realName;
    //年龄
    @TableField(condition = SqlCondition.LIKE)
    private Integer age;
    //邮箱
    private String email;
    //直属上级
    private Long managerId;
    //创建时间
    private LocalDateTime createTime;

    //修改时间
    private LocalDateTime updateTime;
    /**
     * 不插入数据库的三种方法
     * 1.transient
     * 2.转为静态方法
     * 3.@TableField(exist = false)
     */
    //备注 不加入数据库
    @TableField(exist = false)
    private String remark;


    //版本
    private Integer version;
    //逻辑删除标识（0.未删除，1.已删除)
    @TableLogic
    //查询时不显示
    @TableField(select = false)
    private Integer deleted;
//    public User(Long userId, String realName, Integer age, String email, Long managerId, LocalDateTime createTime, String remark) {
//        this.userId = userId;
//        this.realName = realName;
//        this.age = age;
//        this.email = email;
//        this.managerId = managerId;
//        this.createTime = createTime;
//        this.remark = remark;
//    }
}
