package com.MarketBudget.Project.service;


import com.MarketBudget.Project.dto.CommentsDTO;
import org.jvnet.hk2.annotations.Service;

import java.util.List;

@Service
public interface CommentsService {
    CommentsDTO save(CommentsDTO commentsDTO);
    List<CommentsDTO> getAllComments();
    void delete(Long id);
    CommentsDTO update(Long id, CommentsDTO commentsDTO);
}
