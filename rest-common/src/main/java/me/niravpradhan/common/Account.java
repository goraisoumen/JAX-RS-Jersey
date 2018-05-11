package me.niravpradhan.common;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

@XmlRootElement(name = "account")
public class Account implements Serializable {

    private String name;

    private Date hireDate;

    @Min(value = 10000)
    @Max(value = 20000)
    private double salary;

    public Account() {
    }

    public Account(String name, Date hireDate, double salary) {
        this.name = name;
        this.hireDate = hireDate;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getHireDate() {
        return hireDate;
    }

    public void setHireDate(Date hireDate) {
        this.hireDate = hireDate;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Double.compare(account.getSalary(), getSalary()) == 0 &&
                Objects.equals(getName(), account.getName()) &&
                Objects.equals(getHireDate(), account.getHireDate());
    }

    @Override
    public int hashCode() {

        return Objects.hash(getName(), getHireDate(), getSalary());
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("name='").append(name).append('\'');
        sb.append(", hireDate=").append(hireDate);
        sb.append(", salary=").append(salary);
        sb.append('}');
        return sb.toString();
    }
}
