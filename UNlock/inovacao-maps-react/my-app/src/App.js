import RedirecionamentoCadastro from './components/RedirecionamentoCadastro';
import CadastroArtista from './pages/CadastroArtista';
import CadastroEstabelecimento from './pages/CadastroEstabelecimento';
import EnderecoArtista from './pages/EnderecoArtista';
import Login from './pages/Login';
import TelaInicial from './pages/TelaInicial';
import Rotas from './routes';

import React from 'react';
import ReactDOM from 'react-dom/client';
import Header from './components/Header';
import Estabelecimentos from './pages/Estabelecimentos';

function App() {
  return (
    <>
      {/* <Login/> */}
      <Estabelecimentos/>
    </>
    // <div className="App">
    //   <header className="App-header">
    //     <img src={logo} className="App-logo" alt="logo" />
    //     <p>
    //       Edit <code>src/App.js</code> and save to reload.
    //     </p>
    //     <a
    //       className="App-link"
    //       href="https://reactjs.org"
    //       target="_blank"
    //       rel="noopener noreferrer"
    //     >
    //       Learn React
    //     </a>
    //   </header>
    // </div>


  );
}

export default App;
