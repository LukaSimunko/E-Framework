/*
 * Joachim Grüneis
 * Copyright (C) 2013
 * All rights reserved.
 */
package at.grueneis.spengergasse.lesson_plan.persistence.jdbc;

import at.grueneis.spengergasse.lesson_plan.domain.Teacher;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

/**
 *
 */
public class TeacherDao extends AbstractDatabaseDao<Teacher> {

    public TeacherDao(Connection connection) {
        super(connection);
    }

    @Override
    protected String idColumnName() {
        return "id";
    }

    @Override
    protected String[] otherColumnNames() {
        return new String[]{"firstname", "lastname", "birthdate", "email"};
    }

    @Override
    protected String tableName() {
        return "teachers";
    }

    @Override
    protected Teacher bind(ResultSet resultSet) {
        try {
            Long id = resultSet.getLong("id");
            if (resultSet.wasNull()) {
                id = null;
            }
            String firstname = resultSet.getString("firstname");
            String lastname = resultSet.getString("lastname");
            Date birthdate = resultSet.getDate("birthdate");
            String email = resultSet.getString("email");
            return new Teacher(id, firstname, lastname, birthdate, email);
        } catch (SQLException e) {
            throw new LessonPlanDataAccessException("Failed at binding teacher", e);
        }
    }

    @Override
    protected void setValuesOfOtherColumnsIntoStatment(PreparedStatement preparedStatement, Teacher entity) {
        try {
            preparedStatement.setString(1, entity.getFirstname());
            preparedStatement.setString(2, entity.getLastname());
            preparedStatement.setDate(3, new java.sql.Date(entity.getBirthdate().getTime()));
            preparedStatement.setString(4, entity.getEmail());
        } catch (SQLException e) {
            throw new LessonPlanDataAccessException("Failed at setting attributes into statement", e);
        }
    }
}
