package service;

import bl.SessionUtil;
import dao.EmployeeDAO;
import entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

/**
 * Created by Андрей on 31.08.2017.
 */
public class EmployeeService extends SessionUtil implements EmployeeDAO {

    public void add(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.save(employee);
        closeTransactionSession();
    }

    public List<Employee> getAll() throws SQLException {
        openTransactionSession();
        Session session = getSession();

        String sql = "SELECT * FROM EMPLOYEE";
        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        List<Employee> resultList = query.list();

        closeTransactionSession();

        return resultList;
    }

    public Employee getEmployeeById(long id) throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM EMPLOYEE WHERE ID = :id";
        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Employee.class);
        query.setParameter("id", id);

        Employee employee = (Employee) query.getSingleResult();
        closeTransactionSession();
        return employee;
    }

    public void update(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.update(employee);
        closeTransactionSession();
    }

    public void remove(Employee employee) throws SQLException {
        openTransactionSession();
        Session session = getSession();
        session.remove(employee);
        closeTransactionSession();
    }
}
