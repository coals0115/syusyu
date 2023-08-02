package com.teamProject.syusyu.controller.bos.cs.mypage;

import com.teamProject.syusyu.common.ViewPath;
import com.teamProject.syusyu.domain.PageHandler2;
import com.teamProject.syusyu.domain.PageHandler3;
import com.teamProject.syusyu.domain.cs.*;
import com.teamProject.syusyu.service.fos.cs.InqryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/adminInqry")
public class AdminInqryController {

    @Autowired
    InqryService inqryService;

    @GetMapping("/adminInqryList")
    public String list(Integer page, Integer pageSize, Model m, HttpServletRequest request){

        if(page==null) page=1;
        if(pageSize==null) pageSize=10;

        try {
            // 검색 조건에 해당하는 공지사항 총 개수 조회
            int totalCnt = inqryService.getCount();
            System.out.println("totalCnt = " + totalCnt);
            System.out.println("page = " + page);
            System.out.println("page = " + pageSize);
            PageHandler2 pageHandler = new PageHandler2(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1)*pageSize);
            map.put("pageSize", pageSize);

            List<InqryDTO> list = inqryService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("totalCnt", totalCnt);

            // inqryTypeTextMap을 Model에 추가
            Map<String, String> inqryTypeTextMap = new HashMap<>();
            inqryTypeTextMap.put("91", "주문문의");
            inqryTypeTextMap.put("92", "상품문의");
            inqryTypeTextMap.put("93", "배송문의");
            inqryTypeTextMap.put("94", "결제문의");
            inqryTypeTextMap.put("95", "이 상품 찾아요");
            inqryTypeTextMap.put("96", "건의사항 있어요");
            m.addAttribute("inqryTypeTextMap", inqryTypeTextMap);
        } catch (Exception e) {
            e.printStackTrace();
        }
        InqryDTO inqry = new InqryDTO();
        return ViewPath.BOS_CS + "adminInqryList";
    }

}



//    @PostMapping("/remove")
//    @ResponseBody
//    public int remove(Integer inqryNo, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr) {
//        InqryDTO inqry = new InqryDTO();
//        int removeYn = 1;
//
//        Integer mbrId = (Integer)session.getAttribute("mbrId");
//        // 세션에서 regrId 값 가져오기
//        try {
//            if(inqryService.remove(inqryNo, mbrId.toString())!=1)
//                throw new Exception("Delete failed.");
//        } catch (Exception e) {
//            e.printStackTrace();
//            removeYn = 0;
////                rattr.addFlashAttribute("msg", "DEL_ERR");
//        }
//
////            m.addAttribute("page", page);
////            m.addAttribute("pageSize", pageSize);
////            m.addAttribute("msg", msg);
//
//        return removeYn;
//        //"redirect:" +
//
//    }
//
//    @PostMapping("/inqry")
//    public String inqry(Integer inqryNo, Model m) {
//        try{
//            InqryDTO inqry = new InqryDTO();
////            InqryDTO inqryDTO = inqryService.read(inqryNo);
////            m.addAttribute(inqryDTO);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ViewPath.FOS_MYPAGE +"inqry";
//    }
//
//    @GetMapping("/read")
//    public String read(Integer inqryNo, Model m) {
//        try{
//            InqryDTO inqryDTO = inqryService.read(inqryNo);
//            m.addAttribute(inqryDTO);
//        }catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return ViewPath.FOS_MYPAGE +"inqry";
//    }
//
//    @GetMapping("/modify")
//    public String modify(Integer inqryNo, Model m, HttpSession session, RedirectAttributes rattr){
//
//        try {
//            InqryDTO inqryDTO = inqryService.read(inqryNo);
//            String Content = inqryService.getContent(inqryNo);
//            m.addAttribute("inqryDTO", inqryDTO);
//            m.addAttribute("Content", Content);
//            System.out.println("inqryNo = " + inqryNo);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return ViewPath.FOS_MYPAGE +"inqrymodify";
//    }
//
//    @PostMapping("/write")
//    @ResponseBody
//    public int write(@RequestBody InqryDTO inqryDTO, HttpSession session, RedirectAttributes rattr, Model m) {
//        // inqryDTO 객체에 클라이언트에서 전송한 데이터가 이미 매핑되어 있습니다.
//        // 따라서 이후에 inqryDTO 객체를 사용하여 title과 RegDttm 정보를 가져와 사용할 수 있습니다.
//
//        Integer regrId = (Integer)session.getAttribute("mbrId");
//
//        // 모델에 inqryDTO 객체를 추가하여 클라이언트로 전달
//        m.addAttribute("inqryDTO", inqryDTO);
//
//        try {
//            // InqryService를 통해 데이터 삽입
//            inqryDTO.setRegrId(regrId);
//            int result = inqryService.insert(inqryDTO);
//            // 필요한 경우 'result' 변수를 사용합니다. (예: 오류 처리 또는 추가 처리).
//
//            // 성공적으로 등록되었음을 클라이언트에게 알리기 위해 1 반환
//            return 1;
//        } catch (Exception e) {
//            // 예외 처리가 필요한 경우 처리합니다.
//            e.printStackTrace();
//            // 오류가 발생했음을 나타내는 오류 코드를 반환
//            return -1;
//        }
//    }
//
//    // 1:1 문의 수정을 처리하는 메서드
//    @PostMapping("/modify")
//    @ResponseBody
//    public int updateInqry(@RequestBody InqryDTO inqryDTO, HttpSession session) {
//        Integer regrId = (Integer) session.getAttribute("mbrId");
//        inqryDTO.setRegrId(regrId);
//
//        try {
//            // inqryDTO에서 필요한 데이터를 추출하고 비즈니스 로직을 처리합니다.
//            // 이후 inqryService를 통해 DB에 업데이트 작업을 수행합니다.
//            inqryService.modify(inqryDTO);
//
//            // 성공적으로 등록되었음을 클라이언트에게 알리기 위해 1 반환
//            return 1;
//        } catch (Exception e) {
//            // 예외 처리가 필요한 경우 처리합니다.
//            e.printStackTrace();
//            // 오류가 발생했음을 나타내는 오류 코드를 반환
//            return -1;
//        }
//    }






