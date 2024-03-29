package io.renren.modules.app.generator;

import io.renren.modules.app.entity.CSVEntity;

/**
 * @author xiehanying
 */
public abstract class BaseGenerator {
    /**
     * 文件路径生成csv
     * @param obj
     * @return
     */
    public abstract CSVEntity generateTable(Object obj);
}
