package com.spring.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.spring.board.BoardVO;
import com.spring.board.common.JDBCUtil;

@Repository("boardDAO")
public class BoardDAO {
	//JDBC 관련 변수
	private Connection conn=null;
	private PreparedStatement stmt=null;
	private ResultSet rs=null;
	
	//SQL 명령어들
	private final String BOARDEX_INSERT="insert into boardex(seq, title,writer,content) values((select nvl(max(seq),0)+1 from boardex),?,?,?)";
	private final String BOARDEX_UPDATE="update boardex set title=?, content=? where seq=?";
	private final String BOARDEX_DELETE="delete boardex where seq=?";
	private final String BOARDEX_GET="select * from boardex where seq=?";
	private final String BOARDEX_LIST="select * from boardex order by seq desc";
	
	//CRUD
	//글등롣
	public void insertBoard(BoardVO vo) {
		System.out.println("===> JDBC로 insertBoard() 기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARDEX_INSERT);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2 ,vo.getWriter());
			stmt.setString(3, vo.getContent());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//글 수정
	public void updateBoard(BoardVO vo) {
		System.out.println("===> JDBC로 updateBoard() 기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARDEX_UPDATE);
			stmt.setString(1, vo.getTitle());
			stmt.setString(2 ,vo.getContent());
			stmt.setInt(3, vo.getSeq());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//글삭제
	public void deleteBoard(BoardVO vo) {
		System.out.println("===> JDBC로 deleteBoard() 기능 처리");
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARDEX_DELETE);
			stmt.setInt(1, vo.getSeq());
			stmt.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(stmt, conn);
		}
	}
	//글 상세 조회
	public BoardVO getBoard(BoardVO vo) {
		System.out.println("===> JDBC로 getBoard() 기능 처리");
	BoardVO boardex=null;
	try {
		conn=JDBCUtil.getConnection();
		stmt=conn.prepareStatement(BOARDEX_GET);
		stmt.setInt(1, vo.getSeq());
		rs=stmt.executeQuery();
		if(rs.next()) {
			boardex=new BoardVO();
			boardex.setSeq(rs.getInt("SEQ"));
			boardex.setTitle(rs.getString("TITLE"));
			boardex.setWriter(rs.getString("WRITER"));
			boardex.setContent(rs.getString("CONTENT"));
			boardex.setRegDate(rs.getDate("REGDATE"));
			boardex.setCnt(rs.getInt("CNT"));
		}
	}catch(Exception e) {
		e.printStackTrace();
	}finally {
		JDBCUtil.close(rs,stmt,conn);
	}
	return boardex;
	}
	//글 목록 조회
		public List<BoardVO> getBoardList(BoardVO vo) {
			System.out.println("===> JDBC로 getBoardList() 기능 처리");
			List<BoardVO> boardList=new ArrayList<BoardVO>();
		try {
			conn=JDBCUtil.getConnection();
			stmt=conn.prepareStatement(BOARDEX_LIST);
			
			rs=stmt.executeQuery();
			if(rs.next()) {
				
				BoardVO boardex=new BoardVO();
				boardex.setSeq(rs.getInt("SEQ"));
				boardex.setTitle(rs.getString("TITLE"));
				boardex.setWriter(rs.getString("WRITER"));
				boardex.setContent(rs.getString("CONTENT"));
				boardex.setRegDate(rs.getDate("REGDATE"));
				boardex.setCnt(rs.getInt("CNT"));
				boardList.add(boardex);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			JDBCUtil.close(rs,stmt,conn);
		}
		return boardList;
		}
}
