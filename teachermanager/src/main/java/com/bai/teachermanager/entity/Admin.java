package com.bai.teachermanager.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.bai.teachermanager.utils.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 管理员表
 * </p>
 *
 * @author escoding
 * @since 2020-11-20
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@ApiModel(value="Admin对象", description="管理员表")
public class Admin extends BaseEntity {

    private static final long serialVersionUID=1L;

    @ApiModelProperty(value = "登录密码")
    private String password;

    @ApiModelProperty(value = "真实姓名")
    private String name;

    @ApiModelProperty(value = "性别")
    private Integer sex;

    @ApiModelProperty(value = "职称")
    private String title;

    @ApiModelProperty(value = "联系方式")
    private String telephone;

    @ApiModelProperty(value = "逻辑删除")
    @TableLogic
    private Integer isDeleted;


}
