<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>TRIOShop</title>
    <!-- 부트스트랩 CSS 링크 -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="css/hdarea.css">
</head>
<body>
<style>
    @media (max-width: 991.5px) {
        #hdWrap .hdCate .cateWrap {
            position: absolute;
            top: 15px;
            left: 90px;
        }
    }

    @media (max-width: 768px) {
        #hdWrap .hdCate .cateWrap {
            position: absolute;
            top: 15px;
            left: 90px;
        }
    }
    .tmenu .dropdown-toggle::after {
        display: none; /* 토글 아이콘 숨기기 */
    }

    .tmenu .dropdown-menu {
        left: 50%;
        transform: translateX(-50%);
        display: none;
    }

    .tmenu:hover .dropdown-menu {
        display: block; /* 마우스를 올렸을 때 메뉴를 표시 */
    }




</style>
<div id="hdWrap" class="headroom headroom--not-bottom headroom--pinned headroom--top">
    <div class="hdArea">
        <div class="container">
            <div class="row justify-content-center">
                <div class="col-12">
                    <div class="hdCate">
                        <div class="cateWrap d-flex flex-wrap justify-content-center">
                            <div class="tmenu dropdown mx-2">
                                <a class="dropdown-toggle" href="<c:url value='/itemList'><c:param name='category' value='top'/></c:url>" id="navbarDropdownTop" role="button" aria-haspopup="true" aria-expanded="false">
                                    Top
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownTop">
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='기본 상의'/></c:url>">상의</a>
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='울 스웨터'/></c:url>">스웨터</a>
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='셔츠'/></c:url>">셔츠</a>
                                </div>
                            </div>
                            <div class="tmenu dropdown mx-2">
                                <a class="dropdown-toggle" href="<c:url value='/itemList'><c:param name='category' value='pants'/></c:url>" id="navbarDropdownPants" role="button" aria-haspopup="true" aria-expanded="false">
                                    Pants
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownPants">
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='기본 바지'/></c:url>">기본 바지</a>
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='반 바지'/></c:url>">반 바지</a>
                                </div>
                            </div>
                            <div class="tmenu dropdown mx-2">
                                <a class="dropdown-toggle" href="<c:url value='/itemList'><c:param name='category' value='outer'/></c:url>" id="navbarDropdownOuter" role="button" aria-haspopup="true" aria-expanded="false">
                                    Outer
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownOuter">
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='가죽 자켓'/></c:url>">가죽 자켓</a>
                                </div>
                            </div>
                            <div class="tmenu dropdown mx-2">
                                <a class="dropdown-toggle" href="<c:url value='/itemList'><c:param name='category' value='shoes'/></c:url>" id="navbarDropdownShoes" role="button" aria-haspopup="true" aria-expanded="false">
                                    Shoes
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownShoes">
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='구두'/></c:url>">구두</a>
                                </div>
                            </div>
                            <div class="tmenu dropdown mx-2">
                                <a class="dropdown-toggle" href="<c:url value='/itemList'><c:param name='category' value='acc'/></c:url>" id="navbarDropdownAcc" role="button" aria-haspopup="true" aria-expanded="false">
                                    Acc
                                </a>
                                <div class="dropdown-menu" aria-labelledby="navbarDropdownAcc">
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='가죽 벨트'/></c:url>">가죽 벨트</a>
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='야구 모자'/></c:url>">야구 모자</a>
                                    <a class="dropdown-item" href="<c:url value='/itemList'><c:param name='itemName' value='가방'/></c:url>">가방</a>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<!-- 부트스트랩 JS 및 jQuery 링크 -->
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.5.4/dist/umd/popper.min.js"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<script>
    document.addEventListener("DOMContentLoaded", function () {
        var tmenuItems = document.querySelectorAll('.tmenu');

        tmenuItems.forEach(function (tmenuItem) {
            tmenuItem.addEventListener('mouseover', function () {
                this.querySelector('.dropdown-menu').style.display = 'block';
            });

            tmenuItem.addEventListener('mouseout', function () {
                this.querySelector('.dropdown-menu').style.display = 'none';
            });
        });
    });
</script>
</body>
</html>
