package io.renren.modules.app.utils.parase;

import com.alibaba.fastjson.JSON;
import com.github.abel533.echarts.Option;
import com.github.abel533.echarts.Title;

public class Test {
    private static String json = "{\n" +
            "  title: {\n" +
            "    text: 'Referer of a Website',\n" +
            "    subtext: 'Fake Data',\n" +
            "    left: 'center'\n" +
            "  },\n" +
            "  tooltip: {\n" +
            "    trigger: 'item'\n" +
            "  },\n" +
            "  legend: {\n" +
            "    orient: 'vertical',\n" +
            "    left: 'left'\n" +
            "  },\n" +
            "  series: [\n" +
            "    {\n" +
            "      name: 'Access From',\n" +
            "      type: 'pie',\n" +
            "      radius: '50%',\n" +
            "      data: [\n" +
            "        { value: 1048, name: 'Search Engine' },\n" +
            "        { value: 735, name: 'Direct' },\n" +
            "        { value: 580, name: 'Email' },\n" +
            "        { value: 484, name: 'Union Ads' },\n" +
            "        { value: 300, name: 'Video Ads' }\n" +
            "      ],\n" +
            "      emphasis: {\n" +
            "        itemStyle: {\n" +
            "          shadowBlur: 10,\n" +
            "          shadowOffsetX: 0,\n" +
            "          shadowColor: 'rgba(0, 0, 0, 0.5)'\n" +
            "        }\n" +
            "      }\n" +
            "    }\n" +
            "  ]\n" +
            "}";


    public static void main(String[] args) {
        Option option = JSON.parseObject(json, Option.class);
        System.out.println(JSON.toJSON(option));
        Title title = new Title();
        title.setBackgroundColor("#ccccc");
    }
}
