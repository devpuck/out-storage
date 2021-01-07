package com.wms.mapper.outstorage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.OutWarehouseBillSubEntity;
import com.wms.api.outstorage.OutWarehouseBillSubQueryParam;
import com.wms.model.bo.outstorage.OutWarehouseBillSubBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出库单子表 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-24
 */
@Repository
public interface OutWarehouseBillSubMapper extends BaseMapper<OutWarehouseBillSubEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OutWarehouseBillSubBo getOutWarehouseBillSubById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param outWarehouseBillSubQueryParam
     * @return
     */
    IPage<OutWarehouseBillSubBo> getOutWarehouseBillSubPageList(@Param("page") Page page, @Param("param") OutWarehouseBillSubQueryParam outWarehouseBillSubQueryParam);

}
