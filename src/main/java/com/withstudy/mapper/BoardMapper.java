package com.withstudy.mapper;

import com.withstudy.domain.StudyBoardDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BoardMapper {
    public void studyBoardReg(StudyBoardDTO studyBoardDTO);
}
