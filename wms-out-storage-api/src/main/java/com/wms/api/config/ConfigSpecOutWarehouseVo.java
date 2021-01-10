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
 * @date 2021-01-10
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "ConfigSpecOutWarehouseVo对象", description = "出库业务配置查询参数")
public class ConfigSpecOutWarehouseVo extends BaseVo implements Serializable {
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

    @ApiModelProperty(value = "物料编码")
    private String productionCode;

    @ApiModelProperty(value = "至少需要库存状态级别")
    private String needProductionStatusLevel;

    @ApiModelProperty(value = "是否需要质检")
    private String needQuality;

    @ApiModelProperty(value = "配置状态")
    private String status;

    @ApiModelProperty(value = "版本")
    private String version;

}
