import React from "react";
import { useState,useEffect } from "react";
import "../style/AdvanceRecocery.css"; 
import Main from './Main'
import axios from 'axios';
import { BsGrid3X3GapFill } from "react-icons/bs";
import { FaListUl } from "react-icons/fa";
import { FaRegObjectGroup } from "react-icons/fa";
import { IoIosSearch } from "react-icons/io";
import { TiTick } from "react-icons/ti";
import Search from "./Search";
import AdvanceTypeForm from "./AdvanceTypeForm";
import BackToTop from "./BacktoTop";
import Loading from "./Loading";
const AdvanceTypeList = () => {

    const [advanceTypes, setAdvanceTypes] = useState([]);
    const [boxView, setBoxView] = useState(true);
    const [listView, setListView] = useState(false);
    const [showSearch, setShowSearch] = useState(false);
    const [showForm, setShowForm] = useState(false);
    const [searchData,setSearchdata] = useState("");
    const [selectedItem, setSelectedItem] = useState(null);
    const [loading, setLoading] = useState(true);
    const [flag, setFlag] = useState(false); // new state for flag from child
// useEffect(() => {
//   if (!searchData.trim()) { // Only fetch all if search is empty
//     axios.get("http://localhost:9082/viewAdvanceType")
//       .then(res => setAdvanceTypes(res.data))
//       .catch(console.error);
//   }
// }, []);
    const handleFlagChange = (newFlag) => {
    setFlag(newFlag);  // update parent state
      setTimeout(() => {
        setFlag(false); // reset flag after 2 seconds
      }, 1000);
  };
    const handleSearchChange = (e) => {
        setSearchdata(e.target.value);
       
        }
        useEffect(() => {
        const delayDebounceFn = setTimeout(() => {
            if (searchData.trim()) {
                axios.get(`http://localhost:9082/searchAdvanceType?data=${searchData}`)
                .then((res) => setAdvanceTypes(res.data))
                .catch(console.error);
            }else {
      // If searchData is empty, get all advance types
        axios.get("http://localhost:9082/viewAdvanceType")
        .then((res) => setAdvanceTypes(res.data))
        .catch(console.error);
    }
        }, 200); // debounce delay
 return () => clearTimeout(delayDebounceFn);
}, [searchData]);

useEffect(() => {
  if (showForm) {
            setLoading(true); // reset loading
            const timer = setTimeout(() => {
                setLoading(false);
            }, 2000);

            return () => clearTimeout(timer); // clean up on unmount
            }
            else{
              axios.get("http://localhost:9082/viewAdvanceType")
        .then((res) => setAdvanceTypes(res.data))
        .catch(console.error);
    }
            
          }, [showForm]);
    const toggleForm = () => {setShowForm(prev => !prev);
 if (showForm) {
       setSelectedItem(null);
  }}
    const containerStyle = boxView
  ? { display: 'flex', flexDirection: 'row' }
  : listView
    ? { display: 'flex', flexDirection: 'column' }
    : {};
    const hanbleSearchChange = (item) => {
        setSelectedItem(item);
        toggleForm();
    }

  return (
    <div className="advance-type-page">
    <div className="header-section">
        <h2>Advance Type</h2>
        <div className="view-icons">
            <div className="icons">
            <BsGrid3X3GapFill size={24}  
            onClick={() => {setBoxView(!boxView); setListView(false);}}
            title="Tile View"
            style={boxView ? { color: '#188bd8' } : undefined}
            />
            </div>
            <div className="icons">
            <FaListUl size={24}
            title="List View" 
            onClick={() => {setListView(true); setBoxView(false);}}
             style={listView ?  { color: '#188bd8' }:undefined }
            />
            </div>
            <div className="icons">
            <FaRegObjectGroup title="Grouping" size={24} onClick={() => {setShowSearch(!showSearch)}}/>
            </div>
            
        <div className="search-box">
            <input type="text" name="search" onChange={handleSearchChange} value={searchData} placeholder="Search here ..." />
            <div className="search-icon">
                <IoIosSearch size={22} style={{ marginLeft: '21px' }}  /></div>
        </div>
        </div>
    </div>
    <div className={`slide-container ${showSearch ? 'show' : 'hide'}`}>
        
      <Search/>
        
        </div>
      <div className="card-grid"
      style={containerStyle}
      >
        {advanceTypes.map((item) => (
          <div className="advance-card" 
          style={ listView ? { width: '96%', marginRight: '20px'} : undefined}
          key={item.code}>
            <div className="card-header">
              <span className="code" style={{cursor:'pointer'}} onClick={() =>{hanbleSearchChange(item)}}>{item.code}</span>
              <div>
              <span className="check-icon"><TiTick /></span>
              <span className="date">{item.activeDate}</span></div>
            </div>
            <div className="card-title" style={{cursor:'pointer'}} onClick={() =>{hanbleSearchChange(item)}}>{item.name}</div>
            <div className="card-shortname">{item.shortName}</div>
            <div className="card-description">{item.description}</div>
          </div>
        ))}
      </div>
          <Main toggleForm={toggleForm} onFlagChange={handleFlagChange}/>
           {showForm && selectedItem && loading && <Loading />}
      {showForm && !loading && selectedItem && (
        <AdvanceTypeForm data={selectedItem} toggleForm={toggleForm} />
      )}
      {showForm && !selectedItem &&  (
        <AdvanceTypeForm data={selectedItem} toggleForm={toggleForm} />
      )}
      {flag &&  <Loading />}
           <BackToTop />
    </div>
  );
};

export default AdvanceTypeList;
