package io.renren.modules.app.generator;

/**
 * @author xiehanying
 */
public class GeneratorFactor {
    public static BaseGenerator factory(String fileType) {
        switch (fileType) {
            case "csv": return new CSVGenerator();
        }
        return null;
    }
}
