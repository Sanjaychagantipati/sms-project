import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "./components/Login";
import Students from "./components/Students";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Login />} />
        <Route path="/students" element={<Students />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
