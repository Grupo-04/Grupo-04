import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import Render from './Map';
import Header from './Header';
import Estabelecimentos from './Estabelecimentos';
import './css/pos_login.css'

import reportWebVitals from './reportWebVitals';

const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <React.StrictMode>
    <>
        {/* TODO: Arrumar botao de curtir estabelecimento!!! */}
      <Header />
      <Estabelecimentos/>
    </>
  </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
