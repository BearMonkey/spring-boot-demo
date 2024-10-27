package org.monkey.springbootdemo.domain;

import com.alibaba.fastjson2.JSONObject;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * Blog
 *
 * @author cc
 * @since 2024/10/23 11:10
 */
@EqualsAndHashCode(callSuper = true)
@Data
@TableName("srv_blog")
public class Blog extends BaseEntity {

    @TableId
    private String id;

    private String title;

    private String author;

    private String content;

    private String privateFlag;

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
