import { useState } from "react";
import { Link } from "react-router-dom";
import "../style/Header.css";
import { IoNotificationsSharp } from "react-icons/io5"; // Example from Ionicons
import { BiSolidCollection } from "react-icons/bi";
// import { FaUserTie } from "react-icons/fa6";
import { ImUser } from "react-icons/im";
const Header = () => {
//   const [isMenuOpen, setIsMenuOpen] = useState(false);
  
//   const toggleMenu = () => {
//     setIsMenuOpen(!isMenuOpen);
//   };
const [notOpen, setNotOpen] = useState(false);
const [dashOpen, setDashOpen] = useState(false);
    return (
    <header className="header">
        <div className="logo">Cloud Stack Solutions</div>
        <div className="header-right">
            <div className="notification" onMouseEnter={() => setNotOpen(!notOpen)} onMouseLeave={() => setNotOpen(!notOpen)}>
                <IoNotificationsSharp size={23} />
                <div className="msgs">0</div>
                {notOpen && (
      <div className="notification-dropdown">
        <p>No new notifications</p>
      </div>
              )}
            </div>
              
        <div>
            <div className="dashboard" onMouseEnter={() => setDashOpen(!dashOpen)} onMouseLeave={() => setDashOpen(!dashOpen)}>
                <BiSolidCollection size={23} />
                <div className="msgs">0</div>
                {dashOpen && (
                    <div className="notification-dropdown">
                        <p>No new notifications1111</p>
                    </div>
                )}
                    
            </div>
            
        </div>
            <div className="location-date">
            <span className="location">Kochi_Kakkanad</span>
            <span className="date">12/09/2025</span>
            </div>
        <div className="user-profile">
            <ImUser size={24} style={{ color: '#1092e9'}}/>
        </div></div>
        
    </header>
  );
};

export default Header;