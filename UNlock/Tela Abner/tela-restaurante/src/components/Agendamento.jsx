function Agendamento () {
    return(
        <>
        <div class="div-agendamento">
                <span class="agendamento">Vamos fechar &#127881;</span>
                <div class="box-agendamento">
                    <div class="container-agendamento">
                        <span class="valor-agendamento">R$100/ hora</span>
                        <div class="box-informacoes-agendamento">
                            <form action="">
                                <div class="data-hora-show">
                                    <div class="dia-show">
                                        <span>Período do Show</span>
                                        <br/>
                                        <input type="date"/>
                                    </div>

                                    <div class="hora-show">
                                        <span>Horario do Show</span>
                                        <br/>
                                        <input type="datetime-local"/>
                                    </div>
                                </div>

                                <br/>
                                <br/>

                                <div class="nro-integrantes">
                                    <span>Nº Integrantes</span>
                                    <br/>
                                    <select name="Nº Integrantes" id="nroIntegrantes">
                                        <option value="">4</option>
                                    </select>
                                </div>

                                <br/>

                                <div class="tenho-instrumento">
                                    <span>Tenho Instrumento Próprio?</span>
                                    <br/>
                                    <select name="Tenho Instrumento Próprio?" id="tenhoInstrumento">
                                        <option value="">Sim</option>
                                    </select>
                                </div>

                                <br/>

                                <div class="estilo-artista">
                                    <span>Tipo de estilo artista</span>
                                    <br/>
                                    <input type="text"/>
                                </div>
                            </form>
                        </div>
                        <button class="botao-enviar-requisicao">Enviar Requisição</button>
                        <br/>
                        <div class="pagamento-valor">
                            <u class="pagamento-u">pagamento</u>
                            <span class="pagamento-span">R$100</span>
                            <br/>
                            <u class="pagamento-u">n° de horas no show</u>
                            <span class="pagamento-span">1</span>
                            <br/>
                            <br/>
                            <div class="div-x">
                                <u >As datas são compatíveis com a disponibilidade do
                                    estabelecimento, por favor conferir a escolha</u>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
           
            </>
    );
}

export default Agendamento;