package com.wms.api.config;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出库业务配置 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2021-01-09
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ConfigOutWarehouseVo对象", description = "出库业务配置查询参数")
public class ConfigOutWarehouseVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "配置编号")
    private String configCode;

    @ApiModelProperty(value = "库房编码")
    private String warehouseCode;

    @ApiModelProperty(value = "处理事务编号")
    private String warehouseWorkCode;

    @ApiModelProperty(value = "处理流程编号")
    private String warehouseDealCode;

    @ApiModelProperty(value = "需要的物料状态，如果有多个请配置多条")
    private String needProductionStatus;

    @ApiModelProperty(value = "是否需要质检")
    private String needQuality;

    @ApiModelProperty(value = "配置状态")
    private String status;

    @ApiModelProperty(value = "配置类型，出库类型比较多，单独配置比较复杂，需要设计一些默认配置。系统默认为system_default,用户创建为user_create")
    private String configType;

    @ApiModelProperty(value = "版本")
    private String version;

}
