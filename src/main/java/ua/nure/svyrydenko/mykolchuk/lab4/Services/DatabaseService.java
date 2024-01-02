package ua.nure.svyrydenko.mykolchuk.lab4.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlOutParameter;
import org.springframework.jdbc.core.SqlParameter;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.sql.Types;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Map;

@Service
public class DatabaseService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public Object execute(String name, Map<String, Object> parameters) throws ParseException {
        if ("GetSpentByPatient".equals(name)) {
            String phoneNumber = (String) parameters.get("phoneNumber");
            return jdbcTemplate.queryForList("SELECT * FROM dbo.GetSpentByPatient(?)", phoneNumber);
        }

        else if ("FindMostExpensiveDoctor".equals(name)) {
            String dateParam = (String) parameters.get("dateParam");
            return jdbcTemplate.queryForList("SELECT dbo.FindMostExpensiveDoctor(?)", dateParam);
        }

        else if ("AddAppointment".equals(name)) {
            String appointmentType = (String) parameters.get("appointmentType");
            String dateString = (String) parameters.get("appointmentDate");
            int doctorId = Integer.parseInt((String) parameters.get("doctorId"));
            int patientId = Integer.parseInt((String) parameters.get("patientId"));


            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date date = sdf.parse(dateString);
            Date appointmentDate = new Date(date.getTime());

            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("AddAppointment")
                    .declareParameters(
                            new SqlParameter("appointmentType", Types.VARCHAR),
                            new SqlParameter("appointmentDate", Types.DATE),
                            new SqlParameter("doctorId", Types.BIGINT),
                            new SqlParameter("patientId", Types.BIGINT),
                            new SqlOutParameter("resultMessage", Types.VARCHAR));

            SqlParameterSource inParams = new MapSqlParameterSource()
                    .addValue("appointmentType", appointmentType)
                    .addValue("appointmentDate", appointmentDate)
                    .addValue("doctorId", doctorId)
                    .addValue("patientId", patientId);

            Map<String, Object> result = jdbcCall.execute(inParams);
            String message = (String) result.get("resultMessage");
            System.out.println("Result from stored procedure: " + message);

            return message;
        }

        else if ("UpdateDoctorSchedule".equalsIgnoreCase(name)) {
            int doctorId;
            Object doctorIdObj = parameters.get("doctorId");

            if (doctorIdObj instanceof Integer) {
                doctorId = (Integer) doctorIdObj;
            } else {
                doctorId = Integer.parseInt((String) doctorIdObj);
            }
            String dayOfWeek = (String) parameters.get("dayOfWeek");
            String startTime = (String) parameters.get("startTime");
            String endTime = (String) parameters.get("endTime");

            SimpleJdbcCall jdbcCall = new SimpleJdbcCall(jdbcTemplate)
                    .withProcedureName("UpdateDoctorSchedule")
                    .declareParameters(
                            new SqlParameter("doctorId", Types.INTEGER),
                            new SqlParameter("dayOfWeek", Types.NVARCHAR),
                            new SqlParameter("startTime", Types.TIME),
                            new SqlParameter("endTime", Types.TIME),
                            new SqlOutParameter("resultMessage", Types.NVARCHAR));

            SqlParameterSource inParams = new MapSqlParameterSource()
                    .addValue("doctorId", doctorId)
                    .addValue("dayOfWeek", dayOfWeek)
                    .addValue("startTime", startTime)
                    .addValue("endTime", endTime);

            Map<String, Object> result = jdbcCall.execute(inParams);

            String message = (String) result.get("resultMessage");
            System.out.println("Result from stored procedure: " + message);

            return message;
        }
        throw new IllegalArgumentException("Unknown operation: " + name);
    }
}

