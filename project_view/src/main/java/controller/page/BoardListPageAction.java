package controller.page;

import java.util.ArrayList;

import controller.common.Action;
import controller.common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.board.BoardDAO;
import model.board.BoardDTO;

public class BoardListPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardListPageAction 시작");

		//		셀렉트올 인데 ? 검색 키워드 받아야하고
		//				셀렉트 할 때 파일도 가져와야 됨 


		String searchContent = request.getParameter("searchContent");
		String searchKeyword = request.getParameter("searchKeyword");

		// 데이터 로그
		System.out.println("searchContent : " + searchContent);

		BoardDTO boardDTO = new BoardDTO();

		if (searchContent == null || searchContent.isEmpty()) {
			boardDTO.setBoard_condition("BOARD_ALL");
			boardDTO.setBoard_page_num(1);
		} 
		else if (searchContent.equals("BOARD_CONTENT")) {
			boardDTO.setBoard_searchKeyword(searchKeyword); // 검색 키워드 설정
			boardDTO.setBoard_condition("BOARD_CONTENT");
		} 
		else if (searchContent.equals("BOARD_LIKE")) {
			boardDTO.setBoard_condition("BOARD_LIKE");
		} 
		else {
			System.out.println("잘못된 접근");
			// 기본 조건 설정 혹은 예외 처리
			boardDTO.setBoard_condition("BOARD_ALL");
		}

		BoardDAO boardDAO = new BoardDAO();
		ArrayList<BoardDTO> boardList = boardDAO.selectAll(boardDTO);
		
		System.out.println(boardList);

		request.setAttribute("boardList", boardList);

		ActionForward forward = new ActionForward();
		forward.setPath("boardList.jsp"); // 경로 확인
		forward.setRedirect(false);
		System.out.println("BoardListPageAction 끝");
		return forward;
	}



}
