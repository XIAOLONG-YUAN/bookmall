package com.yuan.bookmall.pojo.scTest;

import java.time.LocalDateTime;
import com.baomidou.mybatisplus.annotation.TableLogic;
import java.io.Serializable;
import java.util.Date;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

/**
 * <p>
 * 
 * </p>
 *
 * @author yxl
 * @since 2020-01-02
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="ScTest对象", description="")
public class ScTest implements Serializable {

    private static final long serialVersionUID=1L;

    private String scId;

    @ApiModelProperty(value = "名称")
    private String scName;

    @ApiModelProperty(value = "操作人")
    private String scOperator;

    @ApiModelProperty(value = "操作时间")
    private Date scOperatorTime;

    @TableLogic
    private String scDelflag;


}
