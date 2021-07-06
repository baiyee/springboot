package com.zx.springboot.global.data.vo;


import com.zx.springboot.global.JsonParse;
import com.zx.springboot.utils.util.constants.ApiDesc;

import java.util.List;


/**
 * 批量删除指定id聚合的,id之间用,隔开;
 */
public class DeleteIdsRequestVo extends JsonParse {

    @ApiDesc(value= "对应的评论列表的主键列表聚合,使用char k = 7,分隔的字符口串; ")
    private List<Long> commentIds;
    @ApiDesc(value= "对应的点赞列表的主键列表聚合,使用char k = 7,分隔的字符口串; ")
    private List<Long> praiseIds;
    @ApiDesc(value= "对应的播放列表的主键列表聚合,使用char k = 7,分隔的字符口串; ")
    private List<Long> playIds;
    @ApiDesc(value= "对应的收藏列表的主键列表聚合,使用char k = 7,分隔的字符口串; ")
    private List<Long> storeIds;

    public List<Long> getCommentIds() {
        return commentIds;
    }

    public DeleteIdsRequestVo setCommentIds(List<Long> commentIds) {
        this.commentIds = commentIds;
        return this;
    }

    public List<Long> getPraiseIds() {
        return praiseIds;
    }

    public DeleteIdsRequestVo setPraiseIds(List<Long> praiseIds) {
        this.praiseIds = praiseIds;
        return this;
    }

    public List<Long> getPlayIds() {
        return playIds;
    }

    public DeleteIdsRequestVo setPlayIds(List<Long> playIds) {
        this.playIds = playIds;
        return this;
    }

    public List<Long> getStoreIds() {
        return storeIds;
    }

    public DeleteIdsRequestVo setStoreIds(List<Long> storeIds) {
        this.storeIds = storeIds;
        return this;
    }
}
