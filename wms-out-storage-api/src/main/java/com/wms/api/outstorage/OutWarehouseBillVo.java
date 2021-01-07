package com.wms.api.outstorage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出库单据 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OutWarehouseBillVo对象", description = "出库单据查询参数")
public class OutWarehouseBillVo extends BaseVo implements Serializable {
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    @ApiModelProperty(value = "需求单ID")
    private String requirementId;

    @ApiModelProperty(value = "需求来源系统，隐藏字段，页面不展示")
    private String systemFrom;

    @ApiModelProperty(value = "出库单号")
    private String billCode;

    @ApiModelProperty(value = "目标编号")
    private String targetCode;

    @ApiModelProperty(value = "目标类型")
    private String targetType;

    @ApiModelProperty(value = "出库单类型，对应事务类型")
    private String workCode;

    @ApiModelProperty(value = "处理类型编号，如合同到货、紧急到货。相当于WORK_CODE的一个补充,对接系统的需要，实际操作只需要配置即可，无需理会，主要用于处理老事务处理不规范情况")
    private String dealCode;

    @ApiModelProperty(value = "出库人，负责出库单人，非操作员。通常为货物领用人")
    private String outPerson;

    @ApiModelProperty(value = "出库部门，负出入库货物的部门")
    private String outDept;

    @ApiModelProperty(value = "库房编号")
    private String warehouseCode;

    @ApiModelProperty(value = "操作人")
    private String outOperator;

    @ApiModelProperty(value = "操作人部门")
    private String outOperatorDept;

    @ApiModelProperty(value = "操作时间")
    private Date outOperatorTime;

    @ApiModelProperty(value = "出库单状态")
    private String status;

    @ApiModelProperty(value = "版本")
    private String version;

    @ApiModelProperty(value = "备注")
    private String note;

}
