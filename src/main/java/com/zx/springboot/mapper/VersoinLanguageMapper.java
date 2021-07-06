package com.zx.springboot.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.zx.springboot.model.VersoinLanguage;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 * 版本记录语言描述 Mapper 接口
 * </p>
 *
 * @author zhangxuan123
 * @since 2018-09-10
 */
public interface VersoinLanguageMapper extends BaseMapper<VersoinLanguage> {

    @Delete("delete from tb_versoin_language where versoinId = #{versoinId}")
    Integer deleteByVersoinId(@Param("versoinId") Long versoinId);


    Integer insertLanguage(VersoinLanguage language);

    Integer updateLanguageByVid(@Param("versoinId") Long versoinId,
                                @Param("content") String content,
                                @Param("description") String description);
}
