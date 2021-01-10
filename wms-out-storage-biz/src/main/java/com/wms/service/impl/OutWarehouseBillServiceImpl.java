package com.wms.service.impl;

import com.wms.model.bo.outstorage.OutWarehouseBillSubBo;
import com.wms.model.entity.OutWarehouseBillSubEntity;
import com.wms.service.OutWarehouseBillSubService;
import com.xac.core.constant.CoreConstant;
import com.wms.model.entity.OutWarehouseBillEntity;
import com.wms.mapper.outstorage.OutWarehouseBillMapper;
import com.wms.service.OutWarehouseBillService;
import com.wms.api.outstorage.OutWarehouseBillQueryParam;
import com.wms.model.bo.outstorage.OutWarehouseBillBo;
import com.xac.core.service.impl.BaseServiceImpl;
import com.xac.core.api.Paging;
import com.xac.core.util.BeanListUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.beans.factory.annotation.Autowired;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;


/**
 * <pre>
 * 出库单据 服务实现类
 * </pre>
 *
 * @author puck
 * @since 2020-12-22
 */
@Slf4j
@Service
public class OutWarehouseBillServiceImpl extends BaseServiceImpl<OutWarehouseBillMapper, OutWarehouseBillEntity> implements OutWarehouseBillService
{

    @Autowired
    private OutWarehouseBillMapper outWarehouseBillMapper;

    @Autowired
    private OutWarehouseBillSubService outWarehouseBillSubService;

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean saveOutWarehouseBill(OutWarehouseBillBo outWarehouseBill)   throws Exception
    {
        boolean result = false;
        String billCode = outWarehouseBill.getBillCode();
        if(null == billCode)
        {
            generateBillCode(outWarehouseBill);
        }

        OutWarehouseBillEntity entity = new OutWarehouseBillEntity();
        BeanUtils.copyProperties(outWarehouseBill, entity);
        result = super.save(entity);
        if(!result)
        {
            return false;
        }

        List<OutWarehouseBillSubBo> outWarehouseBillSubBoList = outWarehouseBill.getOutWarehouseBillSubBoList();
        if(null != outWarehouseBillSubBoList)
        {
            List<OutWarehouseBillSubEntity> outWarehouseBillSubEntityList = new ArrayList<OutWarehouseBillSubEntity>();
            outWarehouseBillSubEntityList = BeanListUtil.copyListProperties(outWarehouseBillSubBoList,OutWarehouseBillSubEntity.class);
            result = outWarehouseBillSubService.saveBatch(outWarehouseBillSubEntityList);
        }
        return result;
    }

    public void generateBillCode(OutWarehouseBillBo outWarehouseBill)
    {
        String billCode = UUID.randomUUID().toString().replaceAll("-", "");
        outWarehouseBill.setBillCode(billCode);
        List<OutWarehouseBillSubBo> outWarehouseBillSubBoList = outWarehouseBill.getOutWarehouseBillSubBoList();
        if(null != outWarehouseBillSubBoList)
        {
            Iterator<OutWarehouseBillSubBo> it = outWarehouseBillSubBoList.iterator();
            while(it.hasNext())
            {
                OutWarehouseBillSubBo outWarehouseBillSubBo = it.next();
                outWarehouseBillSubBo.setBillCode(billCode);
            }
        }
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean updateOutWarehouseBill(OutWarehouseBillBo outWarehouseBill)
    {
        OutWarehouseBillEntity entity = new OutWarehouseBillEntity();
        BeanUtils.copyProperties(outWarehouseBill, entity);
        return super.updateById(entity);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public boolean deleteOutWarehouseBill(Long id)
    {
        return super.removeById(id);
    }

    @Override
    public OutWarehouseBillBo getOutWarehouseBillById(Serializable id)
    {
        return outWarehouseBillMapper.getOutWarehouseBillById(id);
    }

    @Override
    public Paging<OutWarehouseBillBo> getOutWarehouseBillPageList(OutWarehouseBillQueryParam outWarehouseBillQueryParam)
    {
        Page page = setPageParam(outWarehouseBillQueryParam, OrderItem.desc(CoreConstant.CREATED_DATE));
        IPage<OutWarehouseBillBo> iPage = outWarehouseBillMapper.getOutWarehouseBillPageList(page, outWarehouseBillQueryParam);
        return new Paging(iPage);
    }

    @Override
    public String queryOutWarehouseBillIDByRequirementID(String requirementID)
    {
        return outWarehouseBillMapper.queryOutWarehouseBillIDByRequirementID(requirementID);
    }

}
