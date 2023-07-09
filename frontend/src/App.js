import { BrowserRouter, Route, Routes } from 'react-router-dom';
import './App.css';
import Header from './components/Header';
import Home from './components/Home'
import Cart from './components/Cart'
import DarkVariantExample from './components/DarkVariantExample';

function App() {
  return (
    <BrowserRouter>
      {/* <Header/>*/
      <DarkVariantExample/>/*
      <div className='App'>
      <Routes>

        <Route path='/' exact Component={Home
        }/>
        <Route path='/cart' exact Component={Cart}/>
      </Routes>
      </div> */}
    </BrowserRouter>
    
  );
}

export default App;


// import "./App.css";
// import Header from "./components/common/header/Header";
// import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
// import About from "./components/about/About";
// import CourseHome from "./components/allcourses/CourseHome";
// import Team from "./components/team/Team";
// import Pricing from "./components/pricing/Pricing";
// import Blog from "./components/blog/Blog";
// import Contact from "./components/contact/Contact";
// import Footer from "./components/common/footer/Footer";
// import Home from "./components/home/Home";
// import CourseDetails from "./components/blog/CourseDetails";
// function App() {
//   return (
//     <>
//       <Router>
//         <Header />
//         <Routes>
//           <Route path="/" exact component={Blog} />
//           <Route path="/about" exact component={About} />
//           <Route path="/courses" exact component={CourseHome} />
//           <Route path="/team" exact component={Team} />
//           <Route path="/pricing" exact component={Pricing} />
//           <Route path="/journal" exact component={Blog} />
//           <Route path="/contact" exact component={Contact} />
//           <Route path="/courseDetails" exact component={CourseDetails} />
//         </Routes>
//         <Footer />
//       </Router>
//     </>
//   );
// }

// export default App;
