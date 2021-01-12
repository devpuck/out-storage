package com.wms.model.bo.config;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出库业务配置 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2021-01-11
 */
@Data
@Accessors(chain = true)
public class ConfigSpecOutWarehouseBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
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
