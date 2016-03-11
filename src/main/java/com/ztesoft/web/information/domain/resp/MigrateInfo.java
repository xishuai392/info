package com.ztesoft.web.information.domain.resp;

/**
 * 迁移信息
 * 
 * @author Ocean
 */
public class MigrateInfo {

    // 迁移信息的div的Style样式：style="display:none;" 或者 style="display:block;"
    private String qyxxDivStyleCSS;

    // 何时何因由何地迁来本市(县)
    private String timeAndResultForMigrateLocal;

    // 何时何因由何地迁来本址
    private String timeAndResultForMigrateNative;

    // 何时何因迁往何地
    private String timeAndResultForMigrateOtherPlace;

    public String getTimeAndResultForMigrateLocal() {
        return timeAndResultForMigrateLocal;
    }

    public void setTimeAndResultForMigrateLocal(
            String timeAndResultForMigrateLocal) {
        this.timeAndResultForMigrateLocal = timeAndResultForMigrateLocal;
    }

    public String getTimeAndResultForMigrateOtherPlace() {
        return timeAndResultForMigrateOtherPlace;
    }

    public void setTimeAndResultForMigrateOtherPlace(
            String timeAndResultForMigrateOtherPlace) {
        this.timeAndResultForMigrateOtherPlace = timeAndResultForMigrateOtherPlace;
    }

    public String getTimeAndResultForMigrateNative() {
        return timeAndResultForMigrateNative;
    }

    public void setTimeAndResultForMigrateNative(
            String timeAndResultForMigrateNative) {
        this.timeAndResultForMigrateNative = timeAndResultForMigrateNative;
    }

    /**
     * @return the qyxxDivStyleCSS
     */
    public String getQyxxDivStyleCSS() {
        return qyxxDivStyleCSS;
    }

    /**
     * @param qyxxDivStyleCSS the qyxxDivStyleCSS to set
     */
    public void setQyxxDivStyleCSS(String qyxxDivStyleCSS) {
        this.qyxxDivStyleCSS = qyxxDivStyleCSS;
    }

}
