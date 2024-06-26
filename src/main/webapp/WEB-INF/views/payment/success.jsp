<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="utf-8" />
</head>
<body>
<h2>결제 성공</h2>
<p id="paymentKey"></p>
<p id="orderId"></p>
<p id="amount"></p>

<script>
    // 쿼리 파라미터 값이 결제 요청할 때 보낸 데이터와 동일한지 반드시 확인하세요.
    // 클라이언트에서 결제 금액을 조작하는 행위를 방지할 수 있습니다.
    const urlParams = new URLSearchParams(window.location.search);
    const paymentKey = urlParams.get("paymentKey");
    const orderId = urlParams.get("orderId");
    const amount = urlParams.get("amount");

    async function confirm() {
        const requestData = {
            paymentKey: paymentKey,
            orderId: orderId,
            amount: amount,
        };

        const response = await fetch("/toss/confirm", {
            method: "POST",
            headers: {
                "Content-Type": "application/json",
            },
            body: JSON.stringify(requestData),
        });

        const json = await response.json();

        <%--if (!response.ok) {--%>
        <%--    // 결제 실패 비즈니스 로직을 구현하세요.--%>
        <%--    console.log(json);--%>
        <%--    window.location.href = `/fail?message=${json.message}&code=${json.code}`;--%>
        <%--}--%>

        // 결제 성공 비즈니스 로직을 구현하세요.
        console.log(json);
    }
    confirm();

    const paymentKeyElement = document.getElementById("paymentKey");
    const orderIdElement = document.getElementById("orderId");
    const amountElement = document.getElementById("amount");

    orderIdElement.textContent = "주문번호: " + orderId;
    amountElement.textContent = "결제 금액: " + amount;
    paymentKeyElement.textContent = "paymentKey: " + paymentKey;

    // 특정 페이지로 리디렉션할 URL
    var redirectUrl = "${pageContext.request.contextPath}/orderList";

    // 부모 창을 리디렉션하고 팝업 창을 닫는 함수
    function redirectToParent() {
        if (window.opener != null && !window.opener.closed) {
            window.opener.location.href = redirectUrl;
            window.close();
        }
    }
    // 모든 페이지 로드 후에 실행되도록 딜레이를 줄 수 있음
    function delayedRedirect() {
        // 여기에 다른 모든 코드가 실행되었는지 확인하는 로직 추가 가능
        setTimeout(redirectToParent, 0);  // 0ms 딜레이를 주어 마지막에 실행되도록 함
    }
    delayedRedirect();
</script>
</body>
</html>