<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <!-- 부트스트랩 CSS 링크 -->
  <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>

<div class="container">
  <h1 class="my-4">All Items</h1>
  <div class="row mb-4">
    <div class="col-md-12 d-flex justify-content-end">
      <!-- 검색창 및 카테고리 선택 항목 결합 -->
      <form class="form-inline" method="get" action="${pageContext.request.contextPath}/searchItems">
        <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search" name="itemName">
        <select class="form-control mr-sm-2" name="category">
          <option value="">Select Category</option>
          <c:forEach var="category" items="${categoryList}">
            <option value="${category.categoryName}">${category.categoryName}</option>
          </c:forEach>
        </select>
        <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
      </form>
    </div>
  </div>
  <div class="row">
    <c:forEach var="item" items="${itemList}">
      <div class="col-lg-4 col-md-6 mb-4">
        <div class="card h-100" onclick="location.href='${pageContext.request.contextPath}/item/${item.itemCode}'" style="cursor: pointer;">
          <img class="card-img-top" src="${item.itemSrc}" alt="${item.itemName}">
          <div class="card-body">
            <h4 class="card-title">${item.itemName}</h4>
            <h5>₩${item.itemPrice}</h5>
            <p class="card-text">
              Category: ${item.categoryName}<br>
              Factory: ${item.factoryName}<br>
              Stock Quantity: ${item.stockQty}
            </p>
          </div>
        </div>
      </div>
    </c:forEach>
  </div>
</div>

<!-- 부트스트랩 JavaScript 링크 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
</body>
</html>