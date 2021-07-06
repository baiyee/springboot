package com.zx.springboot.model;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.enums.IdType;

import java.io.Serializable;

/**
 * <p>
 * 版本记录语言描述
 * </p>
 *
 * @author zhangxuan123
 * @since 2018-09-10
 */
@TableName("tb_versoin_language")
public class VersoinLanguage extends Model<VersoinLanguage> {

    private static final long serialVersionUID = 1L;

    /**
     * 版本记录语言ID
     */
    @TableId(value = "ID", type = IdType.AUTO)
    private Long id;

    /**
     * 版本记录表ID
     */
    private Long versoinId;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getVersoinId() {
        return versoinId;
    }

    public VersoinLanguage setVersoinId(Long versoinId) {
        this.versoinId = versoinId;
        return this;
    }

    public String getDescription() {
        return description;
    }

    public VersoinLanguage setDescription(String description) {
        this.description = description;
        return this;
    }

    public String getContent() {
        return content;
    }

    public VersoinLanguage setContent(String content) {
        this.content = content;
        return this;
    }

    public String getLocale() {
        return locale;
    }

    public VersoinLanguage setLocale(String locale) {
        this.locale = locale;
        return this;
    }

    public static final String VERSOINID = "versoinId";

    public static final String DESCRIPTION = "description";

    public static final String CONTENT = "content";

    public static final String LOCALE = "locale";

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "VersoinLanguage{" +
        "versoinId=" + versoinId +
        ", description=" + description +
        ", content=" + content +
        ", locale=" + locale +
        "}";
    }
}
