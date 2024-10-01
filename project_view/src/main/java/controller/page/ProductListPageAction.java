package controller.page;

import java.util.ArrayList;

import controller.common.Action;
import controller.common.ActionForward;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.product.ProductDAO;
import model.product.ProductDTO;

public class ProductListPageAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		// 상품 목록 페이지
		System.out.println("ProductListPageAction 시작");
		String product_searchKeyword = request.getParameter("product_searchKeyword");
		
		//데이터 로그
		System.out.println("product_searchKeyword : "+product_searchKeyword);
		ProductDTO productDTO = new ProductDTO();
		if(product_searchKeyword != null && product_searchKeyword.equals("")) {
			productDTO.setProduct_searchKeyword(product_searchKeyword);
			if(product_searchKeyword.equals("PRODUCT_BY_RATING")) {
				productDTO.setProduct_page_num(1);
				productDTO.setProduct_condition("PRODUCT_BY_RATING");
			}
			else if(product_searchKeyword.equals("PRODUCT_BY_RESERVATIONS")) {
				productDTO.setProduct_page_num(1);
				productDTO.setProduct_condition("PRODUCT_BY_RESERVATIONS");
			}
			else if(product_searchKeyword.equals("PRODUCT_BY_WISHLIST")) {
				productDTO.setProduct_page_num(1);
				productDTO.setProduct_condition("PRODUCT_BY_WISHLIST");
			}
			else if(product_searchKeyword.equals("PRODUCT_BY_KEYWORD")) {
				productDTO.setProduct_page_num(1);
				productDTO.setProduct_condition("PRODUCT_BY_KEYWORD");
			}
			else if(product_searchKeyword.equals("PRODUCT_BY_FILTERING")) {
				productDTO.setProduct_page_num(1);
				productDTO.setProduct_condition("PRODUCT_BY_FILTERING");
			}
		}
		else {
			productDTO.setProduct_condition("PRODUCT_BY_ALL");
			productDTO.setProduct_page_num(1);
		}
		ProductDAO productDAO = new ProductDAO();
		ArrayList<ProductDTO> productList = productDAO.selectAll(productDTO);
		System.out.println("여기여기여기여기여기여기"+productList);
		request.setAttribute("productList", productList);
		System.out.println("확인 로그"+productList);
		
		ActionForward forward = new ActionForward();
		forward.setPath("productList.jsp");
		forward.setRedirect(false);
		
		System.out.println("ProductListPageAction 끝");
		return forward;
	}

}
