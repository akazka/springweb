package com.springexam.biz.board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.spring.board.BoardService;
import com.spring.board.BoardVO;
import com.spring.board.dao.BoardDAO;
import com.spring.common.Log4jAdvice;

public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardDAO boardDAO;
	private Log4jAdvice log;
	
	 public BoardServiceImpl() {
		 log = new Log4jAdvice();
	 }
	 
	 @Override
	 public void insertBoard(BoardVO vo) {
		 log.printLogging();
		 boardDAO.insertBoard(vo);
	 }
	 
	 @Override
	 public void deleteBoard(BoardVO vo) {
		 log.printLogging();
		 boardDAO.insertBoard(vo);
	 }
	 
	 @Override
	 public List<BoardVO> getBoardList(BoardVO vo) {
		 log.printLogging();
		 return boardDAO.getBoardList(vo);
	 }

	@Override
	public void updateBoard(BoardVO vo) {
		 log.printLogging();
		 boardDAO.insertBoard(vo);
		
	}

	@Override
	public BoardVO getBoard(BoardVO vo) {
		 log.printLogging();
		 return boardDAO.getBoard(vo);
	}
}
