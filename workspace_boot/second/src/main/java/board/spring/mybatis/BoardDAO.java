package board.spring.mybatis;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface BoardDAO {
	// 게시물 리스트
	int getTotalBoard();
	List<BoardDTO> getBoardList(int limit);
	// 상세 게시물 조회를 위해 필요한 코드
	BoardDTO getOneBoard(int seq);
	void updateViewCount(int seq);
	void insertBoard(BoardDTO dto);
}
