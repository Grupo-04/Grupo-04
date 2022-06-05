import { BrowserRouter, Route, Routes } from "react-router-dom";

import CadastroArtista from "./pages/CadastroArtista";
import CadastroEstabelecimento from "./pages/CadastroEstabelecimento";
import EnderecoArtista from "./pages/EnderecoArtista";
import Estabelecimentos from "./pages/Estabelecimentos";
import Restaurante from "./pages/Restaurante";
import Login from "./pages/Login";

function Rotas() {
  return (
      <BrowserRouter>
          <Routes>
              {/* <Route exact path="/normal_redirect" render={() => {window.location.href="index.html"}} /> */}

              <Route path="/cadastro-artista" element={<CadastroArtista/>}/>
              <Route path="/cadastro-estabelecimento" element={<CadastroEstabelecimento/>}/>
              <Route path="/cadastro-endereco-artista" element={<EnderecoArtista/>}/>
              <Route path="/estabelecimentos" element={<Estabelecimentos/>}/>
              <Route path="/restaurante" element={<Restaurante/>}/>
              <Route path="/login" element={<Login/>}/>

              {/* <Route path="/cadastro-endereco-estabelecimento" element={<EnderecoEstabelecimento/>}/> */}
              {/* <Route path="*" element={}/> 404 */}
          </Routes>
      </BrowserRouter>
  );
}

export default Rotas;