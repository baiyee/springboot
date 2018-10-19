package com.example.springboot.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.example.springboot.dto.request.VersoinRequest;
import com.example.springboot.dto.response.VersoinResponse;
import com.example.springboot.mapper.VersoinLanguageMapper;
import com.example.springboot.mapper.VersoinMapper;
import com.example.springboot.model.Page;
import com.example.springboot.model.Versoin;
import com.example.springboot.model.VersoinLanguage;
import com.example.springboot.service.VersoinService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author sea123
 * @since 2018-03-23
 */
@Service
public class VersoinServiceImpl extends ServiceImpl<VersoinMapper, Versoin> implements VersoinService {
    @Autowired
    private VersoinMapper mVersoinMapper;

    @Autowired
    private VersoinLanguageMapper languageMapper;

    @Override
    public Versoin searchVersoinInfoWithSystem(String system) {
        return mVersoinMapper.searchVersoinInfoWithSystem(system);
    }

    @Override
    public void updateCoinTypeVersion() {
        mVersoinMapper.updateCoinTypeVersion();
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean addVersoin(VersoinRequest request){
        Integer result;
        Versoin versoin = new Versoin();
        versoin.setId(request.getId()).setVersoin(request.getVersoin()).setCoinTypeVersion(request.getCoinTypeVersion())
                .setSystem(request.getSystem()).setIsforce(request.getIsforce()).setUrl(request.getUrl())
                .setPackageSize(request.getPackageSize()).setUpdateDate(request.getUpdateDate())
                .setUpdateUrl(request.getUpdateUrl());
        result = mVersoinMapper.insert(versoin);
        if (versoin.getId() == null) {
            return false;
        }
        VersoinLanguage language = new VersoinLanguage();
        language.setVersoinId(versoin.getId());
        language.setContent(request.getContent());
        language.setDescription(request.getDescription());
        language.setLocale(request.getLocale());
        result = languageMapper.insertLanguage(language);
        if (result == 0) {
            return false;
        }
        return true;
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public Boolean deleteAllById(Long versoinId) {
        Integer result;
        result = mVersoinMapper.deleteById(versoinId);
        if (result == 0){
            return false;
        }
        result = languageMapper.deleteByVersoinId(versoinId);
        if (result == 0){
            return false;
        }
        return true;
    }

    @Override
    public Boolean updateAllById(VersoinRequest request) {
        Integer result;
        Versoin versoin = new Versoin();
        versoin.setId(request.getId()).setCoinTypeVersion(request.getCoinTypeVersion())
                .setSystem(request.getSystem()).setIsforce(request.getIsforce()).setUrl(request.getUrl())
                .setPackageSize(request.getPackageSize()).setUpdateDate(request.getUpdateDate())
                .setUpdateUrl(request.getUpdateUrl());
        result = mVersoinMapper.updateVersoin(versoin);
        Long versoinId = request.getId();
        result = languageMapper.updateLanguageByVid(versoinId,request.getContent(),request.getDescription());
        if (result == 0) {
            return false;
        }
        return true;
    }

    @Override
    public VersoinResponse selectVsrsoinList(VersoinRequest request) {
        Integer pageIndex = null;
        Page page = new Page();
        if (request.getPageNumber() != null && request.getPageSize() != null) {
            pageIndex  = (request.getPageNumber() - 1)* request.getPageSize();
            page.setPageIndex(request.getPageNumber());
            page.setPageSize(request.getPageSize());
        }
        List<VersoinRequest> versoins = mVersoinMapper.selectVersoinList(pageIndex,request.getPageSize());
        Integer totalCount = mVersoinMapper.selectTotalCount();
        page.setTotalCount(totalCount);
        VersoinResponse response = new VersoinResponse(page);
        response.setVersoinList(versoins);
        return response;
    }
}
