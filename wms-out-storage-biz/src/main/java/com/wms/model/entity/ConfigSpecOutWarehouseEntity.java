package com.wms.model.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
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
 * 出库业务配置
 * </pre>
 *
 * @author puck
 * @since 2021-01-10
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@TableName("CONFIG_SPEC_OUT_WAREHOUSE")
public class ConfigSpecOutWarehouseEntity extends BaseEntity {

    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 配置编号
     */
    private String configCode;

    /**
     * 库房编码
     */
    private String warehouseCode;

    /**
     * 处理事务编号
     */
    private String warehouseWorkCode;

    /**
     * 处理流程编号
     */
    private String warehouseDealCode;

    /**
     * 物料编码
     */
    private String productionCode;

    /**
     * 至少需要库存状态级别
     */
    private String needProductionStatusLevel;

    /**
     * 是否需要质检
     */
    private String needQuality;

    /**
     * 配置状态
     */
    private String status;

    /**
     * 版本
     */
    private String version;

}
