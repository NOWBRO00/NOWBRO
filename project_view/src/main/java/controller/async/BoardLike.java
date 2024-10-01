package controller.async;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.board.BoardDAO;
import model.board.BoardDTO;
import model.like.LikeDAO;
import model.like.LikeDTO;

@WebServlet("/boardLike")
public class BoardLike extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
     public BoardLike() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청 도착");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청 도착");
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String member_id = (String)request.getSession().getAttribute("member_id");
		
		// 데이터 확인 로그
		System.out.println("board_num : "+board_num);
		System.out.println("member_id : "+member_id);
		
		LikeDTO likeDTO = new LikeDTO();
		likeDTO.setLike_member_id(member_id);
		likeDTO.setLike_board_num(board_num);
		
		LikeDAO likeDAO=new LikeDAO();
		likeDTO = likeDAO.selectOne(likeDTO);
		
		response.setContentType("application/json"); // JSON으로 응답 설정

		boolean flag;
		String jsonResponse;
		PrintWriter out=response.getWriter();

		LikeDTO newLikeDTO = new LikeDTO();
		newLikeDTO.setLike_member_id(member_id);
		newLikeDTO.setLike_board_num(board_num);
		if(likeDTO == null) {
			flag = likeDAO.insert(newLikeDTO);
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoard_num(board_num);
			boardDTO.setBoard_condition("BOARD_SELECT_ONE");
			
			BoardDAO boardDAO = new BoardDAO();
			boardDTO = boardDAO.selectOne(boardDTO);
			jsonResponse = "{\"flag\": " + "true" + "," + "\"likeCnt\": " + boardDTO.getBoard_like_cnt() + "}";
		}
		else {
			flag = likeDAO.delete(likeDTO);
			BoardDTO boardDTO = new BoardDTO();
			boardDTO.setBoard_num(board_num);
			boardDTO.setBoard_condition("BOARD_SELECT_ONE");
			
			BoardDAO boardDAO = new BoardDAO();
			boardDTO = boardDAO.selectOne(boardDTO);
			jsonResponse = "{\"flag\": " + "false" + "," + "\"likeCnt\": " + boardDTO.getBoard_like_cnt() + "}";
		}
		out.print(jsonResponse);
	    out.flush();
	}
	// 좋아요를 셀렉트
	// 있으면 꺼야되고
	// 없으면 켜야됨
	

}
