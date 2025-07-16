
import React, { useEffect, useState } from 'react';
import axios from 'axios';
import { useNavigate, useParams } from 'react-router-dom';
import '../Compoent/StudentsForm.css';

function StudentForm() {


  const [student, setStudent] = useState({
    name: '',
    department: '',
    email: ''
  });

  const navigate = useNavigate();
  const { id } = useParams();

  const handleChange = (e) => {
    setStudent({ ...student, [e.target.name]: e.target.value });
  };

  useEffect(() => {
    if (id) {
      axios.get(`http://localhost:8080/students/${id}`)
        .then((res) => setStudent(res.data));
    }
  }, [id]);

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (id) {
      await axios.put(`http://localhost:8080/students/${id}`, student);
    } else {
      await axios.post("http://localhost:8080/students", student);
    }
    navigate('/');
  };



return(
<div className="student-form-container">
    <h2>{id ? "Edit Student" : "Add Student"}</h2>
    <form className="student-form" onSubmit={handleSubmit}>
      
      <div className="form-group">
        <label htmlFor="name">Full Name</label>
        <input
          id="name"
          className="form-input"
          name="name"
          placeholder="Pradhap"
          value={student.name}
          onChange={handleChange}
          required
        />
      </div>
      
      <div className="form-group">
        <label htmlFor="department">Department</label>
        <input
          id="department"
          className="form-input"
          name="department"
          placeholder="Mechanical engineer"
          value={student.department}
          onChange={handleChange}
          required
        />
      </div>
      
      <div className="form-group">
        <label htmlFor="email">Email Address</label>
        <input
          id="email"
          className="form-input"
          name="email"
          type="email"
          placeholder="pradhap@123gmail.com"
          value={student.email}
          onChange={handleChange}
          required
        />
      </div>
      
      <button type="submit" className="submit-btn">
        {id ? "Update Student" : "Add Student"}
      </button>
    </form>
  </div>

)    
}

export default StudentForm;