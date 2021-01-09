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
 * @date 2021-01-09
 */
@Data
@Accessors(chain = true)
public class ConfigOutWarehouseBo extends BaseBo implements Serializable {
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
     * 需要的物料状态，如果有多个请配置多条
     */
    private String needProductionStatus;

    /**
     * 是否需要质检
     */
    private String needQuality;

    /**
     * 配置状态
     */
    private String status;

    /**
     * 配置类型，出库类型比较多，单独配置比较复杂，需要设计一些默认配置。系统默认为system_default,用户创建为user_create
     */
    private String configType;

    /**
     * 版本
     */
    private String version;

}
