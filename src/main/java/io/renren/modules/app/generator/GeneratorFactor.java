package io.renren.modules.app.generator;

import io.renren.common.exception.RRException;

/**
 * @author xiehanying
 */
public class GeneratorFactor {
    public static BaseGenerator factory(String fileType) {
        switch (fileType) {
            case "csv": return new CSVGenerator();
            case "text/csv": return new CSVFileGenerator();
            default: {
                throw new RRException("目前还不支持该文件接口");
            }
        }
    }
}
