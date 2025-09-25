package Dao;

import java.time.LocalDateTime;

public class Visit {

    private long id;
    private String visitor_name;
    private String visitor_document;
    private String visitor_email;
    private String host_name;
    private String reason;
    private LocalDateTime visit_date;
    private LocalDateTime visit_exit;

    public Visit() {

    }

    public Visit(String visitor_name, String host_name, String visitor_document, String visitor_email, String reason) {
        this.visitor_name = visitor_name;
        this.host_name = host_name;
        this.visitor_document = visitor_document;
        this.visitor_email = visitor_email;
        this.reason = reason;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getVisitor_name() {
        return visitor_name;
    }

    public void setVisitor_name(String visitor_name) {
        this.visitor_name = visitor_name;
    }

    public String getVisitor_document() {
        return visitor_document;
    }

    public void setVisitor_document(String visitor_document) {
        this.visitor_document = visitor_document;
    }

    public String getVisitor_email() {
        return visitor_email;
    }

    public void setVisitor_email(String visitor_email) {
        this.visitor_email = visitor_email;
    }

    public String getHost_name() {
        return host_name;
    }

    public void setHost_name(String host_name) {
        this.host_name = host_name;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public LocalDateTime getVisit_date() {
        return visit_date;
    }

    public void setVisit_date(LocalDateTime visit_date) {
        this.visit_date = visit_date;
    }

    public LocalDateTime getVisit_exit() {
        return visit_exit;
    }

    public void setVisit_exit(LocalDateTime visit_exit) {
        this.visit_exit = visit_exit;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "visitor_name='" + visitor_name + '\'' +
                ", visitor_document='" + visitor_document + '\'' +
                ", visit_date=" + visit_date +
                ", visit_exit=" + visit_exit +
                '}';
    }
}
