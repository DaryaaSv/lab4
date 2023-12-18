package ua.nure.svyrydenko.mykolchuk.lab4.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.Date;

import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;

import java.sql.Types;
import java.util.Map;

@Controller
public class SqlController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @PostMapping("/executeFunction")
    public String executeFunction(@RequestParam String executionType,
                                  @RequestParam String sqlOption,
                                  @RequestParam(required = false) Date dateParam,
                                  @RequestParam(required = false) String phoneNumber,
                                  @RequestParam(required = false) String appointmentType,
                                  @RequestParam(required = false) Date appointmentDate,
                                  @RequestParam(required = false) long doctorId,
                                  @RequestParam(required = false) long patientId,
                                  @RequestParam(required = false) String dayOfWeek,
                                  @RequestParam(required = false) long doctorIdForSchedule,
                                  @RequestParam(required = false) java.sql.Time startTime,
                                  @RequestParam(required = false) java.sql.Time endTime,
                                  Model model) throws Exception {
        String result = null;

        if ("function".equals(executionType)) {
            switch (sqlOption) {
                case "FindMostExpensiveDoctor":
                    result = executeFindMostExpensiveDoctor(dateParam);
                    break;
                case "GetSpentByPatient":
                    result = executeGetSpentByPatient(phoneNumber);
                    break;
            }

        } else if ("procedure".equals(executionType)) {
            switch (sqlOption) {
                case "AddAppointment":
                    executeAddAppointment(appointmentType, appointmentDate, doctorId, patientId);
                    result = "AddAppointment executed successfully";
                    break;
                case "UpdateDoctorSchedule":
                    executeUpdateDoctorSchedule(doctorId, dayOfWeek, startTime, endTime);
                    result = "UpdateDoctorSchedule executed successfully";
                    break;
            }
        }

        model.addAttribute("result", result);
        return "result";
    }

    private String executeFindMostExpensiveDoctor(Date dateParam) {
        String sql = "SELECT dbo.FindMostExpensiveDoctor(?) AS result";
        return jdbcTemplate.queryForObject(sql, String.class, dateParam);
    }

    private String executeGetSpentByPatient(String phoneNumber) {
        String sql = "SELECT * FROM dbo.GetSpentByPatient(?)";
        return jdbcTemplate.queryForObject(sql, String.class, phoneNumber);
    }

    private void executeAddAppointment(String appointmentType, Date appointmentDate, long doctorId, long patientId) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("AddAppointment")
                .declareParameters(
                        new SqlParameter("appointment_type", Types.VARCHAR),
                        new SqlParameter("appointment_date", Types.DATE),
                        new SqlParameter("doctor_id", Types.BIGINT),
                        new SqlParameter("patient_id", Types.BIGINT)
                );

        Map<String, Object> inParams = Map.of(
                "appointment_type", appointmentType,
                "appointment_date", appointmentDate,
                "doctor_id", doctorId,
                "patient_id", patientId
        );

        jdbcCall.execute(inParams);
    }

    private void executeUpdateDoctorSchedule(long doctorIdForSchedule, String dayOfWeek, java.sql.Time startTime, java.sql.Time endTime) {
        SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                .withProcedureName("UpdateDoctorSchedule")
                .declareParameters(
                        new SqlParameter("doctor_id", Types.BIGINT),
                        new SqlParameter("day_of_week", Types.VARCHAR),
                        new SqlParameter("start_time", Types.TIME),
                        new SqlParameter("end_time", Types.TIME)
                );

        Map<String, Object> inParams = Map.of(
                "doctor_id", doctorIdForSchedule,
                "day_of_week", dayOfWeek,
                "start_time", startTime,
                "end_time", endTime
        );

        jdbcCall.execute(inParams);
    }
}
