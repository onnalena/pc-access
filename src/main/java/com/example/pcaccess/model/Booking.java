package com.example.pcaccess.model;

public class Booking {

    private String idnumber;
    private String access_token;
    private Long computer_id;
    private String status;

    public String getIdnumber() {
        return idnumber;
    }
    public void setIdnumber(String idnumber) {
        this.idnumber = idnumber;
    }
    public String getStatus() {
        return idnumber;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public Long getComputer_id() {
        return computer_id;
    }

    public void setComputer_id(Long computer_id) {
        this.computer_id = computer_id;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "idnumber='" + idnumber + '\'' +
                ", access_token='" + access_token + '\'' +
                ", computer_id=" + computer_id +
                '}';
    }
}
