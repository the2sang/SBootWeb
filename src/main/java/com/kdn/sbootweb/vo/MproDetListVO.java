package com.kdn.sbootweb.vo;

import java.util.List;

public class MproDetListVO {

    public MproDetListVO() {

    }

    private List<MproDetVO> mproDetVOList;

    public List<MproDetVO> getMproDetVOList() {
        return mproDetVOList;
    }

    public void setMproDetVOList(List<MproDetVO> mproDetVOList) {
        this.mproDetVOList = mproDetVOList;
    }

    @Override
    public String toString() {
        return "MproDetListVO{" +
                "mproDetVOList=" + mproDetVOList +
                '}';
    }
}
