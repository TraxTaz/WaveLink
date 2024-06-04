import { Route, Routes, BrowserRouter as Router, NavLink } from "react-router-dom";
import './App.css'
import LoginPage from "./pages/LoginPage"
import SignUpPage from './pages/SignUpPage';
import HomePage from "./pages/HomePage";
import ProfilePage from "./pages/ProfilePage";

function App() {

  const link = {
    path: "/",  
  }

  return (
    <div className="App">
    <Router>
      <NavLink to={link.path}>
      </NavLink>
      <Routes>
        <Route path='/signup' element={<SignUpPage />} />'
        <Route path='/' element={<LoginPage />} />
        <Route path="/home" element={<HomePage />} />
        <Route path="/Profile" element={<ProfilePage />} />
      </Routes>
    </Router>
  </div>
  )
}

export default App
