import Voltar from "../components/Voltar";
import Infos from "../components/Infos";
import estrela from "../imgs/estrela-vazia.png";
import GraficoEAvaliacoes from "../components/GraficoEAvaliacoes";
import grafico from "../imgs/grafico.png"
import img1 from "../imgs/imagem-mulher-1.png";
import img2 from "../imgs/imagem-homem-1.png";
import img3 from "../imgs/imagem-mulher-2.png";
import Calendar from "../components/Calendar";
import Agendamento from "../components/Agendamento";
import Avaliacao from "../components/Avaliacao";
import Footer from "../components/Footer";

import '../css/restaurantes-encontrados.css'

function Restaurante() {
    return (
        <>
            <body className="body-restaurantes-encontrados">

                <Voltar />
                <div class="container">
                    <h1><span class="sublinha">Led's</span> Burguer</h1>
                    <br />
                    <h5>4,5</h5>

                    <div class="avaliacao-estrelas">
                        <img src={estrela} alt="estrela avaliação" class="estrela-avaliacao" />
                        <img src={estrela} alt="estrela avaliação" class="estrela-avaliacao" />
                        <img src={estrela} alt="estrela avaliação" class="estrela-avaliacao" />
                        <img src={estrela} alt="estrela avaliação" class="estrela-avaliacao" />
                        <img src={estrela} alt="estrela avaliação" class="estrela-avaliacao" />
                    </div>

                    <span class="avaliacoes-totais">460 avaliações</span>

                    <br />

                    <span class="nacionalidade-restaurante">Restaurante Brasileiro</span>

                    <br />

                    <Infos />

                    <br />
                    <br />
                    <br />

                    <div class="informacoes-2">
                        <div class="grafico-de-fluxo">
                            <h5>Horários de pico</h5>

                            <br />

                            <div class="grapho">
                                <img src={grafico} alt="" />
                            </div>
                        </div>

                        <div class="avaliacoes-basicas">
                            <div class="imagens-comentarios-basicos">
                                <img class="imgp1" src={img1}
                                    alt="mulher comentando" />
                                <br />
                                <img class="imgp2" src={img2} alt="homem comentando" />
                                <br />
                                <img class="imgp3" src={img3} alt="mulher comentando" />
                            </div>

                            <GraficoEAvaliacoes />
                        </div>

                    </div>
                    <Calendar />
                    <Agendamento />
                    <Avaliacao />
                </div>
                <Footer />
            </body>
        </>
    );
}

export default Restaurante;