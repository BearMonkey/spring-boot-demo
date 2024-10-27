package org.monkey.springbootdemo.domain;

import com.alibaba.fastjson2.JSON;
import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.LocalDateTime;

/**
 * User
 *
 * @author cc
 * @since 2024/10/14 14:49
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("usr_user")
public class User extends BaseEntity {

    private Integer id;

    private String username;

    private String password;

    private String name;

    private LocalDateTime birth;

    private String gender;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
