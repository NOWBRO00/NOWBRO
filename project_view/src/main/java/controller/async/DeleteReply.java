package controller.async;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.reply.ReplyDAO;
import model.reply.ReplyDTO;

import java.io.IOException;
import java.io.PrintWriter;

import controller.common.ActionForward;

@WebServlet("/deleteReply")
public class DeleteReply extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public DeleteReply() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("GET 요청 도착");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("POST 요청 도착");
		
		int reply_num = Integer.parseInt(request.getParameter("reply_num"));
		
		//데이터 로그
		System.out.println("reply_num : "+reply_num);
		
		ReplyDTO replyDTO=new ReplyDTO();
		replyDTO.setReply_num(reply_num);
		
		ReplyDAO replyDAO=new ReplyDAO();
		boolean flag = replyDAO.delete(replyDTO);
		
		PrintWriter out=response.getWriter();
		if(flag) { // 성공
			out.print(flag); 
		}
		else { // 실패
			out.print(flag);
		}
	}

}
