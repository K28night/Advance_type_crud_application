
import './App.css'
import Header from './components/Header'
import AdvanceRecovery from './components/AdvanceRecovery'
import Loading from './components/Loading'
import AdvanceTypeForm from './components/AdvanceTypeForm'
function App() {
  // const [count, setCount] = useState(0)
  //  useEffect(() => {
  //   const handleRightClick = (e) => e.preventDefault();
  //   window.addEventListener('contextmenu', handleRightClick);
    
  //   return () => {
  //     window.removeEventListener('contextmenu', handleRightClick);
  //   };
  // }, []);
  return (
    <>
    
      <Header />
      <AdvanceRecovery />
    </>
  )
}

export default App
