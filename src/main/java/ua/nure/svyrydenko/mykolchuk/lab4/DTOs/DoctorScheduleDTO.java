package ua.nure.svyrydenko.mykolchuk.lab4.DTOs;

import java.sql.Time;

public class DoctorScheduleDTO {

    private Long scheduleId;
    private String doctorName;
    private String dayOfWeek;
    private java.sql.Time startTime;
    private java.sql.Time endTime;

    public DoctorScheduleDTO() {
    }

    public DoctorScheduleDTO(Long scheduleId, String doctorName, String dayOfWeek, java.sql.Time startTime, java.sql.Time endTime) {
        this.scheduleId = scheduleId;
        this.doctorName = doctorName;
        this.dayOfWeek = dayOfWeek;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public Long getScheduleId() {
        return scheduleId;
    }

    public void setScheduleId(Long scheduleId) {
        this.scheduleId = scheduleId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public String getDayOfWeek() {
        return dayOfWeek;
    }

    public void setDayOfWeek(String dayOfWeek) {
        this.dayOfWeek = dayOfWeek;
    }

    public Time getStartTime() {
        return startTime;
    }

    public void setStartTime(Time startTime) {
        this.startTime = startTime;
    }

    public Time getEndTime() {
        return endTime;
    }

    public void setEndTime(Time endTime) {
        this.endTime = endTime;
    }
}
