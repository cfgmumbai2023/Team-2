import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './components/Header';
import Home from './components/Home'
import Cart from './components/Cart'
import ProfilePage from './components/Profile';
import UserProfile from './components/Form';

function App() {
  return (
    <BrowserRouter>
      <Header/>
      <div className='App'>
      <Routes>

        <Route path='/' exact Component={Home}/>
        <Route path='/Profile' exact Component={ProfilePage}/>
        <Route path='/cart' exact Component={Cart}/>
        <Route path='/Form' exact Component={UserProfile}/>
      </Routes>
      </div>
    </BrowserRouter>
    
  );
}

export default App;
