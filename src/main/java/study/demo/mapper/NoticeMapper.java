package study.demo.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;
import study.demo.domain.NoticeResponse;
import study.demo.domain.Notice;

import java.util.List;

@Mapper
@Component
public interface NoticeMapper {
    public int createNotice(NoticeResponse notice);

    public Notice selectNoticeDetail(int id);

    public int updateNotice(NoticeResponse notice);

    public int deleteNotice(int id);

    public List<Notice> selectNoticeList();
}
