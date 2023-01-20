package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	
	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist (@RequestParam(value="page", required=false, defaultValue="1") int page) {
		
		//몇페이지 구성 선택 가능 보여주는 링크 
		//1.select count(*) from board=int-nil 저장
		//2.select * from board limit (page -1)*3,3-list-model 저장
		//3.board/list 뷰 
		
		int totalboard = service.getTotalBoard();
		int limit = (page-1)*3;
		List<BoardDTO> list = service.getBoardList(limit);
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("list",list);
		mv.setViewName("board/list");
		return mv;
	}
}