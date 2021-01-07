package com.wms.model.bo.outstorage;

import com.xac.core.bo.BaseBo;
import lombok.Data;
import lombok.experimental.Accessors;
import java.io.Serializable;

import java.util.Date;

/**
 * <pre>
 * 出库单据 查询结果业务对象
 * </pre>
 *
 * @author puck
 * @date 2020-12-22
 */
@Data
@Accessors(chain = true)
public class OutWarehouseBillBo extends BaseBo implements Serializable {
    private static final long serialVersionUID = 1L;

    /**
     * 表id
     */
    private Long id;

    /**
     * 需求单ID
     */
    private String requirementId;

    /**
     * 需求来源系统，隐藏字段，页面不展示
     */
    private String systemFrom;

    /**
     * 出库单号
     */
    private String billCode;

    /**
     * 目标编号
     */
    private String targetCode;

    /**
     * 目标类型
     */
    private String targetType;

    /**
     * 出库单类型，对应事务类型
     */
    private String workCode;

    /**
     * 处理类型编号，如合同到货、紧急到货。相当于WORK_CODE的一个补充,对接系统的需要，实际操作只需要配置即可，无需理会，主要用于处理老事务处理不规范情况
     */
    private String dealCode;

    /**
     * 出库人，负责出库单人，非操作员。通常为货物领用人
     */
    private String outPerson;

    /**
     * 出库部门，负出入库货物的部门
     */
    private String outDept;

    /**
     * 库房编号
     */
    private String warehouseCode;

    /**
     * 操作人
     */
    private String outOperator;

    /**
     * 操作人部门
     */
    private String outOperatorDept;

    /**
     * 操作时间
     */
    private Date outOperatorTime;

    /**
     * 出库单状态
     */
    private String status;

    /**
     * 版本
     */
    private String version;

    /**
     * 备注
     */
    private String note;

}
