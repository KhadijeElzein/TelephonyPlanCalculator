import React from 'react';
import Header from './components/Header';
import Footer from './components/Footer';
import Main from './pages/Main'
import 'bootstrap/dist/css/bootstrap.min.css';

function App() {
  return (
    <div className="App">
      <Header/>
      <Main/>
      <Footer/>
    </div>
  );
}

export default App;
