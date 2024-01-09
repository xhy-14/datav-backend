package io.renren.modules.app.generator;

import io.renren.modules.app.entity.CSVEntity;

import java.io.File;

/**
 * @author xiehanying
 */
public class ExcelGenerator{
    public static CSVEntity generateTable(String path) {
        File temp = new File("./temp");
        boolean mkdir = temp.mkdir();
        System.out.println(mkdir);
        return null;
    }
}
