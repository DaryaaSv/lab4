package ua.nure.svyrydenko.mykolchuk.lab4.DTOs;

import java.sql.Date;

public class AppointmentDTO {

    private Long appointmentId;
    private String appointmentType;
    private Date appointmentDate;
    private double appointmentPrice;

    private String patientName;
    private String doctorName;

    public AppointmentDTO() {
    }

    public AppointmentDTO(
            Long appointmentId,
            String appointmentType,
            Date appointmentDate,
            double appointmentPrice,
            String patientFirstName,
            String patientLastName,
            String doctorFirstName,
            String doctorLastName) {
        this.appointmentId = appointmentId;
        this.appointmentType = appointmentType;
        this.appointmentDate = appointmentDate;
        this.appointmentPrice = appointmentPrice;
        this.patientName = patientFirstName + " " + patientLastName;
        this.doctorName = doctorFirstName + " " + doctorLastName;
    }

    public Long getAppointmentId() {
        return appointmentId;
    }

    public void setAppointmentId(Long appointmentId) {
        this.appointmentId = appointmentId;
    }

    public String getAppointmentType() {
        return appointmentType;
    }

    public void setAppointmentType(String appointmentType) {
        this.appointmentType = appointmentType;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(Date appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public double getAppointmentPrice() {
        return appointmentPrice;
    }

    public void setAppointmentPrice(double appointmentPrice) {
        this.appointmentPrice = appointmentPrice;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }
}
