package study.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import study.demo.domain.Notice;
import study.demo.domain.NoticeResponse;
import study.demo.mapper.NoticeMapper;

import javax.annotation.Resource;
import java.util.List;

@Service()
@RequiredArgsConstructor
public class NoticeService {

    @Resource()
    NoticeMapper noticeMapper;

    public List<Notice> noticeListService() throws Exception{

        return noticeMapper.selectNoticeList();
    }

    public Notice noticeDetailService(int id) throws Exception{

        return noticeMapper.selectNoticeDetail(id);
    }

    public int noticeCreateService(NoticeResponse noticeResponse) throws Exception{

        return noticeMapper.createNotice(noticeResponse);
    }

    public int noticeUpdateService(NoticeResponse noticeResponse) throws Exception{

        return noticeMapper.updateNotice(noticeResponse);
    }

    public int noticeDeleteService(int id) throws Exception{

        return noticeMapper.deleteNotice(id);
    }
}
