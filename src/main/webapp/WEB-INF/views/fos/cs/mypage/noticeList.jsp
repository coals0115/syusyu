<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jstl/fmt_rt" %>
<%@ page session="true" %>
<c:set var="loginId" value="${sessionScope.id}"/>
<c:set var="loginOutLink" value="${loginId=='' ? '/login/login' : '/login/logout'}"/>
<c:set var="loginOut" value="${loginId=='' ? 'Login' : 'ID='+=loginId}"/>

<head>
        <style>
            @import url(${cssUrlFos}/cs/noticeList.scss);

        </style>
</head>

    <script>
        let msg = "${msg}";
        if (msg == "LIST_ERR") alert("게시물 목록을 가져오는데 실패했습니다. 다시 시도해 주세요.");
        if (msg == "READ_ERR") alert("삭제되었거나 없는 게시물입니다.");
        if (msg == "DEL_ERR") alert("삭제되었거나 없는 게시물입니다.");

        if (msg == "DEL_OK") alert("성공적으로 삭제되었습니다.");
        if (msg == "WRT_OK") alert("성공적으로 등록되었습니다.");
        if (msg == "MOD_OK") alert("성공적으로 수정되었습니다.");
    </script>
<header class="fb__bbs__header">
        <h3 class="title-t ty3 mb-30">공지사항</h3>
<%--  게시글 갯수 카운팅 <span class="notice_count">총 ${ph.totalCnt} 개 </span>--%>
        <br>
        <br>


<%--검색 바  : 제목 + 내용 , 제목 , 내용 항목--%>

<div class="board-container">
    <div class="search-container">
        <form action="<c:url value="/notice/noticeList"/>" class="search-form" method="get">

            <div class="fb__bbs__header__filter">
                    <div>
                        <select id = "sType"class="search-option" name="option">
                            <option value="A" ${ph.sc.option=='A' || ph.sc.option=='' ? "selected" : ""}>제목+내용</option>
                            <option value="T" ${ph.sc.option=='T' ? "selected" : ""}>제목만</option>
                            <option value="C" ${ph.sc.option=='C' ? "selected" : ""}>내용만</option>
<%--   지우면 안되요~         <option value="W" ${ph.sc.option=='W' ? "selected" : ""}>작성자</option>--%>
                        </select>


                        <input type="text" id = "noticeSearchText" name="keyword" class="search-input" type="text" value="${ph.sc.keyword}"
                               placeholder="검색어 입력">
                        <input type="submit" id = "btnSearch" class="search-button" value="검색">
                    </div>

            </div>
        </form>

<%-- 글쓰기 버튼--%>
<%--        <button id="writeBtn" class="btn-write" onclick="location.href='<c:url value="/notice/write"/>'"><i--%>
<%--                class="fa fa-pencil"></i> 글쓰기--%>
<%--        </button>--%>

    </div>


</div>
</header>

        <%--테이블 정보--%>
        <div id="ux_page_list">
            <div class="tbl ty1">
                <table>
                        <colgroup>
                            <col style="width: auto">
                            <col style="width: 120px">
                        </colgroup>
                    <tbody>
                    <tr>
            <%--        <th class="notcNo">번호</th>--%>
            <%--            <th class="notcTp">분류</th>--%>
                        <th class="notice-title">제목</th>
                        <th class="regDttm">등록일</th>
            <%--            <th class="viewCnt">조회수</th>--%>
                    </tr>


                    <c:forEach var="noticeDto" items="${list}">
                        <tr>
            <%--글 번호--%>
            <%--                <td class="notcNo">${noticeDto.notcNo}</td>--%>
            <%--타입--%>
            <%--                <td class="notcTp"><c:out value="${noticeDto.notcTp}"/></td>--%>
            <%--제목--%>
                            <td class="fw-7"><a href="<c:url value="/notice/read${ph.sc.queryString}&notcNo=${noticeDto.notcNo}"/>">${noticeDto.title}</a></td>
            <%--등록날짜--%>
                            <c:choose>
                                <c:when test="${noticeDto.regDttm.time >= startOfToday}">
                                    <td class="fz-15 color-3 ta-c"><fmt:formatDate value="${noticeDto.regDttm}" pattern="HH:mm" type="time"/></td>
                                </c:when>
                                <c:otherwise>
                                    <td class="fz-15 color-3 ta-c"><fmt:formatDate value="${noticeDto.regDttm}" pattern="yyyy-MM-dd" type="date"/></td>
                                </c:otherwise>
                            </c:choose>
            <%--조회수--%>
            <%--                <td class="viewCnt">${noticeDto.viewCnt}</td>--%>

                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
            </div>
        </div>

<%--페이지 이동 페이지 핸들링--%>
            <br>
            <div id="devPageWrap">
                <div class="wrap-pagination">
                        <c:if test="${ph.totalCnt==null || ph.totalCnt==0}">
                            <div> 게시물이 없습니다.</div>
                        </c:if>

                        <c:if test="${ph.totalCnt!=null && ph.totalCnt!=0}">
                            <c:if test="${ph.showPrev}">
                                <a class="page" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.beginPage-1)}'/>">&lt;</a>
                            </c:if>

                            <c:forEach var="i" begin="${ph.beginPage}" end="${ph.endPage}">
                                 <a class="page ${i==ph.sc.page? "paging-active" : ""}" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(i)}'/>">${i}</a>
                            </c:forEach>

                            <c:if test="${ph.showNext}">
                                <a class="page" href="<c:url value='/notice/noticeList${ph.sc.getQueryString(ph.endPage+1)}'/>">&gt;</a>
                            </c:if>

                        </c:if>

                    </div>
            </div>

