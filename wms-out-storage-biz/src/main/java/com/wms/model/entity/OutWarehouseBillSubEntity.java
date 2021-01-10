package com.wms.model.entity;

import java.math.BigDecimal;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import java.util.Date;
import com.xac.core.entity.BaseEntity;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * <pre>
 * 出库单子表
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("WMS_OUT_WAREHOUSE_BILL_SUB")
public class OutWarehouseBillSubEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    private String billCode;

    /**
     * 需求单子表ID
     */
    private String requirementSubId;

    /**
     * 派工号，FO执行序列号
     */
    private String dispatchCode;

    /**
     * 合同子号
     */
    private String contractSubCode;

    /**
     * 产品编码
     */
    private String productionCode;

    /**
     * 产品类型
     */
    private String productionType;

    /**
     * 库位号
     */
    private String warehouseLocationCode;

    /**
     * 是否为父件，0父件、1子件、2非父子件
     */
    private String isParent;

    /**
     * 物料制造处理状态，produce 在制品，clout 余料，waste废料
     */
    private String produceStatus;

    /**
     * 父产品编码
     */
    private String parentProductionCode;

    /**
     * 项目编码
     */
    private String projectCode;

    /**
     * 牌号
     */
    private String brand;

    /**
     * 规格
     */
    private String specifications;

    /**
     * 状态/级别/型号
     */
    private String productionLevel;

    /**
     * 项目编码
     */
    private String technicalConditions;

    /**
     * 附加技术条件
     */
    private String additionalTechnicalConditions;

    /**
     * 图号
     */
    private String drawCode;

    /**
     * 三期代码
     */
    private String threePeriodCode;

    /**
     * 生产日期
     */
    private Date manufactureDate;

    /**
     * 过期日期
     */
    private Date expirationDate;

    /**
     * 批次号
     */
    private String batch;

    /**
     * 炉批号或小号
     */
    private String splysotCode;

    /**
     * 机型
     */
    private String aircraftCode;

    /**
     * 架次
     */
    private String sortieCode;

    /**
     * 版号
     */
    private String modelCode;

    /**
     * 构型号
     */
    private String constructionCode;

    /**
     * 质量编号
     */
    private String qualityCode;

    /**
     * 质检状态
     */
    private String qualityStatus;

    /**
     * 状态
     */
    private String status;

    /**
     * 合格证号
     */
    private String certificateNo;

    /**
     * 供方合格证号
     */
    private String supplyCertificateNo;

    /**
     * 数量
     */
    private BigDecimal quantity;

    /**
     * 试料数量
     */
    private BigDecimal tryQuantity;

    /**
     * 已经出库数量
     */
    private BigDecimal alreadyOutQuantity;

    /**
     * 主单位
     */
    private String unit;

    /**
     * 接收人
     */
    private String receiverSysUser;

    /**
     * 接收部门
     */
    private String receiverHrDept;

    private String isConsignment;

    /**
     * 备注
     */
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
