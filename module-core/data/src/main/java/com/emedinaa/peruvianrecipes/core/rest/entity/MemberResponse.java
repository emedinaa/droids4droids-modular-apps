package com.emedinaa.peruvianrecipes.core.rest.entity;


import com.emedinaa.peruvianrecipes.core.entity.MemberEntity;

import java.util.List;

/**
 * Created by eduardo on 11/12/16.
 */
public class MemberResponse extends BaseResponse {

    private List<MemberEntity> results;

    public List<MemberEntity> getResults() {
        return results;
    }

    public void setResults(List<MemberEntity> results) {
        this.results = results;
    }
}
