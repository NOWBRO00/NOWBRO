<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!-- 상품파일은 항상 비어있지 않다 -->
<c:if test="${not empty file.file_images}">
	<div class="blog-item set-bg" data-setbg="${file.file_images}">
    	<div class="bi-text">
    		<!-- 상품 카테고리 -->
            <span class="b-tag">${product.product_category}</span>
            <!-- 상품 별점 평균 -->
            <div id="averageRating"></div>
            <!-- 상품명 및 링크 --> <!-- 상품의 PK값과 함께 이동 -->
            <h4><a href="productDetail.do?product_num=${product.product_num}">${product.product_title}</a></h4>
        </div>
	</div>
</c:if>