<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<head>
    <script src="<c:url value="${jsUrlBos}/order/orderView.js"/>"></script>
    <script>
        document.addEventListener("DOMContentLoaded", () => {
            orderView.initLoad();
            orderView.bindButtonEvent();
        });
    </script>
</head>
<div class="container-fluid px-4">
    <h1 class="mt-4">주문통합검색</h1>

    <div class="search_form">
        <table>
            <tr>
                <th>기간</th>
                <td colspan="3" style="position:relative;">
                    <select id="date_type" class="form-select" style="width:115px;">
                        <option value="O.ORD_DTTM" selected="selected">주문일</option>
                        <option value="memo_date">메모작성일</option>
                        <option value="pay_date">결제일</option>
                        <option value="shipready_date">송장번호입력일</option>
                        <option value="shipbegin_date">배송시작일</option>
                        <option value="shipend_date">배송완료일</option>
                        <option value="purchaseconfirmation_date">구매확정일</option>
                    </select>

                    <div class="date_range_container">
                        <button data-interval="0" class="btn btn-outline-dark date_range active">오늘</button>
                        <button data-interval="1" class="btn btn-outline-dark date_range">어제</button>
                        <button data-interval="3" class="btn btn-outline-dark date_range">3일</button>
                        <button data-interval="7" class="btn btn-outline-dark date_range">7일</button>
                        <button data-interval="15" class="btn btn-outline-dark date_range">15일</button>
                        <button data-interval="30" class="btn btn-outline-dark date_range">1개월</button>
                        <button data-interval="90" class="btn btn-outline-dark date_range">3개월</button>
                        <button data-interval="180" class="btn btn-outline-dark date_range">6개월</button>
                    </div>

                    <div class="calendar">
                        <div class="input w-208">
                            <input type="text" name="start_date" id="start_date" readonly="readonly" class="inp datepicker hasDatepicker">
                        </div>
                        <span class="m">~</span>
                        <div class="input w-208">
                            <input type="text" name="end_date" id="end_date" readonly="readonly" class="inp datepicker hasDatepicker">
                        </div>
                    </div>
                </td>
            </tr>
            <tr>
                <th>검색어</th>
                <td>
                    <select id="search_type" class="form-select" style="width:150px;">
                        <option>-검색항목선택-</option>
                        <option value="ODA.RECIPIENT">수령인명</option>
                        <option value="M.NAME">구매자명</option>
                        <option value="M.LGIN_ID">구매자ID</option>
                        <option value="ODA.MP_NO">구매자연락처</option>
                        <option value="O.ORD_NO">주문번호</option>
                        <option value="OD.ORD_DTL_NO">주문상세번호</option>
                        <option value="OD.PROD_ID">상품번호</option>
                    </select>
                    <input type="text" id="search_keyword" class="form-control" style="width: 500px">
                </td>
            </tr>
        </table>
    </div>
    <div class="button_area">
        <button id="btn_search" class="btn btn-dark">검색</button>
        <button class="btn btn-light">초기화</button>
    </div>

    <div id="example-table"></div>
</div>