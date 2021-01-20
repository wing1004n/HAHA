package org.zerock.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
@RequiredArgsConstructor
@ToString
public class BoardServiceImpl implements BoardService {
 
	private final BoardMapper mapper;

	public Long register(BoardVO board) {
		
		mapper.insertSelectKey(board);
		
		return board.getBno();
	}

	public BoardVO get(Long bno) {
	
		return mapper.read(bno);
	}

	public int modify(BoardVO board) {
		
		return mapper.update(board);
	}

	public int remove(Long bno) {
	
		return mapper.delete(bno);
	}

	public List<BoardVO> getList() {
		
		return mapper.getList();
	}

	public List<BoardVO> getList(Criteria cri) {	
		return mapper.getListWithPaging(cri);
	}

	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}
	
}
