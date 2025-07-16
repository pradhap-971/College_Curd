import React from 'react';
import { BrowserRouter as Router, Route, Routes } from 'react-router-dom';
import './App.css';
import StudentForm from './Compoent/StudentForm';
import StudentList from './Compoent/StudentList';

function App() {
  return (
     <Router>
      <Routes>
        <Route path="/" element={<StudentList />} />
        <Route path="/add" element={<StudentForm />} />
        <Route path="/edit/:id" element={<StudentForm />} />
      </Routes>
    </Router>
  );
}

export default App;
