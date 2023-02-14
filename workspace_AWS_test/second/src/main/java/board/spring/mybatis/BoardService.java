package board.spring.mybatis;

import java.util.List;

public interface BoardService {
	//게시물리스트 서비스 명세서
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
	//상세게시물정보 서비스 
	BoardDTO getOneBoard(int seq);
	//void updateViewCount(int seq);
	
	void insertBoard(BoardDTO dto);
}
