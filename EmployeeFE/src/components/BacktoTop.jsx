import React, { useState, useEffect } from 'react';
import { BsFillRocketFill } from "react-icons/bs";
const BackToTop = () => {
  const [visible, setVisible] = useState(false);

  // Show button after user scrolls down 300px (adjust as needed)
  useEffect(() => {
    const toggleVisibility = () => {
      if (window.pageYOffset > 300) {
        setVisible(true);
      } else {
        setVisible(false);
      }
    };

    window.addEventListener('scroll', toggleVisibility);
    
    return () => window.removeEventListener('scroll', toggleVisibility);
  }, []);

  const scrollToTop = () => {
    window.scrollTo({
      top: 0,
      behavior: 'smooth'  // Smooth scroll
    });
  };

  return (
    <>
      {visible && (
        <button
          onClick={scrollToTop}
          style={{
            position: 'fixed',
            bottom: '40px',
            right: '40px',
            padding: '5px 7px',
            fontSize: '18px',
            borderRadius: '50%',
            border: 'none',
            color: 'red',
            cursor: 'pointer',
            boxShadow: '0 2px 5px rgba(0,0,0,0.3)',
            zIndex: 1000,
            width: '34px',
            height: '31px',
            outline: 'none',
            transition: 'all 0.3s ease-in-out' ,
          }}
          aria-label="Back to top"
        >
        <BsFillRocketFill />
        </button>
      )}
    </>
  );
};

export default BackToTop;
