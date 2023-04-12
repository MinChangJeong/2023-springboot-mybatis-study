package study.demo.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import study.demo.domain.NoticeResponse;
import study.demo.service.NoticeService;

@RestController
@RequestMapping("/notice")
@RequiredArgsConstructor
public class NoticeController {

    @Resource(name="study.demo.service.NoticeService")
    NoticeService noticeService;

    @RequestMapping("/list")
    private String noticeList(Model model) throws Exception{

        model.addAttribute("list", noticeService.noticeListService());

        return "list"; //생성할 jsp
    }

    @RequestMapping("/detail/{id}")
    private String noticeDetail(@PathVariable int id, Model model) throws Exception{

        model.addAttribute("detail", noticeService.noticeDetailService(id));

        return "detail";
    }

    @RequestMapping("/insert") //게시글 작성폼 호출
    private String noticeInsertForm(){

        return "insert";
    }

    @RequestMapping("/insertProc")
    private int noticeInsertProc(HttpServletRequest request) throws Exception{

        NoticeResponse noticeResponse = (NoticeResponse) request.getParameterMap();

        return noticeService.noticeCreateService(noticeResponse);
    }

    @RequestMapping("/update/{id}")
    private String noticeUpdateForm(@PathVariable int id, Model model) throws Exception{

        model.addAttribute("detail", noticeService.noticeDetailService(id));

        return "update";
    }

    @RequestMapping("/updateProc")
    private int noticeUpdateProc(HttpServletRequest request) throws Exception{

        NoticeResponse noticeResponse = (NoticeResponse) request.getParameterMap();

        return noticeService.noticeUpdateService(noticeResponse);
    }

    @RequestMapping("/delete/{id}")
    private String deleteNotice(@PathVariable int id) throws Exception{

        noticeService.noticeDeleteService(id);

        return "redirect:/list";
    }
}
