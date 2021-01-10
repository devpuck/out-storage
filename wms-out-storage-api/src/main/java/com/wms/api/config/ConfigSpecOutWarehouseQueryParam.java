package com.wms.api.config;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 出库业务配置 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2021-01-10
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "ConfigSpecOutWarehouseQueryParam对象", description = "出库业务配置查询参数")
public class ConfigSpecOutWarehouseQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
