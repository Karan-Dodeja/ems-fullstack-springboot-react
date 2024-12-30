import React from "react";

function ListEmployeeComponent() {
  const dummyData = [
    { id: 1, firstName: "A", lastName: "B" },
    { id: 2, firstName: "B", lastName: "C" },
    { id: 3, firstName: "C", lastName: "D" },
    { id: 4, firstName: "E", lastName: "F" },
  ];
  return (
    <div>
      <h1>ListEmployeeComponent</h1>
      <table>
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
