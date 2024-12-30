import React, { useEffect, useState } from "react";
import { listEmployees } from "../services/EmployeeService";

function ListEmployeeComponent() {
  const [employees, setEmployees] = useState([]);
  useEffect(() => {
    listEmployees()
      .then((res) => {
        setEmployees(res.data);
      })
      .catch((e) => {
        console.log(e);
      });
  }, []);
  return (
    <div className="container">
      <h2 className="text-center">ListEmployeeComponent</h2>
      <table className="table table-striped table-bordered">
        <thead>
          <tr>
            <th>Id</th>
            <th>First name</th>
            <th>Last name</th>
          </tr>
        </thead>
        <tbody>
          {dummyData.map((employee) => (
            <tr key={employee.id}>
              <td>{employee.id}</td>
              <td>{employee.firstName}</td>
              <td>{employee.lastName}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
}

export default ListEmployeeComponent;
