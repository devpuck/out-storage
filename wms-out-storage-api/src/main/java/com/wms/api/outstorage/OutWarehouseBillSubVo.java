package com.wms.api.outstorage;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import com.xac.core.vo.BaseVo;
import lombok.Data;
import lombok.experimental.Accessors;

import java.io.Serializable;

import java.math.BigDecimal;
import java.util.Date;

/**
 * <pre>
 * 出库单子表 查询结果对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-24
 */
@Data
@Accessors(chain = true)
@ApiModel(value = "OutWarehouseBillSubVo对象", description = "出库单子表查询参数")
public class OutWarehouseBillSubVo extends BaseVo implements Serializable
{
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "表id")
    private Long id;

    private String billCode;

    @ApiModelProperty(value = "需求单子表ID")
    private String requirementSubId;

    @ApiModelProperty(value = "派工号，FO执行序列号")
    private String dispatchCode;

    @ApiModelProperty(value = "合同子号")
    private String contractSubCode;

    @ApiModelProperty(value = "产品编码")
    private String productionCode;

    @ApiModelProperty(value = "产品类型")
    private String productionType;

    @ApiModelProperty(value = "库位号")
    private String warehouseLocationCode;

    @ApiModelProperty(value = "是否为父件，0父件、1子件、2非父子件")
    private String isParent;

    @ApiModelProperty(value = "物料制造处理状态，produce 在制品，clout 余料，waste废料")
    private String produceStatus;

    @ApiModelProperty(value = "父产品编码")
    private String parentProductionCode;

    @ApiModelProperty(value = "项目编码")
    private String projectCode;

    @ApiModelProperty(value = "牌号")
    private String brand;

    @ApiModelProperty(value = "规格")
    private String specifications;

    @ApiModelProperty(value = "状态/级别/型号")
    private String productionLevel;

    @ApiModelProperty(value = "项目编码")
    private String technicalConditions;

    @ApiModelProperty(value = "附加技术条件")
    private String additionalTechnicalConditions;

    @ApiModelProperty(value = "图号")
    private String drawCode;

    @ApiModelProperty(value = "三期代码")
    private String threePeriodCode;

    @ApiModelProperty(value = "生产日期")
    private Date manufactureDate;

    @ApiModelProperty(value = "过期日期")
    private Date expirationDate;

    @ApiModelProperty(value = "批次号")
    private String batch;

    @ApiModelProperty(value = "炉批号或小号")
    private String splysotCode;

    @ApiModelProperty(value = "机型")
    private String aircraftCode;

    @ApiModelProperty(value = "架次")
    private String sortieCode;

    @ApiModelProperty(value = "版号")
    private String modelCode;

    @ApiModelProperty(value = "构型号")
    private String constructionCode;

    @ApiModelProperty(value = "质量编号")
    private String qualityCode;

    @ApiModelProperty(value = "质检状态")
    private String qualityStatus;

    @ApiModelProperty(value = "状态")
    private String status;

    @ApiModelProperty(value = "合格证号")
    private String certificateNo;

    @ApiModelProperty(value = "供方合格证号")
    private String supplyCertificateNo;

    @ApiModelProperty(value = "数量")
    private BigDecimal quantity;

    @ApiModelProperty(value = "试料数量")
    private BigDecimal tryQuantity;

    @ApiModelProperty(value = "已经出库数量")
    private BigDecimal alreadyOutQuantity;

    @ApiModelProperty(value = "主单位")
    private String unit;

    @ApiModelProperty(value = "接收人")
    private String receiverSysUser;

    @ApiModelProperty(value = "接收部门")
    private String receiverHrDept;

    private String isConsignment;

    @ApiModelProperty(value = "备注")
    private String details;

    private String attribute1;

    private String attribute2;

    private String attribute3;

    private String attribute4;

    private String attribute5;

    private String attribute6;

    private String attribute7;

    private String attribute8;

    private String attribute9;

    private String attribute10;

    private String version;

}
