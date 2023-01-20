package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	//게시물리스트 서비스 명세서
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
}
