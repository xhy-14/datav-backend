package io.renren.modules.app.service;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.TableDto;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.table.entity.MetadataEntity;

public interface TableService extends IService<MetadataEntity> {
    /**
     * 根据id获取table
     * @param id
     * @return
     */
    R getTableByID(Long id);

    /**
     * 获取数据表
     * @param id
     * @return
     */
    R getTableDataByID(Long id);

    /**
     * 获取数据表信息
     * @param id
     * @return
     */
    MetadataEntity getTableInfoByID(Long id);

    /**
     * 根据excel文件生成csv表格
     * @param id
     * @return
     */
    boolean generateTableByExcel(Long id);

    /**
     * 根据url生成表
     * @param id
     * @return
     */
    R generateTableByFile(Long id);

    /**
     * 保存表
     * @param tableDto
     * @return
     */
    R saveTable(TableDto tableDto);
}
