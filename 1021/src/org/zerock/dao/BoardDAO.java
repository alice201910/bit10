package org.zerock.dao;

import org.zerock.domain.BoardVO;

public interface BoardDAO {
	
	public boolean insert(BoardVO vo);
	
	public BoardVO select(Long bno);
}
