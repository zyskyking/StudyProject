package com.tingshuo.myretrofitdemo.enter;

import java.util.List;

public class TopBean {
    private String count;
    private String start;
    private String total;

    private List<subjectsBean> subjects;
    public class subjectsBean{
        private String title;
        private String id;
        private String mainland_pubdate;

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getMainland_pubdate() {
            return mainland_pubdate;
        }

        public void setMainland_pubdate(String mainland_pubdate) {
            this.mainland_pubdate = mainland_pubdate;
        }
    }

    public String getCount() {
        return count;
    }

    public void setCount(String count) {
        this.count = count;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public List<subjectsBean> getSubjects() {
        return subjects;
    }

    public void setSubjects(List<subjectsBean> subjects) {
        this.subjects = subjects;
    }
}
