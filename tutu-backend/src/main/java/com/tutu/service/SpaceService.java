package com.tutu.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.tutu.model.dto.space.SpaceAddRequest;
import com.tutu.model.dto.space.SpaceQueryRequest;
import com.tutu.model.entity.Space;
import com.tutu.model.entity.User;
import com.tutu.model.vo.SpaceVO;

import javax.servlet.http.HttpServletRequest;

/**
* @author llllle
* @description 针对表【space(空间)】的数据库操作Service
* @createDate 2025-02-11 17:40:12
*/
public interface SpaceService extends IService<Space> {
    void fillSpaceBySpaceLevel(Space space);

    void validSpace(Space space, boolean add);


    long addSpace(SpaceAddRequest spaceAddRequest, User loginUser);


    void checkSpaceAuth(User loginUser, Space space);

    QueryWrapper<Space> getQueryWrapper(SpaceQueryRequest spaceQueryRequest);


    Page<SpaceVO> getSpaceVOPage(Page<Space> spacePage, HttpServletRequest request);


    SpaceVO getSpaceVO(Space space, HttpServletRequest request);





}
