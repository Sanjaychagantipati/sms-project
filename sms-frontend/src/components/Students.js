import { useEffect, useState } from "react";
import API from "../services/api";

function Students() {
  const [students, setStudents] = useState([]);

  useEffect(() => {
    API.get("/api/students").then((res) => {
      setStudents(res.data);
    });
  }, []);

  return (
    <div>
      <h2>Students</h2>
      <ul>
        {students.map((s) => (
          <li key={s.id}>
            {s.name} - {s.email}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Students;
