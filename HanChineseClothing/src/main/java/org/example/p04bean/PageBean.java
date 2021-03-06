package org.example.p04bean;

import java.util.List;

//占位符
public class PageBean <T>{
        //集合
        private List<T> list;
        //总记录数
        private int totalCount;
        //每页记录数
        private int pageSize;
        //总页数
        private int totalPage;
        //当前页数
        private int currentPage;

        public List<T> getList() {
            return list;
        }

        public void setList(List<T> list) {
            this.list = list;
        }

        public int getTotalCount() {
            return totalCount;
        }

        public void setTotalCount(int totalCount) {
            this.totalCount = totalCount;
        }

        public int getPageSize() {
            return pageSize;
        }

        public void setPageSize(int pageSize) {
            this.pageSize = pageSize;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public int getCurrentPage() {
            return currentPage;
        }

        public void setCurrentPage(int currentPage) {
            this.currentPage = currentPage;
        }

        @Override
        public String toString() {
            return "PageBean{" +
                    "list=" + list +
                    ", totalCount=" + totalCount +
                    ", pageSize=" + pageSize +
                    ", totalPage=" + totalPage +
                    ", currentPage=" + currentPage +
                    '}';
        }
}
