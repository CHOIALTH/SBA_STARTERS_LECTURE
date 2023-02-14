package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class BoardController {
	@Autowired
	@Qualifier("boardservice")
	BoardService service;
	
	@RequestMapping("/boardlist")
	public ModelAndView boardlist
	(@RequestParam(value="page", required=false, defaultValue="1") int page) {

		//몇페이지 구성 선택 가능 보여주는 링크
		//1.select count(*) from board-int-model 저장
		//2.select * from board limit (page-1)*3, 3 - list - model 저장
		//3. board/list 뷰
		int totalboard = service.getTotalBoard();
		
		int limit = (page-1)*3;
		List<BoardDTO> list = service.getBoardList(limit);
		
		ModelAndView mv= new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}
	
	@RequestMapping("/oneboard")
	public ModelAndView oneboard(int seq) {
		ModelAndView mv= new ModelAndView();
		
		BoardDTO dto = service.getOneBoard(seq);
		mv.addObject("oneboard", dto);
		mv.setViewName("board/oneboard");
		return mv;
	}
	
	@GetMapping("/insertboard")
	public String insertboardform() {
		return "board/insertform";//login 세션 전달
	}
	@PostMapping("/insertboard")
	public ModelAndView insertboardprocess(BoardDTO dto) {
		ModelAndView mv= new ModelAndView();
		service.insertBoard(dto);//제목 내용 (세션id-작성자) 
		
		/*mv.addObject("list", 1페이지3개게시물);
		mv.addObject("totalboard", 전체게시물수);	
		mv.setViewName("board/list"); //board/list.jsp 뷰 
		*/
		
		mv.setViewName("redirect:/boardlist"); //매핑url /boardlist 메소드 호출
		return mv;
	}
	
}








