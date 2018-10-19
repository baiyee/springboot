package com.example.springboot.dto.response;


import com.example.springboot.dto.request.VersoinRequest;
import com.example.springboot.model.Page;

import java.util.List;

/**
 * <p>
 * </p>
 *
 * @author ZhangXuan
 * @since 2018/9/10 21:49
 */
public class VersoinResponse {

    private List<VersoinRequest> versoinList;

    private Page page ;

    public VersoinResponse() {
    }

    public VersoinResponse(Page page) {
        if (page == null) {
            page = new Page();
        }
        this.page = page;
    }

    public List<VersoinRequest> getVersoinList() {
        return versoinList;
    }

    public void setVersoinList(List<VersoinRequest> versoinList) {
        this.versoinList = versoinList;
    }

    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }
}
