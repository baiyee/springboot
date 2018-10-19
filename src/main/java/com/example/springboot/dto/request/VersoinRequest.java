package com.example.springboot.dto.request;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * <p>
 *     版本记录请求类
 * </p>
 *
 * @author ZhangXuan
 * @since 2018/9/10 13:58
 */
public class VersoinRequest {

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    /**
     * 版本号
     */
    private String versoin;
    /**
     * 币种版本号
     */
    private String coinTypeVersion;
    /**
     * Android 或者 iOS
     */
    @NotNull(message = "手机系统不能为空")
    private @Valid String system;
    /**
     * '1 强制升级 0 不强制升级'
     */
    private Integer isforce;
    /**
     * 跳转地址
     */
    private String url;
    /**
     * 安装包大小
     */
    private String packageSize;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 升级URL
     */
    private String updateUrl;
    /**
     * 版本升级表
     */
    private String description;
    /**
     * 内容信息
     */
    private String content;

    /**
     * 国际化语言标识：en_US 英文;zh_CN 中文
     */
    private String locale;

    private Integer pageNumber;

    private Integer pageSize;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getVersoin() {
        return versoin;
    }

    public void setVersoin(String versoin) {
        this.versoin = versoin;
    }

    public String getCoinTypeVersion() {
        return coinTypeVersion;
    }

    public void setCoinTypeVersion(String coinTypeVersion) {
        this.coinTypeVersion = coinTypeVersion;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public Integer getIsforce() {
        return isforce;
    }

    public void setIsforce(Integer isforce) {
        this.isforce = isforce;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getPackageSize() {
        return packageSize;
    }

    public void setPackageSize(String packageSize) {
        this.packageSize = packageSize;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUrl() {
        return updateUrl;
    }

    public void setUpdateUrl(String updateUrl) {
        this.updateUrl = updateUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public Integer getPageNumber() {
        return pageNumber;
    }

    public void setPageNumber(Integer pageNumber) {
        this.pageNumber = pageNumber;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
}
