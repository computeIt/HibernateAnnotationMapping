package service;

import bl.SessionUtil;
import dao.ProjectDAO;
import entity.Project;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.sql.*;
import java.util.List;

public class ProjectService extends SessionUtil implements ProjectDAO {

    public void add(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();

        session.save(project);
        closeTransactionSession();
    }

    public List<Project> getAll() throws SQLException {
        String sql = "SELECT * FROM PROJECT";
        openTransactionSession();
        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        List<Project> projectList = query.list();
        closeTransactionSession();
        return projectList;
    }

    public Project getProjectById(long id) throws SQLException {
        openTransactionSession();
        String sql = "SELECT * FROM PROJECT WHERE ID=:id";
        Session session = getSession();

        Query query = session.createNativeQuery(sql).addEntity(Project.class);
        Project project = (Project) query.getSingleResult();
        closeTransactionSession();
        return project;
    }

    public void update(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();

        session.update(project);
        closeTransactionSession();
    }

    public void remove(Project project) throws SQLException {
        openTransactionSession();
        Session session = getSession();

        session.remove(project);
        closeTransactionSession();
    }
}
