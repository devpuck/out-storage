package com.wms.mapper.outstorage;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.wms.model.entity.OutWarehouseBillEntity;
import com.wms.api.outstorage.OutWarehouseBillQueryParam;
import com.wms.model.bo.outstorage.OutWarehouseBillBo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

/**
 * <pre>
 * 出库单据 Mapper 接口
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Repository
public interface OutWarehouseBillMapper extends BaseMapper<OutWarehouseBillEntity> {

    /**
     * 根据ID获取查询对象
     *
     * @param id
     * @return
     */
    OutWarehouseBillBo getOutWarehouseBillById(Serializable id);

    /**
     * 获取分页对象
     *
     * @param page
     * @param outWarehouseBillQueryParam
     * @return
     */
    IPage<OutWarehouseBillBo> getOutWarehouseBillPageList(@Param("page") Page page, @Param("param") OutWarehouseBillQueryParam outWarehouseBillQueryParam);

}
