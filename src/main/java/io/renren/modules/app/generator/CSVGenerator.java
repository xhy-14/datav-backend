package io.renren.modules.app.generator;

import io.renren.common.exception.RRException;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.app.utils.CSVUtils;

/**
 * @author xiehanying
 */
public class CSVGenerator extends BaseGenerator{

    @Override
    public CSVEntity generateTable(Object content) {
        String path = (String) content;

        CSVUtils csvUtils = new CSVUtils();
        CSVEntity csv = csvUtils.getCSVByUrl(path);

        if( csv == null ) {
            throw new RRException("生成数据表失败");
        }

        return csv;
    }
}
