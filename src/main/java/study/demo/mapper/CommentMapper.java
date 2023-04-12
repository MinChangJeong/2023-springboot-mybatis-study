package study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import study.demo.domain.Comment;
import study.demo.dto.CommentDto;

import java.util.List;
import java.util.Map;

@Mapper
public interface CommentMapper {
    List<Comment> findAllCommentByBoardId(Long boardId);
    void createComment(CommentDto commentDto);
    void deleteComment(Long boardId);
    void updateComment(Map<String, Object> paramMap);
}
