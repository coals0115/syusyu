
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>--%>
<%--<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>--%>
<%--<%@ page session="true" %>--%>
<%--<c:set var="loginId" value="${sessionScope.id}"/>--%>
<%--<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>--%>
<%--<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>syusyu</title>--%>
<%--    <style>--%>
<%--        @import url(${cssUrlFos}/cs/noticeList.scss);--%>
<%--    </style>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="../common/header.jsp"/>--%>
<%--=======--%>
<%--&lt;%&ndash;--%>
<%--  Created by IntelliJ IDEA.--%>
<%--  User: Han--%>
<%--  Date: 2023-06-27--%>
<%--  Time: AM 10:45--%>
<%--  To change this template use File | Settings | File Templates.--%>
<%--&ndash;%&gt;--%>
<%--<%@ page contentType="text/html;charset=UTF-8" language="java" %>--%>
<%--<html>--%>
<%--<head>--%>
<%--    <title>syusyu</title>--%>
<%--</head>--%>
<%--<body>--%>
<%--<jsp:include page="./fos/common/header.jsp"/>--%>
<%-->>>>>>> Stashed changes--%>

<%--<script>--%>
<%--    let msg = "${msg}";--%>
<%--    if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");--%>
<%--    if (msg == "READ_ERR") alert("삭제되었거나 없는 게시물입니다.");--%>
<%--    if (msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");--%>

<%--    if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");--%>
<%--    if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");--%>
<%--    if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");--%>
<%--</script>--%>

<%--<<<<<<< Updated upstream--%>


<%--<div class="content-mini right-case sections ty2">--%>




<%--    <section>--%>
<%--        <h3 class="title-t ty3 mb-30">공지사항</h3>--%>
<%--        <span class="notice_count">총 ${ph.totalCnt} 개 </span>--%>
<%--        <br>--%>

<%--        <div id="ux_page_list">--%>






<%--            <div class="tbl ty1" page-no="1" page-size="10" total-size="4" total-page="1">--%>
<%--                <table>--%>
<%--                    <colgroup>--%>
<%--                        <col style="width:auto">--%>
<%--                        <col style="width:120px">--%>
<%--                    </colgroup>--%>
<%--                    <tbody>--%>


<%--                    <tr>--%>
<%--                        <td>--%>
<%--                            <a href="https://www.ottogimall.co.kr/front/help/notice_detail?boardPostIdx=12" class="fw-7">--%>

<%--		                        <span class="badge-cont single">--%>
<%--		  							<span class="badge-item ty4">공지</span>--%>
<%--		                        </span>--%>

<%--                                [이벤트] 제주담음이 제주도 보내드린대요!--%>
<%--                            </a>--%>
<%--                        </td>--%>
<%--                        <td class="fz-15 color-3 ta-c">2023.06.16</td>--%>
<%--                    </tr>--%>


<%--                    <tr>--%>
<%--                        <td>--%>
<%--                            <a href="https://www.ottogimall.co.kr/front/help/notice_detail?boardPostIdx=5" class="fw-7">--%>

<%--		                        <span class="badge-cont single">--%>
<%--		  							<span class="badge-item ty4">공지</span>--%>
<%--		                        </span>--%>

<%--                                New 오뚜기몰 오픈에 따른 로그인 안내--%>
<%--                            </a>--%>
<%--                        </td>--%>
<%--                        <td class="fz-15 color-3 ta-c">2023.03.17</td>--%>
<%--                    </tr>--%>


<%--                    <tr>--%>
<%--                        <td>--%>
<%--                            <a href="https://www.ottogimall.co.kr/front/help/notice_detail?boardPostIdx=2" class="fw-7">--%>

<%--		                        <span class="badge-cont single">--%>
<%--		  							<span class="badge-item ty4">공지</span>--%>
<%--		                        </span>--%>

<%--                                롯데카드로 결제하고 최대 12만원 캐시백!--%>
<%--                            </a>--%>
<%--                        </td>--%>
<%--                        <td class="fz-15 color-3 ta-c">2023.01.30</td>--%>
<%--                    </tr>--%>


<%--                    <tr>--%>
<%--                        <td>--%>
<%--                            <a href="https://www.ottogimall.co.kr/front/help/notice_detail?boardPostIdx=9" class="">--%>

<%--                                3/24일 출고 중단 안내--%>
<%--                            </a>--%>
<%--                        </td>--%>
<%--                        <td class="fz-15 color-3 ta-c">2023.03.24</td>--%>
<%--                    </tr>--%>

<%--                    </tbody>--%>
<%--                </table>--%>
<%--=======--%>
<%--<div class="board-container">--%>
<%--    <div class="search-container">--%>
<%--        <form action="<c:url value="/board/list"/>" class="search-form" method="get">--%>

<%--            <div class="notice">공지사항  총 ${ph.totalCnt} 개 </div>--%>

<%--            <div>--%>
<%--                <select class="search-option" name="option">--%>
<%--                    <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>--%>
<%--                    <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>--%>
<%--                    <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>--%>
<%--                </select>--%>

<%--            </div>--%>


<%--            <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"--%>
<%--                   placeholder="검색어를 입력해주세요">--%>
<%--            <input type="submit" class="search-button" value="검색">--%>


<%--        </form>--%>
<%--        <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/board/write"/>'"><i--%>
<%--                class="fa fa-pencil"></i> 글쓰기--%>
<%--        </button>--%>

<%--    </div>--%>

<%--    <table>--%>
<%--        <tr>--%>
<%--            <th class="notcNo">번호</th>--%>
<%--            <th class="notcTp">분류</th>--%>
<%--            <th class="title">제목</th>--%>
<%--            <th class="regDttm">등록일</th>--%>
<%--            <th class="viewCnt">조회수</th>--%>
<%--        </tr>--%>
<%--        <c:forEach var="noticeDto" items="${list}">--%>
<%--            <tr>--%>
<%--                <td class="notcNo">${noticeDto.notcNo}</td>--%>

<%--                <td class="notcTp"><c:out value="${noticeDto.notcTp}"/></td>--%>

<%--                <td class="title"><a--%>
<%--                        href="<c:url value="/board/read${ph.sc.queryString}&notcNo=${noticeDto.notcNo}"/>">${noticeDto.title}</a>--%>
<%--                </td>--%>

<%--                <c:choose>--%>

<%--                    <c:when test="${noticeDto.regDttm.time >= startOfToday}">--%>
<%--                        <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm"--%>
<%--                                                            type="time"/></td>--%>
<%--                    </c:when>--%>

<%--                    <c:otherwise>--%>
<%--                        <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd"--%>
<%--                                                            type="date"/></td>--%>
<%--                    </c:otherwise>--%>

<%--                </c:choose>--%>

<%--                <td class="viewCnt">${noticeDto.viewCnt}</td>--%>
<%--            </tr>--%>
<%--        </c:forEach>--%>
<%--    </table>--%>
<%--    <br>--%>
<%--    <div class="paging-container">--%>
<%--        <div class="paging">--%>
<%--            <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">--%>
<%--            <div> 게시물이 없습니다.</div>--%>
<%--            </c:if>--%>
<%--            <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">--%>
<%--            <c:if test="${ph.showPrev}">--%>
<%--            <a class="page" href="<c:url value="/board/list${ph.sc.getQueryString(ph.beginPage-1)}"/>">&lt;</a>--%>
<%--            </c:if>--%>
<%--            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--            <a class="page ${i==ph.sc.page? "paging-active" : ""}"--%>
<%--               href="<c:url value="/board/list${ph.sc.getQueryString(i)}"/>">${i}</a>--%>
<%--            </c:forEach>--%>
<%--            <c:if test="${ph.showNext}">--%>
<%--            <a class="page"--%>
<%--               href="<c:url value="/board/list${ph.sc.getQueryString(ph.endPage+1)}"/>">&gt;</a>--%>
<%--            </c:if>--%>
<%--            </c:if>--%>

<%--        </div>--%>
<%--    </div>--%>
<%-->>>>>>> Stashed changes--%>
<%--</div>--%>







<%--<<<<<<< Updated upstream--%>













<%--<section id="sectionForm">--%>
<%--    <div id ="first_div" style="text-align:center">--%>
<%--            <div class="board-container">--%>
<%--                    <span class="search-container">--%>
<%--                            <form action="<c:url value='/notice/noticeList'/>" class="search-form" method="get">--%>

<%--                                <div class="logo_notice">공지사항</div>--%>

<%--                                <span class="notice_count">총 ${ph.totalCnt} 개 </span>--%>

<%--                                    <div class="search_filter">--%>
<%--                                        <select class="search-option" name="option">--%>
<%--                                            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>--%>
<%--                                            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>--%>
<%--                                            <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>--%>
<%--                                        </select>--%>
<%--                                    </div>--%>



<%--                                <input type="text" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"--%>
<%--                                       placeholder="검색어를 입력해주세요">--%>
<%--                                <input type="submit" class="search-button" value="검색">--%>

<%--&lt;%&ndash;                                <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value='/notice/write'/>' "><i&ndash;%&gt;--%>
<%--&lt;%&ndash;                                        class="fa fa-pencil"></i> 글쓰기&ndash;%&gt;--%>
<%--&lt;%&ndash;                                </button>&ndash;%&gt;--%>
<%--                            </form>--%>
<%--                    </span>--%>
<%--                    </div>--%>




<%--            <table class="notice_table">--%>
<%--                <tr>--%>
<%--                    <th class="notcNo">번호</th>--%>
<%--&lt;%&ndash;                    <th class="notcTp">분류</th>&ndash;%&gt;--%>
<%--                    <th class="title">제목</th>--%>
<%--                    <th class="regDttm">등록일</th>--%>
<%--&lt;%&ndash;                    <th class="viewCnt">조회수</th>&ndash;%&gt;--%>
<%--                </tr>--%>
<%--                <c:forEach var="noticeDto" items="${list}">--%>
<%--                    <tr>--%>
<%--                        <td class="notcNo">${noticeDto.notcNo}</td>--%>

<%--&lt;%&ndash;                        <td class="notcTp"><c:out value="${noticeDto.notcTp}"/></td>&ndash;%&gt;--%>

<%--                        <td class="title"><a href="<c:url value='/notice/read${ph.sc.queryString}&notcNo=${noticeDto.notcNo}'/>">${noticeDto.title}</a>--%>
<%--                        </td>--%>

<%--                        <c:choose>--%>

<%--                            <c:when test="${noticeDto.regDttm.time >= startOfToday}">--%>
<%--                                <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm"--%>
<%--                                                                    type="time"/></td>--%>
<%--                            </c:when>--%>

<%--                            <c:otherwise>--%>
<%--                                <td class="regDttm"><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd"--%>
<%--                                                                    type="date"/></td>--%>
<%--                            </c:otherwise>--%>

<%--                        </c:choose>--%>

<%--&lt;%&ndash;                        <td class="viewCnt">${noticeDto.viewCnt}</td>&ndash;%&gt;--%>
<%--                    </tr>--%>
<%--                </c:forEach>--%>
<%--            </table>--%>

<%--            <br>--%>

<%--                            <div class="paging-container">--%>
<%--                                    <div class="paging">--%>
<%--                                                <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">--%>
<%--                                                <div> 게시물이 없습니다.</div>--%>
<%--                                                </c:if>--%>
<%--                                            <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">--%>

<%--                                                <c:if test="${ph.showPrev}">--%>
<%--                                                <a class="page" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>--%>
<%--                                                </c:if>--%>

<%--                                                <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">--%>
<%--                                                     <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(i)}'/>">${i}</a>--%>
<%--                                                </c:forEach>--%>

<%--                                                <c:if test="${ph.showNext}">--%>
<%--                                                <a class="page"--%>
<%--                                                   href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>--%>
<%--                                                </c:if>--%>

<%--                                            </c:if>--%>

<%--                                    </div>--%>
<%--                            </div>--%>
<%--            </div>--%>

<%--    </div>--%>
<%-- </section>--%>








<%--<jsp:include page="../common/footer.jsp"/>--%>

<%--=======--%>
<%--<jsp:include page="./fos/common/footer.jsp"/>--%>
<%-->>>>>>> Stashed changes--%>
<%--</body>--%>
<%--</html>--%>