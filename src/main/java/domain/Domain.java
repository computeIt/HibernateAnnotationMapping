package domain;

import bl.HibernateUtil;
import entity.Address;
import entity.Employee;
import entity.Project;
import org.hibernate.Session;
import service.AddressService;
import service.EmployeeService;
import service.ProjectService;

import java.sql.Date;
import java.sql.SQLException;
import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;


public class Domain {

    public static void main( String[] args ) throws SQLException {
        AddressService addressService = new AddressService();
        EmployeeService employeeService = new EmployeeService();
        ProjectService projectService = new ProjectService();

        Address address = new Address();
        address.setCountry("Russia");
        address.setCity("Moscow");
        address.setStreet("Red Square 1");
        address.setPostCode("123456");

        Employee employee = new Employee();
        employee.setFirstName("Ivan");
        employee.setLastName("Ivanov");

        Calendar calendar = Calendar.getInstance();
        calendar.set(1980, Calendar.MAY, 20);

        employee.setBirthday(new Date(calendar.getTime().getTime()));
        employee.setAddress(address);

        Project project = new Project();
        project.setTitle("SuperProject");

        Set<Project> projects = new HashSet<Project>();
        projects.add(project);
        employee.setProjects(projects);

        Set<Employee> employees = new HashSet<Employee>();
        employees.add(employee);
        project.setEmployees(employees);

//        addressService.add(address);
//        projectService.add(project);
//        employeeService.add(employee);

        System.out.println(addressService.getAddressById(1L));
        HibernateUtil.shutdown();
    }
}