package com.MarketBudget.Project.mapper;

import com.MarketBudget.Project.dto.CategoriesDTO;
import com.MarketBudget.Project.dto.CommentsDTO;
import com.MarketBudget.Project.entity.Categories;
import com.MarketBudget.Project.entity.Comments;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CommentsMapper {
    public Comments commentsDTO2Entity(CommentsDTO dto) {

        Comments entity = new Comments();
        entity.setComment(dto.getComments());

        return entity;
    }

    public CommentsDTO commentsEntity2DTO(Comments entity) {

        CommentsDTO dto = new CommentsDTO();
        dto.setId(entity.getId());
        dto.setComments(entity.getComment());


        return dto;
    }

    public List<CommentsDTO> commentsEntityList2DTOList(List<Comments > entities) {

        List<CommentsDTO> dtos = new ArrayList<>();

        for (Comments   entity : entities) {
            dtos.add(this.commentsEntity2DTO(entity));
        }

        return dtos;
    }


    public void commentsEntityRefreshValues(Comments   entity, CommentsDTO dto) {

        entity.setComment(dto.getComments());
    }
}
