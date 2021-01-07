package com.wms.api.outstorage;

import io.swagger.annotations.ApiModel;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import com.xac.core.api.SortQueryParam;

/**
 * <pre>
 * 出库单据 查询参数对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = true)
@ApiModel(value = "OutWarehouseBillQueryParam对象", description = "出库单据查询参数")
public class OutWarehouseBillQueryParam extends SortQueryParam {
    private static final long serialVersionUID = 1L;
}
