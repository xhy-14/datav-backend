package io.renren.modules.app.generator;

import com.fasterxml.jackson.databind.ser.Serializers;
import io.renren.common.exception.RRException;
import io.renren.modules.app.entity.CSVEntity;
import net.bytebuddy.implementation.bytecode.Throw;
import org.apache.poi.ss.usermodel.*;
import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author xiehanying
 */
public class ExcelGenerator extends BaseGenerator {

    @Override
    public CSVEntity generateTable(Object obj) {
        MultipartFile file = (MultipartFile) obj;
        Resource resource = file.getResource();
        try {
            InputStream inputStream = resource.getInputStream();
            Workbook workbook = WorkbookFactory.create(inputStream);
            // 获取第一个sheet
            Sheet sheet = workbook.getSheetAt(0);

            // 读取header
            CSVEntity csvEntity = new CSVEntity();
            List<Object> headers = new ArrayList<>();
            Row headersRow = sheet.getRow(0);
            for(Cell cell: headersRow) {
               headers.add(getCellData(cell));
            }

            List<Map<Object, Object>> data = new ArrayList<>();

            // 读取数据
            for(int i=1; i<sheet.getPhysicalNumberOfRows(); i++) {
                Row row = sheet.getRow(i);
                Map<Object, Object> map = new HashMap<>();
                int j=0;
                for(Cell cell: row) {
                    map.put(headers.get(j), getCellData(cell));
                    j++;
                }

                data.add(map);
            }
            csvEntity.setRows(data);
            csvEntity.setHeaders(headers);
            return csvEntity;
        } catch (IOException e) {
            e.printStackTrace();
            throw new RRException("打开文件失败");
        }
    }

    public Object getCellData(Cell cell) {
        if(cell.getCellType() == CellType.STRING) {
            return cell.getStringCellValue();
        } else if (cell.getCellType() == CellType.NUMERIC) {
            return cell.getNumericCellValue();
        } else if (cell.getCellType() == CellType.BOOLEAN) {
            return cell.getBooleanCellValue();
        } else if (cell.getCellType() == CellType.BLANK) {
            return "";
        } else {
            throw new RRException("读取excel文件失败");
        }
    }
}
