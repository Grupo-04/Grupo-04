import ex1 from '../imgs/rest-ex1.png';
import ex2 from '../imgs/rest-ex2.png';
import ex3 from '../imgs/rest-ex3.png';

import icone1 from '../imgs/icone-relogio.png';
import icone2 from '../imgs/icone-localizacao.png';
import icone3 from '../imgs/icone-remunaracao.png';
import icone4 from '../imgs/icone-reserva.png';
import icone5 from '../imgs/icone-comida.png';
import icone6 from '../imgs/icone-ponto.png';
import icone7 from '../imgs/icone-estilo.png';


function Infos() {
    return (
        <>
            <span class="nacionalidade-restaurante">Restaurante Brasileiro</span>

            <br/>

                <div class="fotos-restaurante">
                    <div class="foto-rest-grande">
                        <img src={ex1} alt="imagem do restaurante" class="img-rest-1"/>
                    </div>

                    <div class="foto-rest-pequena">
                        <img src={ex2} alt="imagem do restaurante" class="img-rest-2"/>
                            <img src={ex3} alt="imagem do restaurante" class="img-rest-3"/>
                            </div>

                    </div>

                    <br/>

                        <h5>Espaço para se apresentar de até 3 pessoas</h5>

                        <br/>
                            <br/>
                                <br/>

                                    <h5>O que esse lugar oferece?</h5>

                                    <br/>
                                        <br/>

                                            <div class="informacoes-restaurante">
                                                <div class="informacoes-esquerda">
                                                    <img src={icone1} alt="icone-horario"/>
                                                        <span>Todos os dias 7:00 - 23h30</span>

                                                        <br/>
                                                            <br/>

                                                                <img src={icone2} alt="icone-localidade"/>
                                                                    <span>R. Augusta, 2018 - Jardim Paulista, São Paulo
                                                                        - SP, 01412-000
                                                                    </span>

                                                                    <br/>
                                                                        <br/>

                                                                            <img src={icone3} alt="icone-remuneração"/>
                                                                                <span>R$200,00 - Duzentos Reais</span>

                                                                                <br/>
                                                                                    <br/>

                                                                                        <img src={icone4} alt="icone-necessidade-reserva"/>
                                                                                            <span>Necessita fazer Reserva</span>
                                                                                        </div>

                                                                                        <div class="informacoes-direita">
                                                                                            <img src={icone5} alt="icone-tipo-comida"/>
                                                                                                <span>Comida Brasileira</span>

                                                                                                <br/>
                                                                                                    <br/>

                                                                                                        <img src={icone6} alt="icone-ponto-de-referencia"/>
                                                                                                            <span>Perto da Estação do Metrô Consolação</span>

                                                                                                            <br/>
                                                                                                                <br/>

                                                                                                                    <img src={icone7} alt="icone-estilo-musical"/>
                                                                                                                        <span>Latina</span>
                                                                                                                    </div>

                                                                                                                </div>
                                                                                                            </>
                                                                                                            )
}

export default Infos;