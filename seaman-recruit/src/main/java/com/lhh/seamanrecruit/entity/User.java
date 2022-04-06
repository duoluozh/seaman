package com.lhh.seamanrecruit.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


/**
 * @Author: yslong
 * @Date: 2022/3/14 13:59
 * @Description: 测试实体类
 */

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("user")
public class User {

    @TableId
    private Long id;
    private String userName;
    private String password;
    private String email;
    private Integer userType;
    private LocalDateTime createdTime;
    private LocalDateTime updatedTime;

}
