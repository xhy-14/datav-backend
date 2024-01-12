package io.renren.modules.app.generator;

import io.renren.common.exception.RRException;
import io.renren.modules.app.entity.CSVEntity;
import io.renren.modules.app.utils.CSVUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

/**
 * @author xiehanying
 */
public class CSVFileGenerator extends BaseGenerator{

    /**
     * 生成csv数据表
     * @param content
     * @return
     */
    @Override
    public CSVEntity generateTable(Object content) {
        MultipartFile file = (MultipartFile) content;
        try {
            String csv = new String(file.getBytes());
            CSVUtils utils = new CSVUtils();
            CSVEntity csvEntity = utils.stringToCSV(csv);
            return csvEntity;
        } catch (IOException e) {
            throw new RRException("读取文件失败");
        }
    }
}
