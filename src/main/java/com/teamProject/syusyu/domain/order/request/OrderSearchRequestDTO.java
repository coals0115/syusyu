package com.teamProject.syusyu.domain.order.request;

public class OrderSearchRequestDTO {
    String dateType; // 조회할 날짜의 종류(예: 주문일, 결제일, 구매확정일)
    String startDate; // 조회시작일
    String endDate; // 조회종료일
    String searchType; // 조회조건
    String searchKeyword; // 검색어

    public String getDateType() {
        return dateType;
    }

    public void setDateType(String dateType) {
        this.dateType = dateType;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getSearchType() {
        return searchType;
    }

    public void setSearchType(String searchType) {
        this.searchType = searchType;
    }

    public String getSearchKeyword() {
        return searchKeyword;
    }

    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    @Override
    public String toString() {
        return "OrderSearchRequestDTO{" +
                "dateType='" + dateType + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", searchType='" + searchType + '\'' +
                ", searchKeyword='" + searchKeyword + '\'' +
                '}';
    }

    public static final class Builder {
        private String dateType;
        private String startDate;
        private String endDate;
        private String searchType;
        private String searchKeyword;

        private Builder() {
        }

        public static Builder anOrderSearchRequestDTO() {
            return new Builder();
        }

        public Builder dateType(String dateType) {
            this.dateType = dateType;
            return this;
        }

        public Builder startDate(String startDate) {
            this.startDate = startDate;
            return this;
        }

        public Builder endDate(String endDate) {
            this.endDate = endDate;
            return this;
        }

        public Builder searchType(String searchType) {
            this.searchType = searchType;
            return this;
        }

        public Builder searchKeyword(String searchKeyword) {
            this.searchKeyword = searchKeyword;
            return this;
        }

        public OrderSearchRequestDTO build() {
            OrderSearchRequestDTO orderSearchRequestDTO = new OrderSearchRequestDTO();
            orderSearchRequestDTO.setDateType(dateType);
            orderSearchRequestDTO.setStartDate(startDate);
            orderSearchRequestDTO.setEndDate(endDate);
            orderSearchRequestDTO.setSearchType(searchType);
            orderSearchRequestDTO.setSearchKeyword(searchKeyword);
            return orderSearchRequestDTO;
        }
    }
}