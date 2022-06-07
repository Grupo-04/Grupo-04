import { BrowserRouter, Route, Routes } from "react-router-dom";

import HomeSoundry from "./pages/HomeSoundry";
import CadastroArtista from "./pages/CadastroArtista";
import CadastroEstabelecimento from "./pages/CadastroEstabelecimento";
import EnderecoArtista from "./pages/EnderecoArtista";
import Estabelecimentos from "./pages/Estabelecimentos";
import Restaurante from "./pages/Restaurante";
import Login from "./pages/Login";
import AlterarSenha from "./pages/AlterarSenha";
import GerarCodigo from "./pages/GerarCodigo";

function Rotas() {
  return (
      <BrowserRouter>
          <Routes>

              <Route path="/" element={<HomeSoundry/>}/>
              <Route path="/cadastro-artista" element={<CadastroArtista/>}/>
              <Route path="/cadastro-estabelecimento" element={<CadastroEstabelecimento/>}/>
              <Route path="/cadastro-endereco-artista" element={<EnderecoArtista/>}/>
              <Route path="/estabelecimentos" element={<Estabelecimentos/>}/>
              <Route path="/restaurante" element={<Restaurante/>}/>
              <Route path="/login" element={<Login/>}/>
              <Route path="/alterar-senha" element={<AlterarSenha/>}/>
              <Route path="/codigo-alterar-senha" element={<GerarCodigo/>}/>

              {/* <Route path="*" element={}/> 404 */}
          </Routes>
      </BrowserRouter>
  );
}

export default Rotas;