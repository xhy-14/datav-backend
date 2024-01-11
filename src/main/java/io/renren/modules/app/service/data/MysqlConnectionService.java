package io.renren.modules.app.service.data;

import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.R;
import io.renren.modules.app.dto.SaveMysqlConnectionDTO;
import io.renren.modules.app.dto.UpdateMysqlConnectionDTO;
import io.renren.modules.table.entity.MysqlConnectionEntity;

import javax.servlet.http.HttpServletRequest;

public interface MysqlConnectionService extends IService<MysqlConnectionEntity> {

    /**
     * 创建数据库连接
     * @param request
     * @param saveMysqlConnectionDTO
     * @return
     */
    R saveMysqlConnection(HttpServletRequest request, SaveMysqlConnectionDTO saveMysqlConnectionDTO);

    R deleteMysqlConnection(HttpServletRequest request, Long mysqlConnectionId);

    R updateMysqlConnection(HttpServletRequest request, UpdateMysqlConnectionDTO updateMysqlConnectionDTO);

    R listMysqlConnection(HttpServletRequest request);
}
