package com.zx.springboot.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 
 * </p>
 *
 * @author sea123
 * @since 2018-05-28
 */
@TableName("tb_versoin")
public class Version extends Model<Version> {

    private static final long serialVersionUID = 1L;

    /**
     * 自增ID
     */
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
    private String system;
    
    private Integer isforce;
    /**
     * 版本升级表
     */
    private String description;
    /**
     * 跳转地址
     */
    private String url;
    /**
     * 内容信息
     */
    private String content;
    /**
     * 更新时间
     */
    private Date updateDate;
    /**
     * 安装包大小
     */
    private String packageSize;
    
    /**
     * WEB更新路径
     */
    private String updateUrl;

    public Long getId() {
        return id;
    }

    public Version setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUpdateUrl() {
		return updateUrl;
	}

	public void setUpdateUrl(String updateUrl) {
		this.updateUrl = updateUrl;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public Date getUpdateDate() {
		return updateDate;
	}

	public Version setUpdateDate(Date updateDate) {
		this.updateDate = updateDate;
		return this;
	}

	public String getPackageSize() {
		return packageSize;
	}

	public Version setPackageSize(String packageSize) {
		this.packageSize = packageSize;
		return this;
	}

	public String getVersoin() {
        return versoin;
    }

    public Version setVersoin(String versoin) {
        this.versoin = versoin;
        return this;
    }

    public String getCoinTypeVersion() {
        return coinTypeVersion;
    }

    public Version setCoinTypeVersion(String coinTypeVersion) {
        this.coinTypeVersion = coinTypeVersion;
        return this;
    }

    public String getSystem() {
        return system;
    }

    public Version setSystem(String system) {
        this.system = system;
        return this;
    }

    public Integer getIsforce() {
        return isforce;
    }

    public Version setIsforce(Integer isforce) {
        this.isforce = isforce;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public Version setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getUrl() {
        return url;
    }

    public Version setUrl(String url) {
        this.url = url;
        return this;
    }

    public static final String ID = "id";

    public static final String VERSOIN = "versoin";

    public static final String COINTYPEVERSION = "coinTypeVersion";

    public static final String SYSTEM = "system";

    public static final String ISFORCE = "isforce";

    public static final String DESCRIPTION = "description";

    public static final String URL = "url";


    @Override
    public String toString() {
        return "Versoin{" +
                "id=" + id +
                ", versoin='" + versoin + '\'' +
                ", coinTypeVersion='" + coinTypeVersion + '\'' +
                ", system='" + system + '\'' +
                ", isforce=" + isforce +
                ", description='" + description + '\'' +
                ", url='" + url + '\'' +
                ", content='" + content + '\'' +
                ", updateDate='" + updateDate + '\'' +
                ", packageSize='" + packageSize + '\'' +
                ", updateUrl='" + updateUrl + '\'' +
                '}';
    }

    @Override
    protected Serializable pkVal() {
        return id;
    }
}
