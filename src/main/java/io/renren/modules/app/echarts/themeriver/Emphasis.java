package io.renren.modules.app.echarts.themeriver;

public class Emphasis {

    private ItemStyle itemStyle;

    class ItemStyle {
        private Integer shadowBlur;

        private String shadowColor;

        public ItemStyle() {
            this.shadowBlur = 20;
            this.shadowColor = "rgba(0, 0, 0, 0.8)";
        }

        public Integer getShadowBlur() {
            return shadowBlur;
        }

        public void setShadowBlur(Integer shadowBlur) {
            this.shadowBlur = shadowBlur;
        }

        public String getShadowColor() {
            return shadowColor;
        }

        public void setShadowColor(String shadowColor) {
            this.shadowColor = shadowColor;
        }
    }

    public Emphasis() {
        this.itemStyle = new ItemStyle();
    }

    public ItemStyle getItemStyle() {
        return itemStyle;
    }

    public void setItemStyle(ItemStyle itemStyle) {
        this.itemStyle = itemStyle;
    }
}
